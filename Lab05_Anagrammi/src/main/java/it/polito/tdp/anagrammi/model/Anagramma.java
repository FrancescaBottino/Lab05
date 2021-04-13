package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class Anagramma {
	
	
	public List<String> anagrammi(String parola){
		
		//5) istruzioni da eseguire sempre 
		
		List<String> risultato= new ArrayList<String>(); //la costruisce (anche fuori)
		
		ricorsione("", parola, 0, risultato); //lancia la ricorsione per la prima volta
		
		return risultato;
		
		
	}

	private void ricorsione(String parziale, String lettere, int livello, List<String> risultato) {
		
		
		//1) caso terminale 
		if(lettere.length()==0) {
			
			risultato.add(parziale); //la sol parziale è completa, la salvo
		}
		else {
			
			//2) genero nuova sol parziale
			
			for(int pos=0; pos<lettere.length(); pos++) {
				
				char tentativo= lettere.charAt(pos);
				
				String nuovaParziale= parziale+tentativo;
				
				String nuovaLettere= lettere.substring(0, pos)+lettere.substring(pos+1);//tolgo carattere pos da 'lettere'
				
				
				//3) controllo sul dizionario se nuova parziale è valida
				
				
				ricorsione(nuovaParziale, nuovaLettere, livello+1, risultato);
				
				//4) backtracking
				
				
			}
			
			
			
		}
		
		
		
		
		
	}

}
