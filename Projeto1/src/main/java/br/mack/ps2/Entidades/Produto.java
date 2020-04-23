package br.mack.ps2.Entidades;

public class Produto {
    private int id;
    private String descricao;
    private String marca;
    private double preco;

    public Produto(){
        this.setId(0);
        this.setDescricao("Melhor produto do mercado");
        this.setMarca("A mais famosa");
        this.setPreco(0);
    }
    public Produto(int id, String descricao, String marca, double preco){
        this.setId(id);
        this.setDescricao(descricao);
        this.setMarca(marca);
        this.setPreco(preco);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return  "\n id = " + id +
                "\n Descrição = " + descricao +
                "\n Marca = " + marca +
                "\n Preço = " + preco;
    }
}
