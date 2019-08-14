/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Tokens;
import modelos.Trampa;

/**
 *
 * @author User
 */
public class CrearHtml {
    public static void tokensHtml(ArrayList<Tokens> listaTokens) {

        String Contenido;
        Contenido = "<html>"
                + "<body>"
                + "<h1 align='center'>TABLA DE TOKENS</h1></br>"
                + "<table cellpadding='10' border = '1' align='center'>"
                + "<tr>"
                + "<td><strong>No."
                + "</strong></td>"
                + "<td><strong>Tipo"
                + "</strong></td>"
                + "<td><strong>Lexema"
                + "</strong></td>"
                + "<td><strong>Id"
                + "</strong></td>"
                + "<td><strong>Fila"
                + "</strong></td>"
                + "<td><strong>Columna"
                + "</strong></td>"
                + "</tr>";

        String CadTokens = "";
        String tempotk;

        int x = 0;
        for (Tokens t : listaTokens) {
            x++;
            tempotk = "";
            tempotk = "<tr>"
                    + "<td><strong>" + Integer.toString(x)
                    + "</strong></td>"
                    + "<td>" + t.getTipo()
                    + "</td>"
                    + "<td>"
                    + t.getLexema()
                    + "</td>"
                    + "<td>" + t.getId()
                    + "</td>"
                    + "<td>" + t.getFila()
                    + "</td>"
                    + "<td>" + t.getColumna()
                    + "</td>"
                    + "</tr>";
            CadTokens = CadTokens + tempotk;

        }

        Contenido = Contenido + CadTokens
                + "</table>"
                + "</body>"
                + "</html>";


        //creando archivo html/
        File file = new File("ReporteTokens.html");

        try {

            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Desktop.getDesktop().open(file);
            //archivo.delete();

        } catch (Exception ex) {

        }
        /*File.WriteAllText("Reporte de Tokens.html", Contenido);
            System.Diagnostics.Process.Start("Reporte de Tokens.html");*/

    }
    
    public static void ErroresHtml(ArrayList<Trampa> listaTrampa) {

        String Contenido;
        Contenido = "<html>"
                + "<body>"
                + "<h1 align='center'>TABLA DE TOKENS CON ERROR</h1></br>"
                + "<table cellpadding='10' border = '1' align='center'>"
                + "<tr>"
                + "<td><strong>No."
                + "</strong></td>"
                + "<td><strong>Descripcion"
                + "</strong></td>"
                + "<td><strong>Lexema"
                + "</strong></td>"
                + "<td><strong>Id"
                + "</strong></td>"
                + "<td><strong>Fila"
                + "</strong></td>"
                + "<td><strong>Columna"
                + "</strong></td>"
                + "</tr>";

        String CadTokens = "";
        String tempotk;

        int x = 0;
        for (Trampa t : listaTrampa) {
            x++;
            tempotk = "";
            tempotk = "<tr>"
                    + "<td><strong>" + Integer.toString(x)
                    + "</strong></td>"
                    + "<td>" + t.getDescri()
                    + "</td>"
                    + "<td>"
                    + t.getError()
                    + "</td>"
                    + "<td>" + "0x69968"
                    + "</td>"
                    + "<td>" + t.getFila()
                    + "</td>"
                    + "<td>" + t.getColumna()
                    + "</td>"
                    + "</tr>";
            CadTokens = CadTokens + tempotk;

        }

        Contenido = Contenido + CadTokens
                + "</table>"
                + "</body>"
                + "</html>";


        //creando archivo html/
        File file = new File("ReporteTokens.html");

        try {

            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Desktop.getDesktop().open(file);
            //archivo.delete();

        } catch (Exception ex) {

        }
        /*File.WriteAllText("Reporte de Tokens.html", Contenido);
            System.Diagnostics.Process.Start("Reporte de Tokens.html");*/

    }

    
        /*File.WriteAllText("Reporte de Tokens.html", Contenido);
            System.Diagnostics.Process.Start("Reporte de Tokens.html");*/

    //To change body of generated methods, choose Tools | Templates.
    

  
    
}
