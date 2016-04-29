package br.com.livraria.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

public class FacesUtil {

	public static Session getSessao(String nome) {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		return (Session) request.getAttribute("sessao");
	}

	public static void addMsgInfo(String mensagem) {
		FacesMessage facesMensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);

		FacesContext facesContexto = FacesContext.getCurrentInstance();

		facesContexto.addMessage(null, facesMensagem);
	}

	public static void addMsgErro(String mensagem) {

		FacesMessage facesMensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);

		FacesContext facesContexto = FacesContext.getCurrentInstance();

		facesContexto.addMessage(null, facesMensagem);
	}

	public static String converterMD5(String valor) {
		MessageDigest msg;
		try {
			msg = MessageDigest.getInstance("MD5");

			byte[] valorMD5;

			valorMD5 = msg.digest(valor.getBytes("UTF-8"));

			StringBuffer sb = new StringBuffer();

			// converter os bytes para hexadecimal
			for (byte b : valorMD5) {
				sb.append(Integer.toHexString((b & 0xFF) | 0x100).subSequence(1, 3));
			}

			return sb.toString();// retornar o valor em hexadecimal

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static HttpServletRequest getRequisicao() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	public static HttpServletResponse getResposta() {
		return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	}
	
	public static HttpSession getSessaoWeb(){
		HttpServletRequest req=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		return req.getSession(true);
	}
	
	public static Object getAtributoSessaoWeb(String nomeAtributo){
		HttpServletRequest req=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession sessao= req.getSession(true);
		return sessao.getAttribute(nomeAtributo);
	}
	public static void setAtributoSessaoWeb(String nomeAtributo,Object objeto){
		HttpServletRequest req=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession sessao= req.getSession(true);
		sessao.setAttribute(nomeAtributo, objeto);
	}
}
