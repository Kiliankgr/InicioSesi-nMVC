package dad.javafx.login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LoginController {
	// model
	StringProperty user = new SimpleStringProperty();
	StringProperty passw = new SimpleStringProperty();
	// view
	LoginView view = new LoginView();

	public LoginController() {
		view.getLoginButton().setOnAction(e -> onLoginButtonAction(e));
		view.getCancelarButton().setOnAction(e -> onCancelarButtonAction(e));
		user.bind(view.getUserText().textProperty());
		passw.bind(view.getPassText().textProperty());
		view.getLoginButton().disableProperty().bind(user.isEmpty().or(passw.isEmpty()));
		
	}

	private void onLoginButtonAction(ActionEvent e) {
		String aux;
		boolean encontrado = false;
		String username = user.getValue().toLowerCase();
		String password = passw.getValue();
		String md5 = DigestUtils.md5Hex(password).toUpperCase();
		String path;

		BufferedReader bf;
		try {
			path = new File("").getCanonicalPath();// ruta actual
			path += "/Users.csv";
			
			bf = new BufferedReader(new FileReader(path));
			while ((aux = bf.readLine()) != null) {// busqueda de un usuario
				
				if (username.equals(lectorUsuarios(aux))) {
					encontrado = true;
					break;
				}
			}
			if (!encontrado) {
				System.out.println("Usuario mal");
				Alert alert = new Alert(AlertType.ERROR);
				alert.initOwner(((Node) (e.getSource())).getScene().getWindow());
				alert.setHeaderText("Intento de inicio de sesión");
				alert.setContentText("Usuario: " + username + " incorrecto");
				alert.showAndWait();
			} else {
				System.out.println("Usuario bien");
				
				// comprobar si la contraseña es correcta
				System.out.println("contraseña puesta "+md5+" Contraseña real "+aux);
					if (aux.contains(md5)) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.initOwner(((Node) (e.getSource())).getScene().getWindow());
						alert.setHeaderText("Intento de inicio de sesión");
						alert.setContentText("Usuario: " + username + "\n" + "Contraseña: " + password + "\n");
						alert.showAndWait();
					}else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.initOwner(((Node) (e.getSource())).getScene().getWindow());
						alert.setHeaderText("Intento de inicio de sesión");
						alert.setContentText("Contraseña: " + password + " incorrecta");
						alert.showAndWait();
					}
			}
		} catch (IOException e1) {
			System.err.println("Algo pudo salir mal :(");
				e1.printStackTrace();
		}
	

	}
	private String lectorUsuarios(String texto) {
		String usuario="";
		for (int i = 0; texto.charAt(i)!=';'; i++) {
			usuario+=texto.charAt(i);
		}
		return usuario;
	}
	
	private void onCancelarButtonAction(ActionEvent e) {
		Platform.exit();
	}

	public LoginView getRoot() {
		return view;
	}
}
