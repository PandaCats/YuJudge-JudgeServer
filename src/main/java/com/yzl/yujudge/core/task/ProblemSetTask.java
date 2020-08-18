package com.yzl.yujudge.core.task;

import com.yzl.yujudge.bo.ScoreBoardBO;
import com.yzl.yujudge.model.ProblemSetEntity;
import com.yzl.yujudge.repository.ProblemSetRepository;
import com.yzl.yujudge.service.ProblemSetService;
import com.yzl.yujudge.store.redis.ProblemSetCache;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author yuzhanglong
 * @description 题目集相关定时任务
 * @date 2020-08-14 12:59:01
 */
@Component
public class ProblemSetTask {
    private final ProblemSetRepository problemSetRepository;
    private final ProblemSetService problemSetService;
    private final ProblemSetCache problemSetCache;

    public ProblemSetTask(
            ProblemSetRepository problemSetRepository,
            ProblemSetService problemSetService,
            ProblemSetCache problemSetCache) {
        this.problemSetRepository = problemSetRepository;
        this.problemSetService = problemSetService;
        this.problemSetCache = problemSetCache;
    }

    /**
     * @author yuzhanglong
     * @description 更新活跃题目集记分板的信息
     * @date 2020-08-14 14:32:12
     */
    @Scheduled(fixedDelay = 5 * 1_000)
    public void renewActiveProblemSetScoreBoard() {
        Date current = new Date();
        List<ProblemSetEntity> activeProblemSets = problemSetRepository.fineBetweenCurrentTime(current);
        for (ProblemSetEntity activeProblemSet : activeProblemSets) {
            ScoreBoardBO scoreBoardBO = problemSetService.getProblemSetScoreBoard(activeProblemSet);
            problemSetCache.setProblemSetScoreBoardCache(scoreBoardBO, activeProblemSet.getId().toString());
        }
    }
}
