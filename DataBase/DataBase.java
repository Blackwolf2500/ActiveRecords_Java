package proyect.DataBase;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {

    // VARIABLES
    String db;
    String url = "jdbc:mysql://localhost:3306/"; // Ruta de tu base de datos
    String user = "root";
    String pass = "root";
    String Driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;

    // CONSTRUCTOR
    public DataBase(String db){ this.db = db; }

    public Connection connectOn(){
        try {
            Class.forName(Driver);
            cx = DriverManager.getConnection(url+db, user, pass);
            //System.out.println("DataBase Connect");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("DataBase Not Connect");
        }
        return cx;
    }

    public void quest_ID(String query){
        try {
            PreparedStatement quest = this.connectOn().prepareStatement(query);
            quest.executeUpdate();

            this.connectOff();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String quest(String query, String[] atributos) {
        String resultado = "";
        try {
            ResultSet result = this.connectOn().createStatement().executeQuery(query);
            String header[] = atributos;
            String data[] = new String[atributos.length];
            while (result.next()){
                for(String dato : header) {
                    for (int i = 0; i < 1; i++) {
                        data[i] = result.getString(dato);
                        resultado = resultado + "," + data[i];
                    }
                }
                resultado = resultado + "\n";
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public void connectOff(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
