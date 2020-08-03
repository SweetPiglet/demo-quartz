package com.example.demo.quartz.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo.quartz.entity.ScheduleJobEntity;
/**
 * 
 * @version: 1.1.0
 * @Description: 定时任务dao层
 * @author: wsq
 * @date: 2020年8月2日下午8:59:11
 */
@Mapper
public interface ScheduleJobDao<T> {
	/**
	 * 
	 * @version: 1.1.0
	 * @Description: 查询定时任务集合
	 * @author: wsq
	 * @date: 2020年8月2日下午8:59:11
	 */
	List<ScheduleJobEntity> queryList();
	/**
	 * 
	 * @version: 1.1.0
	 * @Description: 查询定时任务根据params
	 * @author: wsq
	 * @date: 2020年8月2日下午8:59:11
	 */
	public ScheduleJobEntity queryEntityByParams(ScheduleJobEntity scheduleJobEntity);
	/**
	 * 
	 * @version: 1.1.0
	 * @Description: 添加定时任务
	 * @author: wsq
	 * @date: 2020年8月2日下午8:59:11
	 */
	void add(ScheduleJobEntity scheduleJobEntity);
	/**
	 * 
	 * @version: 1.1.0
	 * @Description: 更新定时任务
	 * @author: wsq
	 * @date: 2020年8月2日下午8:59:11
	 */
	int update(ScheduleJobEntity scheduleJobEntity);
	/**
	 * 
	 * @version: 1.1.0
	 * @Description: 删除定时任务
	 * @author: wsq
	 * @date: 2020年8月2日下午8:59:11
	 */
	int delete(Long jobId);
	/**
	 * 
	 * @version: 1.1.0
	 * @Description: 查找数据总数
	 * @author: wsq
	 * @date: 2020年8月2日下午8:59:11
	 */
	int queryTotal();
}
