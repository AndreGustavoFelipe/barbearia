package model.dao;

import java.util.ArrayList;

public interface IUsuariosAdminDAO{
    public Usuarios selectByPK(String codigo, String tabela);
    public int inserirUsuario(Usuarios usuario, String tabela);
    public ArrayList<Usuarios> selectUsuarios(String tabela);
    public int atualizarUsuario(Usuarios usuario, String tabela);
    public int deletarUsuario(String codigo, String tabela);
}
