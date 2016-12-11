/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concertTickets;

import ee.ttu.idu0075._2015.ws.concert.AddConcertTicketRequest;
import ee.ttu.idu0075._2015.ws.concert.AddConcertTicketResponse;
import ee.ttu.idu0075._2015.ws.concert.AddConcertTicketType;
import ee.ttu.idu0075._2015.ws.concert.GetConcertTicketListRequest;
import ee.ttu.idu0075._2015.ws.concert.GetConcertTicketListResponse;
import ee.ttu.idu0075._2015.ws.concert.SellConcertTicketRequest;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
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
@Path("concertTickets")
public class ConcertTicketsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ConcertTicketsResource
     */
    public ConcertTicketsResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GetConcertTicketListResponse getConcertList(
            @QueryParam("token") String token,
            @QueryParam("req") String reqId,
            @QueryParam("concert") String concertId) {
        if (token == null) {
            throw new IllegalArgumentException("Missing token");
        } else if (reqId == null) {
            throw new IllegalArgumentException("Missing request ID.");
        } else {
            ConcertTicketWebService ws = new ConcertTicketWebService();
            GetConcertTicketListRequest request = new GetConcertTicketListRequest();
            if (concertId != null) {
                request.setConcertId(BigInteger.valueOf(Integer.parseInt(concertId)));
            }
            request.setToken(token);
            request.setRequestId(BigInteger.valueOf(Integer.parseInt(reqId)));
            return ws.getConcertTicketList(request);
        }
    }
    
    @GET
    @Path("/id/{id : \\d+}") //digits only
    @Produces(MediaType.APPLICATION_JSON)
    public boolean sellConcertTicket(
        @PathParam("id") String id,
        @QueryParam("token") String token,
        @QueryParam("req") String reqId) {
        if (token == null) {
            throw new IllegalArgumentException("Missing token.");
        } else if (reqId == null) {
            throw new IllegalArgumentException("Missing request ID.");
        } else {
            ConcertTicketWebService ws = new ConcertTicketWebService();
            SellConcertTicketRequest request = new SellConcertTicketRequest();
            request.setConcertTicketId(BigInteger.valueOf(Integer.parseInt(id)));
            request.setRequestId(BigInteger.valueOf(Integer.parseInt(reqId)));
            request.setToken(token);
            boolean result = ws.sellConcertTicket(request);
            if (!result) {
                throw new IllegalArgumentException("No sellable concert ticket with such ID");
            }
            return result;
        }
    }
    
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AddConcertTicketResponse addConcert(
            List<AddConcertTicketType> content,
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
            AddConcertTicketRequest request = new AddConcertTicketRequest();
            request.setToken(token);
            request.setRequestId(BigInteger.valueOf(Integer.parseInt(reqId)));
            List<AddConcertTicketType> concertTickets = new ArrayList<>();
            for(AddConcertTicketType t : content) {
                AddConcertTicketType concertTicket = new AddConcertTicketType();
                concertTicket.setTicketId(t.getTicketId());
                concertTicket.setConcertId(t.getConcertId());
                concertTicket.setQuantity(t.getQuantity());
                concertTicket.setSold(t.isSold());
                concertTickets.add(concertTicket);
            }
            request.setConcertTicket(concertTickets);
            return ws.addConcertTicket(request);
        }        
    }
}
