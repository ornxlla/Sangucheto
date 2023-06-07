package sangucheto;

import static org.junit.Assert.*;

import org.junit.Test;

public class SanguchetoTest {

	@Test
	public void queSePuedaAgregarIngredienteAlSangucheto() {
		Ingrediente p = new Ingrediente("Pan", 500.0, 50);
		Ingrediente s = new Condimento("Sal", 100.0, 100);
		
		Sangucheto nuevo = new Sangucheto();
		assertTrue(nuevo.agregarIngrediente(s, 1));
		assertTrue(nuevo.agregarIngrediente(p, 2));
		
		Integer valorEsperado = 99;
		Integer valorEsperadoDos = 48;
		assertEquals(valorEsperado, s.getStock());
		assertEquals(valorEsperadoDos, p.getStock());
	}

	@Test
	public void queNoSePuedaAgregarIngredienteAlSangucheto() {
		Ingrediente j = new Ingrediente("Jamon", 500.0, 50);
		Ingrediente m = new Condimento("Mayonesa", 100.0, 100);
		Sangucheto nuevo = new Sangucheto();
		assertFalse(nuevo.agregarIngrediente(j, 51));
		assertFalse(nuevo.agregarIngrediente(m, 101));
	}
	
	@Test
	public void queCalculeElPrecioDelSangucheto() {
		Ingrediente p = new Ingrediente("Pan", 500.0, 50);
		Ingrediente s = new Condimento("Sal", 100.0, 100);
		Ingrediente j = new Ingrediente("Jamon", 500.0, 50);
		Ingrediente m = new Condimento("Mayonesa", 100.0, 100);
		Ingrediente c = new Ingrediente("Carne", 1000.0, 50);
		Sangucheto nuevo = new Sangucheto();
		assertTrue(nuevo.agregarIngrediente(c, 2));
		assertTrue(nuevo.agregarIngrediente(s, 1));
		assertTrue(nuevo.agregarIngrediente(j, 3));
		assertTrue(nuevo.agregarIngrediente(m, 1));
		assertTrue(nuevo.agregarIngrediente(p, 2));
		
		Double valorObtenido = nuevo.getPrecioFinal();
		Double valorEsperado = 4700.0;
		assertEquals(valorEsperado, valorObtenido, 0.01);
	}
	
	@Test
	public void listarLosIngredientesDisponibles() {
		Ingrediente p = new Ingrediente("Pan", 500.0, 50);
		Ingrediente s = new Condimento("Sal", 100.0, 100);
		Ingrediente j = new Ingrediente("Jamon", 500.0, 50);
		Ingrediente m = new Condimento("Mayonesa", 100.0, 100);
		Ingrediente c = new Ingrediente("Carne", 1000.0, 50);
		Sangucheto nuevo = new Sangucheto();
		assertTrue(nuevo.agregarIngrediente(c, 2));
		assertTrue(nuevo.agregarIngrediente(s, 1));
		assertTrue(nuevo.agregarIngrediente(j, 3));
		assertTrue(nuevo.agregarIngrediente(m, 1));
		assertTrue(nuevo.agregarIngrediente(p, 2));
		
		Integer valorEsperado = 5;
		Integer valorObtenido = nuevo.getIngredientes().size();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void consultarStockDisponibleTotalLuegoDeComprarElSangucheto() {
		Ingrediente p = new Ingrediente("Pan", 500.0, 2);
		Ingrediente s = new Condimento("Sal", 100.0, 1);
		Ingrediente j = new Ingrediente("Jamon", 500.0, 50);
		Ingrediente m = new Condimento("Mayonesa", 100.0, 100);
		Ingrediente c = new Ingrediente("Carne", 1000.0, 50);
		Sangucheto nuevo = new Sangucheto();
		assertTrue(nuevo.agregarIngrediente(c, 2));
		assertTrue(nuevo.agregarIngrediente(s, 1));
		assertTrue(nuevo.agregarIngrediente(j, 3));
		assertTrue(nuevo.agregarIngrediente(m, 1));
		assertTrue(nuevo.agregarIngrediente(p, 2));
		
		Integer valorEsperado = 194;
		Integer valorObtenido = nuevo.stockTotal();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queNoSePuedaAgregarIngredientePorqueNoTieneStock() {
		Ingrediente s = new Condimento("Sal", 100.0, 1);
		Sangucheto nuevo = new Sangucheto();
		assertTrue(nuevo.agregarIngrediente(s, 1));
		assertFalse(nuevo.agregarIngrediente(s, 1));
	}
	
	@Test
	public void eliminarPedido() {
		Ingrediente s = new Condimento("Sal", 100.0, 1);
		Sangucheto nuevo = new Sangucheto();
		assertTrue(nuevo.agregarIngrediente(s, 1));
		
		assertTrue(nuevo.eliminarPedido());
		
		Integer valorEsperado = 0;
		Integer valorObtenido = nuevo.getIngredientes().size();
		assertEquals(valorEsperado, valorObtenido);
	}
}
