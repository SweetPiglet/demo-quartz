package com.example.demo.quartz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.quartz.entity.ScheduleJobEntity;
import com.example.demo.quartz.service.ScheduleJobService;
import com.example.demo.quartz.utils.R;

/**
 * 
 * @version: 1.1.0
 * @Description: 定时任务controller层
 * @author: wsq
 * @date: 2020年8月3日上午7:50:18
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleJobController {
@Autowired
private ScheduleJobService scheduleJobService;
@PostMapping("/add")
public R add(@RequestBody ScheduleJobEntity scheduleJobEntity) {
	scheduleJobService.add(scheduleJobEntity);
	return R.ok();
}
}
