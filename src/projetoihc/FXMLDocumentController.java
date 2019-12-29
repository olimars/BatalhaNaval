/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoihc;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {
    
    @FXML private Button jogarButton;
    
    @FXML
    public void jogar(ActionEvent event) throws IOException{
        
        Stage aux;
        Parent root;
        
        aux=(Stage)jogarButton.getScene().getWindow();
        
        root=FXMLLoader.load(getClass().getResource("Game.fxml"));
        
        Scene scene=new Scene(root);
        
        aux.setScene(scene);
        aux.show();
    }
  
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
        
    
}
