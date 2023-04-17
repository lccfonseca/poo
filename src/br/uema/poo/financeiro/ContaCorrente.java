package br.uema.poo.financeiro;

public class ContaCorrente extends Conta {

    private float limite;
    private float taxa_juros;

    public ContaCorrente(String nome, String agencia, String conta) {
        super(nome, agencia, conta, 0);
        //TODO Auto-generated constructor stub
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }
    
}
