package br.com.jonathanferreira.jdbc;

import br.com.jonathanferreira.jdbc.configreader.PropertyReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestConnection {

    public static void main(String[] args) throws IllegalAccessException {
        Properties props = PropertyReader.getProperties();

        if(props == null) throw new IllegalAccessException("Prop error");
        String url = props.getProperty("datasource.url");
        String user = props.getProperty("datasource.user");
        String password = props.getProperty("datasource.password");

        try (Connection conn = DriverManager.getConnection(url, user, password)){
            System.out.println("Here i'm");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
