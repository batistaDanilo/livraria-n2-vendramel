package br.com.livraria.model;

public enum Situacao {
	AG("Aguardando Pagamento"),
	PG("Pago"),
	NP("Não Pago");
	
	private String valor;
	
	Situacao(String valor){
		this.valor=valor;
	}
	
	public String getValor(){
		return valor;
	}
}
