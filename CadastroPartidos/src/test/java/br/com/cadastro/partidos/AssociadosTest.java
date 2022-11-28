package br.com.cadastro.partidos;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.cadastro.partidos.modelo.Associado;
import br.com.cadastro.partidos.modelo.CargoPolitico;
import br.com.cadastro.partidos.modelo.Partido;
import br.com.cadastro.partidos.repository.AssociadoRepository;

@SpringBootTest
@DataJpaTest
class AssociadosTest {
	
	
	@Autowired
	private AssociadoRepository associadoRepository;
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	public void contextLoads() {
		Assert.assertTrue(true);
	}

	@Test
	void deveriaCarregarUmAssociado() {
		String nomeAssociado = "Jozeval";
		
		Associado asso = new Associado();
		asso.setNomeDoAssociado(nomeAssociado);;
		asso.setCargoPolitico(CargoPolitico.VEREADOR);
		
		em.persist(asso);
		
		Associado associado = associadoRepository.findByNomeDoAssociado(nomeAssociado);
		Assert.assertNotNull(associado);
		Assert.assertEquals(nomeAssociado, associado.getNomeDoAssociado());
	}
	
	@Test
	public void naoDeveriaCarregarUmPartidoCujoAssociadoNaoEstejaCadastrado() {
		String nomePolitico = "Amélia";
		Associado associado = associadoRepository.findByNomeDoAssociado(nomePolitico);
		Assert.assertNull(associado);
	}

}
