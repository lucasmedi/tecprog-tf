package persistence.daoderby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import persistence.base.IConnection;
import exceptions.ConnectionException;

public class DerbyConnection implements IConnection {
    public Connection createConnection() throws ConnectionException {
        Connection connection = null;
        
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection("jdbc:derby:cadastro");
            connection.setAutoCommit(false);
        } catch (SQLException | ClassNotFoundException ex) {
        	throw new ConnectionException(ex);
        }
        
        return connection;
    }
}