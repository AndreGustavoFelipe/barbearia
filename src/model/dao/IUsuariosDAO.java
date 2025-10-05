package model.dao;

public interface IUsuariosDAO {
    public Usuarios selectByPK(String codigo, String tabela);
    public int inserirUsuario(Usuarios usuario, String tabela);
}
