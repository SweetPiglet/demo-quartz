package com.example.demo.quartz.service;

import java.util.List;

import com.example.demo.quartz.entity.ScheduleJobEntity;


/**
 * 
 * @version: 1.1.0
 * @Description: 定时任务service层
 * @author: wsq
 * @date: 2020年8月2日下午9:06:20
 */
public interface ScheduleJobService {


	
	/**
	 * 查询定时任务列表
	 */
	List<ScheduleJobEntity> queryList(ScheduleJobEntity scheduleJobEntity);
	/**
	 * 
	 * @Description: 根据params查询定时任务
	 * @author wsq
	 * @date 2019-12-20 04:35:12
	 */
	public ScheduleJobEntity queryEntityByParams(ScheduleJobEntity scheduleJobEntity);
	
	/**
	 * 查询总数
	 */
	int queryTotal();
	
	/**
	 * 保存定时任务
	 */
	void add(ScheduleJobEntity scheduleJobEntity);
	
	/**
	 * 更新定时任务
	 */
	void update(ScheduleJobEntity scheduleJob);

}
