package framework;

import persistence.daoderby.DerbyConnection;
import exceptions.ConnectionException;

public class ConnectionFactory {
    public static IConnection getInstance(DbType type) throws ConnectionException {
        IConnection conn = null;
    	
    	switch (type) {
			case Derby:
				conn = new DerbyConnection();
		}
        
    	if (conn == null)
    		throw new ConnectionException();
    	
		return conn;
    }
}