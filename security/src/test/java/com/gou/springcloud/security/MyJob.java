package com.gou.springcloud.security;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author goujianjun
 * @email lygoujianjun@163.com
 * @date 2019-12-28 22:33
 */

public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

    }
}
