package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.CitaMedica;

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
	public int actualizar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery(
				"Update CitaMedica c set c.diagnostico = :diagnostico, c.receta = :receta, c.fechaControl = :fechaControl where c.numero = :numero");
		query.setParameter("diagnostico", citaMedica.getDiagnostico());
		query.setParameter("receta", citaMedica.getPaciente());
		query.setParameter("fechaControl", citaMedica.getFechaControl());
		query.setParameter("numero", citaMedica.getNumero());
		return query.executeUpdate();
	}

}
