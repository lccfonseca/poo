package br.uema.poo.rh;

public class Programador implements Funcionario {

    private static final int SALARIO = 50000;
    private static final int BONUS = 10000;

    @Override
    public double calcularSalario() {
        return SALARIO + getBonus();
    }

    @Override
    public int getBonus() {
        return BONUS;
    }
    
}
