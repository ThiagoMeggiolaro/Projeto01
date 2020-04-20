package br.mack.ps2.Persistencias;
import br.mack.ps2.Entidades.País;

import java.util.List;

public interface PaísDAO {
    boolean create (País país);
    List<País> read();
    boolean update (País país);
    boolean delete (País país);
}
