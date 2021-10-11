package dad;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {

  private TextField numeroText;
  private Label textoLabel;
  private Button botonAceptar;
  private Alert aciertoAlert = new Alert(AlertType.INFORMATION);
  private double numeroRan = (int) (Math.random() * 100);
  private int intentos = 0;


  @Override
  public void start(Stage primaryStage) throws Exception {

    numeroText = new TextField();

    textoLabel = new Label();

    botonAceptar = new Button();
    botonAceptar.setText("Aceptar");

    VBox root = new VBox(5, numeroText, textoLabel, botonAceptar);
    root.setAlignment(Pos.CENTER);
    root.setFillWidth(false);

    Scene scene = new Scene(root, 320, 200);

    primaryStage.setTitle("Adivina el numero");
    primaryStage.setScene(scene);
    primaryStage.show();

    botonAceptar.setOnAction(e -> showWinOrLose(e));

  }

  private void showWinOrLose(ActionEvent e) {

    double num = Integer.parseInt(numeroText.getText());

    if (num <= 100 && num >= 0) {


      if (num > numeroRan) {
        ++intentos;
        aciertoAlert.setAlertType(AlertType.WARNING);
        aciertoAlert.setTitle("AdivinApp");
        aciertoAlert.setHeaderText("Has Fallado");
        aciertoAlert.setContentText("El numero es menor que " + num);

      } else if (num == numeroRan) {
        ++intentos;
        aciertoAlert.setAlertType(AlertType.CONFIRMATION);
        aciertoAlert.setTitle("AdivinApp");
        aciertoAlert.setHeaderText("Has Acertado");
        aciertoAlert.setContentText("Lo has intentando " + intentos + " vez/veces");

      } else {
        ++intentos;
        aciertoAlert.setAlertType(AlertType.WARNING);
        aciertoAlert.setTitle("AdivinApp");
        aciertoAlert.setHeaderText("Has Fallado");
        aciertoAlert.setContentText("El numero es mayor que " + num);
      }

    } else {

      aciertoAlert.setAlertType(AlertType.ERROR);
      aciertoAlert.setTitle("AdivinApp");
      aciertoAlert.setHeaderText("Error");
      aciertoAlert.setContentText("El numero introducido no esta dentro de los parametros");
    }

    aciertoAlert.showAndWait();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
