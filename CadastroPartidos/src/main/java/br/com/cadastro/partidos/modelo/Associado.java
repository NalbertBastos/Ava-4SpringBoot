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
public class Associado {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeDoAssociado;
	private CargoPolitico cargoPolitico;
	private LocalDate dataDeNascimento;
	private Sexo sexo;
	private Partido partido;
	
	public Associado() {}

	public Associado(String nomeDoAssociado, CargoPolitico cargoPolitico, LocalDate dataDeNascimento,
			Sexo sexo, Partido partido) {
		this.nomeDoAssociado = nomeDoAssociado;
		this.cargoPolitico = cargoPolitico;
		this.dataDeNascimento = dataDeNascimento;
		this.sexo = sexo;
		this.partido = partido;
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
		Associado other = (Associado) obj;
		return Objects.equals(id, other.id);
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setNomeDoAssociado(String nomeDoAssociado) {
		this.nomeDoAssociado = nomeDoAssociado;
	}

	public void setCargoPolitico(CargoPolitico cargoPolitico) {
		this.cargoPolitico = cargoPolitico;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	


}
