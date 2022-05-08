package hr.tvz.zaninovic.hardwareapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@EqualsAndHashCode
public class Review {

  @Id
  @GeneratedValue
  private Integer id;

  @Column
  private String title;

  @Column
  private String content;

  @Column
  private Integer grade;

  @ManyToOne
  @JoinColumn(name = "hardware_Id")
  private Hardware hardware;
}
