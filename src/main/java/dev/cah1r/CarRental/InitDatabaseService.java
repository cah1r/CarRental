package dev.cah1r.CarRental;

import dev.cah1r.CarRental.model.Branch;
import dev.cah1r.CarRental.model.Car;
import dev.cah1r.CarRental.model.Client;
import dev.cah1r.CarRental.repository.BranchRepository;
import dev.cah1r.CarRental.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
class InitDatabaseService {

    private final ClientRepository clientRepository;
    private final BranchRepository branchRepository;

    @PostConstruct
    public void init() {

        Client sii = Client.builder()
                .name("Sii")
                .type(Client.Type.ORGANIZATION)
                .clients(new ArrayList<>())
                .build();

        Client client1 = Client.builder()
                .name("John Wick")
                .type(Client.Type.PERSON)
                .organization(sii)
                .build();

        Client client2 = Client.builder()
                .name("John McClane")
                .type(Client.Type.PERSON)
                .organization(sii)
                .build();

        Client client3 = Client.builder()
                .name("Geralt of Rivia")
                .organization(sii)
                .type(Client.Type.PERSON)
                .build();

        sii.getClients().addAll(Arrays.asList(client1, client2, client3));

        clientRepository.save(sii);

        Branch lublin = Branch.builder()
                .branchCity("Lublin")
                .branchOwnedCars(new ArrayList<>())
                .availableCars(new ArrayList<>())
                .build();
        Car alfa = Car.builder()
                .brand("Alfa Romeo Giulia")
                .currentBranch(lublin)
                .originBranch(lublin)
                .equipmentLevel(Car.EquipmentLevel.HIGH)
                .type(Car.Type.C)
                .rentPrice(new BigDecimal(800))
                .build();
        Car lexus = Car.builder()
                .brand("Lexus IS300h")
                .currentBranch(lublin)
                .originBranch(lublin)
                .type(Car.Type.D)
                .equipmentLevel(Car.EquipmentLevel.PREMIUM)
                .rentPrice(new BigDecimal(600))
                .build();
        Car roach = Car.builder()
                .brand("Płotka")
                .currentBranch(lublin)
                .originBranch(lublin)
                .type(Car.Type.C)
                .equipmentLevel(Car.EquipmentLevel.STANDARD)
                .rentPrice(new BigDecimal(80))
                .build();

        List<Car> cars = Arrays.asList(alfa, lexus, roach);
        lublin.getAvailableCars().addAll(cars);
        lublin.getBranchOwnedCars().addAll(cars);
        branchRepository.save(lublin);

        Branch warszawa = Branch.builder()
                .branchCity("Warszawa")
                .branchOwnedCars(new ArrayList<>())
                .availableCars(new ArrayList<>())
                .build();
        Car ford = Car.builder()
                .brand("Ford Focus RS")
                .currentBranch(warszawa)
                .originBranch(warszawa)
                .type(Car.Type.B)
                .equipmentLevel(Car.EquipmentLevel.STANDARD)
                .rentPrice(new BigDecimal(400))
                .build();
        Car fiat = Car.builder()
                .brand("Fiat 500")
                .currentBranch(warszawa)
                .originBranch(warszawa)
                .rentPrice(new BigDecimal(150))
                .equipmentLevel(Car.EquipmentLevel.STANDARD)
                .type(Car.Type.A)
                .build();
        Car mbs = Car.builder()
                .brand("Mercedes S600")
                .currentBranch(warszawa)
                .originBranch(warszawa)
                .rentPrice(new BigDecimal(900))
                .equipmentLevel(Car.EquipmentLevel.PREMIUM)
                .type(Car.Type.PREMIUM)
                .build();

        List<Car> wwaCars = Arrays.asList(ford, fiat, mbs);
        warszawa.getBranchOwnedCars().addAll(wwaCars);
        warszawa.getAvailableCars().addAll(wwaCars);
        branchRepository.save(warszawa);

        Branch wroclaw = Branch.builder()
                .branchCity("Wrocław")
                .availableCars(new ArrayList<>())
                .branchOwnedCars(new ArrayList<>())
                .build();
        Car mb = Car.builder()
                .brand("Mercedes C300")
                .currentBranch(wroclaw)
                .originBranch(wroclaw)
                .rentPrice(new BigDecimal(350))
                .equipmentLevel(Car.EquipmentLevel.PREMIUM)
                .type(Car.Type.C)
                .build();
        Car volvo = Car.builder()
                .brand("Volvo V90")
                .currentBranch(wroclaw)
                .originBranch(wroclaw)
                .rentPrice(new BigDecimal(320))
                .equipmentLevel(Car.EquipmentLevel.HIGH)
                .type(Car.Type.E)
                .build();
        Car bmw = Car.builder()
                .brand("BMW 645")
                .currentBranch(wroclaw)
                .originBranch(wroclaw)
                .rentPrice(new BigDecimal(410))
                .equipmentLevel(Car.EquipmentLevel.HIGH)
                .type(Car.Type.D)
                .build();

        List<Car> wCars = Arrays.asList(mb, volvo, bmw);
        wroclaw.getBranchOwnedCars().addAll(wCars);
        wroclaw.getAvailableCars().addAll(wCars);
        branchRepository.save(wroclaw);
    }
}
