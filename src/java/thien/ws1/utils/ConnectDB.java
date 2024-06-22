/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thien.ws1.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

/**
 *
 * @author Thienlm30
 */
public class ConnectDB {
    
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String hostName;
    private String instance;
    private String port;
    private String dbName;
    private String user;
    private String pass;

    public ConnectDB() {
        this.hostName = "localhost";
        this.instance = "TUI-TEN-THIEN\\THIENLM30";
        this.port = "1433";
        this.dbName = "ProductIntro";
        this.user = "sa";
        this.pass = "123456";
    }
    
    public ConnectDB(ServletContext sc) {
        this.hostName = sc.getInitParameter("hostName");
        this.instance = sc.getInitParameter("instance");
        this.port = sc.getInitParameter("port");
        this.dbName = sc.getInitParameter("dbName");
        this.user = sc.getInitParameter("sa");
        this.pass = sc.getInitParameter("pass");
    }
    
    public String getURLString() {
        return String.format("jdbc:sqlserver://%s%s:%s;databasename=%s;user=%s;password=%s;",
                this.hostName, (this.instance.length()>0?"\\" + this.instance : ""), 
                this.port, this.dbName, this.user, this.pass);
    }
    
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(this.driver);
            connection = DriverManager.getConnection(getURLString());
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        return connection;
    }    
}
