package dev.cah1r.CarRental.services;

import dev.cah1r.CarRental.api.RentController;
import dev.cah1r.CarRental.model.Car;
import dev.cah1r.CarRental.model.Rent;
import dev.cah1r.CarRental.repository.BranchRepository;
import dev.cah1r.CarRental.repository.CarRepository;
import dev.cah1r.CarRental.repository.ClientRepository;
import dev.cah1r.CarRental.repository.RentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentService {

    private final RentRepository rentRepository;
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final BranchRepository branchRepository;

    public Long rent(RentController.RentRequest rentRequest) {
        return clientRepository.getClientByName(rentRequest.getClientName())
                .map(client -> {
                    List<Car> cars = carRepository.findAllById(rentRequest.getCarIds());
                    Rent rent = Rent.builder()
                            .rentedCars(cars)
                            .rentDays(rentRequest.getRentDays())
                            .startDate(LocalDate.now())
                            .client(client)
                            .type(rentRequest.getType())
                            .build();
                    cars.forEach(car -> car.setCurrentBranch(null));
                    return rentRepository.save(rent).getId();
                })
                .orElseThrow(() -> new RuntimeException("Can't create reservation"));
    }

    public boolean endRent(RentController.EndRentRequest endRentRequest) {
        return rentRepository.findById(endRentRequest.getRentId())
                .flatMap(rent -> branchRepository.findByBranchCity(endRentRequest.getBranchCity())
                        .map(branch -> {
                            rent.setEndDate(LocalDate.now());
                            rent.getRentedCars().forEach(car -> car.setCurrentBranch(branch));
                            rentRepository.save(rent);
                            return true;
                        })).orElseThrow(() -> new RuntimeException("Can't end rent"));
    }
}
