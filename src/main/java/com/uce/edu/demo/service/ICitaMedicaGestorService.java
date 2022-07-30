package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface ICitaMedicaGestorService {

	public void insertarCitaMedica(String numeroTurno, LocalDateTime fechaCita, BigDecimal costoCita, String cedulaDoctor, String cedulaPaciente);
	
	public void actualizarCitaMedica(String numero);
}
