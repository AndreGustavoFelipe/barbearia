package view;

import model.dao.Usuarios;
import model.dao.UsuariosDAO;
import controller.validaLogin;

import java.util.Scanner;

public class TelaCadastro {

    public void mostrarTela() {
        Scanner sc = new Scanner(System.in);
        UsuariosDAO dao = new UsuariosDAO("barbearia");
        validaLogin validaLogin = new validaLogin();

        Usuarios novoUsuario = new Usuarios();

        System.out.println("===== CADASTRO =====");

        // Nome
        System.out.print("Nome: ");
        novoUsuario.setNome(sc.nextLine().trim());

        // Sobrenome
        System.out.print("Sobrenome: ");
        novoUsuario.setSobrenome(sc.nextLine().trim());

        // Login
        String login = "";
        do {
            System.out.print("Login: ");
            login = sc.nextLine().trim();

            if (login.equals("")) {
                System.out.println("Login não pode ser vazio!");
                continue;
            }

            if (validaLogin.validarEntrada(login, "") != null) {
                System.out.println("Login já existe! Escolha outro.");
                login = ""; // força repetir o loop
            }

        } while (login.equals(""));
        novoUsuario.setLogin(login);

        // Senha + confirmação
        String senha = "";
        String confirmaSenha = "";
        do {
            System.out.print("Senha: ");
            senha = sc.nextLine().trim();

            if (senha.equals("")) {
                System.out.println("Senha não pode ser vazia!");
                continue;
            }

            System.out.print("Confirme a senha: ");
            confirmaSenha = sc.nextLine().trim();

            if (!senha.equals(confirmaSenha)) {
                System.out.println("As senhas não coincidem! Tente novamente.\n");
                senha = ""; // força repetir o loop
            }

        } while (senha.equals(""));

        novoUsuario.setSenha(senha);

        // Tipo padrão (1 = usuário)
        novoUsuario.setTipo(1);

        // Inserir no banco
        int linhas = dao.inserirUsuario(novoUsuario, "usuarios");
        System.out.println(linhas > 0 ? "Usuário cadastrado!" : "Erro ao cadastrar!");
    }

    public void sayHello() {
        System.out.println("Olá! Tela de Usuario aqui!");
    }
}
