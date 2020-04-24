package br.mack.ps2.Entidades;

public class Carro {
    private int id;
    private String Modelo;
    private String Marca;
    private int Ano;
    private String Categoria;


    public Carro(){
        this.setId(-1);
        this.setModelo("O mais atual");
        this.setMarca("O melhor");
        this.setCategoria("O mais popular");
        this.setAno(0);
    }
    public Carro(int id, String Modelo, String Marca, int Ano, String Categoria){
        this.setId(id);
        this.setModelo(Modelo);
        this.setMarca(Marca);
        this.setAno(Ano);
        this.setCategoria(Categoria);
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getModelo() { return Modelo; }

    public void setModelo(String modelo) { this.Modelo = modelo; }

    public String getMarca() { return Marca; }

    public void setMarca(String marca) { this.Marca = marca; }

    public int getAno() { return Ano; }

    public void setAno(int ano) { this.Ano = ano; }

    public String getCategoria() { return Categoria; }

    public void setCategoria(String categoria) { this.Categoria = categoria; }

    @Override
    public java.lang.String toString() {
        return
                "\nid = " + id +
                "\nModelo = " + Modelo +
                "\nMarca = " + Marca+
                "\nAno = " + Ano +
                "\nCategoria = " + Categoria;
    }
}
