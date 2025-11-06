package controller;

import dao.ProdutoDAO;
import models.Produto;
import com.google.gson.Gson; // Adicione Gson para JSON

import javax.servlet.;
import javax.servlet.http.;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class ProdutoController extends HttpServlet {
    private ProdutoDAO produtoDAO;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/farmacia_db", "root", "password"); // Substitua por suas credenciais
            produtoDAO = new ProdutoDAO(connection);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Produto> produtos = produtoDAO.listarProdutos();
            Gson gson = new Gson();
            String json = gson.toJson(produtos);
            response.setContentType("application/json");
            response.getWriter().write(json);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
