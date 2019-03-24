package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runners.MethodSorters;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.servicos.LocacaoService;
import br.ce.wcaquino.utils.DataUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocacaoServiceTest {
	
	private LocacaoService service;
	private Usuario usuario;
	private Filme filme; 
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Before
	public void setUp() {
		
		//Cenário
		service = new LocacaoService();
		usuario = new Usuario("Usuario 1");
		filme = new Filme("Filme 1", 2, 5.0);
		
	}
	
	@After
	public void tearDown() {
		
	}
	
	
	@Test
	public void teste() throws Exception {

		//Ação
		Locacao locacao = service.alugarFilme(usuario, filme);
			
			//Verificação
			error.checkThat(locacao.getValor(), is(equalTo(5.0)));
			//assertThat(locacao.getValor(), is(CoreMatchers.not(6.0)));
			error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
			error.checkThat(isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));
		
	}
	
	@Test(expected=FilmeSemEstoqueException.class)
	public void testLocacao() throws Exception {
		
		Filme filme = new Filme("Filme 1", 0, 5.0);
				
				//Ação
				service.alugarFilme(usuario, filme);
	}
	
	@Test
	public void testLocacaoUsuarioVazio() throws FilmeSemEstoqueException{
		
			try {
				service.alugarFilme(null, filme);
				Assert.fail();
			} catch (LocadoraException e) {
				Assert.assertThat(e.getMessage(), is("Usuário vazio"));
			}
	}

}
