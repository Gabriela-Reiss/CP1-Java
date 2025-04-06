package br.com.fiap.cars.api.demo.repositories;

import br.com.fiap.cars.api.demo.domainmodel.Carro;
import br.com.fiap.cars.api.demo.domainmodel.enuns.TipoCarro;
import br.com.fiap.cars.api.demo.dto.CarroDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.fiap.cars.api.demo.domainmodel.enuns.TipoCarro.*;


@Component
public class CarroMockRepository {

    private final List<Carro> dataset = new ArrayList<>();

    public CarroMockRepository() {
        this.dataset.add(new Carro(1L, "Fiat", "Toro", 2015, 250, COMBUSTAO, 50, 700000));
        this.dataset.add(new Carro(2L, "Toyota", "Corolla", 2021, 200, HIBRIDO, 55, 110000));
        this.dataset.add(new Carro(3L, "Tesla", "Model 3", 2023, 350, ELETRICO, 120, 250000));
        this.dataset.add(new Carro(4L, "Chevrolet", "Onix", 2018, 130, COMBUSTAO, 40, 60000));
        this.dataset.add(new Carro(5L, "Renault", "Kwid E-Tech", 2023, 180, ELETRICO, 90, 98000));
        this.dataset.add(new Carro(6L, "Ford", "Fusion", 2020, 240, HIBRIDO, 58, 105000));
        this.dataset.add(new Carro(7L, "Volkswagen", "Golf", 2017, 220, COMBUSTAO, 45, 85000));
        this.dataset.add(new Carro(8L, "Nissan", "Leaf", 2022, 200, ELETRICO, 100, 130000));
        this.dataset.add(new Carro(9L, "Hyundai", "Ioniq", 2021, 230, HIBRIDO, 60, 125000));
        this.dataset.add(new Carro(10L, "Peugeot", "208", 2019, 160, COMBUSTAO, 42, 72000));

        this.dataset.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
    }

    public List<Carro> getAll(){return this.dataset.subList(0, this.dataset.size());}

    public Carro saveCar(Carro carro){
        Long ultimoID = this.dataset.get(this.dataset.size() -1).getId();
        carro.setId(ultimoID + 1);
        this.dataset.add(carro);
        return carro;
    }

    public Carro saveUpdate(Long id, CarroDTO carroDTO){
        Carro carroId = getById(id);

        if (carroId != null) {
            carroId.setMarca(carroDTO.getMarca());
            carroId.setModelo(carroDTO.getModelo());
            carroId.setAno(carroDTO.getAno());
            carroId.setAno(carroDTO.getAno());
            carroId.setTipo(carroDTO.getTipo());
            carroId.setEconomia(carroDTO.getEconomia());
            carroId.setPotencia(carroDTO.getPotencia());
            carroId.setPreco(carroDTO.getPreco());
            return carroId;

        }
        return null;
    }

    public List<Carro> getAllOrderByPotenciaDesc() {
        return dataset.stream()
                .sorted((c1, c2) -> {
                    double p1 = Double.parseDouble(c1.getPotencia().replace(" HP", ""));
                    double p2 = Double.parseDouble(c2.getPotencia().replace(" HP", ""));
                    return Double.compare(p2, p1);
                })
                .collect(Collectors.toList());
    }

    public List<Carro> getAllOrderByEconomiaDesc() {
        return dataset.stream()
                .sorted((c1, c2) -> {
                    double e1 = Double.parseDouble(c1.getEconomia().replace(c1.getTipo().getUnidadeEconomia(), "").trim());
                    double e2 = Double.parseDouble(c2.getEconomia().replace(c2.getTipo().getUnidadeEconomia(), "").trim());
                    return Double.compare(e2, e1);
                })
                .collect(Collectors.toList());
    }

    public List<Carro> getAllEletricos() {
        return dataset.stream()
                .filter(carro -> carro.getTipo().equals(TipoCarro.ELETRICO))
                .collect(Collectors.toList());
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
