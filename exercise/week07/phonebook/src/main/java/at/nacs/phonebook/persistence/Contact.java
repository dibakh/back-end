package at.nacs.phonebook.persistence;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

@Data
@Entity
public class Contact {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name; //(unique)

    @OneToOne(cascade = ALL,fetch = FetchType.EAGER)
    private Address address;

}