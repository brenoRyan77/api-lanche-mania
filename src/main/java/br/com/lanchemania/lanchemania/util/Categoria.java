package br.com.lanchemania.lanchemania.util;

public enum Categoria {

    CHURRASCOS("Churrascos"),
    MELHORES_COMIDAS("Melhores Comidas"),
    PAES("Pães"),
    HAMBURGUERES("Hambúrgueres"),
    CHOCOLATES("Chocolates"),
    SOBREMESAS("Sobremesas"),
    BEBIDAS("Bebidas"),
    FRANGO_FRITO("Frango Frito"),
    SORVETES("Sorvetes"),
    PIZZAS("Pizzas"),
    PORCOS("Porcos"),
    SANDUICHES("Sanduíches"),
    BIFES("Bifes");

    private final String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
