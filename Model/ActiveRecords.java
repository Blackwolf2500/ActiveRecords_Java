package proyect.Model;

import proyect.DataBase.DataBase;

public class ActiveRecords {

    // CONECTOR
    protected String tabla = null;
    protected String[ ] columnasDB = {};
    private String db = "DATABASE_NAME"; // Declarar nombre de la Base de datos a conectarse
    protected DataBase DB = new DataBase(db);

    // getValues
    public String getValues(){ return null; }

    public String[] desArreglo(String[] str){ return null; }

    // Atributos Sin ID
    public String getAtributos(){
        String txt = "";
        for(String columnas: this.columnasDB){
            txt = txt + columnas + ", ";
        }
        txt = txt.substring(0, txt.length() -2);
        txt = txt.substring(4, txt.length());

        return txt;
    }

    // Atributos Con ID
    public String getAtributosAll(){
        String txt = "";
        for(String columnas: this.columnasDB){
            txt = txt + columnas + ", ";
        }
        txt = txt.substring(0, txt.length() -2);

        return txt;
    }

    // Insert a base de datos
    public void queryInsert(){
        String query = "INSERT INTO "+ this.tabla +"("+ this.getAtributos() + ") VALUES ("+ this.getValues() +");";
        DB.quest_ID(query);
    }

    // Actualizar a base de datos
    public void queryUpdate(String args){
        String query = "UPDATE "+ this.tabla +" SET ";
        for (int i = 1; i < this.columnasDB.length; i++){
            query = query + this.columnasDB[i] +" = " + this.getValues().split(",")[i-1]+", ";
            if(i == this.columnasDB.length -1){
                query = query.substring(0, query.length() -2);
            }
        }
        query = query + " WHERE id = '"+ args + "';";
        DB.quest_ID(query);
    }

    // Borrar dato de tabla
    public void queryDelete(String id){
        String query = " DELETE FROM "+ this.tabla +" WHERE id = '"+ id + "';";
        DB.quest_ID(query);
    }

    // Extrae el contenido de una tabla
    public Object querySelect(){
        String query = "SELECT * FROM "+ this.tabla +" LIMIT 1;";
        return  this.desArreglo(DB.quest(query, this.columnasDB).split(","));
    }

    // Extrae el contenido solicitado
    public String[] where(String columna, String valor){
        String query = "SELECT * FROM "+ this.tabla +" WHERE " + columna +"='" + valor + "' LIMIT 1;";
        return this.desArreglo(DB.quest(query, this.columnasDB).split(","));
    }

}
