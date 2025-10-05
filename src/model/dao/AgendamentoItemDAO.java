package model.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AgendamentoItemDAO {

    private Statement s = null;

    public AgendamentoItemDAO(String database) {
        ConexaoDB conexao = new ConexaoDB(database);
        this.s = conexao.getS();
    }

    // INSERT
    public int inserirAgendamentoItem(AgendamentoItem item, String tabela) {
        int linhasAfetadas = 0;
        try {
            String SQL = "INSERT INTO " + tabela +
                    " (codigoItem, valor, quantidade) VALUES (" +
                    "'" + item.getCodigoItem() + "'," +
                    item.getValor() + "," +
                    item.getQuantidade() + ")";
            linhasAfetadas = this.s.executeUpdate(SQL);
            System.out.println("Item inserido: " + linhasAfetadas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }

    // SELECT TODOS
    public ArrayList<AgendamentoItem> selectItens(String tabela) {
        ArrayList<AgendamentoItem> lista = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM " + tabela;
            ResultSet rset = s.executeQuery(SQL);
            while (rset.next()) {
                AgendamentoItem item = new AgendamentoItem();
                item.setCodigoItem(rset.getString("codigoItem"));
                item.setValor(rset.getDouble("valor"));
                item.setQuantidade(rset.getInt("quantidade"));
                lista.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // SELECT POR PK (codigoItem)
    public AgendamentoItem selectByCodigo(String codigoItem, String tabela) {
        AgendamentoItem item = new AgendamentoItem();
        try {
            String SQL = "SELECT * FROM " + tabela + " WHERE codigoItem='" + codigoItem + "'";
            ResultSet rset = s.executeQuery(SQL);
            if (rset.next()) {
                item.setCodigoItem(rset.getString("codigoItem"));
                item.setValor(rset.getDouble("valor"));
                item.setQuantidade(rset.getInt("quantidade"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    // UPDATE
    public int atualizarAgendamentoItem(AgendamentoItem item, String tabela) {
        int linhasAfetadas = 0;
        try {
            String SQL = "UPDATE " + tabela + " SET " +
                    "valor=" + item.getValor() + ", " +
                    "quantidade=" + item.getQuantidade() +
                    " WHERE codigoItem='" + item.getCodigoItem() + "'";
            linhasAfetadas = this.s.executeUpdate(SQL);
            System.out.println("Item atualizado: " + linhasAfetadas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }

    // DELETE
    public int deletarAgendamentoItem(String codigoItem, String tabela) {
        int linhasAfetadas = 0;
        try {
            String SQL = "DELETE FROM " + tabela + " WHERE codigoItem='" + codigoItem + "'";
            linhasAfetadas = this.s.executeUpdate(SQL);
            System.out.println("Item removido: " + linhasAfetadas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }
}
