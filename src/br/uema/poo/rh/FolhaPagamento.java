package br.uema.poo.rh;

public class FolhaPagamento {

    public double calcularFolhaPagamento(Funcionario emp) {
        // Calcula o bônus. Não é preciso verificar com instanceof
        return emp.calcularSalario();
    }

    public static void main(String arg[]) {
        FolhaPagamento fp = new FolhaPagamento();
        Programador prg = new Programador();
        Gerente mgr = new Gerente();
        System.out.println("Salário do Programador " +
                fp.calcularFolhaPagamento(prg));
        System.out.println("Salário do Gerente " +
                fp.calcularFolhaPagamento(mgr));
    }

}
