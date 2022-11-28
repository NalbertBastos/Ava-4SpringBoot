package br.com.cadastro.partidos.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.partidos.Dto.AssociadoDto;
import br.com.cadastro.partidos.Dto.DetalhesAssociado;
import br.com.cadastro.partidos.form.AtualizacaoAssociadoForm;
import br.com.cadastro.partidos.modelo.Associado;
import br.com.cadastro.partidos.modelo.CargoPolitico;
import br.com.cadastro.partidos.repository.AssociadoRepository;




@RestController
@RequestMapping("/associados")
public class AssociadoController {
	
	@Autowired
	private AssociadoRepository Repository;
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesAssociado> Listar(@PathVariable Long id) {
		Optional<Associado> associado = Repository.findById(id);
		if(associado.isPresent()) {
			return ResponseEntity.ok(new DetalhesAssociado(associado.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{cargoPolitico}")
	@Cacheable(value = "listaDePartidos")
	public ResponseEntity<Object> getAssociado(CargoPolitico cargoPolitico){
		Optional<Associado> associados = Repository.findByCargoPolitico(cargoPolitico);
		
		if(associados.isPresent()) {
			return ResponseEntity.ok(new DetalhesAssociado(associados.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	@Cacheable(value = "listaDeAssociados")
	public Page<AssociadoDto> lista(@RequestParam(required = false) CargoPolitico cargoPolitico, 
			@PageableDefault(sort = "nomeDoAssociado", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		
		if (cargoPolitico == null) {
			Page<Associado> associados = Repository.findAll(paginacao);
			return AssociadoDto.converter(associados);
		} else {
			Page<Associado> associados = Repository.findByCargoPoliticoPage(cargoPolitico, paginacao);
			return AssociadoDto.converter(associados);
		}
	}
	@GetMapping
	public List<Associado> mostrar(){
		Sort sort = Sort.by("nomeDoAssociado").ascending();
		
		return Repository.findAll(sort);
		
	}
	
	@PostMapping 
	@ResponseStatus(HttpStatus.CREATED)
	public Associado adicionar(@RequestBody Associado associado) {
		return Repository.save(associado);
	}
	
	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeAssociados", allEntries = true)
	public ResponseEntity<AssociadoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoAssociadoForm form ){
		Optional<Associado> optional = Repository.findById(id);
		if(optional.isPresent()) {
			Associado associado = form.atualizar(id,Repository);
			return ResponseEntity.ok(new AssociadoDto(associado));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeAssociado", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Associado> optional = Repository.findById(id);
		if(optional.isPresent()) {
			Repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	

}
