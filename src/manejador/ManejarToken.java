/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import java.util.ArrayList;
import java.util.Collection;
import modelos.Casilla;
import modelos.Reglas;
import modelos.Tokens;
/**
 *
 * @author Mansilla
 */
public class ManejarToken {
    public static Collection<Reglas> HacerNiveles(ArrayList<Tokens> LT){
        int estado=0;
        Reglas regla = new Reglas();
        Casilla casilla = new Casilla();
        Collection<Reglas> listaRegla = new ArrayList<>();
        
         for(Tokens t: LT){
             //0. Que abrir mayor que
            if(estado==0){
                if(t.getId()==20){
                    estado=1;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
            
            //1. Que venga la palabra reservada Nivel
            if(estado==1){
                if(t.getId()==5){
                    estado=2;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
            
            //2. Que venga la palabra reservada codigo
            if(estado==2){
                if(t.getId()==6){
                    estado=3;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
            
            //3. Que venga un igual
            if(estado==3){
                if(t.getId()==24){
                    estado=4;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
            
            //4. Que venga el numero del nivel y AGREGARLO
            if(estado==4){
                if(t.getId()==30){
                    regla.setNivel(Integer.parseInt(t.getLexema()));
                    estado=5;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
            
            //5. que venga la palabra reservada nombre
             if(estado==5){
                if(t.getId()==7){
                    estado=6;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
            
            //6. que venga un igual
             if(estado==6){
                if(t.getId()==24){
                    estado=7;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
            
             //7. Que venga un identificador y AGREGARLO
             if(estado==7){
                if(t.getId()==32){
                    regla.setNombre(t.getLexema());
                    estado=8;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
             
            //8. Que venga cerrar mayor que
            if(estado==8){
                if(t.getId()==21){
                    estado=9;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
             
            //9. que venga abrir menor que
             if(estado==9){
                if(t.getId()==20){
                    estado=10;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
                        
           //10 que vengan la etiqueta edificio o que venga la etiqueta personaje o que venga o enemigo o que venga la barra
            if(estado==10){
                if(t.getId()==8){
                    estado=11;
                    continue;
                }else if(t.getId()==15){
                    estado= 70;
                    continue;
                }else if(t.getId()==17){
                    estado= 80;
                    continue;
                }else if(t.getId()==22){
                    estado= 999;
                }else{
                    
                }
            }
            
            
            //999 Que cierren la etiqueta nivel
            if(estado==999){
                 if(t.getId()==5){
                    estado=1000;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                } 
            }
            
            //1000 que cierren la etiqueta, guardar las reglas y limpiarlas
            if(estado==1000){
                 if(t.getId()==21){
                     listaRegla.add(regla);
                     regla = new Reglas();                             
                    estado=0;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                } 
            }
            
            //80 Que venga la palabra reservada imagen
            if(estado==80){
                 if(t.getId()==16){
                    estado=81;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                } 
            }
            
            //81 Que venga signo igual
             if(estado==81){
               if(t.getId()==24){
                    estado=82;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                } 
            }
             
             
             //82 Que venga el texto
             if(estado==82){
               if(t.getId()==31){
                   regla.setRutaEnemigo(t.getLexema());
                    estado=83;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                } 
            }
             
             //****83 que venga cerrar >
             if(estado==83){
               if(t.getId()==21){
                    estado=84;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                } 
            }
            
             //84 Que venga abrir <
             if(estado==84){
               if(t.getId()==20){
                    estado=85;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                } 
            }
             
            
             //85 Que venga Moviento o la barra
             if(estado==85){
               if(t.getId()==18){
                    estado=86;
                    casilla.setTipo(3);
                    continue;
                }else if(t.getId()==22){
                    estado=100;
                    continue;
                } 
                else{
                  //Error no viene lo que se espera      
                } 
            }
             
            
             //86 que venga la palabra reservada PosicionX
             if(estado==86){
                if(t.getId()==12){
                    estado=87;
                    continue;
                }
                else{
                  //Error no viene lo que se espera      
                } 
            } 
             
             //87 Que venga el igual
             if(estado==87){
                if(t.getId()==24){
                    estado=88;
                    continue;
                }
                else{
                  //Error no viene lo que se espera      
                } 
            } 
            
             //88 Que venga el numero
             if(estado==88){
                 if(t.getId()==30){
                     casilla.setEjeX(Integer.parseInt(t.getLexema()));
                     estado=89;
                     continue;
                 }else{
                     
                 }
             }
             
             //88 Que venga la palabra reservada Posicion y
             if(estado==89){
                 if(t.getId()==13){
                     estado=90;
                     continue;
                 }else{
                     
                 }
             }
             
             //90 que venga el numero para la posicion Y
             if(estado==90){
                 if(t.getId()==30){
                     casilla.setEjeY(Integer.parseInt(t.getLexema()));
                     regla.getCasillas().add(casilla);
                     casilla = new Casilla();
                     estado= 83;                             
                     continue;
                 }else{
                     
                 }
             }
             
             
             //100 Que venga la palabra reservada Enemigo
            if(estado==100){
                if(t.getId()==17){
                    estado=22;
                    continue;
                }
                else{
                  //Error no viene lo que se espera      
                } 
            } 
            //El estado 22 que espera que se sierre enemigo o edificio             
            
            
            //70 Que venga la palabra reservada imagen
            if(estado==70){
               if(t.getId()==16){
                    estado=71;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                } 
            }
            
            //71 Que venga signo igual
             if(estado==71){
               if(t.getId()==24){
                    estado=72;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                } 
            }
             
             //72 Que venga el texto
             if(estado==72){
               if(t.getId()==31){
                   regla.setRutaPersonaje(t.getLexema());
                    estado=22;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                } 
            }
                        
            //11 que venga la etiqueta Dimension X
            if(estado==11){
                if(t.getId()==9){
                    estado=12;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
            
            //12 que venga igual
            if(estado==12){
                if(t.getId()==24){
                    estado=13;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
            
            //13 Que venga el numero de X y Agregarlo
            if(estado==13){
                if(t.getId()==30){
                    regla.setTamanioA(Integer.parseInt(t.getLexema()));
                    estado=14;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
             
            //14 Que venga la palabra reservada dimencion Y
            if(estado==14){
                 if(t.getId()==10){
                    estado=15;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
            
              //15 Que venga un igual
            if(estado==15){
                 if(t.getId()==24){
                    estado=16;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
            
            //16 que venga numero Y agregarlo
            if(estado==16){
                 if(t.getId()==30){
                    regla.setTamanioB(Integer.parseInt(t.getLexema()));
                    estado=17;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
            
            //17 que venga mayor que >
            if(estado==17){
                 if(t.getId()==21){
                    estado=18;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
            
            //18 que venga abrir etiqueta <
            if(estado==18){
                 if(t.getId()==20){
                    estado=19;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
            
            //19 que venga Escalera (60)  o bloque (60) o barra (21)
            if(estado==19){
                 if(t.getId()==14){
                     // Enviar el tipo escalera
                    casilla.setTipo(1);
                    estado=60;
                    continue;
                }else if(t.getId()==11){
                    // Enviar el tipo bloque
                    casilla.setTipo(2);
                     estado=60;
                    continue;  
                }else if(t.getId()==22){
                    estado = 21;
                }else{
                    
                }                    
            }
            
            //60. Esperar palabra reservada Posicion X
              if(estado==60){
                if(t.getId()==12){
                    estado=61;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
              
            //61. Esperar el signo igual
              if(estado==61){
                if(t.getId()==24){
                    estado=62;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }  
              
            //62. Esperar el numero de X
            if(estado==62){
                if(t.getId()==30){
                    casilla.setEjeX(Integer.parseInt(t.getLexema()));
                    estado=63;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
            
            //63  Que venga la palabra reservada PosicionY
             if(estado==63){
                if(t.getId()==13){
                    estado=64;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
             
            //64 Que venga el igual 
             if(estado==64){
                if(t.getId()==24){
                    estado=65;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
             
            //65 Que venga un numero para Y y guardar la casilla en las reglas y limpiar la casilla
            if(estado==65){
                if(t.getId()==30){
                    casilla.setEjeY(Integer.parseInt(t.getLexema()));
                    regla.getCasillas().add(casilla);
                    casilla = new Casilla();
                    estado=17;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
              //Al terminar aqui regresar a esperar otra vez la etiqueta abierta de 9
                      
            
            //21 esperar la palabra Edificio
              if(estado==21){
                if(t.getId()==8){
                    estado=22;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
            
            //22 esperar que cierren mayor que
              if(estado==22){
                if(t.getId()==21){
                    estado=9;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
              //Regresar al estado 9 para abrir nuevamente
             
              
              
         }
         return listaRegla;
    }
}
