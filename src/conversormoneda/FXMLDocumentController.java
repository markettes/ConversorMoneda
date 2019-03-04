/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversormoneda;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Marcos
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Slider convSlider;
    @FXML
    private Label conversionText;
    @FXML
    private TextField inputField;
    @FXML
    private TextField outputField;
    
    //Vars
    DecimalFormat decFor = new DecimalFormat("#.##");
    @FXML
    private CheckBox checkV;
    @FXML
    private Button convBut;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    
        //Slider Listener
        convSlider.valueProperty().addListener((observable, oldVal, newVal) ->
        {
            if(!checkV.isSelected())
            conversionText.setText("Conversion Rate: "+ decFor.format(newVal)); 
            else {
                outputField.setText(String.valueOf(decFor.format(Double.valueOf(
                    inputField.getText()) * convSlider.getValue()
                    )));
                conversionText.setText("Conversion Rate: "+ decFor.format(newVal));

            }
        });

        //CheckBox Listener
        checkV.selectedProperty().addListener((observable, oldVal, newVal) ->
        {
            if (newVal) convBut.setDisable(true);
            else convBut.setDisable(false);
        });
    
    }

    @FXML
    private void convertAct(ActionEvent event) {
        double res;
        outputField.setText(String.valueOf(decFor.format(Double.valueOf(
                inputField.getText()) * convSlider.getValue()
        )));
    }

    

    @FXML
    private void clearAct(ActionEvent event) {
        inputField.setText("");
        outputField.setText("");
        convSlider.setValue(0.0);
    }
}
