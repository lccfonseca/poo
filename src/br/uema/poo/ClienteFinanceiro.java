package br.uema.poo;

import br.uema.poo.financeiro.Conta;
import br.uema.poo.geometria.Ponto;

public class ClienteFinanceiro {

    String nome = "Projeto 1";

    public static void main(String[] args) throws Exception {
        
        Conta cc = new Conta("Felipe", "0001", "1234");

        cc.extrato();

        cc.movimentacao('c', 100);
        cc.movimentacao('c', 200);
        cc.movimentacao('d', 50);

        cc.extrato();
        
    }
    
}
