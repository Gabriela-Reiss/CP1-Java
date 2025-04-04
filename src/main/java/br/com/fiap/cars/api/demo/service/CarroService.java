package br.com.fiap.cars.api.demo.service;


import br.com.fiap.cars.api.demo.domainmodel.Carro;
import br.com.fiap.cars.api.demo.dto.CarroDTO;
import br.com.fiap.cars.api.demo.repositories.CarroMockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroMockRepository carRepository;

    public void deleteCarById(Long id) {
        this.carRepository.deleteById(id);
    }

    public Carro findById(Long id) {
        return this.carRepository.getById(id);
    }

    public List<Carro> findAll() {
        return this.carRepository.getAll();
    }

    public Carro createCar(Carro carro) {
        return this.carRepository.saveCar(carro);
    }

    public void deleteCar(Carro carro){
        this.carRepository.deleteCar(carro);
    }

    public Carro updateCar(Long id, CarroDTO carroDto) {

        Carro existingCarro = this.findById(id);
        existingCarro.setMarca(carroDto.getMarca());
        existingCarro.setModelo(carroDto.getModelo());
        existingCarro.setAno(carroDto.getAno());
        existingCarro.setPotencia(carroDto.getPotencia());
        existingCarro.setTipo(carroDto.getTipo());
        existingCarro.setEconomia(carroDto.getEconomia());
        existingCarro.setPreco(carroDto.getPreco());

        return this.carRepository.saveCar(existingCarro);

    }

    public List<Carro> findAllByPotenciaDesc(){
        return this.carRepository.getAllOrderByPotenciaDesc();
    }

    public List<Carro> findAllByEconomiaDesc(){
        return this.carRepository.getAllOrderByEconomiaDesc();
    }

    public List<Carro> findAllEletricos(){
        return this.carRepository.getAllEletricos();
    }



}
