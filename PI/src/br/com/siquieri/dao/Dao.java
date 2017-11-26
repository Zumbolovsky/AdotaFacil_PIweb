/*
Andrew Siquieri - RA: 20872955 
Hadil Karim - RA: 20745273
Guilherme Lins - RA: 20699690
José Netto - RA: 20163147
Selma Masuzawa - RA: 20680327
*/
package br.com.siquieri.dao;

import java.util.List;

public interface Dao<T> {

	void adicionar(T entidade);
	List<T> listar();
	T buscar(int id);
	
}
