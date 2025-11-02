import controller.validaLogin;
import controller.Sessao;
import model.dao.Usuarios;
import view.TelaAdmin;
import view.TelaCadastro;
import view.TelaUsuario;

import java.util.Scanner;

public class Main {

    private validaLogin controllerLogin = new validaLogin();

    private void run() {

        Scanner leia = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Cadastro");
            System.out.println("2. Login");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = leia.next();

            switch (opcao) {
                case "1":
                    new TelaCadastro().mostrarTela();
                    break;

                case "2":
                    System.out.print("Login: ");
                    String login = leia.next();
                    System.out.print("Senha: ");
                    String senha = leia.next();

                    Usuarios usuario = controllerLogin.validarEntrada(login, senha);
                    if (usuario != null) {
                        Sessao.setUsuarioLogado(usuario);
                        System.out.println("\nLogin realizado com sucesso!");
                        System.out.println("Bem-vindo, " + usuario.getNome() + "!");
                        if (usuario.getTipo() == 0){
                            new TelaAdmin().sayHello();
                        } else{
                            new TelaUsuario().mostrarTela();
                        }
                    } else {
                        System.out.println("Dados incorretos!");
                    }
                    break;

                case "3":
                    System.out.println("Encerrando o sistema...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
