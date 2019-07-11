package com.spring.quartz.schedule.job;

import com.hw.wechat.wx.app.entity.HwWechatContentAppEntity;
import com.hw.wechat.wx.app.service.HwWechatAppService;
import com.hw.wechat.wx.log.entity.HwWechatScheduleLogEntity;
import com.hw.wechat.wx.log.service.HwWechatScheduleLogService;
import com.hw.wechat.wx.remotecall.service.HwWechatRemoteCallService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

public class ScheduleJob2 extends QuartzJobBean {

    private HwWechatRemoteCallService remoteCallService;
    private HwWechatScheduleLogService hwWechatScheduleLogService;
    private HwWechatAppService hwWechatAppService;

    public void setHwWechatAppService(HwWechatAppService hwWechatAppService) {
        this.hwWechatAppService = hwWechatAppService;
    }
    public void setHwWechatScheduleLogService(HwWechatScheduleLogService hwWechatScheduleLogService) {
        this.hwWechatScheduleLogService = hwWechatScheduleLogService;
    }
    public void setRemoteCallService(HwWechatRemoteCallService remoteCallService) {
        this.remoteCallService = remoteCallService;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        int state = 1;
        int status=2;
        if (state == 1)
        {
            try {
                System.out.println("------------------任务开始Job2------------------");
                List<HwWechatContentAppEntity> list = hwWechatAppService.findAppSchedule(status);
                if (!list.isEmpty()) {
                    for (HwWechatContentAppEntity entity : list) {
                        System.out.println(entity.getAppWechatName() +"|"+ entity.getAppWechatType());
                        String getCall=remoteCallService.loadWxAccessToken(entity.getId());
                        System.out.println(getCall);
                        int logStatus=1;
                        if(getCall.indexOf("error")>1)
                        {
                            logStatus=0;
                            getCall="获取失败:"+getCall;
                        }else{
                            getCall="获取成功";
                        }
                        HwWechatScheduleLogEntity logEntity= new HwWechatScheduleLogEntity();
                        logEntity.setAppId(entity.getId());
                        logEntity.setLogType(status);
                        logEntity.setLogTitle(entity.getAppWechatName());
                        logEntity.setLogContent(getCall);
                        logEntity.setLogStatus(logStatus);
                        logEntity.setCreateUser("_系统");
                        hwWechatScheduleLogService.saveEntity(logEntity,0);
                    }
                }
                System.out.println("------------------任务结束Job2------------------");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
