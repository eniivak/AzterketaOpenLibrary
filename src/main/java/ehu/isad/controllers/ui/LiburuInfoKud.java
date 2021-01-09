package ehu.isad.controllers.ui;

import ehu.isad.App;
import ehu.isad.controllers.db.LiburuaKud;
import ehu.isad.model.Liburua;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.sql.SQLException;
import java.util.List;

public class LiburuInfoKud {
    private App app;
    private ObservableList<Liburua> lista=FXCollections.observableArrayList();
    private int indize;
    @FXML
    private ImageView idImage;

    @FXML
    private TextField idIzenbText;

    @FXML
    private TextField idEgileText;

    @FXML
    private TextField idUrteaText;

    @FXML
    private TextField idISBNTex;

    @FXML
    private Label idIzenbLab;

    @FXML
    private Label idEgileLab;

    @FXML
    private Label idUrteaLab;

    @FXML
    private Label idISBNLab;

    @FXML
    private Button idBilatu;

    @FXML
    private Button idAurrera;

    @FXML
    private Button idAtzera;

    @FXML
    void atzeraOnClick(ActionEvent event) {
        if(indize>0){
             indize--;
            erakutsiLiburua();
        }


    }

    @FXML
    void aurreraOnClick(ActionEvent event) {
        if(indize<lista.size()){
            indize++;
            erakutsiLiburua();
        }

    }

    @FXML
    void bilatuOnClick(ActionEvent event) throws SQLException {
        bilatuLiburua();

    }

    public void setMainApp(App main) {
        this.app=main;
    }

    public void bilatuLiburua() throws SQLException {
        //String isbn = idISBNTex.getText();
        LiburuaKud lb= LiburuaKud.getInstantzia();
        ObservableList<Liburua> liburuak=FXCollections.observableArrayList();
        liburuak=lb.lortuLiburuakDB();
        setLista(liburuak);
    }

    public void erakutsiLiburua(){
        System.out.println(indize);
        idIzenbText.setText(lista.get(indize).getTitle());
        System.out.println(lista.get(indize).getTitle());
       // idEgileText.setText(lista.get(indize).getAuthors());
        idUrteaText.setText(lista.get(indize).getPublish_date());
        idISBNTex.setText(lista.get(indize).getIsbn());
    }

    public void setLista(List<Liburua> plista) {
        lista = FXCollections.observableArrayList();
        lista.addAll(plista);

    }
    @FXML
    void initialize() throws SQLException {
        bilatuLiburua();
        erakutsiLiburua();
        indize=0;
    }
}
