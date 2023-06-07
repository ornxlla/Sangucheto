package sangucheto;

public class Ingrediente {

	protected String nombre;
	protected Double precio;
	protected Integer stock;

	public Ingrediente(String nombre, Double precio, Integer stock) {
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public void agregarStock(Integer stockAAgregar) {
		this.stock += stockAAgregar;
	}

	public Boolean darDeAlta() {
		if(this.stock == 0) {
			return true;
		}
		return false;
	}

	public void eliminarStock(Integer stockAEliminar) {
		this.stock -= stockAEliminar;
		
	}
 
	
}
