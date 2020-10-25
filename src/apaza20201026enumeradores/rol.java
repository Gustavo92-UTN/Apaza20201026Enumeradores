package apaza20201026enumeradores;
public enum rol {
    ADMINISTRADOR(true),
    USUARIO (false);
    
    private boolean tipo;
    
    private rol(boolean tipo){
        this.tipo = tipo;
    }
    
    public String getTipo() {
        if(tipo){
            return "Usted es " + this.name() + " tiene permiso ilimitado";
        }else{
            return "Usted es " + this.name() +" su permiso es limitado";
        }
    }
}
