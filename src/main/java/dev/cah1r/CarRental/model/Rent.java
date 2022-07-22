package dev.cah1r.CarRental.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Instant startDate;
    private Instant endDate;
    private Integer rentDays;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    private Client client;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Car> rentedCars;

    public enum Type {
        SHORT,
        LONG
    }



}
