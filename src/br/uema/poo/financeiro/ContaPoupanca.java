package br.uema.poo.financeiro;

public class ContaPoupanca extends Conta {

    private float taxa_rendimento;

    public ContaPoupanca(String nome, String agencia, String conta) {
        super(nome, agencia, conta);
        //TODO Auto-generated constructor stub
    }

    public float getTaxa_rendimento() {
        return taxa_rendimento;
    }

    public void setTaxa_rendimento(float taxa_rendimento) {
        this.taxa_rendimento = taxa_rendimento;
    }

    public void executarTaxa(){
        float s = getSaldo();
        movimentacao('c', s * (1 + taxa_rendimento));
    }

}
