package br.com.cadastro.partidos.form;

import java.time.LocalDate;

import br.com.cadastro.partidos.modelo.Associado;
import br.com.cadastro.partidos.modelo.Ideologia;
import br.com.cadastro.partidos.modelo.Partido;
import br.com.cadastro.partidos.repository.PartidoRepository;

public class AtualizacaoPartidoForm {
	private String nomeDoPartido;
	private String sigla;
	private Ideologia ideologia;
	private LocalDate dataDeFundacao;
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
	
	public Partido atualizar(Long id, PartidoRepository partidoRepository) {
		Partido partido = partidoRepository.getOne(id);
		partido.setNomeDoPartido(this.nomeDoPartido);
		partido.setSigla(this.sigla);
		partido.setIdeologia(this.ideologia);
		partido.setDataDeFundacao(this.dataDeFundacao);
		partido.setAssociado(this.associado);
		
		
		return partido;
	}

}
