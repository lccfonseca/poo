package br.uema.poo.agenda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

import br.uema.db.SQLiteJDBCDriverConnection;

public class Agenda {

    private static Scanner scanner;
    private SQLiteJDBCDriverConnection db;

    public Agenda() {
        this.db = new SQLiteJDBCDriverConnection("jdbc:sqlite:agenda.db");
        this.db.connect();
        this.initDB();
    }

    private void initDB() {
        try {
            this.db
                    .getStatement()
                    .executeUpdate("CREATE TABLE IF NOT EXISTS contatos ("
                            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + "nome VARCHAR(80) NOT NULL,"
                            + "telefone VARCHAR(15) NOT NULL, "
                            + "email VARCHAR(100));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int menu() {
        System.out.println("###### Selecione qual operação deseja executar: ######");
        System.out.println("1 - Listar");
        System.out.println("2 - Incuir");
        System.out.println("3 - Alterar");
        System.out.println("4 - Excluir");
        System.out.println("0 - Sair");
        System.out.println("############");

        int op = 0;
        try {
            op = scanner.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return op;
    }

    public void listar() {
        try {
            ResultSet rs = this.db
                    .getStatement()
                    .executeQuery("SELECT * FROM contatos;");
            while (rs.next()) {
                Contatos c = new Contatos(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email"));
                System.out.println(c.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String lerString() {
        try {
            String str = scanner.next();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private Contatos lerContatos() {
        System.out.println("Informe o nome: ");
        String nome = lerString();
        System.out.println("Informe o telefone: ");
        String telefone = lerString();
        System.out.println("Informe o e-mail: ");
        String email = lerString();
        Contatos c = new Contatos(0, nome, telefone, email);
        return c;
    }

    public void incluir(Contatos c) {
        try {
            String sql = "INSERT INTO contatos (id, nome, telefone, email) VALUES (?, ?, ?, ?);";
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, null);
            ps.setString(2, c.getNome());
            ps.setString(3, c.getTelefone());
            ps.setString(4, c.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Contatos c){
        String sql = "UPDATE contatos SET nome = ?, telefone = ?, email = ? WHERE id = ?;";
    }

    public void apagar(Contatos c){
        String sql = "DELETE FROM contatos WHERE id = ?;";
    }

    public void executa() {
        int op;
        while ((op = this.menu()) != 0) {
            switch (op) {
                case 1:
                    this.listar();
                    break;
                case 2:
                    this.incluir(lerContatos());
                    break;
                case 3:
                    // this.alterar();
                    break;
                case 4:
                    // this.apagar();
                    break;
                default:
                    break;
            }
        }
    }

    static {
        resync();
    }

    private static void resync() {
        setScanner(new Scanner(new java.io.BufferedInputStream(System.in), "utf-8"));
    }

    private static void setScanner(Scanner scanner) {
        Agenda.scanner = scanner;
        Agenda.scanner.useLocale(new Locale("pt_BR"));
    }

}
