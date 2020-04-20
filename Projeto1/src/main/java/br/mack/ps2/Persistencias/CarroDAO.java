package br.mack.ps2.Persistencias;

import br.mack.ps2.Entidades.Produto;

import java.util.List;

public interface CarroDAO {
    boolean create (Carro carro);
    List<Carro> read();
    boolean update (Carro carro);
    boolean delete (Carro carro);
}
