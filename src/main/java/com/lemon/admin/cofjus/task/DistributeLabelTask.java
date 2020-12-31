package com.lemon.admin.cofjus.task;

import com.lemon.admin.cofjus.service.impl.DistributeLabelServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DistributeLabelTask {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    DistributeLabelServiceImpl distributeLabelService;

    @Scheduled(cron="0 00 3 ? * *")
    public void distribute(){
        distributeLabelService.workoutLastDayLabel();
        logger.info("昨日任务已经处理完成");
        distributeLabelService.distributeTodayLabel();
        logger.info("今日任务已经分配完成");
    }
}
