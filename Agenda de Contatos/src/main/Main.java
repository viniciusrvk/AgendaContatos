package main;

import javafx.application.Application;
import javafx.stage.Stage;
import view.controller.telaPrincipalController;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		new telaPrincipalController().open();		
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
