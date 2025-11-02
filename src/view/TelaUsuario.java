package view;

import controller.buscaProduto;
import controller.buscaServico;
import model.dao.Produtos;
import model.dao.ProdutosDAO;
import model.dao.Servicos;

import java.util.ArrayList;
import java.util.Scanner;

public class TelaUsuario {

    public void mostrarTela() {
        Scanner sc = new Scanner(System.in);
        ProdutosDAO dao = new ProdutosDAO("barbearia");

        buscaProduto produtoController = new buscaProduto("barbearia");
        buscaServico servicoController = new buscaServico("barbearia");

        int opcao;
        do {
            System.out.println("\n===== MENU USUÁRIO =====");
            System.out.println("1. Buscar Produto");
            System.out.println("2. Buscar Serviço");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // consome o \n

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome, descrição ou ID do produto: ");
                    String termoProduto = sc.nextLine().trim();

                    exibirResultados(produtoController.buscar(termoProduto, "produtos"), "Produto");
                    break;

                case 2:
                    System.out.print("Digite o nome, descrição ou ID do serviço: ");
                    String termoServico = sc.nextLine().trim();

                    exibirResultadosServicos(servicoController.buscar(termoServico, "servicos"), "Serviço");
                    break;

                case 3:
                    System.out.println("Saindo da tela do usuário...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);
    }

    private void exibirResultados(ArrayList<Produtos> resultados, String tipo) {
        if (resultados.isEmpty()) {
            System.out.println("Nenhum " + tipo + " encontrado.");
        } else {
            System.out.println("\n" + tipo + "s encontrados:");
            for (Produtos p : resultados) {
                System.out.println("- " + p.getNome() +
                        " | R$ " + p.getValor() +
                        " | Descrição: " + p.getDescricao());
            }
        }
    }

    private void exibirResultadosServicos(ArrayList<Servicos> resultados, String tipo) {
        if (resultados.isEmpty()) {
            System.out.println("Nenhum " + tipo + " encontrado.");
        } else {
            System.out.println("\n" + tipo + "s encontrados:");
            for (Servicos s : resultados) {
                System.out.println("- " + s.getNome() +
                        " | R$ " + s.getValor() +
                        " | Descrição: " + s.getDescricao());
            }
        }
    }



    public void sayHello() {
        System.out.println("Olá! Tela de Usuário aqui!");
    }
}
