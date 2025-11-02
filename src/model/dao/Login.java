package model.dao;

public class Login {
    public Login() {
    }
    public Usuarios validaLogin(String user, String pwd){
        return new UsuariosDAO("barbearia").validaUsuario(user, pwd);
    }
}
