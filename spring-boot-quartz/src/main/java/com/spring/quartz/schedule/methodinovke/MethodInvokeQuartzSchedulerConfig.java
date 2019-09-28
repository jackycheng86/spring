package com.spring.quartz.schedule.methodinovke;

import org.quartz.CronTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
@EnableScheduling
public class MethodInvokeQuartzSchedulerConfig {

    @Bean(name = "methodJobFactory1")
    public MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean1(@Qualifier("methodJob1") MethodJob1 methodJob1){
        MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean=new MethodInvokingJobDetailFactoryBean();
        methodInvokingJobDetailFactoryBean.setTargetObject(methodJob1);
        methodInvokingJobDetailFactoryBean.setTargetMethod("doJob");
        return methodInvokingJobDetailFactoryBean;
    }

    @Bean(name = "methodJobFactory2")
    public MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean2(@Qualifier("methodJob2") MethodJob2 methodJob2){
        MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean=new MethodInvokingJobDetailFactoryBean();
        methodInvokingJobDetailFactoryBean.setTargetObject(methodJob2);
        methodInvokingJobDetailFactoryBean.setTargetMethod("doJob");
        return methodInvokingJobDetailFactoryBean;
    }

    @Bean(name = "methodCronTrigger1")
    public CronTriggerFactoryBean cronTriggerFactoryBean1(@Qualifier("methodJobFactory1") MethodInvokingJobDetailFactoryBean jobDetailFactoryBean) {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        cronTriggerFactoryBean.setBeanName("methodCronTrigger1");
        cronTriggerFactoryBean.setStartDelay(1000);
        cronTriggerFactoryBean.setCronExpression("10/20 * * * * ? ");
        return cronTriggerFactoryBean;
    }

    @Bean(name = "methodCronTrigger2")
    public CronTriggerFactoryBean cronTriggerFactoryBean2(@Qualifier("methodJobFactory2") MethodInvokingJobDetailFactoryBean jobDetailFactoryBean) {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        cronTriggerFactoryBean.setBeanName("methodCronTrigger2");
        cronTriggerFactoryBean.setStartDelay(3000);
        cronTriggerFactoryBean.setCronExpression("10/30 * * * * ? ");
        return cronTriggerFactoryBean;
    }


    @Bean(name = "methodQuartzScheduler")
    public SchedulerFactoryBean schedulerFactoryBean(@Qualifier("methodCronTrigger1") CronTrigger simpleTriggerFactoryBean, @Qualifier("methodCronTrigger2") CronTrigger cronTriggerFactoryBean) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setAutoStartup(true);
        schedulerFactoryBean.setBeanName("methodQuartzScheduler");
        schedulerFactoryBean.setTriggers(simpleTriggerFactoryBean, cronTriggerFactoryBean);
        return schedulerFactoryBean;
    }

}
