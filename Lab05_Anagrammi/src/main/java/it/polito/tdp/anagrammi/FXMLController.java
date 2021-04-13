package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParolaInserita;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;
    
    @FXML
    private Button btnCalcolaAnagrammi;
    
    @FXML
    private Button btnReset;

    @FXML
    void calcolaAnagrammi(ActionEvent event) {

    	btnCalcolaAnagrammi.setDisable(true);
    	btnReset.setDisable(false);
    	
    	String parola=txtParolaInserita.getText();
    	
    	if(parola.length() > 6) {
    		txtAnagrammiCorretti.setText("La parola inserita è troppo lunga (>6 caratteri) "+"\n"+"e il programma potrebbe impiegare molto tempo."+"\n"+"Inseriscine un altra.");
    		txtParolaInserita.clear();
    		return;
    	}
    	
    	List<String> anagrammi=this.model.cercaAnagrammi(parola);
    	
    	String risC="";
    	String risE="";
    	
          for(String s: anagrammi) {
    		if(this.model.isCorrect(s)) {
    			risC+=s+"\n";
    		}
    		else 
    			risE+=s+"\n";
    	}
    		
    	
    	txtAnagrammiCorretti.setText(risC);
    	txtAnagrammiErrati.setText(risE);
    	
    }

    @FXML
    void reset(ActionEvent event) {
    	
    	txtAnagrammiCorretti.clear();
    	txtAnagrammiErrati.clear();
    	txtParolaInserita.clear();
    	btnCalcolaAnagrammi.setDisable(false);
    	btnReset.setDisable(true);

    }

    @FXML
    void initialize() {
        assert txtParolaInserita != null : "fx:id=\"txtParolaInserita\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model=model;
    	}
}
