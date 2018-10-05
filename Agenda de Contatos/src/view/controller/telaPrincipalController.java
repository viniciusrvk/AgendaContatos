package view.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class telaPrincipalController implements Initializable{
    @FXML
    private ListView<String> listContatos;
	@FXML
	private Label nome;
	@FXML
	private Label telefone;
	@FXML
	private Label email;
	@FXML
	private Button get;
	
	ObservableList<String> list = FXCollections.observableArrayList("teste1", "teste2");

	// Event Listener on MenuItem.onAction
	@FXML
	public void addNew(ActionEvent event) {
		new novoContatoController().open();
	}

	public void open() {
		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/view/telaPrincipal.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Tela Principal");
			stage.show();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listContatos.setItems(list);
	}
	@FXML
	public void lvSelect(ActionEvent event) {
		System.out.println("select");
		this.nome.setText(listContatos.getSelectionModel().getSelectedItem());
	}

}
