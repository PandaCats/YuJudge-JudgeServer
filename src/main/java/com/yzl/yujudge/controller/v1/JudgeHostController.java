package com.yzl.yujudge.controller.v1;

import com.yzl.yujudge.bo.JudgeHostBO;
import com.yzl.yujudge.core.common.UnifiedResponse;
import com.yzl.yujudge.dto.JudgeHostDTO;
import com.yzl.yujudge.service.JudgeHostService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yuzhanglong
 * @description 判题服务器相关控制层
 * @date 2020-7-30
 */

@RestController
@Validated
@CrossOrigin
@RequestMapping("/judge_host")
public class JudgeHostController {
    private final JudgeHostService judgeHostService;

    public JudgeHostController(JudgeHostService judgeHostService) {
        this.judgeHostService = judgeHostService;
    }

    /**
     * @author yuzhanglong
     * @description 查看所有判题服务器信息
     * @date 2020-7-30 18:20
     */
    @GetMapping("/inspect_all")
    public UnifiedResponse inspectJudgeHost() {
        List<JudgeHostBO> judgeHostBOList = judgeHostService.inspectJudgeHosts();
        // TODO: BO转化为VO，觉得这里意义不大.....
        return new UnifiedResponse(judgeHostBOList);
    }

    /**
     * @author yuzhanglong
     * @description 添加一个judgeHost记录
     * @date 2020-7-30 18:31
     */
    @PostMapping("/create")
    public UnifiedResponse createJudgeHost(@RequestBody @Validated JudgeHostDTO judgeHostDTO) {
        judgeHostService.createJudgeHost(judgeHostDTO);
        return new UnifiedResponse("添加判题服务器信息成功");
    }
}