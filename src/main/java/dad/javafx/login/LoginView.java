package dad.javafx.login;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginView extends VBox{
	private Label userLabel, passLabel;
	private TextField userText;
	private PasswordField passText;
	private Button loginButton,cancelarButton;
	public LoginView() {
		super();
		
		userLabel = new Label("Usuario:");
		userLabel.setMinWidth(80);
		
		passLabel = new Label("Contraseña:");
		passLabel.setMinWidth(80);
		
		userText = new TextField();
		userText.setPromptText("Nombre de usuario");
		userText.setMaxWidth(80);
		
		passText = new PasswordField();
		passText.setPromptText("Contraseña");
		passText.setMaxWidth(80);
		
		loginButton = new Button("Acceder");
		loginButton.setDefaultButton(true);
		
		cancelarButton = new Button("Cancelar");
		cancelarButton.setDefaultButton(true);
		
		
		HBox userBox = new HBox(5, userLabel, userText);
		userBox.setAlignment(Pos.CENTER);

		HBox passBox = new HBox(5, passLabel, passText);
		passBox.setAlignment(Pos.CENTER);
		
		HBox authBox = new HBox(5, loginButton,cancelarButton);
		authBox.setAlignment(Pos.CENTER);
		
		this.setSpacing(5);
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(userBox, passBox, authBox);
		
	}
	public Label getUserLabel() {
		return userLabel;
	}
	public Label getPassLabel() {
		return passLabel;
	}
	public TextField getUserText() {
		return userText;
	}
	public PasswordField getPassText() {
		return passText;
	}
	public Button getCancelarButton() {
		return cancelarButton;
	}
	public Button getLoginButton() {
		return loginButton;
	}
}
