package com.Spiralfit.Spiralfit.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.Spiralfit.Spiralfit.models.spiral;

public interface ProfisRepository extends CrudRepository<spiral, Long> {
	spiral findByCodigo(long codigo);

	List<spiral> findByNome(String nome);
	
	@Query(value = "select u from spiral u where u.nome like %?1%")
	List<spiral> findByNomesspiral(String nome);
}


