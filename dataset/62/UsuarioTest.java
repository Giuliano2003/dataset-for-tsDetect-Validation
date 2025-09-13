
package br.com.djavani.asserts;
import org.junit.Assert;
import org.junit.Test;

import br.com.djavani.entidades.Usuario;

public class AssertTest {

    /* https://github.com/djavani/UnitTestsWithJunit/blob/master/src/main/java/br/com/djavani/servicos/Calculadora.java */


	
	@Test
	public void testeStrings() {
		Assert.assertEquals("bola", "bola");
		Assert.assertNotEquals("bola", "casa");
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		Assert.assertTrue("bola".startsWith("bo"));
	}
	
	@Test
	public void testeObjeto() {
		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		Usuario u3 = u2;
		Usuario u4 = null;
		
		Assert.assertEquals(u1, u2);
		
		Assert.assertSame(u2, u3);
		Assert.assertNotSame(u1, u2);
		
		Assert.assertNull(u4);
		Assert.assertNotNull(u2);
	}
}
