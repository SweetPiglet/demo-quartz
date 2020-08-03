package com.example.demo.quartz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.quartz.Scheduler;
import org.quartz.SchedulerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.quartz.dao.ScheduleJobDao;
import com.example.demo.quartz.entity.ScheduleJobEntity;
import com.example.demo.quartz.service.ScheduleJobService;
import com.example.demo.quartz.utils.QuartzConstant;
import com.example.demo.quartz.utils.ScheduleUtils;


/**
 * 
 * @version: 1.1.0
 * @Description: 定时任务service层
 * @author: wsq
 * @date: 2020年8月2日下午9:08:08
 */
// @SuppressWarnings("all")
@Service
public class ScheduleJobServiceImpl implements ScheduleJobService {
	private static Logger logger = LoggerFactory.getLogger(ScheduleJobServiceImpl.class);
	@Autowired
    private Scheduler scheduler;
	@Autowired
	private ScheduleJobDao schedulerJobDao;
	/**
	 * 项目启动时，初始化定时器
	 */
	@PostConstruct  
	public void init(){
		logger.info("定时任务开始初始化了......");
		// 获取定时任务列表
		List<ScheduleJobEntity> scheduleJobEntityList = schedulerJobDao.queryList();
		scheduleJobEntityList.forEach(x -> {
			// 开启库中的定时任务
			ScheduleUtils.createScheduleJob(scheduler, x);
		});
		logger.info("定时任务初始化完成了......");
	}
	@Override
	public List<ScheduleJobEntity> queryList(ScheduleJobEntity scheduleJobEntity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ScheduleJobEntity queryEntityByParams(ScheduleJobEntity scheduleJobEntity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int queryTotal() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * 
	 * @version: 1.1.0
	 * @Description: 定时任务的添加
	 * @author: wsq
	 * @date: 2020年8月2日下午9:08:08
	 */
	// @Transactional // 防止任务入库后，却由于其他原因，创建定时任务失败
	@Override
	public void add(ScheduleJobEntity scheduleJobEntity) {
		// TODO Auto-generated method stub
		// 添加定时任务入库
		schedulerJobDao.add(scheduleJobEntity);
		// 添加定时任务的状态
		scheduleJobEntity.setStatus(QuartzConstant.ScheduleStatus.NORMAL.getValue());
		// 创建定时任务
		ScheduleUtils.createScheduleJob(scheduler, scheduleJobEntity);
	}
	@Override
	public void update(ScheduleJobEntity scheduleJob) {
		// TODO Auto-generated method stub
		
	}

}
