package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;


public class AssertTest {
	
	@Test
	public void test() {
		
		Assert.assertTrue(true); //Recebe como par�metro um booleano, testar que uma expresso � verdadeira
		Assert.assertFalse(false);
		Assert.assertEquals(1, 1); //Checa se um valor � igual ao outro
		Assert.assertEquals(0.51, 0.51, 0.01); //Para valores float � necess�rio colocar um valor delta (uma margem de erro)
		Assert.assertEquals(Math.PI, 3.14, 0.01); //Sem a margem de erro n�o � poss�vel fazer essa compara��o, pois o PI � infinito
		
		int i = 5;
		Integer i2 = 5;
		Assert.assertEquals(Integer.valueOf(i), i2); //N�o � poss�vel comparar um tipo primitivo com uma classe wrapper, o conceito de autoboxing n�o se aplica no assert, � preciso converter
		Assert.assertEquals(i, i2.intValue());
		
		Assert.assertEquals("Erro de compara��o", "bola", "casa");
		Assert.assertNotEquals("bola", "casa");
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		Assert.assertTrue("bola".startsWith("bo"));
		
		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		Usuario u3 = null;
		
		Assert.assertEquals(u1, u2); //O assertEquals nesse caso n�o considera os objetos iguais. Quem deve dizer se os objetos s�o iguais s�o os pr�prios objetos. O Java vai procurar o m�todo equals na classe, como n�o tem ele procura na super classe, como tamb�m n�o tem nenhuma super classe declarada, est� impl�cito que a classe extende o Object, que � a super classe de todas as classes. A compara��o que o OObject faz � apenas se o objeto � o mesmo que o outro (mesma inst�ncia)
		
		Assert.assertSame(u1, u1); //Verificar se os objetos s�o a mesma inst�ncia
		
		Assert.assertNull(u3);
		Assert.assertNotNull(u2);
	}

}
