package dev.cah1r.CarRental.dto;

import dev.cah1r.CarRental.model.Car;

public class CarMapper {

    public static CarDto toDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .currentBranch(car.getCurrentBranch().getBranchCity())
                .type(car.getType())
                .equipmentLevel(car.getEquipmentLevel())
                .rentPrice(car.getRentPrice())
                .build();
    }
}
