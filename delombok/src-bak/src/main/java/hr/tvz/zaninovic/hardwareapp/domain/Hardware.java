package hr.tvz.zaninovic.hardwareapp.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Hardware {
    private String name;

    private String code;

    private double price;

    private HardwareType hardwareType;

    private int amount;
}
