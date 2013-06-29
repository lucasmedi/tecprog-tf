package persistence.base;

import java.sql.Connection;

import exceptions.ConnectionException;

public interface IConnection {
	 public Connection createConnection() throws ConnectionException;
}