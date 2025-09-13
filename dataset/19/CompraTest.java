
package es.uca.gii.csi18.stuart.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.uca.gii.csi18.stuart.data.Compra;
import es.uca.gii.csi18.stuart.data.Data;
import es.uca.gii.csi18.stuart.data.Descuento;

/* https://github.com/DanielGilB/csi/blob/master/src/es/uca/gii/csi18/stuart/test/CompraTest.java */

class CompraTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception { Data.LoadDriver(); }
	
	@Test
	public void testConstructor() throws Exception {
		Compra compra = new Compra(1);
		assertEquals(1, compra.getId());
		assertEquals("compra1", compra.getNombre());
		assertEquals(12.99, compra.getImporte());
	}

	@Test
	public void testCreate() throws Exception {
		Descuento descuento = new Descuento(1);
		Compra compra = Compra.Create("compraTest", 9.99, descuento);
		assertEquals(11, compra.getId());
		assertEquals("compraTest", compra.getNombre());
		assertEquals(9.99, compra.getImporte());
	}
	
}
