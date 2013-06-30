package mapping;

import exceptions.MappingException;

public interface IMapping<T, Y> {
	T parseBO(Y dto) throws MappingException;
	Y parseDTO(T bo) throws MappingException;
}