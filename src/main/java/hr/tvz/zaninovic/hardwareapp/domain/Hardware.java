package hr.tvz.zaninovic.hardwareapp.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Hardware {

  @Id
  @GeneratedValue
  private String code;

  @Column
  private String name;

  @Column
  private Double price;

  @Column(name = "hardware_type")
  @Enumerated(EnumType.STRING)
  private HardwareType hardwareType;

  @Column
  private int amount;

  @OneToMany(mappedBy = "hardware", fetch = FetchType.EAGER)
  private List<Review> reviews;

  public Hardware(String code, String name, Double price, HardwareType hardwareType, int amount) {
    this.code = code;
    this.name = name;
    this.price = price;
    this.hardwareType = hardwareType;
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Hardware hardware = (Hardware) o;
    return code.equals(hardware.code)
        && name.equals(hardware.getName())
        && price.equals(hardware.getPrice())
        && hardwareType.equals(hardware.getHardwareType())
        && amount == hardware.getAmount();
  }
}
