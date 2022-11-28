package br.com.cadastro.partidos.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.cadastro.partidos.modelo.Associado;
import br.com.cadastro.partidos.modelo.Ideologia;
import br.com.cadastro.partidos.modelo.Partido;
import br.com.cadastro.partidos.repository.PartidoRepository;


public class PartidoForm {
	@NotNull @NotEmpty @Length(min = 5)
	private String nomeDoPartido;
	@NotNull @NotEmpty @Length(min = 3)
	private String sigla;
	@NotNull @NotEmpty
	private Ideologia ideologia;
	@NotNull @NotEmpty
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dataDeFundacao;
	@NotNull @NotEmpty
	private Associado associado;
	
	public String getNomeDoPartido() {
		return nomeDoPartido;
	}
	public void setNomeDoPartido(String nomeDoPartido) {
		this.nomeDoPartido = nomeDoPartido;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public Ideologia getIdeologia() {
		return ideologia;
	}
	public void setIdeologia(Ideologia ideologia) {
		this.ideologia = ideologia;
	}
	public LocalDate getDataDeFundacao() {
		return dataDeFundacao;
	}
	public void setDataDeFundacao(LocalDate dataDeFundacao) {
		this.dataDeFundacao = dataDeFundacao;
	}
	public Associado getAssociado() {
		return associado;
	}
	public void setAssociado(Associado associado) {
		this.associado = associado;
	}
	
	public Partido converter(PartidoRepository partidoRepository) {
		Partido partido = partidoRepository.findByNome(nomeDoPartido);
		
		return new Partido (nomeDoPartido,sigla,ideologia,dataDeFundacao,associado);
		
		
	}

}
