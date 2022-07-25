package dev.cah1r.CarRental.dto;

import dev.cah1r.CarRental.model.Car;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class CarDto {
    Long id;
    String brand;
    String currentBranch;
    Car.Type type;
    Car.EquipmentLevel equipmentLevel;
    BigDecimal rentPrice;
}
