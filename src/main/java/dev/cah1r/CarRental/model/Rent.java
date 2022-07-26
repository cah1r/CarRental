package dev.cah1r.CarRental.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
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
