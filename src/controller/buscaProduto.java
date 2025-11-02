package controller;

import model.dao.ProdutosDAO;
import model.dao.Produtos;
import java.util.ArrayList;

public class buscaProduto {

    private ProdutosDAO produtosDAO;

    public buscaProduto(String database) {
        this.produtosDAO = new ProdutosDAO(database);
    }

    public ArrayList<Produtos> buscar(String termo, String tabela) {
        return produtosDAO.buscarProdutos(termo, tabela);
    }
}
