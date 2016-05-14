package br.com.livraria.controller.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.livraria.model.Administrador;
import br.com.livraria.model.Usuario;

@WebFilter("*.xhtml")
public class ControleAcessoFiltro implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest requisicao = (HttpServletRequest) req;
		HttpServletResponse resposta = (HttpServletResponse) resp;

		HttpSession sessao = ((HttpServletRequest) req).getSession(true);
		Object pessoa=sessao.getAttribute("pessoa");
		
		if (pessoa == null && requisicao.getRequestURI().contains("/restrito/")) {
			resposta.sendRedirect(requisicao.getContextPath() + "/login.xhtml");
		} else if ((pessoa instanceof Administrador) && requisicao.getRequestURI().contains("/restrito/cliente/")) {
			resposta.sendRedirect(requisicao.getContextPath() + "/login.xhtml");
		} else if ((pessoa instanceof Usuario) && requisicao.getRequestURI().contains("/restrito/adm/")) {
			resposta.sendRedirect(requisicao.getContextPath() + "/login.xhtml");
		}else{
			chain.doFilter(req, resp);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}
}
