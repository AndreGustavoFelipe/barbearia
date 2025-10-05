package controller;

import model.dao.Login;

public class validaLogin {
    private Login login = new Login();

    public validaLogin() {
    }
    public boolean validarEntrada(String user, String pwd){
        if(login.validaLogin(user,pwd)){
            return true;
        }else{
            return false;
        }
    }
}
