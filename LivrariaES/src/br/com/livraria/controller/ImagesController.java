package br.com.livraria.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.livraria.controller.dao.LivroDAO;
import br.com.livraria.model.Livro;

@ManagedBean
@SessionScoped
public class ImagesController {
	
	
	
    public StreamedContent mostrarImagem() throws IOException {
    	LivroDAO livroDAO = new LivroDAO();
        FacesContext context = FacesContext.getCurrentInstance();

        if(true){
        	System.out.println("debug");
        }
        
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        }
        else {
            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
            String studentId = context.getExternalContext().getRequestParameterMap().get("livroID");
            Livro livro = livroDAO.buscarPorCodigo(Long.valueOf(studentId));
            return new DefaultStreamedContent(new ByteArrayInputStream(livro.getImagem()), "image/png");
        }
    }
}
