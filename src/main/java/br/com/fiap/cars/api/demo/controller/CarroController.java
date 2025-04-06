package br.com.fiap.cars.api.demo.controller;


import br.com.fiap.cars.api.demo.domainmodel.Carro;
import br.com.fiap.cars.api.demo.dto.CarroDTO;
import br.com.fiap.cars.api.demo.exceptions.NotFoundException;
import br.com.fiap.cars.api.demo.service.CarroService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping ("/api")
@AllArgsConstructor
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/carros")
    public ResponseEntity<List<Carro>> getAllCars() {
        return new ResponseEntity<>(
                this.carroService.findAll(), HttpStatus.OK
        );
    }

    @PostMapping("/carros")
    public ResponseEntity<Object> addCar(@RequestBody Carro carro) {
        try{
            Carro createdCarro = this.carroService.createCar(carro);
            return new ResponseEntity<>(createdCarro, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível cadastrar o Carro");
        }

    }

    @GetMapping("/carros/{id}")
    public ResponseEntity<Object> getCarById(@PathVariable Long id) {
            Carro carroId = this.carroService.findById(id);
            if (carroId == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Carro não encontrado");
            }
            return new ResponseEntity<>(carroId, HttpStatus.OK);


    }

    @DeleteMapping("/carros/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable Long id) {
        try{
            this.carroService.deleteCarById(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }

    }

    @PutMapping("/carros/{id}")
    public ResponseEntity<Carro> updateCar(@PathVariable Long id, @RequestBody CarroDTO carroDTO) {
        Carro updatedCarro = this.carroService.updateCar(id, carroDTO);
        return new ResponseEntity<>(updatedCarro, HttpStatus.OK);
    }

    @GetMapping("/carros/potencia")
    public ResponseEntity<List<Carro>> getCarsByPotencia() {
        List<Carro> carros = this.carroService.findAllByPotenciaDesc();
        return new ResponseEntity<>(carros, HttpStatus.OK);
    }

    @GetMapping("/carros/economia")
    public ResponseEntity<List<Carro>> getCarsByEconomia() {
        List<Carro> carros = this.carroService.findAllByEconomiaDesc();
        return new ResponseEntity<>(carros, HttpStatus.OK);
    }

    @GetMapping("/carros/eletricos")
    public ResponseEntity<List<Carro>> getCarsEletricos() {
        List<Carro> carros = this.carroService.findAllEletricos();
        return new ResponseEntity<>(carros, HttpStatus.OK);
    }






}
