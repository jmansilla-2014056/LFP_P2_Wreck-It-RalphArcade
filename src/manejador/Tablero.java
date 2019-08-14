/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import modelos.Casilla;
import modelos.Reglas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static practica1_lfp.Editor.listaPublica;
import static practica1_lfp.Editor.pasar;
/**
 *
 * @author Mansilla
 */
public class Tablero extends JFrame implements KeyListener, Runnable{
    int puntuacion=0; 
    int posx = 100;
    int posy = 100;
    int posxEnemy = 100;
    int posyEnemy = 100;
    private Reglas reglas;
    boolean general = false;
    
    public Tablero(Reglas reglas){
  
        super(String.valueOf(reglas.getNivel()) +" : " + reglas.getNombre());
        this.setVisible(true);
        this.addKeyListener(this);
        this.setBounds(1, 1, reglas.getTamanioA()*100, reglas.getTamanioB()*75);
        this.setBackground(Color.BLACK);
        this.reglas = reglas;
        this.posx = enviarPosicionX(reglas.getTamanioA()/2);
        this.posy = enviarPosicionY(0);        
        
         for(int i=0; i<reglas.getTamanioB(); i++){
            for(int j=0; j<reglas.getTamanioA(); j++){
                final int enX = j;
                final int enY = i;
                Casilla c = reglas.getCasillas().stream().filter(p -> p.getEjeX()==enX && p.getEjeY()==enY).findAny().orElse(null);
                if(c==null || c.getTipo()==3){
                    reglas.getCasillas().add(new Casilla(enX,enY,0));
                }else{
                    
                }    
 
                }
            }
         
         for(Casilla ca: reglas.getCasillas()){
             for(Casilla cb: reglas.getCasillas()){
                 if(cb.getTipo()==2){
                         this.posxEnemy = enviarPosicionX(this.posxEnemy);
                         this.posyEnemy = enviarPosicionY(this.posyEnemy);
                     }
                 if(ca.getEjeX()==cb.getEjeX() && ca.getEjeY()==cb.getEjeY() && ca.getTipo()==1 && cb.getTipo()==2){
                     cb.setTipo(5);
                     //ENTRE UNA VEZ
                     ca.setTipo(5);                     
                 }
             }
         }        
        puntuacion=0;
        this.repaint();
    }

    public void paint(Graphics g)
     { 
        update(g);
     }
    
    public void update(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Dimension d = this.getSize();
        Image imagen = createImage(d.width  , d.height);
        Graphics2D fondo = (Graphics2D)imagen.getGraphics();
        Dibujar(fondo);
        g2.drawImage(imagen, 0,0, this);
    }
    
    
    //Dibujar edificio, personaje y enemigo
    private void Dibujar(Graphics g)
    {
        
        Graphics2D G2 = (Graphics2D) g;
        G2.setBackground(Color.BLACK);
        G2.setColor(Color.WHITE);
        
        int _x = 50;
        int _y = 50;
        for(int i=0; i<reglas.getTamanioB()+1; i++){
            for(int j=0; j<reglas.getTamanioA()+1; j++){
                if(i==reglas.getTamanioB()){
                    if(j-1>=0)
                        G2.drawString(String.valueOf(j-1), _x+25, _y+25);
                }else if(j==0){
                    G2.drawString(String.valueOf(Math.abs(i-reglas.getTamanioB()+1)), _x+25, _y+25);
                } 
                else{
                    G2.drawRect(_x, _y, 50, 50);                                       
                }
                
                _x+=50;
            }
            _y+=50;
            _x=50;
        }
                
       G2.drawString("Puntuacion: " + String.valueOf(this.puntuacion), _x, _y);
        
        // 0 Normales
        // 1 Escaleras
        // 2 Bloques Dañados
        // 4 Bloques Reparados
        // 5 Escaleras Dañadas
        //Pintar bloques y escaleras
        if(!reglas.getCasillas().isEmpty()){
            reglas.getCasillas().forEach((c) -> {
                if(c.getTipo()==0 | c.getTipo() == 1 || c.getTipo()==2 || c.getTipo()==4 || c.getTipo()==5){
                    G2.setColor(c.getColor());
                    G2.fill3DRect(enviarPosicionX(c.getEjeX()), enviarPosicionY(c.getEjeY()), 50, 50, rootPaneCheckingEnabled);
                }else{
                    
                }
            });
        }
        
        
        //Dibujar personaje
        G2.drawImage((new ImageIcon(reglas.getRutaPersonaje())).getImage(), this.posx, this.posy, 50, 50, this);
        //Dibujar enemigo
        G2.drawImage((new ImageIcon(reglas.getRutaEnemigo())).getImage(), this.posxEnemy, this.posyEnemy, 50, 50, this);
    }
    
    //Mantener Presion
    @Override
    public void keyTyped(KeyEvent ke) {

    }
    
    //Despresionar
      @Override
    public void keyReleased(KeyEvent ke) {
         //To change body of generated methods, choose Tools | Templates.
    }

