package telas;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReceitaBoundary extends Application {
	private TextField txtnomerec = new TextField();
	private TextField txtdesc = new TextField();
	private Button btnadd = new Button("ADICONAR");
	private Button btnedit = new Button("EDITAR");
	private Button btnex = new Button("EXCLUIR");
	private Button btnpes = new Button("PESQUISAR");
	ReceitaControl rc = new ReceitaControl();
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
		stage.setTitle("CADASTRO DE RECEITAS");
		setStage(stage);
		
		

		ListView<Receita> listarec = new ListView<>(rc.getLista());
		
		listarec.setLayoutX(520);
		listarec.setLayoutY(250);
		listarec.setPrefSize(270, 200);
		root.getChildren().add(listarec);
		
		

	}
	

	public static Stage getStage() {
		return stage;
	}


	public static void setStage(Stage stage) {
		ReceitaBoundary.stage = stage;
	}

	private void action(Group root) {
		btnadd.setOnAction(e -> {
			rc.adicionar();
		});
		}
		
	

	private void background(Group root) {
		Rectangle retangulo = new Rectangle(440, 80, 500, 500);
		retangulo.setArcHeight(20.0);
		retangulo.setArcWidth(20.0);
		retangulo.setFill(Color.rgb(255, 255, 255, 0.3));
		root.getChildren().add(retangulo);
		
		
		Image imgfun = new Image("imgs/chefFunc.png");
		ImageView vimg = new ImageView(imgfun);
		vimg.setFitHeight(500);
		vimg.setFitWidth(350);
		vimg.setLayoutX(100);
		vimg.setLayoutY(80);
		root.getChildren().add(vimg);
		
		Text titulo = new Text(520, 120, "CADASTRAR RECEITA");
		Font font = new Font("Arial Black", 20);
		titulo.setFont(font);
		titulo.setFill(Color.BLUE);
		root.getChildren().add(titulo);

		// sombra do titulo
		DropShadow sombra = new DropShadow(2, 0, 0, Color.GRAY);
		titulo.setEffect(sombra);
		
	}

	private void botoes(Group root) {
		Label lblt = new Label("Nome da Receita:");
		lblt.setLayoutX(520);
		lblt.setLayoutY(140);
		txtnomerec.setLayoutX(520);
		txtnomerec.setLayoutY(160);
		txtnomerec.setPrefWidth(330);
		txtnomerec.getText();
		root.getChildren().addAll(lblt, txtnomerec);
		
		Label lbld = new Label("Descrição:");
		lbld.setLayoutX(520);
		lbld.setLayoutY(190);
		txtdesc.setLayoutX(520);
		txtdesc.setLayoutY(210);
		txtdesc.setPrefWidth(330);
		txtdesc.getText();
		root.getChildren().addAll(lbld,txtdesc);
		
		btnadd.setLayoutX(800);
		btnadd.setLayoutY(300);
		btnadd.setPrefHeight(10);
		btnadd.setPrefWidth(100);
		btnadd.setTextFill(Color.WHITE);
		btnadd.setStyle("-fx-background-color:blue;");

		btnedit.setLayoutX(800);
		btnedit.setLayoutY(340);
		btnedit.setPrefHeight(10);
		btnedit.setPrefWidth(100);
		btnedit.setTextFill(Color.WHITE);
		btnedit.setStyle("-fx-background-color:blue;");

		btnex.setLayoutX(800);
		btnex.setLayoutY(380);
		btnex.setPrefHeight(10);
		btnex.setPrefWidth(100);
		btnex.setTextFill(Color.WHITE);
		btnex.setStyle("-fx-background-color:blue;");

		btnpes.setLayoutX(800);
		btnpes.setLayoutY(420);
		btnpes.setPrefHeight(10);
		btnpes.setPrefWidth(100);
		btnpes.setTextFill(Color.WHITE);
		btnpes.setStyle("-fx-background-color:blue;");
		root.getChildren().addAll(btnadd, btnedit, btnex, btnpes);

	}
	public static void main(String[] args) {
		Application.launch(args);
		
	}
}
