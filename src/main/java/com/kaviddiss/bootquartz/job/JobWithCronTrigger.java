package com.kaviddiss.bootquartz.job;

/**
 * 
 */

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

import com.kaviddiss.bootquartz.SchedulerConfig;

/**
 * @author pavan.solapure
 *
 */
@Component
@DisallowConcurrentExecution
@PropertySource("crond.properties")
public class JobWithCronTrigger implements Job {

	@Value("${cron.frequency.jobwithcrontrigger}")
	private String frequency;

	@Bean(name = "jobWithCronTriggerBean")
	public JobDetailFactoryBean sampleJob() {
		return SchedulerConfig.createJobDetail(this.getClass(), "描述");
	}

	@Bean(name = "jobWithCronTriggerBeanTrigger")
	public CronTriggerFactoryBean sampleJobTrigger(@Qualifier("jobWithCronTriggerBean") JobDetail jobDetail) {
		return SchedulerConfig.createCronTrigger(jobDetail, frequency, null);
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Running JobWithSimpleTrigger | frequency {}" + frequency);
	}
}
