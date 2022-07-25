package dev.cah1r.CarRental.api;

import dev.cah1r.CarRental.model.Rent;
import dev.cah1r.CarRental.services.RentService;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RentController {

    private final RentService rentService;

    @PostMapping("/rent")
    public Long rent(@RequestBody RentRequest rentRequest) {
        return rentService.rent(rentRequest);
    }

    @Value
    @ToString
    public static class RentRequest {
        String clientName;
        List<Long> carIds;
        LocalDate startDate;
        Rent.Type type;
        Integer days;
    }

}
