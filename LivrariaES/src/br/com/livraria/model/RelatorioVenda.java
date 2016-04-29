package br.com.livraria.model;

import java.util.Date;
import java.util.List;

public class RelatorioVenda {
	private Date dataInicio;
	private Date dataFim;
	private List<Venda> listaVendas;
	
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public List<Venda> getListaVendas() {
		return listaVendas;
	}
	public void setListaVendas(List<Venda> listaVendas) {
		this.listaVendas = listaVendas;
	}
	
}
