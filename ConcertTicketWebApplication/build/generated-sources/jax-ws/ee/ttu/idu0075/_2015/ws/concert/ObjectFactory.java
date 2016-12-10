
package ee.ttu.idu0075._2015.ws.concert;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ee.ttu.idu0075._2015.ws.concert package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetConcertResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2015/ws/concert", "getConcertResponse");
    private final static QName _GetTicketResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2015/ws/concert", "getTicketResponse");
    private final static QName _GetTicketListRequest_QNAME = new QName("http://www.ttu.ee/idu0075/2015/ws/concert", "getTicketListRequest");
    private final static QName _SellConcertTicketResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2015/ws/concert", "sellConcertTicketResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ee.ttu.idu0075._2015.ws.concert
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetConcertRequest }
     * 
     */
    public GetConcertRequest createGetConcertRequest() {
        return new GetConcertRequest();
    }

    /**
     * Create an instance of {@link ConcertType }
     * 
     */
    public ConcertType createConcertType() {
        return new ConcertType();
    }

    /**
     * Create an instance of {@link AddConcertRequest }
     * 
     */
    public AddConcertRequest createAddConcertRequest() {
        return new AddConcertRequest();
    }

    /**
     * Create an instance of {@link AddConcertType }
     * 
     */
    public AddConcertType createAddConcertType() {
        return new AddConcertType();
    }

    /**
     * Create an instance of {@link AddConcertResponse }
     * 
     */
    public AddConcertResponse createAddConcertResponse() {
        return new AddConcertResponse();
    }

    /**
     * Create an instance of {@link GetConcertListRequest }
     * 
     */
    public GetConcertListRequest createGetConcertListRequest() {
        return new GetConcertListRequest();
    }

    /**
     * Create an instance of {@link GetConcertListResponse }
     * 
     */
    public GetConcertListResponse createGetConcertListResponse() {
        return new GetConcertListResponse();
    }

    /**
     * Create an instance of {@link GetTicketRequest }
     * 
     */
    public GetTicketRequest createGetTicketRequest() {
        return new GetTicketRequest();
    }

    /**
     * Create an instance of {@link TicketType }
     * 
     */
    public TicketType createTicketType() {
        return new TicketType();
    }

    /**
     * Create an instance of {@link AddTicketRequest }
     * 
     */
    public AddTicketRequest createAddTicketRequest() {
        return new AddTicketRequest();
    }

    /**
     * Create an instance of {@link AddTicketType }
     * 
     */
    public AddTicketType createAddTicketType() {
        return new AddTicketType();
    }

    /**
     * Create an instance of {@link AddTicketResponse }
     * 
     */
    public AddTicketResponse createAddTicketResponse() {
        return new AddTicketResponse();
    }

    /**
     * Create an instance of {@link TicketListRequestType }
     * 
     */
    public TicketListRequestType createTicketListRequestType() {
        return new TicketListRequestType();
    }

    /**
     * Create an instance of {@link GetTicketListResponse }
     * 
     */
    public GetTicketListResponse createGetTicketListResponse() {
        return new GetTicketListResponse();
    }

    /**
     * Create an instance of {@link GetConcertTicketListRequest }
     * 
     */
    public GetConcertTicketListRequest createGetConcertTicketListRequest() {
        return new GetConcertTicketListRequest();
    }

    /**
     * Create an instance of {@link GetConcertTicketListResponse }
     * 
     */
    public GetConcertTicketListResponse createGetConcertTicketListResponse() {
        return new GetConcertTicketListResponse();
    }

    /**
     * Create an instance of {@link ConcertTicketType }
     * 
     */
    public ConcertTicketType createConcertTicketType() {
        return new ConcertTicketType();
    }

    /**
     * Create an instance of {@link AddConcertTicketRequest }
     * 
     */
    public AddConcertTicketRequest createAddConcertTicketRequest() {
        return new AddConcertTicketRequest();
    }

    /**
     * Create an instance of {@link AddConcertTicketType }
     * 
     */
    public AddConcertTicketType createAddConcertTicketType() {
        return new AddConcertTicketType();
    }

    /**
     * Create an instance of {@link AddConcertTicketResponse }
     * 
     */
    public AddConcertTicketResponse createAddConcertTicketResponse() {
        return new AddConcertTicketResponse();
    }

    /**
     * Create an instance of {@link SellConcertTicketRequest }
     * 
     */
    public SellConcertTicketRequest createSellConcertTicketRequest() {
        return new SellConcertTicketRequest();
    }

    /**
     * Create an instance of {@link SearchCriteriaType }
     * 
     */
    public SearchCriteriaType createSearchCriteriaType() {
        return new SearchCriteriaType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConcertType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2015/ws/concert", name = "getConcertResponse")
    public JAXBElement<ConcertType> createGetConcertResponse(ConcertType value) {
        return new JAXBElement<ConcertType>(_GetConcertResponse_QNAME, ConcertType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TicketType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2015/ws/concert", name = "getTicketResponse")
    public JAXBElement<TicketType> createGetTicketResponse(TicketType value) {
        return new JAXBElement<TicketType>(_GetTicketResponse_QNAME, TicketType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TicketListRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2015/ws/concert", name = "getTicketListRequest")
    public JAXBElement<TicketListRequestType> createGetTicketListRequest(TicketListRequestType value) {
        return new JAXBElement<TicketListRequestType>(_GetTicketListRequest_QNAME, TicketListRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2015/ws/concert", name = "sellConcertTicketResponse")
    public JAXBElement<Boolean> createSellConcertTicketResponse(Boolean value) {
        return new JAXBElement<Boolean>(_SellConcertTicketResponse_QNAME, Boolean.class, null, value);
    }

}
