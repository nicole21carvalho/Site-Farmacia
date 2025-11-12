package dao;

import models.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private final Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Produto> listarProdutos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Produto p = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getDouble("preco"), rs.getInt("quantidade_estoque"));
            produtos.add(p);
        }
        return produtos;
    }

    // Outros métodos como buscarPorId, salvar, etc., podem ser adicionados
}