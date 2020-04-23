package br.mack.ps2.Entidades;

public class País {
    private int id;
    private String nome;
    private String continente;
    private int populacao;

    public País(){
        this.setId(-1);
        this.setNome(" ");
        this.setContinente(" ");
        this.setPopulacao(0);

    }
    public País(int id, String Nome, String Continente, int Populacao){
        this.setId(id);
        this.setNome(Nome);
        this.setContinente(Continente);
        this.setPopulacao(Populacao);
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getContinente() { return continente; }

    public void setContinente(String continente) { this.continente = continente; }

    public int getPopulacao() { return populacao; }

    public void setPopulacao(int populacao) { this.populacao = populacao; }

    @Override
    public String toString() {
        return
                "\nid = " + id +
                "\nNome = " + nome +
                "\nContinente = " + continente +
                "\nPopulação = " + populacao;
    }
}
