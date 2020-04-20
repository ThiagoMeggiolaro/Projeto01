package br.mack.ps2.Entidades;

public class País {
    private long id;
    private String nome;
    private String continente;
    private int populacao;

    public País(){
        this.setId(-1);
        this.setNome(" ");
        this.setContinente(" ");
        this.setPopulacao(0);

    }
    public País(long id, String Nome, String Continente, int Populacao){
        this.setId(id);
        this.setNome(Nome);
        this.setContinente(Continente);
        this.setPopulacao(Populacao);
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getContinente() { return continente; }

    public void setContinente(String continente) { this.continente = continente; }

    public int getPopulacao() { return populacao; }

    public void setPopulacao(int populacao) { this.populacao = populacao; }

    @Override
    public String toString() {
        return "País{" +
                "id =" + id +
                ", nome ='" + nome + '\'' +
                ", continente ='" + continente + '\'' +
                ", populacao =" + populacao +
                '}';
    }
}
