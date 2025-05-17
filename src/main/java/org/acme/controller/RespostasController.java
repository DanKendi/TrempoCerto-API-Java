package org.acme.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entity.RespostasEntity;
import org.acme.service.RespostasService;

@Path("/respostas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RespostasController {

    private final RespostasService respostasService;

    public RespostasController(RespostasService respostasService){
        this.respostasService = respostasService;
    }

    @GET
    public Response findAll(@QueryParam("page")@DefaultValue("0") Integer page,
                            @QueryParam("pageSize")@DefaultValue("90") Integer pageSize){
        var respostas = respostasService.findAll(page, pageSize);

        return Response.ok(respostas).build();
    }
    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer respostaId){
        return Response.ok(respostasService.findById(respostaId)).build();
    }

    @POST
    @Transactional
    public Response createResposta(RespostasEntity respostasEntity){
        return  Response.ok(respostasService.createResposta(respostasEntity)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateResposta(@PathParam("id") Integer respostaId, RespostasEntity respostasEntity){
        return Response.ok(respostasService.updateResposta(respostaId, respostasEntity)).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteResposta(@PathParam("id") Integer respostaId){
        respostasService.deleteResposta(respostaId);
        return Response.noContent().build();
    }

}
