package apaza20201026enumeradores;
import java.util.Scanner;
public class Apaza20201026Enumeradores {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nombre = "", apellido = "", mail = "", tipoUsuario;
        int añoNac, mesNac, diaNac;
        Usuario u1 = new Usuario();
        
        System.out.println("******************* Ingrese sus datos *******************");
        System.out.print("Tipo de usuario (Administrador o Usuario): ");
        tipoUsuario = input.nextLine();
        try{
        rol tipoPersona = rol.valueOf(tipoUsuario.toUpperCase());
        System.out.println("Rol: " + tipoPersona.getTipo());
        }
        catch(Exception e){
            System.out.println("ERROR");
        }
        
        System.out.print("\nNombre (entre 3 y 30 caracteres): ");
        nombre = input.nextLine().toLowerCase();    //input.next no me toma los espacios
        u1.setNombre(nombre);
        while(u1.validarNombre(nombre) == 0){
            System.out.print("Caracter incorrecto en el campo Nombre, escriba de nuevo su nombre: ");
            nombre = input.nextLine().toLowerCase();
            u1.setNombre(nombre);
        }
        
        System.out.print("Apellido (entre 3 y 30 caracteres): ");
        apellido = input.nextLine().toLowerCase();
        u1.setApellido(apellido);
        while(u1.validarApellido(apellido) == 0){
            System.out.print("Caracter incorrecto en el campo Apellido, escriba de nuevo su apellido: ");
            apellido = input.nextLine().toLowerCase();
            u1.setApellido(apellido);
        }

        System.out.print("E-mail: ");
        mail = input.nextLine();
        u1.setMail(mail);
        while(u1.validarMail(mail) == 0){
            System.out.print("Falta el @ en el campo E-mail o la cantidad de caracteres esta fuera del limite, ingrese de nuevo el e-mail: ");
            mail = input.nextLine();
            u1.setMail(mail);
        }

        System.out.println("> Fecha de Nacimiento (Digite numeros enteros positivos)");
        System.out.print("Año: ");
        añoNac = input.nextInt();
        u1.setAñoNacimiento(añoNac);
        while(u1.validarAño(añoNac) == 0){
            System.out.print("Año INCORRECTO, ingrese otra vez el año de nacimiento: ");
            añoNac = input.nextInt();
            u1.setAñoNacimiento(añoNac);
        }
        
        System.out.print("Mes: ");
        mesNac = input.nextInt();
        u1.setMesNacimiento(mesNac);
        while(u1.validarMes(mesNac) == 0){
            System.out.print("Mes INCORRECTO, ingrese otra vez el mes de nacimiento: ");
            mesNac = input.nextInt();
            u1.setMesNacimiento(mesNac);
        }
        
        System.out.print("Dia: ");
        diaNac = input.nextInt();
        u1.setDiaNacimiento(diaNac);
        while(u1.validarDia(diaNac) == 0){
            System.out.print("Dia INCORRECTO, ingrese otra vez el dia de nacimiento: ");
            diaNac = input.nextInt();
            u1.setDiaNacimiento(diaNac);
        }
  
        System.out.println("\nDATOS INGRESADOS");
        System.out.println("Nombre: " + u1.getNombre()); //No me imprime bien las letras con tilde
        System.out.println("Apellido: " + u1.getApellido());
        System.out.println("E-mail: " + u1.getMail());
        System.out.println("Fecha de creacion: " + u1.getFechaCreacion());
        System.out.println("Fecha de nacimiento: " + u1.getFechaNacimiento());
        System.out.println("Edad: " + u1.getEdad() + " años");
        //System.out.println("Rol: " + tipoPersona.getTipo());
    }
}

