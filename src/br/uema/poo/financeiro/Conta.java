package br.uema.poo.financeiro;

public class Conta {
    
    private String nome;
    private String agencia;
    private String conta;

    private Operacao operacoes = null;

    private float saldo;

    public Conta(String nome, String agencia, String conta){
        this.nome = nome;
        this.agencia = agencia;
        this.conta = conta;
        this.operacoes = null;
        saldo = 0;
    }

    private Operacao busca(){
        Operacao p = operacoes;
        while (p.getProxima() != null) p = p.getProxima();
        return p;
    }

    public void movimentacao(char tipo, float valor){
        Operacao novo = new Operacao(tipo, "", valor);
        if (operacoes == null){
            this.operacoes = novo;
        } else {
            Operacao ultimo = busca();
            ultimo.setProxima(novo);
        }
        saldo = tipo == 'c' ? saldo + valor : saldo - valor;
    }

    public void extrato(){
        Operacao p = this.operacoes;
        System.out.println("------ Extrado ------");
        while (p != null){
            System.out.println(p.getTipo() + " : R$ " + p.getValor());
            p = p.getProxima();
        }
        System.out.println("------ ------- ------");
        System.out.println(this.saldo);
        System.out.println("------ ------- ------");
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public float getSaldo() {
        return saldo;
    }

}
