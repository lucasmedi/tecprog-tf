package persistence.daoderby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exceptions.ConnectionException;
import framework.IConnection;

public class DerbyConnection implements IConnection {
	private Connection connection;
	
	private Connection createConnection() throws ConnectionException {
        Connection connection = null;
        
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection("jdbc:derby:cadastro");
        } catch (SQLException | ClassNotFoundException ex) {
        	throw new ConnectionException(ex);
        }
        
        return connection;
    }
	
	private boolean hasTransaction() throws ConnectionException {
		try {
			return !connection.getAutoCommit();
		} catch (SQLException e) {
			throw new ConnectionException(e);
		}
	}

	@Override
	public Connection getConnection() throws ConnectionException {
		this.open();
		return this.connection;
	}
	
	@Override
	public void open() throws ConnectionException {
		if (connection == null)
			connection = createConnection();
	}

	@Override
	public void close() throws ConnectionException {
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				throw new ConnectionException(e);
			}
	}

	@Override
	public void openTransaction() throws ConnectionException {
		try {
			if (!hasTransaction())
				connection.setAutoCommit(false);
		} catch (SQLException e) {
			throw new ConnectionException(e);
		}
	}
	
	@Override
	public void commit() throws ConnectionException {
		try {
			if (hasTransaction())
				connection.commit();
		} catch (SQLException e) {
			throw new ConnectionException(e);
		}
	}
	
	@Override
	public void rollback() throws ConnectionException {
		try {
			if (hasTransaction())
				connection.rollback();
		} catch (SQLException e) {
			throw new ConnectionException(e);
		}
	}
}