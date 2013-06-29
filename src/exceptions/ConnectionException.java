package exceptions;

@SuppressWarnings("serial")
public class ConnectionException extends Exception {
	public ConnectionException() {
		this(null);
	}
	
	public ConnectionException(Throwable cause) {
		this("Erro ao abrir conexão com a base de dados.", cause);
	}
	
	public ConnectionException(String message, Throwable cause) {
		super(message, cause);
	}
}