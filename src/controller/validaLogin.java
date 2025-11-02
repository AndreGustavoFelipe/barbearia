package controller;

import model.dao.Login;
import model.dao.Usuarios;

public class validaLogin {
    private Login login = new Login();

    public validaLogin() {
    }
    public Usuarios validarEntrada(String user, String pwd){
        return login.validaLogin(user, pwd);
    }
}
