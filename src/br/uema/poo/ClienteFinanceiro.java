package br.uema.poo;

import br.uema.poo.financeiro.CaixaEletronico;
import br.uema.poo.financeiro.Conta;

public class ClienteFinanceiro {

    String nome = "Projeto 1";

    public static void main(String[] args) throws Exception {

        CaixaEletronico ce = new CaixaEletronico();

        ce.addConta(new Conta("Felipe", "0001", "1234"));
        ce.addConta(new Conta("Luis Carlos", "0001", "4321"));
        ce.addConta(new Conta("Daniel", "0001", "2211"));

        ce.executa();

    }

}
