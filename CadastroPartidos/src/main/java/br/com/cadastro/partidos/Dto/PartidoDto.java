package br.com.cadastro.partidos.Dto;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import br.com.cadastro.partidos.modelo.Associado;
import br.com.cadastro.partidos.modelo.Ideologia;
import br.com.cadastro.partidos.modelo.Partido;


public class PartidoDto {
	private Long id;
	private String nomeDoPartido;
	private String sigla;
	private Ideologia ideologia;
	private LocalDate dataDeFundacao;
	private Associado associado;
	
	
	public PartidoDto(Partido partido) {		
		this.id = id;
		this.nomeDoPartido = nomeDoPartido;
		this.sigla = sigla;
		this.ideologia = ideologia;
		this.dataDeFundacao = dataDeFundacao;
		this.associado = associado;
	}


	public Long getId() {
		return id;
	}


	public String getNomeDoPartido() {
		return nomeDoPartido;
	}


	public String getSigla() {
		return sigla;
	}


	public Ideologia getIdeologia() {
		return ideologia;
	}


	public LocalDate getDataDeFundacao() {
		return dataDeFundacao;
	}
	
	
	public Associado getAssociado() {
		return associado;
	}

	public static Page<PartidoDto> converter(Page<Partido> partido) {
			
			return partido.map(PartidoDto::new);
	}
	
	

}
