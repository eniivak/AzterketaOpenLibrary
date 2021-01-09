package ehu.isad.controllers.db;

import ehu.isad.model.Liburua;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LiburuaKud {
    private static LiburuaKud instantzia= null;
    private  LiburuaKud() {}
    public static LiburuaKud getInstantzia(){
        if(instantzia==null){
            instantzia=new LiburuaKud();
        }
        return instantzia;
    }

    public ObservableList<Liburua> lortuLiburuak(String isbn) throws SQLException {
        String query= "SELECT * FROM liburuak where isbn=" +isbn;
        DbKudSqlite dbkud= DbKudSqlite.getInstantzia();
        ResultSet rs= dbkud.execSQL(query);
        String egilea,data,izenburu,filename;
        ObservableList<Liburua> emaitza= FXCollections.observableArrayList();
        Liburua lib= new Liburua();
        while(rs.next()){
            egilea=rs.getString("egilea");
            data= rs.getString("data");
            izenburu= rs.getString("izenburua");
            filename= rs.getString("filename");
           // lib.setAuthors(egilea);
            lib.setIsbn(isbn);
            lib.setPublish_date(data);
            lib.setTitle(izenburu);
            lib.setThumbnail_url(filename);
            emaitza.add(lib);
        }
        return emaitza;
    }


    public ObservableList<Liburua> lortuLiburuakDB() throws SQLException {
        String query= "SELECT * FROM liburuak";
        DbKudSqlite dbkud= DbKudSqlite.getInstantzia();
        ResultSet rs= dbkud.execSQL(query);
        String isbn,egilea,data,izenburu,filename;
        ObservableList<Liburua> emaitza= FXCollections.observableArrayList();

        while(rs.next()){
            Liburua lib= new Liburua();
            isbn= rs.getString("isbn");
            egilea=rs.getString("egilea");
            data= rs.getString("data");
            izenburu= rs.getString("izenburua");
            filename= rs.getString("filename");
            // lib.setAuthors(egilea);
            lib.setIsbn(isbn);
            lib.setPublish_date(data);
            lib.setTitle(izenburu);
            lib.setThumbnail_url(filename);
            emaitza.add(lib);
        }
        return emaitza;
    }


}
