package br.com.mrksFelipe.repository;

import java.io.Serializable;
import java.util.List;

public interface GenericRepository <T, ID extends Serializable> {
	
	public abstract void save(T obj);
	public abstract T update(T obj);
	public abstract void delete(ID id, Class<T> classe);
	public abstract T findByID(ID id);
	public abstract List<T> findAll();

}
