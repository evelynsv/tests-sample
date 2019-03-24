package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;


public class AssertTest {
	
	@Test
	public void test() {
		
		Assert.assertTrue(true); //Recebe como parâmetro um booleano, testar que uma expresso é verdadeira
		Assert.assertFalse(false);
		Assert.assertEquals(1, 1); //Checa se um valor é igual ao outro
		Assert.assertEquals(0.51, 0.51, 0.01); //Para valores float é necessário colocar um valor delta (uma margem de erro)
		Assert.assertEquals(Math.PI, 3.14, 0.01); //Sem a margem de erro não é possível fazer essa comparação, pois o PI é infinito
		
		int i = 5;
		Integer i2 = 5;
		Assert.assertEquals(Integer.valueOf(i), i2); //Não é possível comparar um tipo primitivo com uma classe wrapper, o conceito de autoboxing não se aplica no assert, é preciso converter
		Assert.assertEquals(i, i2.intValue());
		
		Assert.assertEquals("Erro de comparação", "bola", "casa");
		Assert.assertNotEquals("bola", "casa");
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		Assert.assertTrue("bola".startsWith("bo"));
		
		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		Usuario u3 = null;
		
		Assert.assertEquals(u1, u2); //O assertEquals nesse caso não considera os objetos iguais. Quem deve dizer se os objetos são iguais são os próprios objetos. O Java vai procurar o método equals na classe, como não tem ele procura na super classe, como também não tem nenhuma super classe declarada, está implícito que a classe extende o Object, que é a super classe de todas as classes. A comparação que o OObject faz é apenas se o objeto é o mesmo que o outro (mesma instância)
		
		Assert.assertSame(u1, u1); //Verificar se os objetos são a mesma instância
		
		Assert.assertNull(u3);
		Assert.assertNotNull(u2);
	}

}
