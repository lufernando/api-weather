package br.com.cast.apitempo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.apitempo.dto.ResultWeatherDTO;

@Repository
public class TempoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<ResultWeatherDTO> buscarTodos(String cidade){

		StringBuilder jpql = new StringBuilder();

		jpql.append("FROM ")
			.append(ResultWeatherDTO.class.getName())
			.append(" WHERE cidade = :cidade");
		Query query = entityManager.createQuery(jpql.toString());

		query.setParameter("cidade", cidade);

		return query.getResultList();

	}
	
	

}
