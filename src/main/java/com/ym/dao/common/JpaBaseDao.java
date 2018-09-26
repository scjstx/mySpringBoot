package com.ym.dao.common;

import java.io.Serializable;

public interface JpaBaseDao<T, ID extends Serializable> {

	<S extends T> S add(S obj);

	<S extends T> S update(S obj);

	void delete(ID id);

	void delete(T obj);

	T getOne(ID id);
	
}
