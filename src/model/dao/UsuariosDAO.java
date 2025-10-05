package model.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuariosDAO{

    private Statement s = null;

    public UsuariosDAO(String database) {
        ConexaoDB conexao = new ConexaoDB(database);
        this.s = conexao.getS();
    }

    // INSERT
    public int inserirUsuario(Usuarios usuario, String tabela) {
        int linhasAfetadas = 0;
        try {
            String SQL = "INSERT INTO " + tabela +
                    " (nome, tipo, endereco, data_nascimento, sexo) VALUES (" +
                    "'" + usuario.getNome() + "'," +
                    usuario.getTipo() + "," +
                    "'" + usuario.getEndereco() + "'," +
                    "'" + usuario.getDataNascimento() + "'," +
                    "'" + usuario.getSexo() + "')";
            linhasAfetadas = this.s.executeUpdate(SQL);
            System.out.println("Dados Inseridos: " + linhasAfetadas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }


    // SELECT TODOS
    public ArrayList<Usuarios> selectUsuarios(String tabela) {
        ArrayList<Usuarios> lista = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM " + tabela;
            ResultSet rset = s.executeQuery(SQL);
            while (rset.next()) {
                Usuarios usuario = new Usuarios();
                usuario.setCodigo(rset.getString("codigo"));
                usuario.setNome(rset.getString("nome"));
                usuario.setTipo(rset.getInt("tipo"));
                usuario.setEndereco(rset.getString("endereco"));
                usuario.setDataNascimento(rset.getString("dataNascimento"));
                usuario.setSexo(rset.getString("sexo"));
                lista.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // SELECT POR PK (codigo)
    public Usuarios selectByPK(String codigo, String tabela) {
        Usuarios usuario = new Usuarios();
        try {
            String SQL = "SELECT * FROM " + tabela + " WHERE codigo='" + codigo + "'";
            ResultSet rset = s.executeQuery(SQL);
            if (rset.next()) {
                usuario.setCodigo(rset.getString("codigo"));
                usuario.setNome(rset.getString("nome"));
                usuario.setTipo(rset.getInt("tipo"));
                usuario.setEndereco(rset.getString("endereco"));
                usuario.setDataNascimento(rset.getString("dataNascimento"));
                usuario.setSexo(rset.getString("sexo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    // UPDATE
    public int atualizarUsuario(Usuarios usuario, String tabela) {
        int linhasAfetadas = 0;
        try {
            String SQL = "UPDATE " + tabela + " SET " +
                    "nome='" + usuario.getNome() + "', " +
                    "tipo=" + usuario.getTipo() + ", " +
                    "endereco='" + usuario.getEndereco() + "', " +
                    "dataNascimento='" + usuario.getDataNascimento() + "', " +
                    "sexo='" + usuario.getSexo() + "' " +
                    "WHERE codigo='" + usuario.getCodigo() + "'";
            linhasAfetadas = this.s.executeUpdate(SQL);
            System.out.println("Dados Atualizados: " + linhasAfetadas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }

    // DELETE
    public int deletarUsuario(String codigo, String tabela) {
        int linhasAfetadas = 0;
        try {
            String SQL = "DELETE FROM " + tabela + " WHERE codigo='" + codigo + "'";
            linhasAfetadas = this.s.executeUpdate(SQL);
            System.out.println("Dados Removidos: " + linhasAfetadas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }
}
