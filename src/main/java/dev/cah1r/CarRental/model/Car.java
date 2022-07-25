package dev.cah1r.CarRental.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Branch originBranch;

    @ManyToOne
    private Branch currentBranch;

    private String brand;

    private BigDecimal rentPrice;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private EquipmentLevel equipmentLevel;

    public enum Type {
        A, B, C, D, E, PREMIUM
    }

    public enum EquipmentLevel {
        STANDARD,
        HIGH,
        PREMIUM
    }


}
