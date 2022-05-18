package hr.tvz.zaninovic.hardwareapp.command;

import hr.tvz.zaninovic.hardwareapp.domain.HardwareType;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

@Getter
public class HardwareCommand {

    @NotBlank(message = "Name must not be empty")
    private String name;

    @NotBlank(message = "Code must not be empty")
    @Pattern(message = "Code must only contain digits", regexp = "[0-9]+")
    private String code;

    @NotBlank(message = "Price must not be empty")
    @PositiveOrZero(message = "Price can't be a negative integer")
    private double price;

    @NotBlank(message = "Hardware type must not be empty")
    private HardwareType hardwareType;

    @NotBlank(message = "Amount must not be empty")
    @PositiveOrZero(message = "Amount can't be a negative integer")
    private int amount;
}
