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
public class SampleTrigger implements Job {

	@Value("${cron.frequency.SampleJob}")
	private String frequency;

	@Bean(name = "SampleJob")
	public JobDetailFactoryBean sampleJob() {
		return SchedulerConfig.createJobDetail(this.getClass(), "");
	}

	@Bean(name = "SampleTrigger")
	public CronTriggerFactoryBean sampleJobTrigger(@Qualifier("SampleJob") JobDetail jobDetail) {
		return SchedulerConfig.createCronTrigger(jobDetail, frequency, null);
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Running SampleTrigger | frequency {}" + frequency);
	}
}
