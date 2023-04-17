package br.uema.db;

import java.sql.*;

public class SQLiteJDBCDriverConnection {

    private String cnn_str;
    
    private Connection connection;
    private Statement statement;

    public SQLiteJDBCDriverConnection(){
        this("jdbc:sqlite:banco.db");
    }

    public SQLiteJDBCDriverConnection(String cnn_str){
        this.cnn_str = cnn_str;
    }

    public void connect() {
        try {
            this.connection = DriverManager.getConnection(this.cnn_str);
            this.statement = connection.createStatement();
            System.out.println("Conexão realizada !!!!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void initDB() {	  
		try {
			// Remove e cria a tabela a cada execução. Mero exemplo
            //this.statement.executeUpdate("DROP TABLE IF EXISTS pessoas");
			
			this.statement.executeUpdate("CREATE TABLE IF NOT EXISTS contas ("
				+ "nome varchar(70) NOT NULL,"
				+ "agencia varchar(8), "
                + "conta varchar(10) PRIMARY KEY NOT NULL, "
                + "saldo real);");
		} 
		catch (SQLException e) {
			e.printStackTrace();  
		}  
	}

    public Statement getStatement() {
        return statement;
    }
}
