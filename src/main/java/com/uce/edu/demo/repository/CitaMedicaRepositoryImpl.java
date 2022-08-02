package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.CitaMedica;
import com.uce.edu.demo.modelo.CitaMedicaSencillo;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(citaMedica);
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.merge(citaMedica);
	}

	@Override
	public CitaMedica buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<CitaMedica> query = this.entityManager
				.createQuery("Select cm from CitaMedica cm where cm.numero = :numero", CitaMedica.class);
		query.setParameter("numero", numero);
		return query.getSingleResult();
	}

	@Override
	public List<CitaMedicaSencillo> buscarCitaMedicaSencillos(LocalDateTime fecha, BigDecimal costo) {
		// TODO Auto-generated method stub
		TypedQuery<CitaMedicaSencillo> query = this.entityManager.createQuery(
				"Select new com.uce.edu.demo.modelo.CitaMedicaSencillo (c.fechaCita, c.costo) from CitaMedicaSencilla c where c.fecha > :fecha and c.costo > :costo",
				CitaMedicaSencillo.class);
		query.setParameter("fecha", fecha);
		query.setParameter("costo", costo);
		return query.getResultList();
	}

}
