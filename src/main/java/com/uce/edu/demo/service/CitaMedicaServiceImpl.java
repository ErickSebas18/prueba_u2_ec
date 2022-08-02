package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.CitaMedica;
import com.uce.edu.demo.modelo.CitaMedicaSencillo;
import com.uce.edu.demo.modelo.Doctor;
import com.uce.edu.demo.modelo.Paciente;
import com.uce.edu.demo.repository.ICitaMedicaRepository;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaGestorService {

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

	@Override
	public void actualizarCitaMedica(String numero, String diagnostico, String receta, LocalDateTime fechaControl) {
		// TODO Auto-generated method stub

		CitaMedica citaMedica = this.citaMedicaRepository.buscarPorNumero(numero);
		citaMedica.setDiagnostico(diagnostico);
		citaMedica.setReceta(receta);
		citaMedica.setFechaControl(fechaControl);
		this.citaMedicaRepository.actualizar(citaMedica);
	}

	@Override
	public List<CitaMedicaSencillo> buscarCitaMedicaSencillos(LocalDateTime fecha, BigDecimal costo) {
		// TODO Auto-generated method stub
		return null;
	}

}
