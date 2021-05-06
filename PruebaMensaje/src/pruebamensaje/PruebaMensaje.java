/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebamensaje;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 *
 * @author jm_al
 */
public class PruebaMensaje {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        Integer opcion= 0;
        Integer unidad =0;
        String mensaje;
        while (opcion != 2 ) {
            menu();
            opcion= Integer.parseInt(scann.nextLine());
            if (opcion == 1) {
                menuUnidad();
                unidad = Integer.parseInt(scann.nextLine());
                if (unidad == 1) {
                    System.out.println("Digite el mensaje");
                    mensaje= scann.nextLine();
                    String codigo=CodificarMorse(mensaje);
                    System.out.println("Mensaje codificado exitosamente ");
                    System.out.println(codigo);
                } else if (unidad == 2) {
                    System.out.println("Digite el mensaje");
                    mensaje = scann.nextLine();
                    String codigo = codificarOctal(mensaje);
                    System.out.println("mensaje codificado exitosamente");
                    System.out.println(codigo);
                } else if(unidad == 3) {
                    System.out.println("Digite el mensaje");
                    mensaje = scann.nextLine();
                    String codigo = codificarBACEDIFOGU(mensaje);
                    System.out.println("mensaje codificado exitosamente");
                    System.out.println(codigo);
                }
            } else if (opcion ==2) {
                System.out.println("Programa terminado");
            } else {
                System.out.println("Por favor digite una opcion valida");
               // System.console().flush();
                menu();
                opcion = Integer.parseInt(scann.nextLine());
            }

        }
    }

    public static void menu() {
        System.out.println("*******************************************");
        System.out.println("Por favor escoja que accion realizar");
        System.out.println("1- Enviar mensaje");
        System.out.println("2- Salir");
        
    }    
    
    public static void menuUnidad() {
        System.out.println("*******************************************");
        System.out.println("Por favor digite su unidad");
        System.out.println("1- Unidad Medica");
        System.out.println("2- Unidad de infanteria");
        System.out.println("3- Unidad Aerea ");
    }
    
    public static String CodificarMorse(String mensaje) {
    Hashtable<String, String> equivalencias = new Hashtable<>();
    String mensajeCodificado = "";
    equivalencias.put("A", ".-");
    equivalencias.put("B", "-...");
    equivalencias.put("C", "-.-.");
    equivalencias.put("CH", "----");
    equivalencias.put("D", "-..");
    equivalencias.put("E", ".");
    equivalencias.put("F", "..-.");
    equivalencias.put("G", "--.");
    equivalencias.put("H", "....");
    equivalencias.put("I", "..");
    equivalencias.put("J", ".---");
    equivalencias.put("K", "-.-");
    equivalencias.put("L", ".-..");
    equivalencias.put("M", "--");
    equivalencias.put("N", "-.");
    equivalencias.put("Ñ", "--.--");
    equivalencias.put("O", "---");
    equivalencias.put("P", ".--.");
    equivalencias.put("Q", "--.-");
    equivalencias.put("R", ".-.");
    equivalencias.put("S", "...");
    equivalencias.put("T", "-");
    equivalencias.put("U", "..-");
    equivalencias.put("V", "...-");
    equivalencias.put("W", ".--");
    equivalencias.put("X", "-..-");
    equivalencias.put("Y", "-.--");
    equivalencias.put("Z", "--..");
    equivalencias.put("0", "-----");
    equivalencias.put("1", ".----");
    equivalencias.put("2", "..---");
    equivalencias.put("3", "...--");
    equivalencias.put("4", "....-");
    equivalencias.put("5", ".....");
    equivalencias.put("6", "-....");
    equivalencias.put("7", "--...");
    equivalencias.put("8", "---..");
    equivalencias.put("9", "----.");
    equivalencias.put(".", ".-.-.-");
    equivalencias.put(",", "--..--");
    equivalencias.put(":", "---...");
    equivalencias.put("?", "..--..");
    equivalencias.put("'", ".----.");
    equivalencias.put("-", "-....-");
    equivalencias.put("/", "-..-.");
    equivalencias.put("\"", ".-..-.");
    equivalencias.put("@", ".--.-.");
    equivalencias.put("=", "-...-");
    equivalencias.put("!", "−.−.−−");
        for (int i = 0; i < mensaje.length(); i++) {
          char letra   = mensaje.toUpperCase().charAt(i);
           mensajeCodificado += equivalencias.get(String.valueOf(letra));
         }    

    return mensajeCodificado;
}
    
    public static String codificarOctal(String mensaje) {
        String mensajeCodificado= "";
        mensajeCodificado= mensaje.chars().boxed().map(Integer::toOctalString).collect(Collectors.joining(" "));
        return mensajeCodificado;
    }
    
    public static String codificarBACEDIFOGU(String mensaje) {
        Hashtable<String, String> equivalencias = new Hashtable<>();
        String mensajeCodificado = "";
        equivalencias.put("B", "0");
        equivalencias.put("A", "1");
        equivalencias.put("C", "2");
        equivalencias.put("E", "3");
        equivalencias.put("D", "4");
        equivalencias.put("I", "5");
        equivalencias.put("F", "6");
        equivalencias.put("O", "7");
        equivalencias.put("G", "8");
        equivalencias.put("U" ,"9");
        for (int i = 0; i < mensaje.length(); i++) {
            char letra = mensaje.toUpperCase().charAt(i);
            System.out.println(equivalencias.get(String.valueOf(letra)));
            if (equivalencias.get(String.valueOf(letra)) == null) {
                mensajeCodificado += mensaje.charAt(i);
            } else {                
                mensajeCodificado += equivalencias.get(String.valueOf(letra));
            }
        }
        return mensajeCodificado;
    }
    
}
