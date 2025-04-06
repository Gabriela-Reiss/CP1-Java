package br.com.fiap.cars.api.demo.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Carro não encontrado");
    }
}
