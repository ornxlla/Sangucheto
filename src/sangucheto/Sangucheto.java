package sangucheto;

import java.util.LinkedList;

public class Sangucheto {

	private LinkedList <Ingrediente> ingredientes = new LinkedList <Ingrediente>();
	private Double precioFinal = 0.0;
	
	public LinkedList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(LinkedList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public void setPrecioFinal(Double precioFinal) {
		this.precioFinal = precioFinal;
	}

	public Double getPrecioFinal() {
		return precioFinal;
	}

	public Boolean agregarIngrediente(Ingrediente ingrediente, Integer rebanadas) {
		if(ingrediente.getStock() >= rebanadas) {
			this.ingredientes.add(ingrediente);
			ingrediente.setStock(ingrediente.getStock() - rebanadas);
			this.precioFinal += ingrediente.getPrecio() * rebanadas;
			return true;
		}
		return false;
	}

	public Integer stockTotal() {
		Integer stockTotal = 0;
		for(Ingrediente i :ingredientes) {
			stockTotal += i.getStock();
		}
		return stockTotal;
	}

	public Boolean eliminarPedido() {
		for(Ingrediente i :ingredientes) {
			if(this.ingredientes.contains(i)) {
				this.ingredientes.removeAll(ingredientes);
				return true;
			}
		}
		return false;
	}



}
