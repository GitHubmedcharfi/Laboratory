package tn.enis.outil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import tn.enis.outil.entities.Tool;
@RepositoryRestController
public interface ToolRepository extends JpaRepository<Tool,Long> {
	List <Tool> findBySource(String source);
}
