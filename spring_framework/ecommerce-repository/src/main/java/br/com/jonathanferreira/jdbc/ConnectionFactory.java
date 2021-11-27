package br.com.jonathanferreira.jdbc;

import br.com.jonathanferreira.jdbc.configreader.PropertyReader;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private final DataSource dataSources;

    public ConnectionFactory() throws IllegalAccessException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Properties props = PropertyReader.getProperties();

        if(props == null) throw new IllegalAccessException("Prop error");
        comboPooledDataSource.setJdbcUrl(props.getProperty("datasource.url"));
        comboPooledDataSource.setUser(props.getProperty("datasource.user"));
        comboPooledDataSource.setPassword(props.getProperty("datasource.password"));

        comboPooledDataSource.setMaxPoolSize(15);

        this.dataSources = comboPooledDataSource;
    }

    public Connection getConnection() throws SQLException {
        return dataSources.getConnection();
    }
}
