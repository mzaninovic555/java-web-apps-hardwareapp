package hr.tvz.zaninovic.hardwareapp.validation;

import hr.tvz.zaninovic.hardwareapp.domain.HardwareType;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

@Getter
public class HardwareCommand {

    @NotBlank(message = "Name must not be empty")
    private String name;

    @NotBlank(message = "Code must not be empty")
    @Pattern(message = "Code must only contain digits", regexp = "[0-9]+")
    private String code;

    @PositiveOrZero(message = "Price can't be a negative integer")
    private double price;

    @NotNull(message = "Hardware type must not be empty")
    private HardwareType hardwareType;

    @PositiveOrZero(message = "Amount can't be a negative integer")
    private int amount;
}
