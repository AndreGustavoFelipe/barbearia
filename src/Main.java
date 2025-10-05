import controller.validaLogin;
import model.dao.Usuarios;
import model.dao.UsuariosDAO;
import view.TelaAdmin;
import view.TelaUsuario;

import java.util.Scanner;

public class Main {

    private validaLogin controllerLogin = new validaLogin();

    private void run(){
        Scanner leia = new Scanner(System.in);

        UsuariosDAO user = new UsuariosDAO("barbearia");

        Usuarios u = new Usuarios();


        u.setNome("Teste");
        u.setTipo(1);
        u.setSexo("M");
        u.setEndereco("Teste");
        u.setDataNascimento("08/11/2005");

        int linhas = user.inserirUsuario(u, "usuarios");

//        System.out.println("Digite uma das opções:");
//        System.out.println("1. Usuario Padrão");
//        System.out.println("2. Administrador");
//        System.out.println("3. SAIR");
//
//        String opcao = leia.next();
//        switch (Integer.parseInt(opcao)){
//            case 1:
//                if(controllerLogin.validarEntrada("user1","123456")){
//                    new TelaUsuario().sayHello();
//                }else{
//                    System.out.println("Dados incorretos!");
//                }
//                break;
//            case 2: new TelaAdmin().sayHello();
//                break;
//            case 3: System.exit(0);
//                break;
//            default:
//                System.out.println("Opção Inválida!");
//                break;
//        }
    }
    public static void main(String[] args) {
        new Main().run();
    }
}