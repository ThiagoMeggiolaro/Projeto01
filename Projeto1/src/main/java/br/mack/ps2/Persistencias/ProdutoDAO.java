package br.mack.ps2.Persistencias;

import br.mack.ps2.Entidades.Produto;

import java.util.List;

public interface ProdutoDAO {
    boolean create (Produto produto);
    List<Produto> read();
    boolean update (Produto produto);
    boolean delete (Produto produto);
}
