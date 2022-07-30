package com.uce.edu.demo.repository;

import com.uce.edu.demo.modelo.CitaMedica;

public interface ICitaMedicaRepository {

	public void insertar(CitaMedica citaMedica);
	
	public int actualizar(CitaMedica citaMedica);
	
}
