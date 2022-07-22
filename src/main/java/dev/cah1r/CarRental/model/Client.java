package dev.cah1r.CarRental.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    private Client organization;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<Client> clients = new ArrayList<>();

    public enum Type {
        PERSON,
        ORGANIZATION
    }
}
