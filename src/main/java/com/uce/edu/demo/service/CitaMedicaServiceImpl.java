package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.CitaMedica;
import com.uce.edu.demo.modelo.Doctor;
import com.uce.edu.demo.modelo.Paciente;
import com.uce.edu.demo.repository.ICitaMedicaRepository;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaGestorService{

	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IPacienteService iPacienteService;
	
	@Autowired
	private ICitaMedicaRepository citaMedicaRepository;

	@Override
	public void insertarCitaMedica(String numeroTurno, LocalDateTime fechaCita, BigDecimal costoCita,
			String cedulaDoctor, String cedulaPaciente) {
		// TODO Auto-generated method stub
		Doctor doctor = this.doctorService.buscarPorCedula(cedulaDoctor);
		Paciente paciente = this.iPacienteService.buscarPorCedula(cedulaPaciente);
		
		CitaMedica citaMedica = new CitaMedica();
		citaMedica.setNumero(numeroTurno);
		citaMedica.setFechaCita(fechaCita);
		citaMedica.setValorCita(costoCita);
		citaMedica.setDoctor(doctor);
		citaMedica.setPaciente(paciente);
		
		this.citaMedicaRepository.insertar(citaMedica);
		
	}
	
	

	
}
