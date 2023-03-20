package br.uema.poo.geometria;

public class Ponto {

    // O correto em uma classe é que os atributos estejam protegidos
    // que só sejam acessados por métodos.
    // Chamamos esse conceito de encapsulamento!
    private int x, y;

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distancia(Ponto other) {
        // Calculo da distancia do ponto atual para outro ponto

        return Math.sqrt(
                Math.pow(other.getX() - this.getX(), 2) +
                Math.pow(other.getY() - this.getY(), 2));
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "["
                + Integer.toString(x)
                + ", "
                + Integer.toString(y) + "]";
    }

}
