package edu.mum.cs544.project.ecruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.project.ecruit.domain.QueryFilter;

@Repository
//@Transactional(propagation=Propagation.MANDATORY)
public interface QueryFilterRepository extends CrudRepository<QueryFilter, Integer> {
	
	@Query("SELECT u.filters FROM User u where u.id=:id")
	List<QueryFilter> getQueryFilters(@Param("id") Long key);
	

}
