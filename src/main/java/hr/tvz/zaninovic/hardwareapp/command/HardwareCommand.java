package hr.tvz.zaninovic.hardwareapp.command;

import hr.tvz.zaninovic.hardwareapp.domain.HardwareType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import lombok.Getter;

@Getter
public class HardwareCommand {

  @NotBlank(message = "Name must not be empty")
  private String name;

  @NotBlank(message = "Code must not be empty")
  @Pattern(message = "Code must only contain digits", regexp = "\\d+")
  private String code;

  @PositiveOrZero(message = "Price can't be a negative integer")
  private double price;

  @NotNull(message = "Hardware type must not be empty")
  private HardwareType hardwareType;

  @PositiveOrZero(message = "Amount can't be a negative integer")
  private int amount;
}
