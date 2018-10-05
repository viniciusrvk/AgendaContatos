package view.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.bean.Contato;
import modelo.bean.ContatoDAO;
import javafx.event.ActionEvent;

public class novoContatoController {
	@FXML
	private TextField name;
	@FXML
	private TextField email;
	@FXML
	private TextField phone;

	// Event Listener on Button.onAction
	@FXML
	public void addNewContact(ActionEvent event) {
		if(name.getText() != "" && (email.getText() != "" || phone.getText() != "")) {
			String name = this.name.getText();
			String email = this.email.getText();
			String phone = this.phone.getText();
			ContatoDAO.insert(Contato.create(name, email, phone));
			//System.out.println(name +" "+email+" "+phone);
		}this.close();
	}
	public void open() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/novoContato.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Tela Principal");
			stage.show();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	// Event Listener on Button.onAction
	@FXML
	public void cancel(ActionEvent event) {
		this.close();
	}
	private void close ()
    {
    	Stage stage = (Stage) name.getScene().getWindow();
	    stage.close();
    }
}
