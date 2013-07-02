package framework;

import java.sql.Connection;

import exceptions.ConnectionException;

public interface IConnection {
	Connection getConnection() throws ConnectionException;
	void open() throws ConnectionException;
	void close() throws ConnectionException;
	void openTransaction() throws ConnectionException;
	void commit() throws ConnectionException;
	void rollback() throws ConnectionException;
}