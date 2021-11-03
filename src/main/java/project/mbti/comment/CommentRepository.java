package project.mbti.comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.mbti.comment.dto.CommentDto;
import project.mbti.comment.entity.Comment;
import project.mbti.comment.entity.MBTI;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select new project.mbti.comment.dto." +
            "CommentDto(c.id, c.parent.id, c.createdDate, c.name, c.password, c.content) " +
            "from Comment c where c.mbti = :mbti")
    Page<CommentDto> findCommentDtoPage(Pageable pageable, @Param("mbti") MBTI mbti);
}
