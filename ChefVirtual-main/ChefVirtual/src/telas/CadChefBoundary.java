package telas;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LongStringConverter;

public class CadChefBoundary  extends Application {
	private TextField txtNome = new TextField();
	private TextField txtSobrenome = new TextField();
	private TextField txtNascimento = new TextField();
	private TextField txtEmail = new TextField();
	private PasswordField txtSenha = new PasswordField();
	private TextField txtCPF = new TextField();
	private TextField txtCertificado = new TextField();
	private Button btnCadChef = new Button("CADASTRAR");
	private Button btnCadC = new Button("CADASTRO COMUM");
	private Button btnCadRes = new Button("CADASTRO RESTAURANTE");
	private CadChefControl control = new CadChefControl();
	private static Stage stage;

	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		Scene scn = new Scene(root, 1000, 650, Color.DARKGRAY);
		Image img = new Image("imgs/chef1-2-removebg-preview.png");
		
		background(root);
		layoutItens(root);
		botoes(root);
		Action(root);

		stage.getIcons().add(img);
		stage.setScene(scn);
		stage.show();
		stage.setTitle("Cadastro CHEF");
		setStage(stage);
	}
	
	
	public static Stage getStage() {
		return stage;
	}


	public static void setStage(Stage stage) {
		CadChefBoundary.stage = stage;
	}
	

	public void  Action(Group root) {
		btnCadChef.setOnAction(e ->	control.inserir() );
		
		vincular();
		
		btnCadC.setOnAction(e -> {
			control.abrirCadastroComum();
		});
		
		btnCadRes.setOnAction(e -> {
			control.abrirCadastroRestaurante();
		});
		
	}
	
	private void background(Group root) {
		Rectangle retangulo = new Rectangle(440, 80, 400, 500);
		retangulo.setArcHeight(20.0);
		retangulo.setArcWidth(20.0);
		retangulo.setFill(Color.rgb(255, 255, 255, 0.3));
		root.getChildren().add(retangulo);
		
		Image imgCadChef = new Image("imgs/CadChef.png");
		ImageView vimg = new ImageView(imgCadChef);
		vimg.setFitHeight(500);
		vimg.setFitWidth(350);
		vimg.setLayoutX(100);
		vimg.setLayoutY(80);
		root.getChildren().add(vimg);
		
		Text titulo = new Text(530, 120, "CADASTRO CHEF");
		Font font = new Font("Arial Black", 25);
		titulo.setFont(font);
		titulo.setFill(Color.BROWN);
		root.getChildren().add(titulo);

		// sombra do titulo
		DropShadow sombra = new DropShadow(2, 0, 0, Color.GRAY);
		titulo.setEffect(sombra);
		
	}

	private void layoutItens(Group root) {
		Label lblNome = new Label("Nome:");
		lblNome.setLayoutX(480);
		lblNome.setLayoutY(150);
		txtNome.setLayoutX(480);
		txtNome.setLayoutY(170);
		root.getChildren().addAll(lblNome, txtNome);

		Label lblSobrenome = new Label("Sobrenome:");
		lblSobrenome.setLayoutX(660);
		lblSobrenome.setLayoutY(150);
		txtSobrenome.setLayoutX(660);
		txtSobrenome.setLayoutY(170);
		root.getChildren().addAll(lblSobrenome, txtSobrenome);

		Label lblNascimento = new Label("Nascimento:");
		lblNascimento.setLayoutX(480);
		lblNascimento.setLayoutY(200);
		txtNascimento.setLayoutX(480);
		txtNascimento.setLayoutY(220);
		root.getChildren().addAll(lblNascimento, txtNascimento);

		Label lblCPF = new Label("CPF:");
		lblCPF.setLayoutX(660);
		lblCPF.setLayoutY(200);
		txtCPF.setLayoutX(660);
		txtCPF.setLayoutY(220);
		root.getChildren().addAll(lblCPF, txtCPF);

		Label lblEmail = new Label("Email:");
		lblEmail.setLayoutX(480);
		lblEmail.setLayoutY(250);
		txtEmail.setLayoutX(480);
		txtEmail.setLayoutY(270);
		txtEmail.setPrefWidth(330.0);
		root.getChildren().addAll(lblEmail, txtEmail);

		Label lblSenha = new Label("Senha:");
		lblSenha.setLayoutX(480);
		lblSenha.setLayoutY(300);
		txtSenha.setLayoutX(480);
		txtSenha.setLayoutY(320);
		txtSenha.setPrefWidth(330.0);
		root.getChildren().addAll(lblSenha, txtSenha);
		
		Label lblCertificado = new Label("Certificado:");
		lblCertificado.setLayoutX(480);
		lblCertificado.setLayoutY(350);
		txtCertificado.setLayoutX(480);
		txtCertificado.setLayoutY(370);
		txtCertificado.setPrefWidth(330.0);
		root.getChildren().addAll(lblCertificado, txtCertificado);

		
		Label lblmsg = new Label("É RESTAURANTE? Se cadastre e tenha acesso exclusivo!");
		lblmsg.setLayoutX(495);
		lblmsg.setLayoutY(480);
		root.getChildren().add(lblmsg);
		
	}
	private void botoes(Group root) {

		DropShadow sombra = new DropShadow(10, 2, 4, Color.GRAY);

		RadioButton rbAceito = new RadioButton("Aceito os termos de uso");
		rbAceito.setSelected(false);
		rbAceito.setLayoutX(480);
		rbAceito.setLayoutY(400);
		root.getChildren().add(rbAceito);

		btnCadChef.setLayoutX(480);
		btnCadChef.setLayoutY(420);
		btnCadChef.setPrefWidth(330.0);
		btnCadChef.setPrefHeight(35.0);
		btnCadChef.setTextFill(Color.WHITE);
		btnCadChef.setStyle("-fx-background-color: brown;");
		btnCadChef.setEffect(sombra);
		root.getChildren().add(btnCadChef);

		btnCadC.setLayoutX(480);
		btnCadC.setLayoutY(500);
		btnCadC.setPrefHeight(35.0);
		btnCadC.setPrefWidth(150.0);
		btnCadC.setTextFill(Color.WHITE);
		btnCadC.setStyle("-fx-background-color: brown;");
		btnCadC.setEffect(sombra);
		root.getChildren().add(btnCadC);

		btnCadRes.setLayoutX(650);
		btnCadRes.setLayoutY(500);
		btnCadRes.setPrefHeight(35.0);
		btnCadRes.setPrefWidth(160.0);
		btnCadRes.setTextFill(Color.WHITE);
		btnCadRes.setStyle("-fx-background-color: brown;");
		btnCadRes.setEffect(sombra);
		root.getChildren().add(btnCadRes);

	}
	
	public void vincular() {
		
		StringConverter<? extends Number > converterNumber = new LongStringConverter();
		
		Bindings.bindBidirectional(txtCPF.textProperty(), control.cpfProperty(), (StringConverter)converterNumber);
		Bindings.bindBidirectional(control.nomeProperty(), txtNome.textProperty());
		Bindings.bindBidirectional(control.sobrenomeProperty(), txtSobrenome.textProperty());
		Bindings.bindBidirectional(control.nascimentoProperty(), txtNascimento.textProperty());
		Bindings.bindBidirectional(control.emailProperty(), txtEmail.textProperty());
		Bindings.bindBidirectional(control.senhaProperty(), txtSenha.textProperty());
		Bindings.bindBidirectional(control.certificadoProperty(), txtCertificado.textProperty());

	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
