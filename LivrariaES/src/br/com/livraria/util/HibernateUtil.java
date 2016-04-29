package br.com.livraria.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory fabricaSessao;
	
	static{
		StandardServiceRegistry registro=new StandardServiceRegistryBuilder().configure().build();
		try{
			fabricaSessao=new MetadataSources(registro).buildMetadata().buildSessionFactory();
		}catch(Exception e){
			StandardServiceRegistryBuilder.destroy(registro);
			System.out.println("Erro ao tentar se conectar ao banco de dados!");
			e.printStackTrace();
		}
	}
	public static Session getSessao(){
		return fabricaSessao.openSession();
	}
}
