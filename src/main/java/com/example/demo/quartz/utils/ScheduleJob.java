package com.example.demo.quartz.utils;



import java.lang.reflect.Method;


import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import com.example.demo.quartz.entity.ScheduleJobEntity;




/**
 * 定时任务
 * 
 * @author asiainfo
 *  
 * @date 2016年11月30日 下午12:44:21
 */
@SuppressWarnings("all")
@Component
public class ScheduleJob extends QuartzJobBean {
//	private ExecutorService service = Executors.newSingleThreadExecutor();
//	private ExecutorService service = Executors.newFixedThreadPool(5);
	private static final Logger logger = LoggerFactory.getLogger(ScheduleJob.class);
    @Override
    public void executeInternal(JobExecutionContext context) throws JobExecutionException {

		ScheduleJobEntity scheduleJob = (ScheduleJobEntity) context.getMergedJobDataMap().get(ScheduleJobEntity.JOB_PARAM_KEY);
		//获取spring bean
//        ScheduleJobLogService scheduleJobLogService = (ScheduleJobLogService) SpringContextUtils.getBean("scheduleJobLogService");
        //任务开始时间
        long startTime = System.currentTimeMillis();
        //执行结果返回信息
		Object result = null;
		try {
            //执行任务
			logger.info("任务准备执行，任务ID：" + scheduleJob.getJobId()+"     ExecutorService:" + ScheduleUtils.service);

			Object target = SpringContextUtils.getBean(scheduleJob.getBeanName());
			Method method = null;
			String params = scheduleJob.getParams();
			if(params != null){
				method = target.getClass().getDeclaredMethod(scheduleJob.getMethodName(), String.class);
			}else{
				method = target.getClass().getDeclaredMethod(scheduleJob.getMethodName());
        
            }
			logger.info("Thread id:"+Thread.currentThread().getId()+ ", Thread name:"+Thread.currentThread().getName());
			ReflectionUtils.makeAccessible(method);
			if(params != null){
				result = method.invoke(target, params);
			}else{
				result = method.invoke(target);
			}
			// 将一个方法设置为可调用，主要针对private方法；
			long times = System.currentTimeMillis() - startTime;
			logger.info("任务执行完毕，任务ID：" + scheduleJob.getJobId() + "  总共耗时：" + times + "毫秒   " + "  执行结果：" + "\n");
			// 此定时任务只执行一次，从定时任务中删除
			// ScheduleUtils.deleteScheduleJob(scheduler, scheduleJob.getJobId());
			// 删除任务(否则报错)(本项目以特定一天定时，执行完必须删除，否则再次启动项目执行报错)
			// schedulerJobDao.delete(scheduleJob.getJobId());
		} catch (Exception e) {
			logger.error("任务执行失败，任务ID：" + scheduleJob.getJobId(), e);
			//任务执行总时长
			long times = System.currentTimeMillis() - startTime;
		}
    }
}
