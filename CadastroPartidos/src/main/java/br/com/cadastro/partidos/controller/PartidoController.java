package br.com.cadastro.partidos.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.partidos.Dto.DetalhesPartido;
import br.com.cadastro.partidos.Dto.PartidoDto;
import br.com.cadastro.partidos.form.AtualizacaoPartidoForm;
import br.com.cadastro.partidos.modelo.Ideologia;
import br.com.cadastro.partidos.modelo.Partido;
import br.com.cadastro.partidos.repository.PartidoRepository;


@RestController
@RequestMapping("/partidos")
public class PartidoController {
	
	@Autowired
	private PartidoRepository partidoRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesPartido> Listar(@PathVariable Long id) {
		Optional<Partido> partido = partidoRepository.findById(id);
		if(partido.isPresent()) {
			return ResponseEntity.ok(new DetalhesPartido(partido.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{ideologia}")
	@Cacheable(value = "listaDePartidos")
	public ResponseEntity<Object> getPartido(Ideologia ideologia){
		Optional<Partido> partidos = partidoRepository.findByIdeologia(ideologia);
		
		if(partidos.isPresent()) {
			return ResponseEntity.ok(new DetalhesPartido(partidos.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Partido adicionar(@RequestBody Partido partido) {
		return partidoRepository.save(partido);
	}
	
	
	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDePartidos", allEntries = true)
	public ResponseEntity<PartidoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoPartidoForm form ){
		Optional<Partido> optional = partidoRepository.findById(id);
		if(optional.isPresent()) {
			Partido partido = form.atualizar(id,partidoRepository);
			return ResponseEntity.ok(new PartidoDto(partido));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDePartidos", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Partido> optional = partidoRepository.findById(id);
		if(optional.isPresent()) {
			partidoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}








