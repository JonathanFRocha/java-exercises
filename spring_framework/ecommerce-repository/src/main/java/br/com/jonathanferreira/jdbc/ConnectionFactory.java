package br.com.jonathanferreira.jdbc;

import br.com.jonathanferreira.jdbc.configreader.PropertyReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    public Connection getConnection() throws IllegalAccessException, SQLException {
        Properties props = PropertyReader.getProperties();

        if(props == null) throw new IllegalAccessException("Prop error");

        String url = props.getProperty("datasource.url");
        String user = props.getProperty("datasource.user");
        String password = props.getProperty("datasource.password");

        return DriverManager.getConnection(url, user, password);
    }
}
