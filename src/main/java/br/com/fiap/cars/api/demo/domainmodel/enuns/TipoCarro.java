package br.com.fiap.cars.api.demo.domainmodel.enuns;

public enum TipoCarro {
    COMBUSTAO("km/litro"),
    HIBRIDO("km/litro"),
    ELETRICO("km/kWh");

    private final String unidadeEconomia;

    TipoCarro(String unidadeEconomia) {
        this.unidadeEconomia = unidadeEconomia;
    }

    public String getUnidadeEconomia(){
        return unidadeEconomia;
    }
}
