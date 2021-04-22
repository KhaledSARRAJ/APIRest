package com.example.service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/banque")
public class BanqueWebService {
    //BDD
    private static Map<Integer,Compte> comptes = new HashMap<>();

    @GET
    @Path("conversion/{montant}")
    @Produces(MediaType.APPLICATION_JSON)
public double conversionEuroEnDinard (@PathParam(value = "montant") double mt){
        return mt*3;
    }
    @GET
    @Path("compte/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Compte getCompte (@PathParam(value = "code") int code){
        return comptes.get(code);
    }
    @GET
    @Path("comptes")
    @Produces(MediaType.APPLICATION_JSON)
    public List comptes(){
               return new ArrayList<>(comptes.values());
    }
    @POST
    @Path("/comptes")
    @Produces(MediaType.APPLICATION_JSON)
    public Compte save (Compte cp){
        cp.setDatecreation(new Date());
        comptes.put(cp.getCode(), cp);
        return cp;
    }
    @PUT
    @Path("/comptes/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Compte update (Compte cp,@PathParam("code") int code){
        comptes.put(code, cp);
        return cp;
    }
    @DELETE
    @Path("/comptes/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean delete (@PathParam("code") int code){
        comptes.remove(code);
        return true;
    }
}
