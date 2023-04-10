package br.uema.poo.financeiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CaixaEletronico {

    List<Conta> contas;

    private static Scanner scanner;

    public CaixaEletronico() {
        this.contas = new ArrayList<>();
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void addConta(Conta conta) {
        this.contas.add(conta);
    }

    // Tarefa 01:
    // Implemente uma interface para as operações de:
    // Saldo, Extrato, Saque e Tranferencia
    // Sugestão, criar a classe Banco para manipular as varias contas

    public int menu() {
        clearConsole();
        System.out.println("$$$$$$ Selecione qual operação deseja executar: $$$$$$");
        System.out.println("1 - Saldo");
        System.out.println("2 - Extrato");
        System.out.println("3 - Saque");
        System.out.println("4 - Transferencia");
        System.out.println("5 - Deposito");
        System.out.println("$$$$$$$$$$$$");

        int op = 0;
        try {
            op = scanner.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return op;
    }

    public void executa() {
        int op;
        while ((op = this.menu()) != 0) {
            switch (op) {
                case 1:
                    this.saldo();
                    break;
                case 2:
                    this.extrato();
                    break;
                case 3:
                    this.saque();
                    break;
                case 4:
                    this.transferencia();
                    break;
                case 5:
                    this.deposito();
                    break;
                default:
                    break;
            }
        }
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Linux")) {
                Runtime.getRuntime().exec("clear");
            } else {
                Runtime.getRuntime().exec("cls");
            }
        } catch (final Exception e) {
            // Handle any exceptions.
        }
    }

    public String lerDadosConta() {
        try {
            String conta = scanner.next();
            return conta;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public float lerValor() {
        try {
            float conta = scanner.nextFloat();
            return conta;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Conta buscar() {
        System.out.println("Informe a conta: ");
        String conta = lerDadosConta();
        for (int i = 0; i < this.contas.size(); i++) {
            if (contas.get(i).getConta().equals(conta)) {
                return contas.get(i);
            }
        }
        return null;
    }

    public void saldo() {
        Conta ct = buscar();
        if (ct != null) {
            System.out.println("O saldo da conta é: " + ct.getSaldo());
        } else {
            System.out.println("Conta não encontrada!");
        }

    }

    public void saque() {
        System.out.println("### Saque ###");
        Conta conta = buscar();
        if(conta.getSaldo() == 0){
            System.out.println("Não é possível realizar um saque!");
        } else {
            System.out.println("Informe o Valor a ser retirado (separado por .):");
            conta.movimentacao('d', lerValor());
            System.out.println("O novo saldo da conta é: " + conta.getSaldo());
        }
    }

    public void transferencia() {
        System.out.println("### Tranferência ###");
        System.out.println("ORIGEM!"); 
        Conta contaOrigem = buscar();
        if(contaOrigem.getSaldo() == 0){
            System.out.println("Não é possível realizar uma transferência!");
        } else {
            System.out.println("DESTINO!");         
            Conta contaDestino = buscar();
            System.out.println("Informe o Valor a ser Transferido (separado por .):");
            float valor = lerValor();
            contaOrigem.movimentacao('d', valor);
            contaDestino.movimentacao('c', valor);

            System.out.println("O novo saldo da sua conta é: " + contaOrigem.getSaldo());
        }
    }

    public void extrato() {
        Conta ct = buscar();
        if (ct != null) {
            ct.extrato();
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public void deposito() {
        Conta ct = buscar();
        if (ct != null) {
            System.out.println("Informe o valor (separado por .):");
            ct.movimentacao('c', lerValor());
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    static {
        resync();
    }

    private static void resync() {
        setScanner(new Scanner(new java.io.BufferedInputStream(System.in), "utf-8"));
    }

    private static void setScanner(Scanner scanner) {
        CaixaEletronico.scanner = scanner;
        CaixaEletronico.scanner.useLocale(new Locale("pt_BR"));
    }

}
