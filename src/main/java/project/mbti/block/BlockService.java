package project.mbti.block;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.mbti.block.entity.Block;
import project.mbti.exception.AlreadyBlockedIpException;
import project.mbti.exception.IpNotFoundException;

import static org.springframework.data.domain.Sort.Direction.DESC;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BlockService {

    private final BlockRepository blockRepository;

    @Transactional
    public Block create(String ip) {
        if (blockRepository.findByIp(ip).isPresent())
            throw new AlreadyBlockedIpException();

        return blockRepository.save(new Block(ip));
    }

    public Page<Block> getBlockPage(int page, int size) {
        page = (page == 0 ? 0 : page - 1);
        Pageable pageable = PageRequest.of(page, size, Sort.by(DESC, "id"));
        return blockRepository.findAll(pageable);
    }

    @Transactional
    public void delete(String ip) {
        final Block block = blockRepository.findByIp(ip).orElseThrow(IpNotFoundException::new);
        blockRepository.delete(block);
    }
}
