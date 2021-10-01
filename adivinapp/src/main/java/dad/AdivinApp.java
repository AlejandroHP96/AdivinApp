import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {

  static final int INTENTOS_MAXIMOS = 10;
  private TextField campoNumero=new TextField();
  int intentosQueQuedan;
  private TextArea area=new TextArea();
  
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Adivinar el numero");
    Scene escena=crearEscena();
    primaryStage.setScene(escena);
    primaryStage.show();
  }
  private Scene crearEscena() {
    Label label=new Label("Adivina un numero 1-100: ");
    
    HBox cajaHorizontal=new HBox(label,campoNumero);
    
    Button calcular=new Button("Intentalo...");
    cajaHorizontal.setSpacing(10);
    cajaHorizontal.setAlignment(Pos.CENTER);
    
    VBox CajaVertical=new VBox(cajaHorizontal,area,calcular);
    CajaVertical.setAlignment(Pos.CENTER);
    
    Scene escena=new Scene(CajaVertical,400,300);
    
    calcular.setOnAction(n->validarNumero());
    
    return escena;
  }

  private boolean validarNumero() {
    try {
      int n=Integer.parseInt(campoNumero.getText());
      int numSecreto = (int) (Math.random()*100 + 1);
      
        for (intentosQueQuedan=INTENTOS_MAXIMOS-1 ; numSecreto!=n && intentosQueQuedan>0; 
            intentosQueQuedan--) {
         if (n < numSecreto) {
           area.appendText("\nEs menor que el numero a adivinar");
         } else {
           area.appendText("\nEs mayor que el numero a adivinar");
         }
         area.appendText("\nTe quedan "+intentosQueQuedan+" intentos");
         campoNumero.clear();
        }
        
      if (numSecreto==n) {
        area.appendText("\nLo adivinastes");
        return true;
      } else {
        area.appendText("\nNo lo adivinastes, el numero es "+numSecreto);
        return false;
      }
      
    }catch(NumberFormatException e) {
      area.appendText("\nNo es un numero");
      campoNumero.clear();
    }
    return false;
  }
}