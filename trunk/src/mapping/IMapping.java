package mapping;

public interface IMapping<T, Y> {
	T parseBO(Y dto);
	Y parseDTO(T bo);
}