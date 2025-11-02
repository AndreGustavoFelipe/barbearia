package controller;

import model.dao.Usuarios;

public class Sessao {

    private static Usuarios usuarioLogado;

    public static void setUsuarioLogado(Usuarios usuario) {
        usuarioLogado = usuario;
    }

    public static Usuarios getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void limparSessao() {
        usuarioLogado = null;
    }
}
