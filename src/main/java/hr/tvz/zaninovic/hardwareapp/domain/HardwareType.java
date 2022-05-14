package hr.tvz.zaninovic.hardwareapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HardwareType {
  CPU("CPU"), GPU("GPU"), MBO("MBO"), RAM("RAM"), STORAGE("STORAGE"), OTHER("OTHER");

  private final String hardwareType;
}
