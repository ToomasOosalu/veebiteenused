/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concertTickets;

import ee.ttu.idu0075._2015.ws.concert.AddConcertRequest;
import ee.ttu.idu0075._2015.ws.concert.AddConcertResponse;
import ee.ttu.idu0075._2015.ws.concert.AddConcertType;
import ee.ttu.idu0075._2015.ws.concert.ConcertType;
import ee.ttu.idu0075._2015.ws.concert.GetConcertListRequest;
import ee.ttu.idu0075._2015.ws.concert.GetConcertListResponse;
import ee.ttu.idu0075._2015.ws.concert.GetConcertRequest;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Tom
 */
@Path("concerts")
public class ConcertsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ConcertsResource
     */
    public ConcertsResource() {
    }
    
    @GET
    @Path("/id/{id : \\d+}") //digits only
    @Produces(MediaType.APPLICATION_JSON)
    public ConcertType getConcert(
            @PathParam("id") String id,
            @QueryParam("req") String reqId,
            @QueryParam("token") String token) {
        if (token == null) {
            throw new IllegalArgumentException("Missing token.");
        } else if (reqId == null) {
            throw new IllegalArgumentException("Missing request ID.");
        } else {
            ConcertTicketWebService ws = new ConcertTicketWebService();
            GetConcertRequest request = new GetConcertRequest();
            request.setId(BigInteger.valueOf(Integer.parseInt(id)));
            request.setRequestId(BigInteger.valueOf(Integer.parseInt(reqId)));
            request.setToken(token);
            ConcertType result = ws.getConcert(request);
            if (result == null) {
                throw new IllegalArgumentException("No concert with such ID");
            }
            return result;
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GetConcertListResponse getConcertList(
            @QueryParam("token") String token,
            @QueryParam("req") String reqId) {
        if (token == null) {
            throw new IllegalArgumentException("Missing token");
        } else if (reqId == null) {
            throw new IllegalArgumentException("Missing request ID.");
        } else {
            ConcertTicketWebService ws = new ConcertTicketWebService();
            GetConcertListRequest request = new GetConcertListRequest();
            request.setToken(token);
            request.setRequestId(BigInteger.valueOf(Integer.parseInt(reqId)));
            return ws.getConcertList(request);
        }
    }
    
    @POST
    @Path("/add") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AddConcertResponse addConcert(
            List<AddConcertType> content,
            @QueryParam("token") String token,
            @QueryParam("req") String reqId) {
        if (token == null) {
            throw new IllegalArgumentException("Missing token.");
        } else if (reqId == null) {
            throw new IllegalArgumentException("Missing request ID.");
        }
        if (content == null) {
            throw new IllegalArgumentException("Missing content.");
        } else {
            ConcertTicketWebService ws = new ConcertTicketWebService();
            AddConcertRequest request = new AddConcertRequest();
            request.setToken(token);
            request.setRequestId(BigInteger.valueOf(Integer.parseInt(reqId)));
            List<AddConcertType> concerts = new ArrayList<>();
            for(AddConcertType c : content) {
                AddConcertType concert = new AddConcertType();
                concert.setTitle(c.getTitle());
                concert.setArtist(c.getArtist());
                concert.setVenue(c.getVenue());
                concert.setStartDate(c.getStartDate());
                concert.setEndDate(c.getEndDate());
                concert.setNrOfTickets(c.getNrOfTickets());
                concerts.add(concert);
            }
            request.setConcert(concerts);
            return ws.addConcert(request);
        }        
    }
    
}
