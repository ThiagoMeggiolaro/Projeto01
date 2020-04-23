package br.mack.ps2.Persistencias;

import br.mack.ps2.Entidades.Carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAOMySQL implements CarroDAO {
    private String createSQL = "INSERT INTO carro ( Modelo, Marca, Ano, Categoria) VALUES (?,?,?,?)";
    private String readSQL = "SELECT * FROM carro";
    private String updateSQL = "UPDATE carro SET Modelo = ?, Marca = ?, Ano = ?, Categoria = ? WHERE id=?";
    private String deleteSQL = "DELETE FROM carro WHERE id=?";

    private final MySQLConnection mysql = new MySQLConnection();


    @Override
    public boolean create(Carro carro) {
        Connection connection = mysql.getConnection();
        try {
            PreparedStatement stm = connection.prepareStatement(createSQL);
            stm.setString(1, carro.getModelo());
            stm.setString(2, carro.getMarca());
            stm.setInt(3, carro.getAno());
            stm.setString(4, carro.getCategoria());
            int registro = stm.executeUpdate();
            return (registro > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Carro> read() {
        Connection conexao = mysql.getConnection();
        List<Carro> carros = new ArrayList();

        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Carro carro = new Carro();
                carro.setId(rs.getInt("id"));
                carro.setModelo(rs.getString("Modelo"));
                carro.setMarca(rs.getString("Marca"));
                carro.setAno(rs.getInt("Ano"));
                carro.setCategoria(rs.getString("Categoria"));
                carros.add(carro);
            }

            return carros;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return carros;
    }


    @Override
    public boolean update(Carro carro) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(updateSQL);

            stm.setString(1, carro.getModelo());
            stm.setString(2, carro.getMarca());
            stm.setInt(3, carro.getAno());
            stm.setString(4, carro.getCategoria());
            stm.setInt(5, carro.getId());

            int registros = stm.executeUpdate();
            return registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Carro carro) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);

            stm.setInt(1, carro.getId());

            int registros = stm.executeUpdate();

            return registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
}

