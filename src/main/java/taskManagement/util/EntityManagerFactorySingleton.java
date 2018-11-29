package taskManagement.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	private static EntityManagerFactory emf=null;
	
	private  EntityManagerFactorySingleton(){
		
	}
	public static EntityManagerFactory getEntityManagerFactory(){
		if(emf==null){
			emf=Persistence.createEntityManagerFactory("dataAnalyser");
		}

		return emf;
	}
}
