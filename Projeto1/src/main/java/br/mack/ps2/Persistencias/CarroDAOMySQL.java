package br.mack.ps2.Persistencias;

import br.mack.ps2.Entidades.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAOMySQL implements CarroDAO {
    private String createSQL = "INSERT INTO carro (id, modelo, marca, ano, categoria) VALUES (?,?,?,?,?)";
    private String readSQL = "SELECT * FROM carro";
    private String updateSQL = "UPDATE carro SET id = ?, modelo = ?, marca = ?, ano = ?, categoria = ?";
    private String deleteSQL = "DELETE FROM carro WHERE id=?";

    private final MySQLConnection mysql = new MySQLConnection();


    @Override
    public boolean create(Carro carro) {
        Connection connection = mysql.getConnection();
        try {
            PreparedStatement stm = connection.prepareStatement(createSQL);
            stm.setLong(1, carro.getId());
            stm.setString(2, carro.getModelo());
            stm.setString(3, carro.getMarca());
            stm.setInt(4, carro.getAno());
            stm.setString(5, carro.getCategoria());
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
                carro.setId(rs.getLong("id"));
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

            stm.setLong(1, carro.getId());
            stm.setString(2, carro.getModelo());
            stm.setString(3, carro.getMarca());
            stm.setInt(4, carro.getAno());
            stm.setString(5, carro.getCategoria());

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

            stm.setLong(1, carro.getId());

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

