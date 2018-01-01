/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.koneksi;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 *
 * @author TOSHIBA
 */
public class myConnection {

    public Connection con;
    private Properties prop;

    public myConnection() {
        initVar();
    }

    private void initVar() {
        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src\\com\\disperindag\\DBconfig\\database.xml"));
        } catch (IOException ex) {
            prop.setProperty("HOST", "localhost");
            prop.setProperty("PORT", "3306");
            prop.setProperty("DATABASE", "db_disperindag");
        }
    }

    public Connection getConnection() {
        try {
            MysqlDataSource ds = new MysqlDataSource();
            ds.setServerName(prop.getProperty("HOST"));
            ds.setUser("root");
            ds.setPassword("root");
            ds.setPort(Integer.parseInt(prop.getProperty("PORT")));
            ds.setDatabaseName(prop.getProperty("DATABASE"));
            con = ds.getConnection();
        } catch (Exception e) {
            return con = null;
        }
        return con;
    }
}
