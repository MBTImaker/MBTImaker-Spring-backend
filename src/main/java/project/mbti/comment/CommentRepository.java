package project.mbti.comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.mbti.comment.dto.CommentDto;
import project.mbti.comment.dto.ReplytDto;
import project.mbti.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select new project.mbti.comment.dto." +
            "CommentDto(c.id, c.createdDate, c.mbti, c.name, c.password, c.content, c.children.size - 1, c.state) " +
            "from Comment c " +
            "where c.id = c.parent.id and c.state = 'WRITTEN'")
    Page<CommentDto> findCommentDtoPage(Pageable pageable);

    @Query("select new project.mbti.comment.dto." +
            "ReplytDto(c.id, c.parent.id, c.createdDate, c.mbti, c.name, c.password, c.content) " +
            "from Comment c " +
            "where c.parent.id = :parentId and c.id <> c.parent.id")
    Page<ReplytDto> findReplyDtoPage(@Param("parentId") Long parentId, Pageable pageable);
}