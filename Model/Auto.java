package proyect.Model;

public class Auto extends ActiveRecords{
    // VARIABLES
    private int id;
    private String marca;
    private String modelo;
    private int propietarioId;

    // getValues
    @Override
    public String getValues(){
        String txt = "'"+ this.marca + "','" + this.modelo + "','" + this.propietarioId + "'";
        return txt;
    }

    @Override
    public String[] desArreglo(String[] str){
        String[] pro = { str[1], str[2], str[3], str[4] };
        return pro;
    }

    // CONSTRUCTOR
    public Auto(){
        this.tabla = "autos";
        this.columnasDB = new String[]{"id", "modelo", "marca", "propietarioId"};
    }
    public Auto(int id, String marca, String modelo, int propietarioId){
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.propietarioId = propietarioId;
        this.tabla = "autos";
        this.columnasDB = new String[]{"id", "modelo", "marca", "propietarioId"};
    }

    // GET's
    public int getId(){ return this.id; }
    public String getMarca() { return this.marca; }
    public String getModelo() { return this.modelo; }
    public int getPropietarioId() { return this.propietarioId; }

    // SET's
    public void setId(int id) { this.id = id; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setPropietarioId(int propietarioId) { this.propietarioId = propietarioId; }

}
