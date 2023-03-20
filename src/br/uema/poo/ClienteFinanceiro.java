package br.uema.poo;

import br.uema.poo.financeiro.Conta;
import br.uema.poo.geometria.Ponto;

public class ClienteFinanceiro {

    String nome = "Projeto 1";

    // Tarefa 01:
    // Implemente uma interface para as operações de:
    // Saldo, Extrato, Saque e Tranferencia
    // Sugestão, criar a classe Banco para manipular as varias contas


    public static void main(String[] args) throws Exception {
        
        Conta cc1 = new Conta("Felipe", "0001", "1234");

        cc1.extrato();

        cc1.movimentacao('c', 100);
        cc1.movimentacao('c', 200);
        cc1.movimentacao('d', 50);

        cc1.extrato();
        
    }
    
}
