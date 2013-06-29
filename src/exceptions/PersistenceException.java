package exceptions;

@SuppressWarnings("serial")
public class PersistenceException extends Exception {
	public PersistenceException(String message) {
		super(message);
	}
	
	public PersistenceException(Throwable cause) {
		this("Erro ao realizar operação na base de dados", cause);
	}
	
	public PersistenceException(String message, Throwable cause) {
		super(message, cause);
	}
}