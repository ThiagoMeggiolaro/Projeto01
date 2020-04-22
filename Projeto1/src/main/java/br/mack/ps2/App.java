package br.mack.ps2;


import br.mack.ps2.Persistencias.CarroDAOMySQL;
import br.mack.ps2.Persistencias.PaísDAOMySQL;
import br.mack.ps2.Persistencias.ProdutoDAOMySQL;

public class App {
    public static void main( String[] args ) {
        ProdutoDAOMySQL mySQLDAO = new ProdutoDAOMySQL();
        PaísDAOMySQL mySQL = new PaísDAOMySQL();
        CarroDAOMySQL mySQL1 = new CarroDAOMySQL();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(mySQLDAO);
        interfaceUsuario.iniciar();
    }
}
