/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concertTickets;


import ee.ttu.idu0075._2015.ws.concert.AddTicketRequest;
import ee.ttu.idu0075._2015.ws.concert.AddTicketResponse;
import ee.ttu.idu0075._2015.ws.concert.AddTicketType;
import ee.ttu.idu0075._2015.ws.concert.GetTicketListResponse;
import ee.ttu.idu0075._2015.ws.concert.GetTicketRequest;
import ee.ttu.idu0075._2015.ws.concert.SearchCriteriaType;
import ee.ttu.idu0075._2015.ws.concert.TicketListRequestType;
import ee.ttu.idu0075._2015.ws.concert.TicketType;
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
@Path("tickets")
public class TicketsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TicketsResource
     */
    public TicketsResource() {
    }

    @GET
    @Path("/id/{id : \\d+}") //digits only
    @Produces(MediaType.APPLICATION_JSON)
    public TicketType getTicket(
            @PathParam("id") String id,
            @QueryParam("token") String token,
            @QueryParam("req") String reqId){
        if (token == null) {
            throw new IllegalArgumentException("Missing token.");
        } else if (reqId == null) {
            throw new IllegalArgumentException("Missing request ID");
        } else { 
            ConcertTicketWebService ws = new ConcertTicketWebService();
            GetTicketRequest request = new GetTicketRequest();
            request.setId(BigInteger.valueOf(Integer.parseInt(id)));
            request.setRequestId(BigInteger.valueOf(Integer.parseInt(reqId)));
            request.setToken(token);
            TicketType result = ws.getTicket(request);
            if (result == null) {
                throw new IllegalArgumentException("No ticket with such ID");
            }
            return result;
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public GetTicketListResponse getTicketList(
            SearchCriteriaType searchCriteria,
            @QueryParam("token") String token,
            @QueryParam("req") String reqId) {
        if (token == null) {
            throw new IllegalArgumentException("Missing token");
        } else if (reqId == null) {
            throw new IllegalArgumentException("Missing request ID.");
        } else if (searchCriteria == null) {
            throw new IllegalArgumentException("SearchCriteria element can be empty but it needs to exist.");
        } else {
            ConcertTicketWebService ws = new ConcertTicketWebService();
            TicketListRequestType request = new TicketListRequestType();
            request.setToken(token);
            request.setRequestId(BigInteger.valueOf(Integer.parseInt(reqId)));
            request.setSearchCriteria(searchCriteria);
            return ws.getTicketList(request);
        }
    }
    
    @POST
    @Path("/add") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AddTicketResponse addConcert(
            List<AddTicketType> content,
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
            AddTicketRequest request = new AddTicketRequest();
            request.setToken(token);
            request.setRequestId(BigInteger.valueOf(Integer.parseInt(reqId)));
            List<AddTicketType> tickets = new ArrayList<>();
            for(AddTicketType t : content) {
                AddTicketType ticket = new AddTicketType();
                ticket.setType(t.getType());
                ticket.setPrice(t.getPrice());
                ticket.setStanding(t.isStanding());
                tickets.add(ticket);
            }
            request.setTicket(tickets);
            return ws.addTicket(request);
        }        
    }
    
}