    //teclear
    @Override
    public void keyPressed(KeyEvent ke) {

        switch (ke.getKeyCode()) {
            //Abajo
            case 40:
                if(verificarMov()){
                     this.posy += 50;
                }                  
                        
                if(ObtnerPosicionY() < 0){
                    this.posy -= 50;
                }                
                break;
            //Arriba    
            case 38:                
             
                    this.posy -= 50;   
                     
                 if(ObtnerPosicionY() >= reglas.getTamanioB() || !verificarMov()){
                    this.posy += 50;
                    }                 
                break;                
            //Derecha
            case 39:
                this.posx += 50;
                //posx--;
                if(ObtnerPosicionX() >= reglas.getTamanioA()){
                    this.posx -= 50;
                }
                break;                
            //Izquierda    
            case 37:
                this.posx -= 50;
                // posy--;               
                if(ObtnerPosicionX()<0){
                 this.posx += 50;   
                }         
                break;
            case 10:
            //verificar si uno: es bloque dañado(2) y dos: reparlo(0) 
            reparacion(2,0);
            //verificar si uno: es escalera dañado(5) y dos: reparlo(1) 
            reparacion(5,1);
            default:
                break;
        }
        this.repaint();
        
        //verificar si gano
        ganar();
        //verificar si perdio
        perder();
        
    }    
    
    //Reparar bloques
    public void reparacion(int uno, int dos){
        
        //verificar reparacion de arriba;
        reglas.getCasillas().stream().filter((c) -> (c.getEjeY()==ObtnerPosicionY() && c.getEjeX()==ObtnerPosicionX() && c.getTipo()==uno)).map((c) -> {
            c.setTipo(dos);
            puntuacion = puntuacion + 100;
            return c;            
        }).forEachOrdered((c) -> {            
            c.setTipo(dos);
        });

                
    }
           
    public boolean verificarMov(){
        boolean b = false;
       
        for(Casilla c: reglas.getCasillas()){
            if((c.getEjeY()==ObtnerPosicionY()  && c.getEjeX()==ObtnerPosicionX()) && (c.getTipo()==1 || c.getTipo()==5)){
                b = true;
                break;
            }
        }
        return b;
    }
    
   
    
    public int ObtnerPosicionEnemiX(){
        return (this.posxEnemy/50)-2;        
    }
    
    public int ObtnerPosicionEnemiY(){
        return reglas.getTamanioB()-(this.posyEnemy/50);  
    }
    
    public int ObtnerPosicionX(){
        return (this.posx/50)-2;        
    }
    
    public int ObtnerPosicionY(){
        return reglas.getTamanioB()-(this.posy/50);
    }
    
    private int enviarPosicionX(int x){
        x = (x+2)*50;
        return x;
    }
    
    private int enviarPosicionY(int y){
        y++;
        y = (reglas.getTamanioB()-y)*50;
        return y+50;
    }
        
    
    //Dañar escaleras o bloques
    public void danar(){
        for(Casilla c: reglas.getCasillas()){
            //Dañar escaleras
            if(c.getEjeX()== ObtnerPosicionEnemiX()  && c.getEjeY()==ObtnerPosicionEnemiY() && c.getTipo()==1){
                c.setTipo(5);
                puntuacion = puntuacion - 100;
                break;
            //Dañar bloques normales o reparados    
            }else if(c.getEjeX()== ObtnerPosicionEnemiX()  && c.getEjeY()==ObtnerPosicionEnemiY() && (c.getTipo()==0 || c.getTipo()==4)){
                c.setTipo(2);
                puntuacion = puntuacion - 100;
                break;
            }           
        }                    
    }
       
    //Mover Enemigo 
    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    
    Thread thread0 = new Thread(() -> {        
        try{
        while(true){
            reglas.getCasillas().stream().filter(p -> p.getTipo()==3).collect(Collectors.toList()).stream().map((c) -> {
                this.posxEnemy = enviarPosicionX(c.getEjeX());
                return c;
            }).map((c) -> {
                this.posyEnemy = enviarPosicionY(c.getEjeY());
                perder();
                return c;                                          
            }).map((_item) -> {
                return _item;
            }).forEachOrdered((_item) -> {
                try{
                    perder();
                    if(!general){
                        service.awaitTermination((long) 2.8, TimeUnit.SECONDS);
                    }                    
                    danar();
                }catch(InterruptedException e){
                    
                }
            });
        }
        }catch(Exception x){
            
        }
        });
        
    //juegoPerdido
    public boolean perder(){
        boolean pierde=false;
        if(this.posx == this.posxEnemy && this.posy == this.posyEnemy){
            pierde=true;
        }
        if(pierde){    
            general = true;
            this.removeKeyListener(this);        
            JOptionPane.showMessageDialog(null, "Vuelva a intentarlo " + reglas.getNivel());
            this.thread0.stop();                 
            this.posxEnemy = this.posx;
            this.posyEnemy = this.posy;
                                           
        }        
        return pierde;
    }
    
    //JuegoGanado
    public boolean ganar(){
        boolean gana=true;
        for(Casilla c: reglas.getCasillas()){
            if((c.getTipo()==4 || c.getTipo()==1) || c.getTipo()==3 || c.getTipo()==0){
                gana = true;
            }else{          
            gana=false;
            break;
        }
        }
        if(gana){
            this.thread0.stop();
            JOptionPane.showMessageDialog(null, "Felicidades has completado el nivel " + reglas.getNivel());  
            this.removeKeyListener(this);
            this.dispose();
            try{
                if(reglas.isSuperado()==false){
                    pasar++;
                }
                
            listaPublica.get(pasar).setSuperado(true);
            
            
            Tablero tablero = new Tablero(listaPublica.get(pasar));
            tablero.run();
              
            }catch(Exception x){
                    
            }                    
        }        
        return gana;
    }
    
    @Override
    public void run() {
        thread0.start();
    }
}
