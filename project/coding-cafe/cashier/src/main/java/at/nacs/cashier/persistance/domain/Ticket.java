package at.nacs.cashier;


import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
public class Ticket {


  @Id
  @GeneratedValue
  private Long id;


  @Column(unique = true)
  private UUID uuid;


  @OneToMany
  @LazyCollection(LazyCollectionOption.FALSE)
  @Builder.Default
  private List<Product> products = new ArrayList<>();

  private Double total;

}
