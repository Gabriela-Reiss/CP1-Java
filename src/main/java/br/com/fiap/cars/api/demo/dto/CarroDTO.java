package br.com.fiap.cars.api.demo.dto;

import br.com.fiap.cars.api.demo.domainmodel.enuns.TipoCarro;

public class CarroDTO {

    private String marca;
    private String modelo;
    private int ano;
    private double potencia;
    private TipoCarro tipo;
    private double economia;
    private double preco;

    public CarroDTO() {
    }

    public CarroDTO(String marca, String modelo, int ano, double potencia, TipoCarro tipo, double economia, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.potencia = potencia;
        this.tipo = tipo;
        this.economia = economia;
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public TipoCarro getTipo() {
        return tipo;
    }

    public void setTipo(TipoCarro tipo) {
        this.tipo = tipo;
    }

    public double getEconomia() {
        return economia;
    }

    public void setEconomia(double economia) {
        this.economia = economia;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
