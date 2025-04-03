package br.com.fiap.cars.api.demo.service;


import br.com.fiap.cars.api.demo.domainmodel.Car;
import br.com.fiap.cars.api.demo.repositories.CarMockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private  CarMockRepository carRepository;

    public void deleteCarById(Long id) {
        this.carRepository.deleteById(id);
    }

    public Car findById(Long id) {
        return this.carRepository.getById(id);
    }

    public List<Car> findAll() {
        return this.carRepository.getAll();
    }

    public Car createCar(Car car) {
        return this.carRepository.saveCar(car);
    }

    public void deleteCar(Car car){
        this.carRepository.deleteCar(car);
    }

    public Car updateCar(Car car) {
        return this.carRepository.saveCar(car);
    }



}
