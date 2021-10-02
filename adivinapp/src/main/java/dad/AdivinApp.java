package dad;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {

  private TextField numeroText;
  private Label textoLabel;
  private Button botonAceptar;

  @Override
    public void start(Stage primaryStage) throws Exception {

      numeroText = new TextField();

      textoLabel = new Label();

      botonAceptar = new Button();
      botonAceptar.setText("Aceptar");

      VBox root = new VBox(5,numeroText,textoLabel,botonAceptar);
      root.setAlignment(Pos.CENTER);
      root.setFillWidth(false);

      Scene scene = new Scene(root,320,200);

      primaryStage.setTitle("Adivina el numero");
      primaryStage.setScene(scene);
      primaryStage.show();
      

   }

  public static void main(String[] args) {
    launch(args);
  }
}