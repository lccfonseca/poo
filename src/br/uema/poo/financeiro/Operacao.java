package br.uema.poo.financeiro;

import java.time.LocalDate;

public class Operacao {

    private LocalDate data;
    private String descricao;
    private char tipo;
    private float valor;
    private Operacao proxima;

    public Operacao() {
        this('c', "", 0);
        this.data = LocalDate.now();
    }

    public Operacao(char tipo, String descricao, float valor) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.valor = valor;
        this.proxima = null;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Operacao getProxima() {
        return proxima;
    }

    public void setProxima(Operacao proxima) {
        this.proxima = proxima;
    }
    
}
