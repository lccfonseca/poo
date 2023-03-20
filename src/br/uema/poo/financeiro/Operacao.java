package br.uema.poo.financeiro;

public class Operacao {

    char tipo;
    float valor;
    Operacao proxima;

    public Operacao() {
        this.tipo = 'c';
        this.valor = 0;
        proxima = null;
    }

    public Operacao(char tipo, float valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.proxima = null;
    }
    
}
