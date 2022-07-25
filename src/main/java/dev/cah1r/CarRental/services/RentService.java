package dev.cah1r.CarRental.services;

import dev.cah1r.CarRental.api.RentController;
import dev.cah1r.CarRental.model.Car;
import dev.cah1r.CarRental.model.Rent;
import dev.cah1r.CarRental.repository.CarRepository;
import dev.cah1r.CarRental.repository.ClientRepository;
import dev.cah1r.CarRental.repository.RentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentService {

    private final RentRepository rentRepository;
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;

    public Long rent(RentController.RentRequest rentRequest) {
        return clientRepository.getClientByName(rentRequest.getClientName())
                .map(client -> {
                    List<Car> cars = carRepository.findAllById(rentRequest.getCarIds());
                    Rent rent = Rent.builder()
                            .rentedCars(cars)
                            .rentDays(rentRequest.getDays())
                            .startDate(Instant.now())
                            .client(client)
                            .type(rentRequest.getType())
                            .build();
                    cars.forEach(car -> car.setCurrentBranch(null));
                    return rentRepository.save(rent).getId();
                })
                .orElseThrow(() -> new RuntimeException("Can't create reservation"));
    }
}
