package dev.cah1r.CarRental.api;

import dev.cah1r.CarRental.dto.CarDto;
import dev.cah1r.CarRental.dto.CarMapper;
import dev.cah1r.CarRental.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
class CarController {

    private final CarRepository carRepository;

    @GetMapping("/cars")
    public List<CarDto> getCars() {
        return carRepository.findAll().stream()
                .map(CarMapper::toDto)
                .collect(Collectors.toList());
    }

}
