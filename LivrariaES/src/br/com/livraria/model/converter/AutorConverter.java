package br.com.livraria.model.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.livraria.controller.dao.AutorDAO;
import br.com.livraria.model.Autor;
@FacesConverter(forClass=Autor.class)
public class AutorConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		// TODO Auto-generated method stub
		AutorDAO autorDAO=new AutorDAO();
		return autorDAO.buscarPorCodigo(new Long(valor));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		// TODO Auto-generated method stub
		return ((Autor)obj).getId().toString();
	}

}
