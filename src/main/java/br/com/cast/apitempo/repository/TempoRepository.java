package br.com.cast.apitempo.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.apitempo.entity.Weather;

@Repository
public class TempoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Weather> buscarTodos(String cidade){

		StringBuilder jpql = new StringBuilder();

		jpql.append("FROM ")
			.append(Weather.class.getName())
			.append(" WHERE cidade = (:cidade) and data >= (:data) ");
		Query query = entityManager.createQuery(jpql.toString());

		query.setParameter("cidade", cidade);
		query.setParameter("data",new Date());

		return query.getResultList();

	}
	
	@Transactional
	public void inserir (Weather weather) {
		entityManager.persist(weather);
	}
	
	
	@Transactional
	public void excluir(String cidade) {
		
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("DELETE FROM ")
			.append(Weather.class.getName())
			.append(" WHERE cidade = (:cidade)");
		
		Query query = entityManager.createQuery(jpql.toString());
		
		query.setParameter("cidade", cidade);
		
		query.executeUpdate();
		
	}

}
