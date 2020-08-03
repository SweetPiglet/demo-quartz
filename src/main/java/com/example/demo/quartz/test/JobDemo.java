package com.example.demo.quartz.test;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 
 * @version: 1.1.0
 * @Description: 任务实现列表
 * @author: wsq
 * @date: 2020年8月2日下午6:40:57
 */
public class JobDemo implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("This is a job workding......");
	}

}
