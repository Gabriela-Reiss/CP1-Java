package br.com.fiap.cars.api.demo.repositories;

import br.com.fiap.cars.api.demo.domainmodel.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static br.com.fiap.cars.api.demo.domainmodel.enuns.TipoCarro.*;


@Component
public class CarMockRepository {

    private final List<Car> dataset = new ArrayList<>();

    public CarMockRepository() {
        this.dataset.add(new Car(1L, "Fiat", "Toro", 2015, 250, COMBUSTAO, 50, 700000));
        this.dataset.add(new Car(2L, "Honda", "Civic", 2020, 230, HIBRIDO, 50, 900000));
        this.dataset.add(new Car(3L, "BYD", "Golphin", 2024, 300, ELETRICO, 100, 150000));
        this.dataset.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
    }

    public List<Car> getAll(){return this.dataset.subList(0, this.dataset.size());}

    public Car saveCar(Car car){
        Long ultimoID = this.dataset.get(this.dataset.size() -1).getId();
        car.setId(ultimoID + 1);
        this.dataset.add(car);
        return car;
    }

    public Car saveUpdateCar(Long id, Car car){
        Car carId = getById(id);
        saveCar(carId);
        return null;
    }

    public Car getById(Long id){
        List<Car> cars = this.getAll();
        for (int i = 0; i < getAll().size(); i++) {
            if(cars.get(i).getId().equals(id)){
                return cars.get(i);
            }
        }
        return null;
    }

    public void deleteById(Long id){
        this.dataset.removeIf(
                car -> car.getId().equals(id)
        );
    }

    public void deleteCar(Car car1){
        this.dataset.removeIf(
                car -> car.getId().equals(car1.getId())
        );
    }
}
