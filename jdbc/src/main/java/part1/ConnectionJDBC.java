package part1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    public static void main(String[] args) throws SQLException {
        String urlConnection = "jdbc:mysql://localhost/testeDigital";
        try(Connection connection = DriverManager.getConnection(urlConnection,"root", "admin123");){
            //responsável por pegar driver e criar conexão
            System.out.println("Sucesso!");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
