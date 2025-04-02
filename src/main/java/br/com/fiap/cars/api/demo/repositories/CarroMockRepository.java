package br.com.fiap.cars.api.demo.repositories;

import br.com.fiap.cars.api.demo.domainmodel.Carro;

import java.util.ArrayList;
import java.util.List;

import static br.com.fiap.cars.api.demo.domainmodel.enuns.TipoCarro.*;

public class CarroMockRepository {

    private final List<Carro> dataset = new ArrayList<>();

    public CarroMockRepository() {
        this.dataset.add(new Carro(1L, "Fiat", "Toro", 2015, 250, COMBUSTAO, 50, 700000));
        this.dataset.add(new Carro(2L, "Honda", "Civic", 2020, 230, HIBRIDO, 50, 900000));
        this.dataset.add(new Carro(3L, "BYD", "Golphin", 2024, 300, ELETRICO, 100, 150000));
        this.dataset.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
    }

    public List<Carro> getAll(){return this.dataset.subList(0, this.dataset.size());}

    public Carro saveCar(Carro carro){
        Long ultimoID = this.dataset.get(this.dataset.size() -1).getId();
        carro.setId(ultimoID + 1);
        this.dataset.add(carro);
        return carro;
    }

    public Carro saveUpdateCar(Carro carro){
        Carro carroId = getById(carro.getId());

        if (carroId != null) {
            carroId.setMarca(carro.getMarca());
            carroId.setModelo(carro.getModelo());
            carroId.setAno(carro.getAno());
            carroId.setPotencia(Double.parseDouble((carroId.getPotencia())));
            carroId.setTipo(carro.getTipo());
            carroId.setEconomia(Double.parseDouble((carroId.getEconomia())));
            carroId.setPreco(carro.getPreco());
            return carroId;
        }
        return null;
    }

    public Carro getById(Long id){
        List<Carro> carros = this.getAll();
        for (int i = 0; i < getAll().size(); i++) {
            if(carros.get(i).getId().equals(id)){
                return carros.get(i);
            }
        }
        return null;
    }

    public void deleteById(Long id){
        this.dataset.removeIf(
                carro -> carro.getId().equals(id)
        );
    }

    public void deleteCar(Carro carro1){
        this.dataset.removeIf(
                carro -> carro.getId().equals(carro1.getId())
        );
    }
}
