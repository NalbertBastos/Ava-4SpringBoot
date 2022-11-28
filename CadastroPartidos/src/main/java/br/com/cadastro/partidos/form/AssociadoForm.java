package br.com.cadastro.partidos.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.cadastro.partidos.modelo.Associado;
import br.com.cadastro.partidos.modelo.CargoPolitico;
import br.com.cadastro.partidos.modelo.Partido;
import br.com.cadastro.partidos.modelo.Sexo;
import br.com.cadastro.partidos.repository.AssociadoRepository;

public class AssociadoForm {
	@NotNull @NotEmpty @Length(min = 3)
	private String nomeDoAssociado;
	@NotNull @NotEmpty
	private CargoPolitico cargoPolitico;
	@NotNull @NotEmpty 
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dataDeNascimento;
	@NotNull @NotEmpty 
	private Sexo sexo;
	@NotNull @NotEmpty 
	private Partido partido;
	
	public String getNomeDoAssociado() {
		return nomeDoAssociado;
	}
	public void setNomeDoAssociado(String nomeDoAssociado) {
		this.nomeDoAssociado = nomeDoAssociado;
	}
	public CargoPolitico getCargoPolitico() {
		return cargoPolitico;
	}
	public void setCargoPolitico(CargoPolitico cargoPolitico) {
		this.cargoPolitico = cargoPolitico;
	}
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	public Partido getPartido() {
		return partido;
	}
	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	public Associado converter(AssociadoRepository associadoRepository) {
		Associado associado = associadoRepository.findByNomeDoAssociado(nomeDoAssociado);
		
		return new Associado (nomeDoAssociado,cargoPolitico,dataDeNascimento,sexo,partido);
		
		
	}


}
