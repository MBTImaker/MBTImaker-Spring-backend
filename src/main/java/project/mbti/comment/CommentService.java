package project.mbti.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.mbti.block.BlockRepository;
import project.mbti.comment.dto.CommentDto;
import project.mbti.comment.dto.CommentWriteResultType;
import project.mbti.comment.dto.ReplytDto;
import project.mbti.comment.entity.Comment;
import project.mbti.MBTI;
import project.mbti.comment.entity.CommentState;
import project.mbti.exception.CommentNameNotMatchException;
import project.mbti.exception.CommentNotFoundException;
import project.mbti.exception.CommentPasswordNotMatchException;
import project.mbti.exception.InvalidMbtiException;
import project.mbti.report.ReportRepository;
import project.mbti.util.BadWordsFilter;

import javax.persistence.EntityManager;

import java.time.LocalDateTime;

import static org.springframework.data.domain.Sort.Direction.*;
import static project.mbti.comment.dto.CommentWriteResultType.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ReportRepository reportRepository;
    private final BlockRepository blockRepository;
    private final BadWordsFilter badWordsFilter;
    private final EntityManager em;

    @Transactional
    public CommentWriteResultType create(MBTI mbti, String name, String password, String content, Long parentId, String ip) {
        CommentWriteResultType result;
        if (blockRepository.findByIp(ip).isPresent())
            result = BLOCKED_IP;
        else {
            if (mbti.equals(MBTI.NOT_FOUND))
                throw new InvalidMbtiException();

            final Comment comment = Comment.builder()
                    .mbti(mbti)
                    .name(name)
                    .password(password)
                    .content(badWordsFilter.filterText(content))
                    .parent(commentRepository.findById(parentId))
                    .ip(ip)
                    .build();

            result = SUCCESS;
            commentRepository.save(comment);
        }

        return result;
    }

    @Transactional
    public Comment delete(Long id, String name, String password) {
        final Comment findComment = commentRepository.findById(id).orElseThrow(CommentNotFoundException::new);
        validateComment(name, password, findComment);

        findComment.updateState(CommentState.DELETED);
        em.flush();
        reportRepository.bulkUpdateReportStateByCommentId(id, "댓글 작성자가 해당 댓글을 삭제함 - " + LocalDateTime.now());

        return findComment;
    }

    private void validateComment(String name, String password, Comment findComment) {
        if (!findComment.getName().equals(name))
            throw new CommentNameNotMatchException();
        else if (!findComment.getPassword().equals(password))
            throw new CommentPasswordNotMatchException();
    }

    public Page<CommentDto> getCommentPage(int page, int size) {
        page = (page == 0 ? 0 : page - 1);
        Pageable pageable = PageRequest.of(page, size, Sort.by(DESC, "id"));
        return commentRepository.findCommentDtoPage(pageable);
    }

    public Page<ReplytDto> getReplyPage(Long parentId, int page, int size) {
        page = (page == 0 ? 0 : page - 1);
        Pageable pageable = PageRequest.of(page, size, Sort.by(ASC, "id"));
        return commentRepository.findReplyDtoPage(parentId, pageable);
    }
}
