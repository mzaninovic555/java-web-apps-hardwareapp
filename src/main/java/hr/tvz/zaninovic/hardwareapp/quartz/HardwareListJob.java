package hr.tvz.zaninovic.hardwareapp.quartz;

import hr.tvz.zaninovic.hardwareapp.domain.HardwareDTO;
import hr.tvz.zaninovic.hardwareapp.service.HardwareService;
import java.util.List;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class HardwareListJob extends QuartzJobBean {

  private final HardwareService hardwareService;

  public HardwareListJob(HardwareService hardwareService) {
    this.hardwareService = hardwareService;
  }

  private void printHardwareList() {
    List<HardwareDTO> hardwareList = hardwareService.findAll();
    StringBuilder stringHardwareList = new StringBuilder();

    for(HardwareDTO h : hardwareList) {
      stringHardwareList.append(h.toString()).append("\n");
    }

    System.out.println(stringHardwareList);
  }

  @Override
  protected void executeInternal(JobExecutionContext context) {
    printHardwareList();
  }
}
