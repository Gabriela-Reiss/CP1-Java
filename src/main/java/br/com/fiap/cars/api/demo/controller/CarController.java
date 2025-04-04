package br.com.fiap.cars.api.demo.controller;


import br.com.fiap.cars.api.demo.domainmodel.Car;
import br.com.fiap.cars.api.demo.dto.CarDTO;
import br.com.fiap.cars.api.demo.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/car")
@AllArgsConstructor
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/")
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(
                this.carService.findAll(), HttpStatus.OK
        );
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        Car createdCar = this.carService.createCar(car);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Car carId = this.carService.findById(id);
        return new ResponseEntity<>(carId, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        this.carService.deleteCarById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody CarDTO carDTO) {
        Car updatedCar = this.carService.updateCar(id, carDTO);
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
    }




}
