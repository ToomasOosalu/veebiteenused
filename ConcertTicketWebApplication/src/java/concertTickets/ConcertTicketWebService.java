/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concertTickets;

import com.sun.xml.ws.developer.SchemaValidation;
import ee.ttu.idu0075._2015.ws.concert.AddConcertRequest;
import ee.ttu.idu0075._2015.ws.concert.AddConcertResponse;
import ee.ttu.idu0075._2015.ws.concert.AddConcertTicketRequest;
import ee.ttu.idu0075._2015.ws.concert.AddConcertTicketResponse;
import ee.ttu.idu0075._2015.ws.concert.AddConcertTicketType;
import ee.ttu.idu0075._2015.ws.concert.AddConcertType;
import ee.ttu.idu0075._2015.ws.concert.AddTicketRequest;
import ee.ttu.idu0075._2015.ws.concert.AddTicketResponse;
import ee.ttu.idu0075._2015.ws.concert.AddTicketType;
import ee.ttu.idu0075._2015.ws.concert.ConcertType;
import ee.ttu.idu0075._2015.ws.concert.ConcertTicketType;
import ee.ttu.idu0075._2015.ws.concert.GetConcertListRequest;
import ee.ttu.idu0075._2015.ws.concert.GetConcertListResponse;
import ee.ttu.idu0075._2015.ws.concert.GetConcertRequest;
import ee.ttu.idu0075._2015.ws.concert.GetConcertTicketListRequest;
import ee.ttu.idu0075._2015.ws.concert.GetConcertTicketListResponse;
import ee.ttu.idu0075._2015.ws.concert.GetTicketListResponse;
import ee.ttu.idu0075._2015.ws.concert.GetTicketRequest;
import ee.ttu.idu0075._2015.ws.concert.SearchCriteriaType;
import ee.ttu.idu0075._2015.ws.concert.SellConcertTicketRequest;
import ee.ttu.idu0075._2015.ws.concert.TicketListRequestType;
import ee.ttu.idu0075._2015.ws.concert.TicketType;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.jws.WebService;

/**
 *
 * @author Tom
 */
@WebService(serviceName = "ConcertService", portName = "ConcertPort", endpointInterface = "ee.ttu.idu0075._2015.ws.concert.ConcertPortType", targetNamespace = "http://www.ttu.ee/idu0075/2015/ws/concert", wsdlLocation = "WEB-INF/wsdl/ConcertTicketWebService/ConcertTicketService.wsdl")
@SchemaValidation
public class ConcertTicketWebService {
    
    private static List<String> tokens = Arrays.asList("kdgIkN87DGlJGDh", "gd9BJ9Kkjhhd70l", "mkmdvsl875ls9JHF", "test");
    private static Map<String, Object> requestMap = new HashMap<>();        
    private static Map<Integer, ConcertType> concerts = new HashMap<>();
    private static Map<Integer, TicketType> tickets = new HashMap<>();
    private static Map<Integer, ConcertTicketType> concertTickets = new HashMap<>();
    private static int nextConcertId, nextTicketId, nextConcertTicketId = 0;
    private final String CAST_ERR_MSG = "Invalid Request ID.";
    
    public ConcertType getConcert(GetConcertRequest parameter) {
        if (tokens.contains(parameter.getToken())) {
            Object validation = validateRequest(parameter.getRequestId().intValue(), parameter.getToken());
            if (validation == null) {
                if (concerts.containsKey(parameter.getId().intValue())) {
                    ConcertType result = concerts.get(parameter.getId().intValue());
                    String key = parameter.getToken() + "_" + parameter.getRequestId().intValue();
                    requestMap.put(key, result);
                    return result;
                }
            } else {
                try{
                    return (ConcertType) validation;
                } catch(Exception e) {
                    throw new IllegalArgumentException(this.CAST_ERR_MSG);
                }
                
            }
        }
        return null;
    }

