package br.uema.poo.agenda;

public class Contatos {

    private int id;
    private String nome;
    private String telefone;
    private String email;

    public Contatos(int id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return "[" + this.id + ", " +
                this.nome + ", " +
                this.telefone + ", " +
                this.email + "]";
    }

}
