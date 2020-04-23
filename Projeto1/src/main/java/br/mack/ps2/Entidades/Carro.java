package br.mack.ps2.Entidades;

public class Carro {
    private int id;
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

    public void setModelo(String modelo) { Modelo = modelo; }

    public String getMarca() { return Marca; }

    public void setMarca(String marca) { Marca = marca; }

    public int getAno() { return Ano; }

    public void setAno(int ano) { Ano = ano; }

    public String getCategoria() { return Categoria; }

    public void setCategoria(String categoria) { Categoria = categoria; }

    @Override
    public java.lang.String toString() {
        return
                "\nid = " + getId() +
                "\nModelo = " + getModelo() + '\'' +
                "\nMarca = " + getMarca() + '\'' +
                "\nAno = " + getAno() +
                "\nCategoria = " + getCategoria() + '\'' +
                '}';
    }
}
