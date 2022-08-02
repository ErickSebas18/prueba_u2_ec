package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.modelo.CitaMedicaSencillo;

public interface ICitaMedicaGestorService {

	public void insertarCitaMedica(String numeroTurno, LocalDateTime fechaCita, BigDecimal costoCita, String cedulaDoctor, String cedulaPaciente);
	
	public void actualizarCitaMedica(String numero, String diagnostico, String receta, LocalDateTime fechaControl);
	
	public List<CitaMedicaSencillo> buscarCitaMedicaSencillos(LocalDateTime fecha, BigDecimal costo);
}
