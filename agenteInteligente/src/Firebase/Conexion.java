/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Firebase;

import Receta.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.net.*;
import java.util.*;

/**
 *
 * @author ric21
 */
public class Conexion {

    public static void main(String [] args) {        
        
        //Añadir receta
        /*------------------------------------------------------------------
        List<Paso> Lp = new ArrayList<Paso>();
        List<Ingrediente> Li = new ArrayList<Ingrediente>();
        Paso p;
        Ingrediente i;
        for(int j = 0;j<10;j++){
            p = new Paso();
            i = new Ingrediente();
            
            p.setId(j);
            p.setDescripcion("Descripcion "+j);
            Lp.add(p);
            
            i.setCantidad("Cantidad "+j);
            i.setId("Ingrediente "+j);
            i.setUnidades("Prueba");
            Li.add(i);            
        }
        Receta r = new Receta("Receta 1",Lp,Li);
        anadirReceta(r);
        -------------------------------------------------------------------*/
        
        
        //getReceta
        /*-------------------------------------------------------------------
        Receta r = getReceta("Receta 1");       
        -------------------------------------------------------------------*/
        
        
        //getIngredientes
        /*-------------------------------------------------------------------
        List<Ingrediente> Li = getIngredientes("Receta 1");
        -------------------------------------------------------------------*/
        return;
    }

    public static String anadirReceta(Receta receta) {
        Gson json = new Gson();
        return sendJson(json.toJson(receta),"putReceta");
    }
    
    public static Receta getReceta(String name){
        String json = sendJson("{\"id\":\""+ name +"\"}","getReceta");
        Gson gson = new Gson();
        return gson.fromJson(json, Receta.class);
    }
    
    public static List<Ingrediente> getIngredientes(String receta){
        Type Ingredientes = new TypeToken<List<Ingrediente>>(){}.getType();
        String json = sendJson("{\"id\":\""+ receta +"\"}","getIngredientes");
        Gson gson = new Gson();
        return gson.fromJson(json.substring(json.indexOf("["), json.length() -1), Ingredientes);
    }

    private static String sendJson(String json, String function) {
        String result = "";
        try {
            String link = "https://us-central1-pruebas-richi.cloudfunctions.net/" + function;
            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            //con.setRequestMethod("POST");
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(json);
            out.flush();
            out.close();

            int status = con.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            result = content.toString();
            con.disconnect();
        } catch (Exception ex) {
            result = ex.toString();
        }
        return result;
    }
}
