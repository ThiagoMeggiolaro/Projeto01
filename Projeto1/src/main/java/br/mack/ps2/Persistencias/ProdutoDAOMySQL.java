package br.mack.ps2.Persistencias;

import br.mack.ps2.Entidades.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAOMySQL implements ProdutoDAO {
    private String createSQL = "INSERT INTO produto (id, descricao, marca, preco) VALUES (?,?,?,?)";
    private String readSQL = "SELECT * FROM produto";
    private String updateSQL = "UPDATE produto SET id = ?, descricao = ?, marca = ?, preco = ?";
    private String deleteSQL = "DELETE FROM produto WHERE id=?";

    private final MySQLConnection mysql = new MySQLConnection();


    @Override
    public boolean create(Produto produto) {
        Connection connection = mysql.getConnection();
        try {
            PreparedStatement stm = connection.prepareStatement(createSQL);
            stm.setLong(1, produto.getId());
            stm.setString(2, produto.getDescricao());
            stm.setString(3, produto.getMarca());
            stm.setDouble(4, produto.getPreco());
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
    public List<Produto> read() {
        Connection conexao = mysql.getConnection();
        List<Produto> produtos = new ArrayList();

        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setDescricao(rs.getString("Descrição"));
                produto.setMarca(rs.getString("Marca"));
                produto.setPreco(rs.getDouble("Preço"));
                produtos.add(produto);
            }

            return produtos;

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
        return produtos;
    }


    @Override
    public boolean update(Produto produto) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(updateSQL);

            stm.setLong(1, produto.getId());
            stm.setString(2, produto.getDescricao());
            stm.setString(3, produto.getMarca());
            stm.setDouble(4, produto.getPreco());

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
    public boolean delete(Produto produto) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);

            stm.setLong(1, produto.getId());

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
