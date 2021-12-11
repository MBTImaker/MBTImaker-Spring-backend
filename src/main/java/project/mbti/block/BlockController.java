package project.mbti.block;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.mbti.block.dto.BlockIpDto;
import project.mbti.block.entity.Block;
import project.mbti.response.result.ResultResponse;

import javax.validation.constraints.NotNull;

import static project.mbti.response.result.ResultCode.*;

@Api(tags = "차단 API")
@RestController
@RequiredArgsConstructor
public class BlockController {

    private final BlockService blockService;

    @ApiOperation(value = "IP 차단", notes = "IP 차단 시, 댓글&신고 작성이 불가능 합니다.")
    @PostMapping("/block")
    public ResponseEntity<ResultResponse> block(@Validated @RequestBody BlockIpDto dto) {
        final Block block = blockService.create(dto.getIp());

        return ResponseEntity.ok()
                .body(ResultResponse.of(BLOCK_IP_SUCCESS, block));
    }

    @ApiOperation("IP 차단 목록 페이징 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "페이지", example = "1", required = true),
            @ApiImplicitParam(name = "size", value = "차단 명단 수", example = "5", required = true)
    })
    @GetMapping("/block")
    public ResponseEntity<ResultResponse> blockList(
            @Validated @NotNull(message = "페이지를 입력해주세요.") @RequestParam int page,
            @Validated @NotNull(message = "차단 명단 수를 입력해주세요.") @RequestParam int size) {
        final Page<Block> blocks = blockService.getBlockPage(page, size);

        return ResponseEntity.ok()
                .body(ResultResponse.of(FIND_BLOCK_PAGE_SUCCESS, blocks));
    }

    @ApiOperation("IP 차단 해제")
    @DeleteMapping("/block")
    public ResponseEntity<ResultResponse> unblock(@Validated @RequestBody BlockIpDto dto) {
        blockService.delete(dto.getIp());
        final BlockIpDto blockIpDto = new BlockIpDto(dto.getIp());

        return ResponseEntity.ok()
                .body(ResultResponse.of(UNBLOCK_IP_SUCCESS, blockIpDto));
    }
}
