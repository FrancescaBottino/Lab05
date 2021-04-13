package it.polito.tdp.anagrammi.model;

import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	private AnagrammaDAO anagrammaDao;
	
	public Model() {
		anagrammaDao=new AnagrammaDAO();
	}
	
	
 public List<String> cercaAnagrammi(String parola) {
	
	  Anagramma a= new Anagramma();
	  List<String> anagrammi=a.anagrammi(parola);
	
      return anagrammi;
	  
  
}
 
 public boolean isCorrect(String anagramma) {
	
	 return anagrammaDao.isCorrect(anagramma);
 }
	

}
