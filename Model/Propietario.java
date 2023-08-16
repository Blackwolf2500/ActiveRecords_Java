package proyect.Model;

public class Propietario extends ActiveRecords {

    // VARIABLES
    private int id;
    private String nombre;
    private String apellido;

    // getValues
    @Override
    public String getValues(){
        String txt = "'"+ this.nombre + "','" + this.apellido + "'";
        return txt;
    }

    @Override
    public String[] desArreglo(String[] str){
        String pro[] = { str[1], str[2], str[3] };
        return pro;
    }


    // CONSTRUCTOR
    public Propietario(){
        this.tabla = "propietarios";
        this.columnasDB = new String[]{"id", "nombre", "apellido"};
    }
    public Propietario(int id, String nombre, String apellido){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tabla = "propietarios";
        this.columnasDB = new String[]{"id", "nombre", "apellido"};
    }

    // GET's
    public int getId(){ return this.id; }
    public String getNombre() { return this.nombre; }
    public String getApellido() { return this.apellido; }

    // SET's
    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApelldio(String apellido) { this.apellido = apellido; }

}
