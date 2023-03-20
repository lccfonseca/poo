package br.uema.poo.geometria;

public class Linha {
    
    Ponto p1;
    Ponto p2;

    public Linha(Ponto pt1, Ponto pt2){
        this.p1 = pt1;
        this.p2 = pt2;
    }

    public double comprimento(){
        return p1.distancia(p2);
    }

}
