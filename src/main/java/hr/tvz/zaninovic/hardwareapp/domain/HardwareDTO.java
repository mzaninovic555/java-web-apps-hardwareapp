package hr.tvz.zaninovic.hardwareapp.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class HardwareDTO {
    private String code;

    private String name;

    private double price;
}
