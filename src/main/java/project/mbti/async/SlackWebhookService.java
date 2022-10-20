package project.mbti.async;

import static org.springframework.http.HttpMethod.*;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import project.mbti.comment.entity.Comment;
import project.mbti.report.entity.Report;
import project.mbti.report.entity.ReportSubject;

@Slf4j
@Service
@RequiredArgsConstructor
public class SlackWebhookService {

	private static final String MESSAGE_TEMPLATE = "🔥🔥 새로운 신고가 접수되었어요! 🔥🔥\n\n" +
		"#️⃣ 신고 id: %s\n" +
		"✅ 신고 유형: %s\n" +
		"😫 신고 사유: %s\n\n" +
		"#️⃣ 댓글 id: %s\n" +
		"🤬 댓글 내용: %s";
	private final RestTemplate restTemplate;
	@Value("${webhook.slack.url}")
	private String WEBHOOK_URL;

	@Async
	public void sendReport(ReportSubject subject, String description, Long commentId, Comment comment, Report report) {
		try {
			final Map<String, Object> slackRequest = new HashMap<>();
			slackRequest.put("text", String.format(MESSAGE_TEMPLATE, report.getId(), subject.getName(), description,
				commentId, comment.getContent()));
			final HttpEntity<Map<String, Object>> entity = new HttpEntity<>(slackRequest);
			restTemplate.exchange(WEBHOOK_URL, POST, entity, String.class);
		} catch (Exception e) {
			log.error("Fail to send message to slack: {}", e.getMessage());
		}
	}

}
