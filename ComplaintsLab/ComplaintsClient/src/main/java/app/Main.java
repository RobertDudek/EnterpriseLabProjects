/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author rokok
 */
public class Main {
    public static void main(String[] args){
        Client client = ClientBuilder.newClient();
        String count =
        client.target("http://localhost:8080/Complaints/" +
         "resources/complaints/count")
        .request(MediaType.TEXT_PLAIN)
        .get(String.class);
        System.out.println("Count: " + count);
        
        // Pobierz i wyświetl na konsoli wszystkie skargi
        ArrayList<HashMap>  complaints;
        complaints = client.target("http://localhost:8080/Complaints/" +
                "resources/complaints")
                .request(MediaType.APPLICATION_JSON)
                .get(ArrayList.class);
        System.out.println(complaints);
        
        //Pobierz i wyświetl na konsoli jedną z otwartych skarg (przesyłając jej identyfikator do usługi)
        HashMap openComplaint = client.target("http://localhost:8080/Complaints/" +
                "resources/complaints/451")
                .request(MediaType.APPLICATION_JSON)
                .get(HashMap.class);
        System.out.println(openComplaint);
        
        //Zmodyfikuj skargę pobraną w poprzednim punkcie zmieniając jej status na zamknięty (poprzez podmianę całego zasobu)
        openComplaint.put("status", "closed");
        client.target("http://localhost:8080/Complaints/" +
                "resources/complaints/451")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(openComplaint, MediaType.APPLICATION_JSON));
        
        //Pobierz i wyświetl na konsoli wszystkie otwarte skargi.
        java.util.ArrayList<HashMap>  openComplaints;
        openComplaints = client.target("http://localhost:8080/Complaints/" +
                "resources/complaints?status=open")
                .request(MediaType.APPLICATION_JSON)
                .get(java.util.ArrayList.class);
        System.out.println(openComplaints);
        client.close(); 
    }
}
