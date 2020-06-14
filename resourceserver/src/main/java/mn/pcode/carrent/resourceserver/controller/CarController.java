package mn.pcode.carrent.resourceserver.controller;

import mn.pcode.carrent.resourceserver.model.Car;
import mn.pcode.carrent.resourceserver.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarRepository carRepository;

    @GetMapping("/all")
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
