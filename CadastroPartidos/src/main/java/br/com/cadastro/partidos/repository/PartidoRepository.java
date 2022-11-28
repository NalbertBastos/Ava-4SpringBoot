package br.com.cadastro.partidos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


import br.com.cadastro.partidos.modelo.CargoPolitico;
import br.com.cadastro.partidos.modelo.Ideologia;
import br.com.cadastro.partidos.modelo.Partido;



@Repository
@EnableJpaRepositories
public interface PartidoRepository extends JpaRepository<Partido,Long>  {
	Partido findByNome(String nome);

	Optional<Partido> findById(Long id);

	Optional<Partido> findByIdeologia(Ideologia ideologia);

	Partido getOne(Long id);
	

}
