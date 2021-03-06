package at.nacs.cashier.persistance.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

  @Id
  @GeneratedValue
  private Long id;

  @Column(unique = true)
  private String name;

  private Double price;
}
