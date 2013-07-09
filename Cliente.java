package br.com.ufpb.LojaDeRoupas.POO;

public class Cliente extends Pessoa{
    
    private double saldo;
    private String opcaoCompra;
    
    public double getCache() {
		return saldo;
	}
	public void setCache(double cache) {
		this.saldo = cache;
	}
	public String getOpcaoCompra() {
		return opcaoCompra;
	}
	public void setOpcaoCompra(String opcaoCompra) {
		this.opcaoCompra = opcaoCompra;
	}

}
