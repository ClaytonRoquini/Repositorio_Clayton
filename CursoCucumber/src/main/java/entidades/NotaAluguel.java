package entidades;

//import steps.Date;
import java.util.Date;

public class NotaAluguel {
	
	private int preco;
	public Date dataEntrega;

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date time) {
			dataEntrega = time;
	}
	

}
