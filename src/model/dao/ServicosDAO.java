package model.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ServicosDAO {

    private Statement s = null;

    public ServicosDAO(String database) {
        ConexaoDB conexao = new ConexaoDB(database);
        this.s = conexao.getS();
    }

    // INSERT
    public int inserirServico(Servicos servico, String tabela) {
        int linhasAfetadas = 0;
        try {
            String SQL = "INSERT INTO " + tabela +
                    " (nome, descricao, valor) VALUES (" +
                    "'" + servico.getNome() + "'," +
                    "'" + servico.getDescricao() + "'," +
                    servico.getValor() + ")";
            linhasAfetadas = this.s.executeUpdate(SQL);
            System.out.println("Serviço inserido: " + linhasAfetadas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }

    // SELECT TODOS
    public ArrayList<Servicos> selectServicos(String tabela) {
        ArrayList<Servicos> lista = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM " + tabela;
            ResultSet rset = s.executeQuery(SQL);
            while (rset.next()) {
                Servicos servico = new Servicos();
                servico.setNome(rset.getString("nome"));
                servico.setDescricao(rset.getString("descricao"));
                servico.setValor(rset.getDouble("valor"));
                lista.add(servico);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // SELECT POR NOME (PK ou identificador lógico)
    public Servicos selectByNome(String nome, String tabela) {
        Servicos servico = new Servicos();
        try {
            String SQL = "SELECT * FROM " + tabela + " WHERE nome='" + nome + "'";
            ResultSet rset = s.executeQuery(SQL);
            if (rset.next()) {
                servico.setNome(rset.getString("nome"));
                servico.setDescricao(rset.getString("descricao"));
                servico.setValor(rset.getDouble("valor"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return servico;
    }

    // UPDATE
    public int atualizarServico(Servicos servico, String tabela) {
        int linhasAfetadas = 0;
        try {
            String SQL = "UPDATE " + tabela + " SET " +
                    "descricao='" + servico.getDescricao() + "', " +
                    "valor=" + servico.getValor() +
                    " WHERE nome='" + servico.getNome() + "'";
            linhasAfetadas = this.s.executeUpdate(SQL);
            System.out.println("Serviço atualizado: " + linhasAfetadas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }

    // DELETE
    public int deletarServico(String nome, String tabela) {
        int linhasAfetadas = 0;
        try {
            String SQL = "DELETE FROM " + tabela + " WHERE nome='" + nome + "'";
            linhasAfetadas = this.s.executeUpdate(SQL);
            System.out.println("Serviço removido: " + linhasAfetadas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }
}
