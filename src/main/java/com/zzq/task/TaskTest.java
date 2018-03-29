package com.zzq.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zzq
 * @createTime 2018/3/29
 */
@Component
public class TaskTest {
    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

    // 定义每五秒执行一次任务
    //@Scheduled(fixedRate = 5000)
    // 使用 cron 表达式，这里的表达式只支持6位，不支持年
    // 4到10秒之间每秒执行一次
    //@Scheduled(cron = "4-40 * * * * ?")
    public void reportCurrentTime(){
        System.out.println("现在时间："+dataFormat.format(new Date()));
    }
}
