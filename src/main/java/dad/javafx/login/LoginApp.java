package dad.javafx.login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApp extends Application {
	

	
	LoginController controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
//		this.primaryStage = primaryStage;
		controller=new LoginController();
		
		
		Scene scene = new Scene(controller.getRoot(), 320, 200);
		
		primaryStage.setTitle("Iniciar sesión");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}