package project.mbti.report;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.mbti.comment.CommentRepository;
import project.mbti.report.dto.ReportAddDto;
import project.mbti.report.dto.ReportUpdateDto;
import project.mbti.report.entity.Report;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;
    private final CommentRepository commentRepository;

    public Page<Report> findAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by(ASC, "id"));
        return reportRepository.findAll(pageable);
    }

    @Transactional
    public Report create(ReportAddDto reportAddDto){
            Report report = Report.builder()
                .comment(commentRepository.findById(reportAddDto.getCommentId()))
                .description(reportAddDto.getDescription())
                .type(reportAddDto.getType())
                .build();
        return reportRepository.save(report);
    }

    @Transactional
    public Report update(ReportUpdateDto reportUpdateDto){
        Report report = reportRepository.findById(reportUpdateDto.getId())
            .orElseThrow(()-> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        report.update(reportUpdateDto.getState());
        return report;
    }

}
