package exceptions;

@SuppressWarnings("serial")
public class BusinessException extends Exception {
	public BusinessException (Throwable ex) {
		super("Erro na camada de negócio.", ex);
	}
}