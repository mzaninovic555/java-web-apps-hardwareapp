package hr.tvz.zaninovic.hardwareapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Hardware {
    private String code;

    private String name;


    private double price;

    private HardwareType hardwareType;

    private int amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Hardware hardware = (Hardware) o;
        return code.equals(hardware.code);
    }
}
