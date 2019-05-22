package at.nacs.cashier.persistance.domain;


import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
public class Ticket {

  @Id
  @GeneratedValue
  private Long id;

  @Column(unique = true)
  private String uuid;

  @OneToMany
  @LazyCollection(LazyCollectionOption.FALSE)
  @Builder.Default
  private List<Product> products = new ArrayList<>();

  private Double total;
}
