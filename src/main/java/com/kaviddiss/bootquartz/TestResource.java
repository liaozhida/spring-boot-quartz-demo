//package com.kaviddiss.bootquartz;
//
//import org.quartz.Scheduler;
//import org.quartz.SchedulerException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/test")
//public class TestResource {
//
//	@Autowired
//	private Scheduler scheduler;
//
//	@RequestMapping(value = "/a", method = RequestMethod.GET)
//	public String templateAbortTicket() throws SchedulerException, InterruptedException {
//
////		JobDetail jobDetail = JobBuilder.newJob(SampleJob.class).storeDurably(true).build();
////
////		Trigger trigger = TriggerBuilder.newTrigger().forJob(jobDetail).startNow().build();
////
////		scheduler.scheduleJob(jobDetail, trigger);
////
////		Thread.sleep(5000);
//
//		return "ok";
//	}
//}
