package hr.tvz.zaninovic.hardwareapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
