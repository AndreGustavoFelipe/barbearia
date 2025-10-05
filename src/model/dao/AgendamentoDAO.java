package model.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AgendamentoDAO {

    private Statement s = null;

    public AgendamentoDAO(String database) {
        ConexaoDB conexao = new ConexaoDB(database);
        this.s = conexao.getS();
    }

    // INSERT
    public int inserirAgendamento(Agendamento agendamento, String tabela) {
        int linhasAfetadas = 0;
        try {
            String SQL = "INSERT INTO " + tabela +
                    " (codigoCliente, codigoFuncionario, dataAgendamento, observacao, total) VALUES (" +
                    agendamento.getCodigoCliente() + "," +
                    agendamento.getCodigoFuncionario() + "," +
                    "'" + agendamento.getDataAgendamento() + "'," +
                    "'" + agendamento.getObservacao() + "'," +
                    agendamento.getTotal() + ")";
            linhasAfetadas = this.s.executeUpdate(SQL);
            System.out.println("Agendamento inserido: " + linhasAfetadas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }

    // SELECT TODOS
    public ArrayList<Agendamento> selectAgendamentos(String tabela) {
        ArrayList<Agendamento> lista = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM " + tabela;
            ResultSet rset = s.executeQuery(SQL);
            while (rset.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setCodigoCliente(rset.getInt("codigoCliente"));
                agendamento.setCodigoFuncionario(rset.getInt("codigoFuncionario"));
                agendamento.setDataAgendamento(rset.getString("dataAgendamento"));
                agendamento.setObservacao(rset.getString("observacao"));
                agendamento.setTotal(rset.getDouble("total"));
                lista.add(agendamento);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // SELECT POR CLIENTE
    public ArrayList<Agendamento> selectByCliente(int codigoCliente, String tabela) {
        ArrayList<Agendamento> lista = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM " + tabela + " WHERE codigoCliente=" + codigoCliente;
            ResultSet rset = s.executeQuery(SQL);
            while (rset.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setCodigoCliente(rset.getInt("codigoCliente"));
                agendamento.setCodigoFuncionario(rset.getInt("codigoFuncionario"));
                agendamento.setDataAgendamento(rset.getString("dataAgendamento"));
                agendamento.setObservacao(rset.getString("observacao"));
                agendamento.setTotal(rset.getDouble("total"));
                lista.add(agendamento);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // UPDATE
    public int atualizarAgendamento(Agendamento agendamento, String tabela) {
        int linhasAfetadas = 0;
        try {
            String SQL = "UPDATE " + tabela + " SET " +
                    "codigoFuncionario=" + agendamento.getCodigoFuncionario() + ", " +
                    "dataAgendamento='" + agendamento.getDataAgendamento() + "', " +
                    "observacao='" + agendamento.getObservacao() + "', " +
                    "total=" + agendamento.getTotal() +
                    " WHERE codigoCliente=" + agendamento.getCodigoCliente();
            linhasAfetadas = this.s.executeUpdate(SQL);
            System.out.println("Agendamento atualizado: " + linhasAfetadas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }

    // DELETE
    public int deletarAgendamento(int codigoCliente, String tabela) {
        int linhasAfetadas = 0;
        try {
            String SQL = "DELETE FROM " + tabela + " WHERE codigoCliente=" + codigoCliente;
            linhasAfetadas = this.s.executeUpdate(SQL);
            System.out.println("Agendamento removido: " + linhasAfetadas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }
}
