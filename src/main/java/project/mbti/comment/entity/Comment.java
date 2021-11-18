package project.mbti.comment.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import project.mbti.comment.dto.CommentDto;
import project.mbti.MBTI;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;
import static project.mbti.comment.entity.CommentState.WRITTEN;

@Entity
@Getter
@Table(name = "comments")
@NoArgsConstructor(access = PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Comment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "parent_id")
    private Comment parent;

    @OneToMany(mappedBy = "parent")
    private List<Comment> children = new ArrayList<>();

    @Enumerated(value = STRING)
    private MBTI mbti;

    @Enumerated(value = STRING)
    private CommentState state;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    private String name;
    private String password;
    private String content;

    @Builder
    public Comment(Optional<Comment> parent, MBTI mbti, String name, String password, String content) {
        this.parent = (parent.isEmpty() ? this : parent.get());
        this.mbti = mbti;
        this.name = name;
        this.password = password;
        this.content = content;
        this.state = WRITTEN;
    }

    public CommentDto convert() {
        return CommentDto.builder()
                .id(getId())
                .parentId(getParent().getId())
                .createdDate(getCreatedDate())
                .name(getName())
                .password(getPassword())
                .content(getContent())
                .build();
    }
}
