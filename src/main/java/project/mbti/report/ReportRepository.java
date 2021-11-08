package project.mbti.report;

import org.springframework.data.jpa.repository.JpaRepository;
import project.mbti.report.entity.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