    public AddConcertResponse addConcert(AddConcertRequest parameter) {
        if (tokens.contains(parameter.getToken())) {
            Object validation = validateRequest(parameter.getRequestId().intValue(), parameter.getToken());
            if (validation == null) {
                List<ConcertType> concertList = new ArrayList<>();
                for(AddConcertType concert : parameter.getConcert()) {
                    ConcertType c = new ConcertType();
                    c.setId(BigInteger.valueOf(nextConcertId));
                    c.setTitle(concert.getTitle());
                    c.setArtist(concert.getArtist());
                    c.setVenue(concert.getVenue());
                    c.setStartDate(concert.getStartDate());
                    c.setEndDate(concert.getEndDate());
                    c.setNrOfTickets(concert.getNrOfTickets());
                    c.setFreeTickets(concert.getNrOfTickets());
                    concertList.add(c);
                    this.concerts.put(nextConcertId, c);
                    nextConcertId++;
                }
                AddConcertResponse result = new AddConcertResponse();
                result.setConcert(concertList);
                String key = parameter.getToken() + "_" + parameter.getRequestId().intValue();
                requestMap.put(key, result);
                return result;
            } else {
                try{
                    return (AddConcertResponse) validation;
                } catch(Exception e) {
                    throw new IllegalArgumentException(this.CAST_ERR_MSG);
                }
            }
        }
        return null;
    }

    public GetConcertListResponse getConcertList(GetConcertListRequest parameter) {
        if (tokens.contains(parameter.getToken())) {
            Object validation = validateRequest(parameter.getRequestId().intValue(), parameter.getToken());
            if (validation == null) {
                GetConcertListResponse result = new GetConcertListResponse();
                result.setConcert(new ArrayList(this.concerts.values()));
                String key = parameter.getToken() + "_" + parameter.getRequestId().intValue();
                requestMap.put(key, result);
                return result;
            } else {
                try{
                    return (GetConcertListResponse) validation;
                } catch(Exception e) {
                    throw new IllegalArgumentException(this.CAST_ERR_MSG);
                }
            }
        }
        return null;
    }

    public TicketType getTicket(GetTicketRequest parameter) {
        if (tokens.contains(parameter.getToken())) {
            Object validation = validateRequest(parameter.getRequestId().intValue(), parameter.getToken());
            if (validation == null) {
                if (tickets.containsKey(parameter.getId().intValue())) {
                    TicketType result = tickets.get(parameter.getId().intValue());
                    String key = parameter.getToken() + "_" + parameter.getRequestId().intValue();
                    requestMap.put(key, result);
                    return result;
                }
            } else {
                try{
                    return (TicketType) validation;
                } catch(Exception e) {
                    throw new IllegalArgumentException(this.CAST_ERR_MSG);
                }
            }
        }
        return null;
    }

    public AddTicketResponse addTicket(AddTicketRequest parameter) {
        if (tokens.contains(parameter.getToken())) {
            Object validation = validateRequest(parameter.getRequestId().intValue(), parameter.getToken());
            if (validation == null) {
                List<TicketType> ticketsToAdd = new ArrayList<>();
                for (AddTicketType t : parameter.getTicket()) {
                    TicketType ticket = new TicketType();
                    ticket.setId(BigInteger.valueOf(this.nextTicketId));     
                    ticket.setType(t.getType());
                    ticket.setPrice(t.getPrice());
                    ticket.setStanding(t.isStanding());
                    tickets.put(nextTicketId, ticket);
                    ticketsToAdd.add(ticket);
                    this.nextTicketId++;
                }
                AddTicketResponse result = new AddTicketResponse();
                result.setTicket(ticketsToAdd);
                String key = parameter.getToken() + "_" + parameter.getRequestId().intValue();
                requestMap.put(key, result);
                return result;
            } else {
                try{
                    return (AddTicketResponse) validation;
                } catch(Exception e) {
                    throw new IllegalArgumentException(this.CAST_ERR_MSG);
                }
            }
        }
        return null;
    }

    public GetTicketListResponse getTicketList(TicketListRequestType parameter) {
        if (tokens.contains(parameter.getToken())) {
            Object validation = validateRequest(parameter.getRequestId().intValue(), parameter.getToken());
            if (validation == null) {
                List<TicketType> resultTickets = new ArrayList(tickets.values());
                SearchCriteriaType sc = parameter.getSearchCriteria();
                
                if (sc.getType() != null) {
                    Iterator<TicketType> it = resultTickets.iterator();
                    while (it.hasNext()) {
                        TicketType t = it.next();
                        if (!t.getType().value().equals(sc.getType())) {
                            it.remove();
                        }
                    }
                }
                if (sc.getPrice() != null) {
                    Iterator<TicketType> it = resultTickets.iterator();
                    while (it.hasNext()) {
                        TicketType t = it.next();
                        if (t.getPrice() != sc.getPrice()) {
                            it.remove();
                        }
                    }
                }
                if (sc.isStanding() != null) {
                    Iterator<TicketType> it = resultTickets.iterator();
                    while (it.hasNext()) {
                        TicketType t = it.next();
                        if (t.isStanding() != sc.isStanding()) {
                            it.remove();
                        }
                    }
                }
                
                GetTicketListResponse result = new GetTicketListResponse();
                result.setTicket(resultTickets);
                String key = parameter.getToken() + "_" + parameter.getRequestId().intValue();
                requestMap.put(key, result);
                return result;
            } else {
                try{
                    return (GetTicketListResponse) validation;
                } catch(Exception e) {
                    throw new IllegalArgumentException(this.CAST_ERR_MSG);
                }
            }
        }
        return null;
    }

