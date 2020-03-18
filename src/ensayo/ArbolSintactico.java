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
public class ArbolSintactico {
     private NodoDoble raiz;
    /**
     * Este es el constructor del árbol binario
     **/
     public ArbolSintactico() {
    }
    
    public void crearArbol(String hilera){
        String auxHilera=null;
        char padre,hijo,aux;
        StringBuilder invertir=new StringBuilder(hilera);
        auxHilera=invertir.reverse().toString();
        int i=0;
        hijo=auxHilera.charAt(i);
        i++;
        padre=auxHilera.charAt(i);
        NodoDoble x=new NodoDoble(padre);
        raiz=x;
        NodoDoble y=new NodoDoble(hijo);
        x.setLd(y);
        System.out.println(hilera);
        NodoDoble p=raiz;
        if(tieneUnion(hilera)){
            dosHileras(p,auxHilera);
        }else if(soloParentesis(hilera)){
            
        }else{
            concatenacion(i,auxHilera,p);
        }
        
        
    }
    public void automataParentesis(NodoDoble padre,String hilera){
        char aux,padre1,hijo,hijo1;
        int n=hilera.length(),j=0;
        NodoDoble x,y;
        for(j=0;j<n;j++){
            aux=hilera.charAt(j);
            if(aux=='|'){
                hijo1=hilera.charAt(j-1);
                hijo=hilera.charAt(j+1);
                padre1=aux;
                x=new NodoDoble(padre1);
                padre.setLi(x);
                padre=x;
                x=new NodoDoble(hijo1);
                y=new NodoDoble(hijo);
                padre.setLd(y);
                padre.setLi(x);
                
             }
       
        }
    }
    public String inOrden(NodoDoble r){        
       String hilera="";
        if(r!=null){
            hilera= hilera+inOrden((NodoDoble)r.getLi());
            if(r.getLd()==null && r.getLi()==null){
                hilera+=r.getPosicion();
            }
            
            hilera=hilera+inOrden((NodoDoble)r.getLd());
        }
       return hilera;        
    }
    public  boolean tieneUnion(String hilera){
        boolean condicion=false;
        int n=hilera.length(),i;
        char aux;
        for(i=0;i<n;i++){ // cambiar por while(condicion==false && i<n)
            aux=hilera.charAt(i);
            if(aux=='('){
                i+=1;
                boolean bandera=true;
                while(bandera){                        
                    if(aux!=')'){
                            aux=hilera.charAt(i);
                            i+=1;
                    }else{
                        bandera=false;
                    }               
                }
            }
            if(aux=='|'){
                condicion=true;
            }
        }
        return condicion;
    }
    public int posicionUnion(String hilera){
        int pos=0;
         int n=hilera.length(),i;
        char aux;
        for(i=0;i<n;i++){
            aux=hilera.charAt(i);
            if(aux==')'){
                i+=1;
                boolean bandera=true;
                while(bandera){                        
                    if(aux!='('){
                        aux=hilera.charAt(i);
                        i+=1;
                    }else{
                        bandera=false;
                    }
                }
                aux=hilera.charAt(i);
            }
            if(aux=='|'){
                pos=i;
                return i;
            }
        }
        return pos;
    }
    public boolean soloParentesis(String hilera){
        return false;
    }
    public void dosHileras(NodoDoble padre,String auxHilera){
        NodoDoble x,y,z,w,pad;
        int pos=posicionUnion(auxHilera);
        Stack pila=new Stack();
        pila.push(auxHilera.substring(pos+1,auxHilera.length()));//lo guarda todo como String
        pila.push(auxHilera.substring(2,pos));
        x=new NodoDoble(auxHilera.charAt(pos));
        padre.setLi(x);
        padre=x;
        x=new NodoDoble(' ');
        y=new NodoDoble(' ');
        int cont=0,j=0;
        String parte;
        char aux,padre1,hijo1,hijo2;
        while(!pila.empty()){
            cont++;
            parte=(String)pila.pop(); //Al guardar todo como string, así mismo lo saca   //la hilera sigue creciendo y se evalúa desde el principio
            System.out.println(parte);
            if(cont==1){
                 padre.setLd(y);
                 pad=padre.getLd();
                 j=0;
                 if(parte.charAt(j)=='+'||parte.charAt(j)=='*'){
                     pad.setDato(parte.charAt(j));                     
                 }
                 for( j=j+1;j<parte.length();j++){
                        aux=parte.charAt(j);
                        switch(aux){
                            case'*':
                                padre1=aux;
                                z=new NodoDoble(padre1);
                                pad.setLi(z);
                                pad=z;
                            break;
                            case'+':
                                padre1=aux;
                                z=new NodoDoble(padre1);
                                pad.setLi(z);
                                pad=z;
                            break;
                            case')':
                                j++;
                                hijo1=parte.charAt(j);
                                j++;
                                padre1=parte.charAt(j);
                                j++;
                                hijo2=parte.charAt(j);
                                y=new NodoDoble(padre1);
                                z=new NodoDoble(hijo1);
                                w=new NodoDoble(hijo2);
                                pad.setLi(y);
                                pad=y;
                                pad.setLd(z);
                                pad.setLi(w);
                                j++;
                            break;                           
                        }
                    }                 
            }else{
                padre.setLi(x);
                pad=padre.getLi();
                 j=0;
                 if(parte.charAt(j)=='+'||parte.charAt(j)=='*'){
                     pad.setDato(parte.charAt(j));                     
                 }
                 for(j=j+1;j<parte.length();j++){
                        aux=parte.charAt(j);
                        switch(aux){
                            case'*':
                                padre1=aux;
                                z=new NodoDoble(padre1);
                                pad.setLi(z);
                                pad=z;
                            break;
                            case'+':
                                padre1=aux;
                                z=new NodoDoble(padre1);
                                pad.setLi(z);
                                pad=z;
                            break;
                            case')':
                                j++;
                                hijo1=parte.charAt(j);
                                j++;
                                padre1=parte.charAt(j);
                                j++;
                                hijo2=parte.charAt(j);
                                x=new NodoDoble(padre1);
                                z=new NodoDoble(hijo1);
                                w=new NodoDoble(hijo2);
                                pad.setLi(x);// Ya se hace en la línea 193
                                pad=x;
                                pad.setLd(z);
                                pad.setLi(w);
                                j++;
                            break;                           
                        }
                    }
            }
        }
    }
    public void concatenacion(int i,String auxHilera,NodoDoble p){
        char aux,padre,hijo;
        NodoDoble x,y;
        for(int j=i+1;j<auxHilera.length();j++){
            aux=auxHilera.charAt(j);
            switch(aux){
                case'*':
                    padre=aux;
                    x=new NodoDoble(padre);
                    p.setLi(x);
                    p=x;
                    break;
                 case'+':
                    padre=aux;
                    x=new NodoDoble(padre);
                    p.setLi(x);
                    p=x;
                     break;
                 case')':
                     String subHilera="";
                     boolean bandera=true;
                     j+=1;
                     while(bandera){

                         if(aux!='('){
                             aux=auxHilera.charAt(j);
                             subHilera+=aux;
                             j+=1;
                             aux=auxHilera.charAt(j);

                         }else{
                             bandera=false;
                         }
                     }
                     automataParentesis(p,subHilera);
                     j=auxHilera.length()-1;
                     break;
                default:
                    hijo=auxHilera.charAt(j);
                    j++;
                    padre=auxHilera.charAt(j);
                    x=new NodoDoble(padre);
                    y=new NodoDoble(hijo);
                    p.setLi(x);
                    x.setLd(y);
                    p=x;
            }
         }
    }
    public NodoDoble getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoDoble raiz) {
        this.raiz = raiz;
    }
    
}
