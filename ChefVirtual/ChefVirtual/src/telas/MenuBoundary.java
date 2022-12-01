package telas;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuBoundary extends Application {
	private Button btnadd = new Button("ADICIONAR RECEITA");
	private Button btnfac = new Button("ENVIAR FAC");
	private Button btnconta = new Button("MINHA CONTA");
	private Button btnrec = new Button("MINHAS RECEITAS");
	MenuControl menuc = new MenuControl();
	private static Stage stage;

	
	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		Scene scn = new Scene(root, 1000, 650, Color.DARKGRAY);
		Image img = new Image("imgs/chef1-2-removebg-preview.png");
		
		background(root);
		botoes(root);
		action(root);
		
		stage.getIcons().add(img);
		stage.setScene(scn);
		stage.show();
		stage.setTitle("CHEF VIRTUAL");
		setStage(stage);
	}
	

	public static Stage getStage() {
		return stage;
	}


	public static void setStage(Stage stage) {
		MenuBoundary.stage = stage;
	}

	private void action(Group root) {
		
		btnadd.setOnAction(e -> {
			menuc.addReceita();
			
		});
		
		btnfac.setOnAction(e -> {
			menuc.enviarFac();
		});
		btnconta.setOnAction(e -> {
			menuc.minhaConta();
		});
		btnrec.setOnAction(e -> {
			menuc.minhasRec();
		});
	}

	private void background(Group root) {
		Rectangle retangulo = new Rectangle(440, 80, 400, 500);
		retangulo.setArcHeight(20.0);
		retangulo.setArcWidth(20.0);
		retangulo.setFill(Color.rgb(168, 47, 47));
		root.getChildren().add(retangulo);
		
		Image imglogin = new Image("imgs/imglogin.png");
		ImageView vimg = new ImageView(imglogin);
		vimg.setFitHeight(500);
		vimg.setFitWidth(350);
		vimg.setLayoutX(100);
		vimg.setLayoutY(80);
		root.getChildren().add(vimg);
		
		Text titulo = new Text(600, 120, "MENU");
		Font font = new Font("Arial Black", 25);
		titulo.setFont(font);
		titulo.setFill(Color.WHITESMOKE);
		root.getChildren().add(titulo);

	
	}
	private void botoes(Group root) {

		btnconta.setLayoutX(450);
		btnconta.setLayoutY(150);
		btnconta.setPrefWidth(390.0);
		btnconta.setPrefHeight(100.0);
		btnconta.setTextFill(Color.WHITE);
		btnconta.setStyle("-fx-background-color: brown; -fx-border-color:gray; -fx-border-px: 1;");
		
		btnadd.setLayoutX(450);
		btnadd.setLayoutY(250);
		btnadd.setPrefWidth(390.0);
		btnadd.setPrefHeight(100.0);
		btnadd.setTextFill(Color.WHITE);
		btnadd.setStyle("-fx-background-color: brown; -fx-border-color:gray; -fx-border-px: 1;");
		
		btnfac.setLayoutX(450);
		btnfac.setLayoutY(350);
		btnfac.setPrefWidth(390.0);
		btnfac.setPrefHeight(100.0);
		btnfac.setTextFill(Color.WHITE);
		btnfac.setStyle("-fx-background-color: brown; -fx-border-color:gray; -fx-border-px: 1;");
		
		btnrec.setLayoutX(450);
		btnrec.setLayoutY(450);
		btnrec.setPrefWidth(390.0);
		btnrec.setPrefHeight(100.0);
		btnrec.setTextFill(Color.WHITE);
		btnrec.setStyle("-fx-background-color: brown; -fx-border-color:gray; -fx-border-px: 1;");

		root.getChildren().addAll(btnconta, btnadd, btnfac, btnrec);


	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
