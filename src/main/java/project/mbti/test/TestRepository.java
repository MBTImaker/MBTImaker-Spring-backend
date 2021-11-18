package project.mbti.test;

import org.springframework.data.jpa.repository.JpaRepository;
import project.mbti.test.entity.Test;

public interface TestRepository extends JpaRepository<Test, Long> {
}
