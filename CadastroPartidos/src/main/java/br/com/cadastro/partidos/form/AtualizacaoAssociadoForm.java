package br.com.cadastro.partidos.form;

import java.time.LocalDate;

import br.com.cadastro.partidos.modelo.Associado;
import br.com.cadastro.partidos.modelo.CargoPolitico;
import br.com.cadastro.partidos.modelo.Partido;
import br.com.cadastro.partidos.modelo.Sexo;
import br.com.cadastro.partidos.repository.AssociadoRepository;
import br.com.cadastro.partidos.repository.PartidoRepository;


public class AtualizacaoAssociadoForm {
	
	private String nomeDoAssociado;
	private CargoPolitico cargoPolitico;
	private LocalDate dataDeNascimento;
	private Sexo sexo;
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
	public Associado atualizar(Long id, AssociadoRepository repository) {
		Associado associado = repository.getOne(id);
		associado.setNomeDoAssociado(this.nomeDoAssociado);
		associado.setCargoPolitico(this.cargoPolitico);
		associado.setDataDeNascimento(this.dataDeNascimento);
		associado.setSexo(this.sexo);
		associado.setPartido(this.partido);
		
		
		return associado;
	}
	
	

}
