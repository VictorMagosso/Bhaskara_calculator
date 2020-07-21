package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import static java.lang.Float.parseFloat;

public class Controller {
   @FXML
   TextField valorA, valorB, valorC;
   @FXML
   Label valorX1, valorX2, valorDelta, erro;
   @FXML
   ImageView concavidade;

   public void calcularBhaskara(){

       if (valorA.equals("") || valorB.equals("") || valorC.equals("")){
           erro.setText("Por favor, preencha todos os campos!");
       }

        float vA = parseFloat(valorA.getText());
        float vB = parseFloat(valorB.getText());
        float vC = parseFloat(valorC.getText());


       File pathBaixo = new File("src/sample/conbaixo.png");
       File pathCima = new File("src/sample/concima.png");
       Image imageBaixo = new Image(pathBaixo.toURI().toString());
       Image imageCima = new Image(pathCima.toURI().toString());
        if (vA > 0){
            concavidade.setImage(imageCima);
        }else{
            concavidade.setImage(imageBaixo);
        }
        float vD = (float) (Math.pow(vB, 2) - (4*vA*vC));
        float x1 = ((-vB + vD)/2*vA);
        float x2 = ((-vB - vD)/2*vA);

       valorDelta.setText("Delta = " + (vD));

        if (vD < 0){
            valorX1.setText("Não possui raízes reais");
            valorX2.setText("Não possui raízes reais");
        }else {
            valorX1.setText("X¹ = " + x1);
            valorX2.setText("X² = " + x2);
        }
    }
        public void limparCampos() {
            valorA.setText("");
            valorB.setText("");
            valorC.setText("");
            valorDelta.setText("Delta = ");
            concavidade.setImage(null);
            valorX1.setText("X¹ = ");
            valorX2.setText("X² = ");
        }
    }
