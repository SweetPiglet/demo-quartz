package com.example.demo.quartz.utils;
/**
 * 
 * @version: 1.1.0
 * @Description: 定时任务常量
 * @author: wsq
 * @date: 2020年8月3日上午7:25:15
 */
public class QuartzConstant {

    /**
     * 定时任务状态
     * 
     * @author asiainfo
     *  
     * @date 2016年12月3日 上午12:07:22
     */
    public enum ScheduleStatus {
        /**
         * 正常
         */
    	NORMAL(0),
        /**
         * 暂停
         */
    	PAUSE(1);

        private int value;

        private ScheduleStatus(int value) {
            this.value = value;
        }
        
        public int getValue() {
            return value;
        }
    }



}
