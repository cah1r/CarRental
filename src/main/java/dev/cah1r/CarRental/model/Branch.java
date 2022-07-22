package dev.cah1r.CarRental.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String branchCity;

    @OneToMany(mappedBy = "originBranch", cascade = CascadeType.ALL)
    private List<Car> branchOwnedCars = new ArrayList<>();

    @OneToMany(mappedBy = "currentBranch", cascade = CascadeType.ALL)
    private List<Car> availableCars = new ArrayList<>();

}
