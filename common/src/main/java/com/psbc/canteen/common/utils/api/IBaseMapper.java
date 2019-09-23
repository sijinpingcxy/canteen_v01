package com.psbc.canteen.common.utils.api;

import java.io.Serializable;
import java.util.List;


public abstract interface IBaseMapper<T, PK extends Serializable> {

	public abstract Integer insert(T entity) throws Exception;

	public abstract Integer delete(PK id) throws Exception;

	public abstract Integer updateById(T entity) throws Exception;

	public abstract List<T> findAll(T entity) throws Exception;
	
	public abstract Integer getCount(T entity) throws Exception;
}