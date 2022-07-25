package dev.cah1r.CarRental.repository;

import dev.cah1r.CarRental.model.Car;
import dev.cah1r.CarRental.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
