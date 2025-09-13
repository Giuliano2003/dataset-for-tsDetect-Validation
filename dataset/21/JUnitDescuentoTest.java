package es.uca.gii.csi18.stuart.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.uca.gii.csi18.stuart.data.Descuento;
import es.uca.gii.csi18.stuart.data.Data;

class JUnitDescuentoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception { Data.LoadDriver(); }
	
	@Test
	public void testConstructor() throws Exception {
		Descuento descuento = new Descuento(1);
		assertEquals(1, descuento.getId());
		assertEquals("sin descuento", descuento.getNombre());
	}
	
}