package br.com.fiap.cars.api.demo.domainmodel;


import br.com.fiap.cars.api.demo.domainmodel.enuns.TipoCarro;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "CARRO")
@NoArgsConstructor
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private int ano;
    private String potencia;
    private TipoCarro tipo;
    private String economia;
    private double preco;


    public Carro(Long id, String marca, String modelo, int ano, double potencia, TipoCarro tipo, double economiaValor, double preco) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.potencia = formatarPotencia(potencia);
        this.tipo = tipo;
        this.economia = formatarEconomia(economiaValor, tipo);
        this.preco = preco;
    }

    private String formatarEconomia(double economiaValor, TipoCarro tipo){
        return economiaValor + " " + tipo.getUnidadeEconomia();
    }

    private String formatarPotencia(double potencia){
        return potencia + "HP";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = formatarPotencia(potencia);
    }

    public TipoCarro getTipo() {
        return tipo;
    }

    public void setTipo(TipoCarro tipo) {
        this.tipo = tipo;
        this.economia = formatarEconomia(Double.parseDouble(economia.split(" ")[0]), tipo);
    }

    public String getEconomia() {
        return economia;
    }

    public void setEconomia(double economiaValor) {
        this.economia = formatarEconomia(economiaValor, this.tipo);
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
