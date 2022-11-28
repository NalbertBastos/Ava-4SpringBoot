package br.com.cadastro.partidos.Dto;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import br.com.cadastro.partidos.modelo.Associado;
import br.com.cadastro.partidos.modelo.CargoPolitico;
import br.com.cadastro.partidos.modelo.Partido;
import br.com.cadastro.partidos.modelo.Sexo;

public class AssociadoDto {
	private Long id;
	private String nomeDoAssociado;
	private CargoPolitico cargoPolitico;
	private LocalDate dataDeNascimento;
	private Sexo sexo;
	private Partido partido;
	
	public AssociadoDto(Associado associado) {		
		this.id = id;
		this.nomeDoAssociado = nomeDoAssociado;
		this.cargoPolitico = cargoPolitico;
		this.dataDeNascimento = dataDeNascimento;
		this.sexo = sexo;
		this.partido = partido;
	}

	public Long getId() {
		return id;
	}

	public String getNomeDoAssociado() {
		return nomeDoAssociado;
	}

	public CargoPolitico getCargoPolitico() {
		return cargoPolitico;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}
	public Partido getPartido() {
		return partido;
	}
	
	public static Page<AssociadoDto> converter(Page<Associado> associado) {
		
		return associado.map(AssociadoDto::new);
    }

}
