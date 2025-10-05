package model.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProdutosDAO {

    private Statement s = null;

    public ProdutosDAO(String database) {
        ConexaoDB conexao = new ConexaoDB(database);
        this.s = conexao.getS();
    }

    // INSERT
    public int inserirProduto(Produtos produto, String tabela) {
        int linhasAfetadas = 0;
        try {
            String SQL = "INSERT INTO " + tabela +
                    " (nome, descricao, valor, estoque) VALUES (" +
                    "'" + produto.getNome() + "'," +
                    "'" + produto.getDescricao() + "'," +
                    produto.getValor() + "," +
                    produto.getEstoque() + ")";
            linhasAfetadas = this.s.executeUpdate(SQL);
            System.out.println("Produto inserido: " + linhasAfetadas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }

    // SELECT TODOS
    public ArrayList<Produtos> selectProdutos(String tabela) {
        ArrayList<Produtos> lista = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM " + tabela;
            ResultSet rset = s.executeQuery(SQL);
            while (rset.next()) {
                Produtos produto = new Produtos();
                produto.setNome(rset.getString("nome"));
                produto.setDescricao(rset.getString("descricao"));
                produto.setValor(rset.getDouble("valor"));
                produto.setEstoque(rset.getInt("estoque"));
                lista.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // SELECT POR NOME (PK ou identificador lógico)
    public Produtos selectByNome(String nome, String tabela) {
        Produtos produto = new Produtos();
        try {
            String SQL = "SELECT * FROM " + tabela + " WHERE nome='" + nome + "'";
            ResultSet rset = s.executeQuery(SQL);
            if (rset.next()) {
                produto.setNome(rset.getString("nome"));
                produto.setDescricao(rset.getString("descricao"));
                produto.setValor(rset.getDouble("valor"));
                produto.setEstoque(rset.getInt("estoque"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    }

    // UPDATE
    public int atualizarProduto(Produtos produto, String tabela) {
        int linhasAfetadas = 0;
        try {
            String SQL = "UPDATE " + tabela + " SET " +
                    "descricao='" + produto.getDescricao() + "', " +
                    "valor=" + produto.getValor() + ", " +
                    "estoque=" + produto.getEstoque() +
                    " WHERE nome='" + produto.getNome() + "'";
            linhasAfetadas = this.s.executeUpdate(SQL);
            System.out.println("Produto atualizado: " + linhasAfetadas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }

    // DELETE
    public int deletarProduto(String nome, String tabela) {
        int linhasAfetadas = 0;
        try {
            String SQL = "DELETE FROM " + tabela + " WHERE nome='" + nome + "'";
            linhasAfetadas = this.s.executeUpdate(SQL);
            System.out.println("Produto removido: " + linhasAfetadas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }
}
