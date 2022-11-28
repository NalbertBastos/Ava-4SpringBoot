package br.com.cadastro.partidos.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastro.partidos.modelo.Associado;
import br.com.cadastro.partidos.modelo.CargoPolitico;


public interface AssociadoRepository extends JpaRepository<Associado,Long>{

	Optional<Associado> findById(Long id);

	Page<Associado> findByCargoPoliticoPage(CargoPolitico cargoPolitico, Pageable paginacao);

	Associado findByNomeDoAssociado(String nomeDoAssociado);

	Optional<Associado> findByCargoPolitico(CargoPolitico cargoPolitico);

}
