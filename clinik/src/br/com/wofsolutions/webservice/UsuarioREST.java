package br.com.wofsolutions.webservice;

import java.io.Serializable;

import br.com.wofsolutions.vo.Usuario;
import br.com.wofsolutions.vo.Usuario;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;


public class UsuarioREST implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String URL_WS = "http://192.168.0.74:8080/sismaiawebservice/usuario/";

	
    
    
    
    public Usuario getUsuario(String user, String senha) throws Exception {
    	//  System.out.println("Link= "+ URL_WS +numSerie);
    	if(user!=null){
    		 String[] resposta = new WebServiceCliente().get(URL_WS +user+"/"+senha);
    		  
    	        if (resposta[0].equals("200")) {
    	          //  Gson gson = new Gson();
    	            
    	            GsonBuilder gsonBuilder = new GsonBuilder();
    	            gsonBuilder.setDateFormat("MMM dd, yyyy");
    	            Gson gson = gsonBuilder.create();
    	            
    	            
    	            JsonParser parser = new JsonParser();
    	            JsonArray array = parser.parse(resposta[1]).getAsJsonArray();
    	          
    	            Usuario usuario = gson.fromJson(array.get(0), Usuario.class);
    	            return usuario;
    	        } else {
    	            throw new Exception(resposta[1]);
    	        }
    	}
       return null;
       }
    
    
   
}