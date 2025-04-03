package br.com.fiap.cars.api.demo.dto;

import br.com.fiap.cars.api.demo.domainmodel.Car;
import br.com.fiap.cars.api.demo.domainmodel.enuns.TipoCarro;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDTO {
    private String marca;
    private String modelo;
    private int ano;
    private double potencia;
    private TipoCarro tipo;
    private double economia;
    private double preco;


    public Car toEntity(Long id) {
        Car car = new Car();
        car.setId(id);
        car.setMarca(this.marca);
        car.setModelo(this.modelo);
        car.setAno(this.ano);
        car.setTipo(this.tipo);
        car.setPreco(this.preco);
        car.setPotencia(this.potencia);
        car.atualizarEconomia(this.economia);
        return car;
    }
}