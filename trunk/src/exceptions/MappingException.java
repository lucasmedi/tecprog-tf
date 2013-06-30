package exceptions;

@SuppressWarnings("serial")
public class MappingException extends Exception {
	public MappingException(Throwable cause) {
		super("Erro ao converter os objetos.", cause);
	}
}