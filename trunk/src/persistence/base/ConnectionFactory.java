package persistence.base;

import java.sql.Connection;

import persistence.daoderby.DerbyConnection;
import exceptions.ConnectionException;

public class ConnectionFactory {
    public static Connection getInstance(DbType type) throws ConnectionException {
        IConnection conn = null;
    	
    	switch (type) {
			case Derby:
				conn = new DerbyConnection();
		}
        
    	if (conn == null)
    		throw new ConnectionException();
    	
		return conn.createConnection();
    }
    
    public static Connection getInstanceDerby() throws ConnectionException {
    	return getInstance(DbType.Derby);
    }
}