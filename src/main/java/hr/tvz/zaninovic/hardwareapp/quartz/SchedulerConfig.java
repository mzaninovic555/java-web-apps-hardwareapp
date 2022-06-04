package hr.tvz.zaninovic.hardwareapp.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {
  @Bean
  public JobDetail hardwareListJobBuilder() {
    return JobBuilder.newJob(HardwareListJob.class)
        .withIdentity("hardwareListJob")
        .storeDurably()
        .build();
  }

  @Bean
  public Trigger hardwareListJobTrigger() {
    SimpleScheduleBuilder scheduleBuilder =
        SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever();

    return TriggerBuilder.newTrigger()
        .forJob(hardwareListJobBuilder())
        .withIdentity("hardwareListTrigger")
        .withSchedule(scheduleBuilder)
        .build();
  }
}
