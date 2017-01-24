package br.com.contabilizei.desafio.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by contabilizei on 20/01/2017.
 */
@Path("/home")
public class HomeJersey {

    @GET
    public Response getIndex() {
        return Response.ok("Hello, stranger!").build();
    }

    @GET
    @Path("/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getIndex(@PathParam("name")String name) {
        return Response.ok("Hello, " + name).build();
    }
}
