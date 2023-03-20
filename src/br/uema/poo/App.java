package br.uema.poo;

import br.uema.poo.geometria.Ponto;

public class App {

    String nome = "Projeto 1";

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Ponto pt1 = new Ponto(2, 3);
        Ponto pt2 = new Ponto(1, 5);

        System.out.println(pt1);
        System.out.println(pt2);
        System.out.println("Distancia entre pt1 e pt2: " + pt1.distancia(pt2));
        
    }
    
}
