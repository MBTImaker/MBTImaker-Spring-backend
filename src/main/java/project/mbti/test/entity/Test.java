package project.mbti.test.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import project.mbti.MBTI;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "tests")
@NoArgsConstructor(access = PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Test {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "test_id")
    private Long id;

    @Enumerated(value = STRING)
    private MBTI mbti;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    public Test(MBTI mbti) {
        this.mbti = mbti;
    }
}
