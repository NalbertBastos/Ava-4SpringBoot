package br.com.cadastro.partidos.modelo;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Partido {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeDoPartido;
	private String sigla;
	private Ideologia ideologia;
	private LocalDate dataDeFundacao;
	private Associado associado;
	
	public Partido() {}

	public Partido(String nomeDoPartido, String sigla, Ideologia ideologia, LocalDate dataDeFundacao, Associado associado) {
		this.nomeDoPartido = nomeDoPartido;
		this.sigla = sigla;
		this.ideologia = ideologia;
		this.dataDeFundacao = dataDeFundacao;
		this.associado = associado;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		return Objects.equals(id, other.id);
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setNomeDoPartido(String nomeDoPartido) {
		this.nomeDoPartido = nomeDoPartido;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public void setIdeologia(Ideologia ideologia) {
		this.ideologia = ideologia;
	}

	public void setDataDeFundacao(LocalDate dataDeFundacao) {
		this.dataDeFundacao = dataDeFundacao;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}
	
	
	
	
	
	
	
	

}
