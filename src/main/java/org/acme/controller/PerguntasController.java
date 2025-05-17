package org.acme.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entity.PerguntasEntity;
import org.acme.service.PerguntasService;

@Path("/perguntas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerguntasController {

    private final PerguntasService perguntasService;

    public PerguntasController(PerguntasService perguntasService) {
        this.perguntasService = perguntasService;
    }

    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page,
                            @QueryParam("pageSize") @DefaultValue("30") Integer pageSize) {
        var users = perguntasService.findAll(page, pageSize);


        return Response.ok(users).build();
    }


    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer userId) {
        return Response.ok(perguntasService.findById(userId)).build();
    }

    @POST
    @Transactional
    public Response createPergunta(PerguntasEntity perguntasEntity){
        return  Response.ok(perguntasService.createPergunta(perguntasEntity)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updatePergunta(@PathParam("id") Integer perguntaId, PerguntasEntity perguntasEntity){
        return Response.ok(perguntasService.updatePergunta(perguntaId, perguntasEntity)).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletePergunta(@PathParam("id") Integer perguntaId){
        perguntasService.deletePergunta(perguntaId);
        return Response.noContent().build();
    }


}

