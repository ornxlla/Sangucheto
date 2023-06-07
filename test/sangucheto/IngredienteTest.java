package sangucheto;

import static org.junit.Assert.*;

import org.junit.Test;

public class IngredienteTest {

	@Test
	public void queSeCreenLosIngredientes() {
		Ingrediente j = new Ingrediente("Jamon", 500.0, 50);
		Ingrediente c = new Ingrediente("Carne", 1000.0, 100);
		Ingrediente q = new Ingrediente("Queso", 500.0, 50);
		Ingrediente m = new Condimento("Mayonesa", 100.0, 100);
		Ingrediente s = new Condimento("Sal", 100.0, 100);
		
		assertNotNull(j);
		assertNotNull(c);
		assertNotNull(q);
		assertNotNull(m);
		assertNotNull(s);
	}
	
	@Test
	public void agregarStockALosIngredientes() {
		Ingrediente j = new Ingrediente("Jamon", 500.0, 50);
		Ingrediente s = new Condimento("Sal", 100.0, 100);
		j.agregarStock(5);
		s.agregarStock(8);
		
		Integer valorEsperado = 55;
		Integer valorObtenido = j.getStock();
		assertEquals(valorEsperado, valorObtenido);
		
		Integer valorEsperadoDos = 108;
		Integer valorObtenidoDos = s.getStock();
		assertEquals(valorEsperadoDos, valorObtenidoDos);
	}
	
	@Test
	public void consultarStockDeCualquierIngredienteAunqueEsteSeaCero() {
		Ingrediente j = new Ingrediente("Jamon", 500.0, 50);
		Ingrediente s = new Condimento("Sal", 100.0, 100);
		Ingrediente q = new Ingrediente("Queso", 500.0, 0);
		Ingrediente m = new Condimento("Mayonesa", 100.0, 0);
		
		Integer valorEsperado = 50;
		Integer valorEsperadoDos = 100;
		Integer valorEsperadoTres = 0;
		
		assertEquals(valorEsperado, j.getStock());
		assertEquals(valorEsperadoDos, s.getStock());
		assertEquals(valorEsperadoTres, q.getStock());
		assertEquals(valorEsperadoTres, m.getStock());
	}
	
	@Test
	public void darDeAltaUnIngredientePorTenerStockCero() {
		Ingrediente j = new Ingrediente("Jamon", 500.0, 0);
		
		assertTrue(j.darDeAlta());
	}
	
	@Test
	public void queNoSePuedaDarDeAltaPorqueExisteStock() {
		Ingrediente j = new Ingrediente("Jamon", 500.0, 1);
		
		assertFalse(j.darDeAlta());
	}
	
	@Test
	public void eliminarStockDeUnIngrediente() {
		Ingrediente j = new Ingrediente("Jamon", 500.0, 50);
		j.eliminarStock(3);
		
		Integer valorEsperado = 47;
		Integer valorObtenido = j.getStock();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
}
