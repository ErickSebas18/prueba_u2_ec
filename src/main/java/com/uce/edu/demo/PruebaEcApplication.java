package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.Doctor;
import com.uce.edu.demo.modelo.Paciente;
import com.uce.edu.demo.service.ICitaMedicaGestorService;
import com.uce.edu.demo.service.IDoctorService;
import com.uce.edu.demo.service.IPacienteService;

@SpringBootApplication
public class PruebaEcApplication implements CommandLineRunner{

	private static Logger logJava = Logger.getLogger(PruebaEcApplication.class);
	
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IPacienteService pacienteService;
	
	@Autowired
	private ICitaMedicaGestorService citaMedicaGestorService;
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaEcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Doctor doctor = new Doctor();
		doctor.setCedula("143143565");
		doctor.setNombre("Erick");
		doctor.setApellido("Chávez");
		doctor.setFechaNacimiento(LocalDateTime.of(1995, 04, 21, 0, 0));
		doctor.setNumeroConsultorio("6");
		doctor.setSalario(new BigDecimal(4500));
		
		//this.doctorService.insertar(doctor);
		logJava.info("Se ha insertado un doctor: " + doctor);
		
		Doctor doctor2 = new Doctor();
		doctor2.setCedula("17461341");
		doctor2.setNombre("Paul");
		doctor2.setApellido("Perez");
		doctor2.setFechaNacimiento(LocalDateTime.of(1990, 06, 12, 0, 0));
		doctor2.setNumeroConsultorio("9");
		doctor2.setSalario(new BigDecimal(5000));
		
		//this.doctorService.insertar(doctor2);
		logJava.info("Se ha insertado un doctor: " + doctor2);
		
		Paciente paciente = new Paciente();
		paciente.setCedula("62313414");
		paciente.setNombre("Cristian");
		paciente.setApellido("Arboleda");
		paciente.setFechaNacimiento(LocalDateTime.of(1998, 07, 14, 0, 0));
		paciente.setCodigoIees("1652");
		paciente.setEstatura(1.96);
		paciente.setPeso(52.0);
		paciente.setGenero("Masculino");
		
		//this.pacienteService.insertar(paciente);
		logJava.info("Se ha insertado un doctor: " + paciente);
		
		Paciente paciente2 = new Paciente();
		paciente2.setCedula("71243154");
		paciente2.setNombre("Kevin");
		paciente2.setApellido("Toapanta");
		paciente2.setFechaNacimiento(LocalDateTime.of(2002, 04, 13, 0, 0));
		paciente2.setCodigoIees("6321");
		paciente2.setEstatura(1.50);
		paciente2.setPeso(86.4);
		paciente2.setGenero("Masculino");
		
		//this.pacienteService.insertar(paciente2);
		logJava.info("Se ha insertado un doctor: " + paciente2);
		
		//this.citaMedicaGestorService.insertarCitaMedica("4",LocalDateTime.now() , new BigDecimal(50), doctor.getCedula(), paciente2.getCedula());
		logJava.info("Se ha insertado una cita médica");
		
		this.citaMedicaGestorService.actualizarCitaMedica("4", "Gripe", "Paracetamol 8 h", LocalDateTime.now());
	}

}
