package br.com.livraria.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.Transaction;

@WebFilter(servletNames="Faces Servlet")
public class FiltroSessao implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		Session sessao=HibernateUtil.getSessao();
		Transaction trx=null;
		
		try{

			trx=sessao.beginTransaction();
			request.setAttribute("sessao", sessao);
			chain.doFilter(request, response);
			trx.commit();
		}catch(Exception e){
			trx.rollback();
			e.printStackTrace();
		}finally {
			sessao.close();
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
