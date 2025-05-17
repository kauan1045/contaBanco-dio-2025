package Banco;

import java.util.Scanner;

public class main {
    public main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criação do cliente e conta
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Crie uma senha: ");
        String senha = scanner.nextLine();

        Banco conta = new ContaCorrente(); // ou new ContaPoupanca();
        Clinte cliente = new Clinte(nome, senha, conta);

        System.out.print("Digite a senha para acessar a conta: ");
        String tentativa = scanner.nextLine();

        if (!cliente.autenticar(tentativa)) {
            System.out.println("Acesso negado. Senha incorreta.");
            return;
        }

        int opcao;
        do {
            System.out.println("\n=== MENU BANCO ===");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Ver Saldo");
            System.out.println("4. Ver Histórico");
            System.out.println("5. Aplicar rendimento (poupança)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor para depositar: ");
                    double valorDep = scanner.nextDouble();
                    conta.depositar(valorDep);
                    break;
                case 2:
                    System.out.print("Valor para sacar: ");
                    double valorSaq = scanner.nextDouble();
                    conta.sacar(valorSaq);
                    break;
                case 3:
                    System.out.println("Saldo atual: R$ " + conta.getSaldo());
                    break;
                case 4:
                    System.out.println("Histórico de transações:");
                    for (String item : conta.getHistorico()) {
                        System.out.println(item);
                    }
                    break;
                case 5:
                    if (conta instanceof ContaPoupanca) {
                        ((ContaPoupanca) conta).aplicarRendimentoMensal();
                        System.out.println("Rendimento aplicado.");
                    } else {
                        System.out.println("Esta opção é exclusiva para contas poupança.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