    public GetConcertTicketListResponse getConcertTicketList(GetConcertTicketListRequest parameter) {
        if (tokens.contains(parameter.getToken())) {
            Object validation = validateRequest(parameter.getRequestId().intValue(), parameter.getToken());
            if (validation == null) {
                GetConcertTicketListResponse result = new GetConcertTicketListResponse();
                if (parameter.getConcertId() != null) {
                    int id = parameter.getConcertId().intValue();
                    List<ConcertTicketType> tickets = new ArrayList<>();
                    for(ConcertTicketType ct : this.concertTickets.values()) {
                        if (ct.getConcertId().intValue() == id) {
                            tickets.add(ct);
                        }
                    }
                    result.setConcertTicket(tickets);
                } else {
                    result.setConcertTicket(new ArrayList(this.concertTickets.values()));
                }
                String key = parameter.getToken() + "_" + parameter.getRequestId().intValue();
                requestMap.put(key, result);
                return result;
            } else {
                try{
                    return (GetConcertTicketListResponse) validation;
                } catch(Exception e) {
                    throw new IllegalArgumentException(this.CAST_ERR_MSG);
                }
            }
        }
        return null;
    }

    public AddConcertTicketResponse addConcertTicket(AddConcertTicketRequest parameter) {
        if (tokens.contains(parameter.getToken())) {
            Object validation = validateRequest(parameter.getRequestId().intValue(), parameter.getToken());
            if (validation == null) {
                List<ConcertTicketType> ticketsToAdd = new ArrayList<>();
                for (AddConcertTicketType ct : parameter.getConcertTicket()) {
                    for (int i = 0; i < ct.getQuantity().intValue(); i++) {
                        ConcertTicketType ticket = new ConcertTicketType();
                        ticket.setId(BigInteger.valueOf(nextConcertTicketId));
                        ticket.setTicketId(ct.getTicketId());
                        ticket.setConcertId(ct.getConcertId());
                        ticket.setSold(ct.isSold());
                        concertTickets.put(nextConcertTicketId, ticket);
                        ticketsToAdd.add(ticket);
                        nextConcertTicketId++;
                    }
                }
                AddConcertTicketResponse result = new AddConcertTicketResponse();
                result.setConcertTickets(ticketsToAdd);
                String key = parameter.getToken() + "_" + parameter.getRequestId().intValue();
                requestMap.put(key, result);
                return result;
            } else {
                try{
                    return (AddConcertTicketResponse) validation;
                } catch(Exception e) {
                    throw new IllegalArgumentException(this.CAST_ERR_MSG);
                }
            }
        }
        return null;
    }

    public boolean sellConcertTicket(SellConcertTicketRequest parameter) {
        if (tokens.contains(parameter.getToken())) {
            Object validation = validateRequest(parameter.getRequestId().intValue(), parameter.getToken());
            if (validation == null) {
                String key = parameter.getToken() + "_" + parameter.getRequestId().intValue();
                for (ConcertTicketType ct : this.concertTickets.values()) {
                    if (ct.getId().intValue() == parameter.getConcertTicketId().intValue()) {
                        if (ct.isSold()) {
                            requestMap.put(key, false);   
                            return false;
                        } else {
                            ConcertType concert = concerts.get(ct.getConcertId().intValue());
                            if (concert == null) {
                                requestMap.put(key, false);
                                return false;
                            }
                            int free = concert.getFreeTickets().intValue();
                            concert.setFreeTickets(BigInteger.valueOf(free - 1));
                            ct.setSold(true);
                            requestMap.put(key, true);
                            return true;
                        }
                    }
                }
            } else {
                try{
                    return (boolean) validation;
                } catch(Exception e) {
                    throw new IllegalArgumentException(this.CAST_ERR_MSG);
                }
            }
        }
        return false;
    }
    
    protected Object validateRequest(int requestId, String token) {
        String key = token + "_" + requestId;
        if (requestMap.containsKey(key)) {
            return requestMap.get(key);
        }
        return null;
    }
}