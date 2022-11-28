package br.com.cadastro.partidos;

import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.cadastro.partidos.modelo.Partido;
import br.com.cadastro.partidos.repository.PartidoRepository;

@SpringBootTest
@DataJpaTest
class CadastroPartidosApplicationTests {
	
	@Autowired
	private PartidoRepository repository;
	
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	public void contextLoads() {
		Assert.assertTrue(true);
	}

	@Test
	void deveriaCarregarUmPartido() {
		String nomePartido = "Democatras";
		
		Partido dem = new Partido();
		dem.setNomeDoPartido(nomePartido);
		dem.setSigla("DEM");
		
		em.persist(dem);
		
		Partido partido = repository.findByNome(nomePartido);
		Assert.assertNotNull(partido);
		Assert.assertEquals(nomePartido, partido.getNomeDoPartido());
	}
	
	@Test
	public void naoDeveriaCarregarUmPartidoCujoSiglaNaoEstejaCadastrado() {
		String siglaPartido = "PCdoB";
		Partido partido = repository.findByNome(siglaPartido);
		Assert.assertNull(partido);
	}

}
