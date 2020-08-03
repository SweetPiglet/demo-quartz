package com.example.demo.quartz.test;
import javax.print.attribute.standard.SheetCollate;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 
 * @version: 1.1.0
 * @Description: 定时测试
 * @author: wsq
 * @date: 2020年8月2日下午6:37:32
 */
public class QuartzTest {
public static void main(String[] args) throws SchedulerException {
	// 创建job
	JobDetail jobDetail = JobBuilder.newJob(JobDemo.class).build();
	// 创建trigger
	CronTrigger cronTrigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?")).build();
	// 创建schedule
	Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
	scheduler.scheduleJob(jobDetail, cronTrigger);
	// 开启定时任务
	scheduler.start();
}
}
