package com.example.demo.quartz.job;

import org.springframework.stereotype.Component;
/**
 * 
 * @version: 1.1.0
 * @Description: 测试任务类
 * @author: wsq
 * @date: 2020年8月3日下午8:02:37
 */
@Component(value = "TestJobSecond")
public class TestJobSecond {
	public void firstTest() {
		System.out.println("This is the testJobSecond firstTest!");
	}
	public void secondTest() {
		System.out.println("This is the testJobSecond secnodTest!");
	}
	public void thirdTest() {
		System.out.println("This is the testJobSecond thirdTest!");
	}

}
