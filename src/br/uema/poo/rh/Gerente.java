package br.uema.poo.rh;

public class Gerente implements Funcionario {

    private static final int SALARIO = 40000;
    private static final int BONUS = 0;

    @Override
    public double calcularSalario() {
        return SALARIO;
    }

    @Override
    public int getBonus() {
        return BONUS;
    }

}
