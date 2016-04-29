package br.com.livraria.model.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.livraria.controller.dao.EditoraDAO;
import br.com.livraria.model.Editora;
@FacesConverter(forClass=Editora.class)
public class EditoraConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		// TODO Auto-generated method stub
		EditoraDAO editoraDAO=new EditoraDAO();
		return editoraDAO.buscarPorCodigo(new Long(valor));
		
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		// TODO Auto-generated method stub
		return ((Editora)obj).getId().toString();
	}

}
