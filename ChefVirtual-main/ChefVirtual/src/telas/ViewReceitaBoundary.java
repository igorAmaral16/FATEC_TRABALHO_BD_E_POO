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

public class ViewReceitaBoundary extends Application {
	private Button btnv = new Button("Voltar");
	
	ViewReceitaControl c = new ViewReceitaControl();
	private static Stage stage;

	
	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		Scene scn = new Scene(root, 1000, 650, Color.DARKGRAY);
		Image img = new Image("imgs/chef1-2-removebg-preview.png");
		
		background(root);
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
		ViewReceitaBoundary.stage = stage;
	}

	private void action(Group root) {
		btnv.setOnAction(e -> {
			c.voltar();
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

		btnv.setLayoutX(450);
		btnv.setLayoutY(150);
		btnv.setPrefHeight(50);
		btnv.setPrefWidth(390);
		btnv.setTextFill(Color.WHITE);
		btnv.setStyle("-fx-background-color: brown;");
		root.getChildren().add(btnv);
	
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
