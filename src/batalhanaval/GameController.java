package projetoihc;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.Random;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameController implements Initializable{
    public void generate_tab_inimigo(){
    
            int tab_en = randInt.nextInt(3);
            
            if (tab_en == 0){
                posicao_barcos_inimigo.add(11);

                posicao_barcos_inimigo.add(21);
                posicao_barcos_inimigo.add(22);

                posicao_barcos_inimigo.add(41);
                posicao_barcos_inimigo.add(42);
                posicao_barcos_inimigo.add(43);

                posicao_barcos_inimigo.add(31);
                posicao_barcos_inimigo.add(32);
                posicao_barcos_inimigo.add(33);
                posicao_barcos_inimigo.add(34);
            }else if(tab_en == 1){
                posicao_barcos_inimigo.add(55);

                posicao_barcos_inimigo.add(21);
                posicao_barcos_inimigo.add(31);

                posicao_barcos_inimigo.add(43);
                posicao_barcos_inimigo.add(44);
                posicao_barcos_inimigo.add(45);

                posicao_barcos_inimigo.add(19);
                posicao_barcos_inimigo.add(29);
                posicao_barcos_inimigo.add(39);
                posicao_barcos_inimigo.add(49);
            }else if(tab_en == 3){
                posicao_barcos_inimigo.add(66);

                posicao_barcos_inimigo.add(64);
                posicao_barcos_inimigo.add(74);

                posicao_barcos_inimigo.add(22);
                posicao_barcos_inimigo.add(21);
                posicao_barcos_inimigo.add(23);

                posicao_barcos_inimigo.add(13);
                posicao_barcos_inimigo.add(14);
                posicao_barcos_inimigo.add(15);
                posicao_barcos_inimigo.add(16);
            }
            
            
    }
           
    
    public ArrayList<Integer> boats_marked(Set<Integer> pos){
        Set<Integer> map = new HashSet<Integer>(pos);
        int num_boats = map.size();
        ArrayList<Integer> b = new ArrayList<Integer>();

        for(int i = 4; i > 0; i--){
            Boolean aa = false;

            for(int j = 0; j < 90; j += 10){
                if(aa) break;
                for(int k = 1; k < 9 - i; k++){
                    if (map.contains(j + k)){
                        int l;
                        for (l = 1; l < i; l++)
                            if (!map.contains(j + k + l)) break;
                        
                        if (l == i){
                            aa = true;
                            b.add(l);
                            for (l = 0; l < i; l++)
                                map.remove(j + k + l);
                        }
                    }
                }
            }

            if (aa) continue;

            for(int j = 1; j < 9; j += 1){
                if (aa) break;
                for(int k = 0; k < 90 - i * 10; k += 10){
                    if (map.contains(j + k)){
                        int l;
                        for (l = 10; l < i * 10; l += 10)
                            if (!map.contains(j + k + l)) break;
                        
                        if (l == i * 10){
                            aa = true;
                            b.add(l / 10);
                            for (l = 0; l < i * 10; l += 10)
                                map.remove(j + k + l);
                        }
                    }
                }
            }

        }

        return b;
    }
    
    
    HashMap<String, String> create_tabuleiro_aliado(){
        HashMap<String, String> aux = new HashMap<String, String>();
        aux.put("a1a", "1");  aux.put("a2a", "2"); aux.put("a3a", "3"); aux.put("a4a", "4"); aux.put("a5a", "5"); aux.put("a6a", "6"); aux.put("a7a", "7"); aux.put("a8a", "8");
        aux.put("a1b", "11"); aux.put("a2b", "12"); aux.put("a3b", "13"); aux.put("a4b", "14"); aux.put("a5b", "15"); aux.put("a6b", "16"); aux.put("a7b", "17"); aux.put("a8b", "18");
        aux.put("a1c", "21"); aux.put("a2c", "22"); aux.put("a3c", "23"); aux.put("a4c", "24"); aux.put("a5c", "25"); aux.put("a6c", "26"); aux.put("a7c", "27"); aux.put("a8c", "28");
        aux.put("a1d", "31"); aux.put("a2d", "32"); aux.put("a3d", "33"); aux.put("a4d", "34"); aux.put("a5d", "35"); aux.put("a6d", "36"); aux.put("a7d", "37"); aux.put("a8d", "38");
        aux.put("a1e", "41"); aux.put("a2e", "42"); aux.put("a3e", "43"); aux.put("a4e", "44"); aux.put("a5e", "45"); aux.put("a6e", "46"); aux.put("a7e", "47"); aux.put("a8e", "48");
        aux.put("a1f", "51"); aux.put("a2f", "52"); aux.put("a3f", "53"); aux.put("a4f", "54"); aux.put("a5f", "55"); aux.put("a6f", "56"); aux.put("a7f", "57"); aux.put("a8f", "58");
        aux.put("a1g", "61"); aux.put("a2g", "62"); aux.put("a3g", "63"); aux.put("a4g", "64"); aux.put("a5g", "65"); aux.put("a6g", "66"); aux.put("a7g", "67"); aux.put("a8g", "68");
        aux.put("a1h", "71"); aux.put("a2h", "72"); aux.put("a3h", "73"); aux.put("a4h", "74"); aux.put("a5h", "75"); aux.put("a6h", "76"); aux.put("a7h", "77"); aux.put("a8h", "78");
        return aux;
    }
    
    HashMap<String, String> create_tabuleiro_enimigo(){
        HashMap<String, String> aux = new HashMap<String, String>();
        aux.put("b1a", "1");  aux.put("b2a", "2"); aux.put("b3a", "3"); aux.put("b4a", "4"); aux.put("b5a", "5"); aux.put("b6a", "6"); aux.put("b7a", "7"); aux.put("b8a", "8");
        aux.put("b1b", "11"); aux.put("b2b", "12"); aux.put("b3b", "13"); aux.put("b4b", "14"); aux.put("b5b", "15"); aux.put("b6b", "16"); aux.put("b7b", "17"); aux.put("b8b", "18");
        aux.put("b1c", "21"); aux.put("b2c", "22"); aux.put("b3c", "23"); aux.put("b4c", "24"); aux.put("b5c", "25"); aux.put("b6c", "26"); aux.put("b7c", "27"); aux.put("b8c", "28");
        aux.put("b1d", "31"); aux.put("b2d", "32"); aux.put("b3d", "33"); aux.put("b4d", "34"); aux.put("b5d", "35"); aux.put("b6d", "36"); aux.put("b7d", "37"); aux.put("b8d", "38");
        aux.put("b1e", "41"); aux.put("b2e", "42"); aux.put("b3e", "43"); aux.put("b4e", "44"); aux.put("b5e", "45"); aux.put("b6e", "46"); aux.put("b7e", "47"); aux.put("b8e", "48");
        aux.put("b1f", "51"); aux.put("b2f", "52"); aux.put("b3f", "53"); aux.put("b4f", "54"); aux.put("b5f", "55"); aux.put("b6f", "56"); aux.put("b7f", "57"); aux.put("b8f", "58");
        aux.put("b1g", "61"); aux.put("b2g", "62"); aux.put("b3g", "63"); aux.put("b4g", "64"); aux.put("b5g", "65"); aux.put("b6g", "66"); aux.put("b7g", "67"); aux.put("b8g", "68");
        aux.put("b1h", "71"); aux.put("b2h", "72"); aux.put("b3h", "73"); aux.put("b4h", "74"); aux.put("b5h", "75"); aux.put("b6h", "76"); aux.put("b7h", "77"); aux.put("b8h", "78");
        return aux;
    }
    
    HashSet<Integer> create_available(){
        HashSet<Integer> aux = new HashSet<Integer>();
        for(int i = 0; i < 64; i++){
            aux.add(i);
        }
        return aux;
    }
    
    ArrayList<Button> create_array_aliado(){
        ArrayList<Button> aux = new ArrayList<Button>();
        aux.add(a1a); aux.add(a2a); aux.add(a3a); aux.add(a4a); aux.add(a5a); aux.add(a6a); aux.add(a7a); aux.add(a8a);
        aux.add(a1b); aux.add(a2b); aux.add(a3b); aux.add(a4b); aux.add(a5b); aux.add(a6b); aux.add(a7b); aux.add(a8b);
        aux.add(a1c); aux.add(a2c); aux.add(a3c); aux.add(a4c); aux.add(a5c); aux.add(a6c); aux.add(a7c); aux.add(a8c);
        aux.add(a1d); aux.add(a2d); aux.add(a3d); aux.add(a4d); aux.add(a5d); aux.add(a6d); aux.add(a7d); aux.add(a8d);
        aux.add(a1e); aux.add(a2e); aux.add(a3e); aux.add(a4e); aux.add(a5e); aux.add(a6e); aux.add(a7e); aux.add(a8e);
        aux.add(a1f); aux.add(a2f); aux.add(a3f); aux.add(a4f); aux.add(a5f); aux.add(a6f); aux.add(a7f); aux.add(a8f);
        aux.add(a1g); aux.add(a2g); aux.add(a3g); aux.add(a4g); aux.add(a5g); aux.add(a6g); aux.add(a7g); aux.add(a8g);
        aux.add(a1h); aux.add(a2h); aux.add(a3h); aux.add(a4h); aux.add(a5h); aux.add(a6h); aux.add(a7h); aux.add(a8h);
        return aux;
    }
    
    ArrayList<Button> create_array_enimigo(){
        ArrayList<Button> aux = new ArrayList<Button>();
        aux.add(b1a); aux.add(b2a); aux.add(b3a); aux.add(b4a); aux.add(b5a); aux.add(b6a); aux.add(b7a); aux.add(b8a);
        aux.add(b1b); aux.add(b2b); aux.add(b3b); aux.add(b4b); aux.add(b5b); aux.add(b6b); aux.add(b7b); aux.add(b8b);
        aux.add(b1c); aux.add(b2c); aux.add(b3c); aux.add(b4c); aux.add(b5c); aux.add(b6c); aux.add(b7c); aux.add(b8c);
        aux.add(b1d); aux.add(b2d); aux.add(b3d); aux.add(b4d); aux.add(b5d); aux.add(b6d); aux.add(b7d); aux.add(b8d);
        aux.add(b1e); aux.add(b2e); aux.add(b3e); aux.add(b4e); aux.add(b5e); aux.add(b6e); aux.add(b7e); aux.add(b8e);
        aux.add(b1f); aux.add(b2f); aux.add(b3f); aux.add(b4f); aux.add(b5f); aux.add(b6f); aux.add(b7f); aux.add(b8f);
        aux.add(b1g); aux.add(b2g); aux.add(b3g); aux.add(b4g); aux.add(b5g); aux.add(b6g); aux.add(b7g); aux.add(b8g);
        aux.add(b1h); aux.add(b2h); aux.add(b3h); aux.add(b4h); aux.add(b5h); aux.add(b6h); aux.add(b7h); aux.add(b8h);
        return aux;
    }

    @FXML private Label a1boat, a2boat, a3boat, a4boat, b1boat, b2boat, b3boat, b4boat;
    @FXML private Button a1a, a2a, a3a, a4a, a5a, a6a, a7a, a8a, a1b, a2b, a3b, a4b, a5b, a6b, a7b, a8b;
    @FXML private Button a1c, a2c, a3c, a4c, a5c, a6c, a7c, a8c, a1d, a2d, a3d, a4d, a5d, a6d, a7d, a8d;
    @FXML private Button a1e, a2e, a3e, a4e, a5e, a6e, a7e, a8e, a1f, a2f, a3f, a4f, a5f, a6f, a7f, a8f;
    @FXML private Button a1g, a2g, a3g, a4g, a5g, a6g, a7g, a8g, a1h, a2h, a3h, a4h, a5h, a6h, a7h, a8h; 
    
    @FXML private Button b1a, b2a, b3a, b4a, b5a, b6a, b7a, b8a, b1b, b2b, b3b, b4b, b5b, b6b, b7b, b8b;
    @FXML private Button b1c, b2c, b3c, b4c, b5c, b6c, b7c, b8c, b1d, b2d, b3d, b4d, b5d, b6d, b7d, b8d;
    @FXML private Button b1e, b2e, b3e, b4e, b5e, b6e, b7e, b8e, b1f, b2f, b3f, b4f, b5f, b6f, b7f, b8f;
    @FXML private Button b1g, b2g, b3g, b4g, b5g, b6g, b7g, b8g, b1h, b2h, b3h, b4h, b5h, b6h, b7h, b8h; 
    
    @FXML private Button proximoButton;
    
    @FXML private ArrayList<Button> tab_aliado;
    @FXML private ArrayList<Button> tab_enimigo;
    
    
    
    private Set<Integer> available = create_available();
    private HashMap<String, String> mapa_aliado = create_tabuleiro_aliado();
    private HashMap<String, String> mapa_enimigo = create_tabuleiro_enimigo();
   
    private Set<Integer> posicao_barcos_aliados = new HashSet<Integer>();
    private Set<Integer> posicao_barcos_inimigo = new HashSet<Integer>();
    private int stage = 1;
    private Boolean can_play = true;
    private Random randInt = new Random();
    
    @FXML private Button jogarButton;
    
    @FXML public void alert(String title, String header, String context){
        Alert aux = new Alert(Alert.AlertType.INFORMATION);
    
        aux.setTitle(title);
        aux.setHeaderText(header);
        
        aux.showAndWait();
    }
    
    private int convert_hashToArray(int x){
        return (x % 10) + (8 * (x / 10)) - 1;
    }
    
    private int convert_arrayToHash(int x){
        int y = 1;
        for(int i = 0; i < x; i++){
            y += 1;
            if (y % 10 == 9) y+= 2;
        }
        return y;
    }
    
    @FXML public void tabAliado(ActionEvent event){
        Boolean start = true;
        String name = event.getSource().toString().split("[=,]+")[1];
        int pos = new Integer(mapa_aliado.get(name));
        
        if (posicao_barcos_aliados.contains(pos)){
            tab_aliado.get(convert_hashToArray(pos)).setStyle(null);
            posicao_barcos_aliados.remove(pos);
                
        }else{
            tab_aliado.get(convert_hashToArray(pos)).setStyle("-fx-background-color:black;");
            posicao_barcos_aliados.add(pos);
        }
        
        
        ArrayList<Integer> aux = boats_marked(posicao_barcos_aliados);
        if (aux.contains(1)) a1boat.setVisible(true); else {a1boat.setVisible(false); start = false;}
        if (aux.contains(2)) a2boat.setVisible(true); else {a2boat.setVisible(false); start = false;}
        if (aux.contains(3)) a3boat.setVisible(true); else {a3boat.setVisible(false); start = false;}
        if (aux.contains(4)) a4boat.setVisible(true); else {a4boat.setVisible(false); start = false;}
        
        if (start && posicao_barcos_aliados.size() == 10){
            proximoButton.setStyle("-fx-background-color:Green;");
            proximoButton.setVisible(true);
            proximoButton.setDisable(false);
        }else{
            proximoButton.setVisible(false);
            proximoButton.setDisable(true);
        }
    }
    
    @FXML public void enviaTiro(ActionEvent event){
        String name = event.getSource().toString().split("[=,]+")[1];
        int pos = new Integer(mapa_enimigo.get(name));
        
        if (can_play){
            can_play = false;
            tab_enimigo.get(convert_hashToArray(pos)).setDisable(true);
            if (posicao_barcos_inimigo.contains(pos)){   
                tab_enimigo.get(convert_hashToArray(pos)).setStyle("-fx-background-color:Green;");
                posicao_barcos_inimigo.remove(pos);
                if (posicao_barcos_inimigo.size() == 0){
                    alert("Vitória", "Ganhou :)", "");
                    try{
                        goBack();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }else{
                tab_enimigo.get(convert_hashToArray(pos)).setStyle("-fx-background-color:Red;");
            }
        }
        
        recebeTiro();

    }
    
    @FXML public void recebeTiro(){
        int pos;
        Boolean big_pp = true;
        
        proximoButton.setVisible(true);
        proximoButton.setDisable(true);

        do{
            pos = randInt.nextInt(64);
            if (available.contains(pos)){
                big_pp = false;
                available.remove(pos);
            }
        }while(big_pp);

        int converted_arrayToHash = convert_arrayToHash(pos);
        
        if (posicao_barcos_aliados.contains(converted_arrayToHash)){
            tab_aliado.get(pos).setStyle("-fx-background-color:Red;");
            posicao_barcos_aliados.remove(converted_arrayToHash);
            if (posicao_barcos_aliados.size() == 0){
                alert("Victoria", "Perdeu :(", "");
                try{
                    goBack();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }else{
            tab_aliado.get(pos).setStyle("-fx-background-color:Green;");
        }

        can_play = true;
        
    }
    
    

    @FXML public void continuarJogo(ActionEvent event){
        if (stage == 1){
            proximoButton.setVisible(true);
            stage += 1;
            for(int i = 0; i < tab_aliado.size(); i++){
                tab_aliado.get(i).setDisable(true);
            }
            
            for(int i = 0; i < tab_enimigo.size(); i++){
                tab_enimigo.get(i).setDisable(false);
            }
            
            proximoButton.setDisable(true);
            proximoButton.setVisible(false);
            
            generate_tab_inimigo();
           
            
        }
        
    }

            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tab_aliado = create_array_aliado();
        tab_enimigo = create_array_enimigo();
        
        a1boat.setVisible(false);
        a2boat.setVisible(false);
        a3boat.setVisible(false);
        a4boat.setVisible(false);
    
        proximoButton.setVisible(false);
        proximoButton.setDisable(true);
        
        for(int i = 0; i < tab_enimigo.size(); i++){
                tab_enimigo.get(i).setDisable(true);
        }
    }    
    
        
    @FXML
    public void goBack() throws IOException{
        
        Stage aux;
        Parent root;
        
        aux=(Stage)a1boat.getScene().getWindow();
        
        root=FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene=new Scene(root);
        
        aux.setScene(scene);
        aux.show();
    }
    
    
}
