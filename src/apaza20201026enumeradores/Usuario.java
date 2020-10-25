package apaza20201026enumeradores;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Usuario {
//tengo problema con los caracteres " \
    private String charEspecial = "|°¬!#$%&/()=?¡¿@*+~[{^]}`-_;,:.0123456789";
    private String nombre = "", apellido = "", mail = "";
    private int edad, añoNacimiento = 0, mesNacimiento = 0, diaNacimiento = 0;

    LocalDate fechaActual = LocalDate.now();
    DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String fechaCreacion = fechaActual.format(formatoFecha), fechaNacimiento = "";
//Aca separo la fecha en 3 datos
    DateTimeFormatter formatoAño = DateTimeFormatter.ofPattern("yyyy");
    DateTimeFormatter formatoMes = DateTimeFormatter.ofPattern("MM");
    DateTimeFormatter formatoDia = DateTimeFormatter.ofPattern("dd");
//Aca convierto de String a entero
    int añoActual = Integer.parseInt(fechaActual.format(formatoAño));
    int mesActual = Integer.parseInt(fechaActual.format(formatoMes));
    int diaActual = Integer.parseInt(fechaActual.format(formatoDia));
//La persona mas longeva en el mundo vivio hasta 122 años y algunos dias, por eso considero como tope 123 años atras del año actual
    int añoMinimo = Integer.parseInt(fechaActual.minusYears(123).format(formatoAño)); //esto da 1897
    
//El constructor no me deja poner como paremetro al enumerador rol
    /*public Usuario(String nombre, String apellido, String mail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        //this.fechaNac = fechaNac;
        //this.fechaCreacion = fechaCreacion;
        //this.edad = edad;
    }*/
    
//Aca esta los setter de cada atributo de esta clase pero no esta la de rol
//Setter---------------------------------------------------------------------------------------------------------------------------------
    public boolean setNombre(String nombre) {
/*con el for anidado voy comparando cada elemento del string nombre con cada elemento del string charEspecial para saber si la cadena de caracteres
no tiene alguno de los caracteres que no deberian aparecer en un nombre*/
        if(nombre.length() < 3 || nombre.length() > 30){
            return false;
        }
        for(int i = 0; i < nombre.length(); i++){
            for(int j = 0; j < charEspecial.length(); j++){
                if(nombre.charAt(i) == charEspecial.charAt(j)){
                    return false;
                }
            }
        }
        this.nombre = nombre;
        return true;
    }
    
    public boolean setApellido(String apellido) {
        if(apellido.length() < 3 || apellido.length() > 30){
            return false;
        }
        for(int i = 0; i < apellido.length(); i++){
            for(int j = 0; j < charEspecial.length(); j++){
                if(apellido.charAt(i) == charEspecial.charAt(j)){
                    return false;
                }
            }
        }
        this.apellido = apellido;
        return true;
    }
    
    public void setMail(String mail) {
/*Con el metodo .indexOf('@', 0) se busca en toda una cadena el caracter @ y empezara a buscar por la posicion cero, en caso se encontrarlo retornara
la posicion (un num entero) donde se ubica el @, en caso de no encontrarlo entonces retornar -1*/
        if(mail.indexOf('@', 0) != -1){
            this.mail = mail;
        }
    }
    
    public void setAñoNacimiento(int añoNacimiento) {
        if(añoNacimiento >= añoMinimo && añoNacimiento <= añoActual){
            this.añoNacimiento = añoNacimiento;
        }
    }

    public void setMesNacimiento(int mesNacimiento) {
        if(mesNacimiento >= 1 && mesNacimiento <= 12){
            this.mesNacimiento = mesNacimiento;
        }
    }

    public void setDiaNacimiento(int diaNacimiento) {
        switch (getMesNacimiento()){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if(diaNacimiento >= 1 && diaNacimiento <=31){
                    this.diaNacimiento = diaNacimiento;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if(diaNacimiento >= 1 && diaNacimiento <=30){
                    this.diaNacimiento = diaNacimiento;
                }
                break;
            case 2:
//Condicion para averiguar si es año bisiesto o no
                if((getAñoNacimiento()%4 == 0 && (getAñoNacimiento()%100 != 0 || getAñoNacimiento()%400 ==0)) && (diaNacimiento >= 1 && diaNacimiento <=29)){
                    this.diaNacimiento = diaNacimiento;
                }else if(diaNacimiento >= 1 && diaNacimiento <=28){
                    this.diaNacimiento = diaNacimiento;
                }
                break;
        }
    }
//Getter--------------------------------------------------------------------------------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getMail() {
        return mail;
    }
    
    public int getAñoNacimiento() {
        return añoNacimiento;
    }
    
    public int getMesNacimiento() {
        return mesNacimiento;
    }
    
    public int getDiaNacimiento() {
        return diaNacimiento;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public String getFechaNacimiento() {
        LocalDate objFecha = LocalDate.of(añoNacimiento, mesNacimiento, diaNacimiento);
        fechaNacimiento = objFecha.format(formatoFecha);
        return fechaNacimiento;
    }

    public int getEdad() {
        edad = ((añoActual*10000 + mesActual*100 + diaActual) - (getAñoNacimiento()*10000 + getMesNacimiento()*100 + getDiaNacimiento()))/10000;
        return edad;
    }
//Metodos---------------------------------------------------------------------------------------------------------------------------------
    public int validarNombre(String nombre){
        if(getNombre().equals(nombre)){
            return 1;
        }
        return 0;   //es lo mismo si le mando else{return 0;}
    }
    
    public int validarApellido(String apellido){
        if(getApellido().equals(apellido)){
            return 1;
        }
        return 0;
    }
    
    public int validarMail(String mail){
        if(getMail().equals(mail)){
            return 1;
        }
        return 0;
    }
    
    public int validarAño(int añoNacimiento){
        if(getAñoNacimiento() != 0 && getAñoNacimiento() == añoNacimiento){
            return 1;
        }
        return 0;
    }
    
    public int validarMes(int mesNacimiento){
        if(getMesNacimiento() != 0 && getMesNacimiento() == mesNacimiento){
            return 1;
        }
        return 0;
    }
    
    public int validarDia(int diaNacimiento){
        if(getDiaNacimiento() != 0 && getDiaNacimiento() == diaNacimiento){
            return 1;
        }
        return 0;
    }
}
