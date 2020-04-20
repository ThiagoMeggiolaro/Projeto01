package br.mack.ps2.Entidades;

public class Carro {
    private long id;
    private String Modelo;
    private String Marca;
    private int Ano;
    private String Categoria;


    public Carro(){
        this.setId(-1);
        this.setModelo(" ");
        this.setMarca(" ");
        this.setCategoria(" ");
        this.setAno(0);
    }
    public Carro(long id, String Modelo, String Marca, int Ano, String Categoria){
        this.setId(id);
        this.setModelo(modelo);
        this.setMarca(marca);
        this.setAno(ano);
        this.setCategoria(categoria);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.descricao = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) { this.ano = ano; }

    public String setCategoria(String categoria) { this.categoria = categoria; }

    public void getCatregoria() { return categoria; }

    @Override
    public java.lang.String toString() {
        return "Carro{" +
                "id=" + id +
                ", Modelo='" + Modelo + '\'' +
                ", Marca='" + Marca + '\'' +
                ", Ano=" + Ano +
                ", Categoria='" + Categoria + '\'' +
                '}';
    }
}
