package com.spring.quartz.schedule;

import com.hw.wechat.schedule.job.ScheduleJob1;
import com.hw.wechat.schedule.job.ScheduleJob2;
import com.hw.wechat.wx.app.service.HwWechatAppService;
import com.hw.wechat.wx.log.service.HwWechatScheduleLogService;
import com.hw.wechat.wx.remotecall.service.HwWechatRemoteCallService;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * 定时任务配置
 * @author chengjian
 * @date 2019/5/2
 */
@Configuration
@EnableScheduling
public class QuartzSchedulerConfig {
    @Bean(name = "job1DataMap")
    public JobDataMap job1DataMap(
            @Autowired HwWechatAppService hwWechatAppService,
            @Autowired HwWechatScheduleLogService hwWechatScheduleLogService,
            @Autowired HwWechatRemoteCallService remoteCallService
    ) {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("hwWechatAppService", hwWechatAppService);
        jobDataMap.put("remoteCallService", remoteCallService);
        jobDataMap.put("hwWechatScheduleLogService", hwWechatScheduleLogService);
        return jobDataMap;
    }

    @Bean(name = "job2DataMap")
    public JobDataMap job2DataMap(
            @Autowired HwWechatAppService hwWechatAppService,
            @Autowired HwWechatScheduleLogService hwWechatScheduleLogService,
            @Autowired HwWechatRemoteCallService remoteCallService
    ) {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("hwWechatAppService", hwWechatAppService);
        jobDataMap.put("remoteCallService", remoteCallService);
        jobDataMap.put("hwWechatScheduleLogService", hwWechatScheduleLogService);
        return jobDataMap;
    }

    @Bean(name = "job1Factory")
    public JobDetailFactoryBean jobDetailFactoryBean1(@Qualifier("job1DataMap") JobDataMap job1DataMap) {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobDataMap(job1DataMap);
        jobDetailFactoryBean.setJobClass(ScheduleJob1.class);
        jobDetailFactoryBean.setName("job1Factory");
        return jobDetailFactoryBean;
    }

    @Bean(name = "job2Factory")
    public JobDetailFactoryBean jobDetailFactoryBean2(@Qualifier("job2DataMap") JobDataMap job2DataMap) {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobDataMap(job2DataMap);
        jobDetailFactoryBean.setJobClass(ScheduleJob2.class);
        jobDetailFactoryBean.setName("job2Factory");
        return jobDetailFactoryBean;
    }


    @Bean(name = "cronTrigger1")
    public CronTriggerFactoryBean cronTriggerFactoryBean1(@Qualifier("job1Factory") JobDetailFactoryBean job1DetailFactoryBean) {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(job1DetailFactoryBean.getObject());
        //simpleTriggerFactoryBean.setBeanName("simpleTrigger");
        //simpleTriggerFactoryBean.setStartDelay(3000);
        //simpleTriggerFactoryBean.setRepeatInterval(25000);
        cronTriggerFactoryBean.setBeanName("cronTrigger1");
        cronTriggerFactoryBean.setStartDelay(6000);
        cronTriggerFactoryBean.setCronExpression("0 */30 * * * ?");
        return cronTriggerFactoryBean;
    }

    @Bean(name = "cronTrigger2")
    public CronTriggerFactoryBean cronTriggerFactoryBean2(@Qualifier("job2Factory") JobDetailFactoryBean job1DetailFactoryBean) {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(job1DetailFactoryBean.getObject());
        cronTriggerFactoryBean.setBeanName("cronTrigger2");
        cronTriggerFactoryBean.setStartDelay(30000);
        cronTriggerFactoryBean.setCronExpression("0 0 */1 * * ?");
        return cronTriggerFactoryBean;
    }


    @Bean(name = "quartzScheduler")
    //public SchedulerFactoryBean schedulerFactoryBean1(@Qualifier("cronTrigger1") CronTrigger simpleTriggerFactoryBean, @Qualifier("cronTrigger2")CronTrigger cronTriggerFactoryBean) {
        public SchedulerFactoryBean schedulerFactoryBean1(@Qualifier("cronTrigger1") CronTrigger simpleTriggerFactoryBean, @Qualifier("cronTrigger2")CronTrigger cronTriggerFactoryBean) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setAutoStartup(true);
        schedulerFactoryBean.setBeanName("quartzScheduler1");
        schedulerFactoryBean.setTriggers(simpleTriggerFactoryBean,cronTriggerFactoryBean);
        return schedulerFactoryBean;
    }

}
