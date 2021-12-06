package project.mbti.block;

import org.springframework.data.jpa.repository.JpaRepository;
import project.mbti.block.entity.Block;

import java.util.Optional;

public interface BlockRepository extends JpaRepository<Block, Long> {
    Optional<Block> findByIp(String ip);
}
