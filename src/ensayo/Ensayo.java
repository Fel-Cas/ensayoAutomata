/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensayo;

import java.util.Stack;

/**
 *
 * @author andres
 */
public class Ensayo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        // TODO code application logic here
//        String hilera="(a|b)*.a.b.c.#",hilera1,hilera2;
//        hilera1="(a|b)*|(a.c)*.#";
//        hilera2="((1|0.1)*|1)+.#";//Esta hilera no la reconoce
//        ArbolSintactico n=new ArbolSintactico();
//        AutomataFD au=new AutomataFD();
//        n.crearArbol(hilera1);
//        au.enumerar(n.getRaiz());
//        System.out.println("");
//        au.anulable(n.getRaiz());
//        System.out.println("");
//        au.calcularPosiciones(n.getRaiz());
//        au.encontrarLenguaje(n.getRaiz());
//        System.out.println();
//        System.out.println(au.getLenguaje());
//        au.follows(n.getRaiz());
        String hilera = "asdfghjklñ", invertida="", hilera1="123456789";
        StringBuilder invertir = new StringBuilder(hilera);
        invertida = invertir.reverse().toString();
        //System.out.println(invertir);
        Stack pila = new Stack();
        pila.push(hilera.substring(2, 10));
        System.out.print(pila.pop()+" "+" "+hilera.length());
//        pila.push(hilera1);
////        for(int i=0; i<hilera.length();i++){
////             pila.push(hilera.charAt(i));            
////        }
//        while(!pila.empty()){
//            String hileraDeLaPila = (String) pila.pop();
//            System.out.println(hileraDeLaPila);
////            char hileraDeLaPila = (char) pila.pop();
////            System.out.print(hileraDeLaPila);
//        }
////        char hileraDeLaPila = (char) pila.pop();
////        System.out.println(hileraDeLaPila);
////        System.out.println(pila.pop());
//        //char hola = (char) pila.pop();
//        //System.out.println(hola);
////        String hola = (String) pila.pop();
////        System.out.println(hola);
    }
   
}
