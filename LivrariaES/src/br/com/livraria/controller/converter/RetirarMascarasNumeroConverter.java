package br.com.livraria.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "retirarMascarasNumero")
public class RetirarMascarasNumeroConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		// TODO Auto-generated method stub
		if (valor != null && !valor.equals("")) {
			valor = valor.replaceAll("[-/.]", "");
			valor = valor.replaceAll("[-()]", "");
			valor = valor.replaceAll("[ ]", "");
		} else {
			if (valor==null) {
				return new Long(0);
			}
		}
		return new Long(valor);
		
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object valor) {
		// TODO Auto-generated method stub
		if (valor != null) {
			return valor.toString();
		} else {
			return "0";
		}
	}

}
