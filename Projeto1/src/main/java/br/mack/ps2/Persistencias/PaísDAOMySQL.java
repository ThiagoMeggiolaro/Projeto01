package br.mack.ps2.Persistencias;
import br.mack.ps2.Entidades.País;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaísDAOMySQL implements PaísDAO{
    private String createSQL = "INSERT INTO pais (id, nome, continente, populacao) VALUES (?,?,?,?)";
    private String readSQL = "SELECT * FROM pais";
    private String updateSQL = "UPDATE pais SET id = ?, nome = ?, continente = ?, populacao = ?";
    private String deleteSQL = "DELETE FROM pais WHERE id=?";

    private final MySQLConnection mysql = new MySQLConnection();


    @Override
    public boolean create(País país) {
        Connection connection = mysql.getConnection();
        try {
            PreparedStatement stm = connection.prepareStatement(createSQL);
            stm.setLong(1, país.getId());
            stm.setString(2, país.getNome());
            stm.setString(3, país.getContinente());
            stm.setInt(4, país.getPopulacao());
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
    public List<País> read() {
        Connection conexao = mysql.getConnection();
        List<País> países = new ArrayList();

        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                País país = new País();
                país.setId(rs.getLong("id"));
                país.setNome(rs.getString("Nome"));
                país.setContinente(rs.getString("Continente"));
                país.setPopulacao(rs.getInt("População"));
                países.add(país);
            }

            return países;

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
        return países;
    }

    @Override
    public boolean update(País país) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(updateSQL);

            stm.setLong(1, país.getId());
            stm.setString(2, país.getNome());
            stm.setString(3, país.getContinente());
            stm.setInt(4, país.getPopulacao());

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
    public boolean delete(País país) {

        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);

            stm.setLong(1, país.getId());

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
