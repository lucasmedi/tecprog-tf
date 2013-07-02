package view;

import exceptions.ConnectionException;
import framework.ConnectionFactory;
import framework.DbType;
import framework.IConnection;

public class View {
	protected IConnection connection;
	
	protected View() throws ConnectionException {
		this.connection = ConnectionFactory.getInstance(DbType.Derby);
	}
	
	@Override
	protected void finalize() throws Throwable {
		this.connection.close();
		super.finalize();
	}
}