
package ee.ttu.idu0075._2015.ws.concert;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="concertTicket" type="{http://www.ttu.ee/idu0075/2015/ws/concert}concertTicketType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "concertTicket"
})
@XmlRootElement(name = "getConcertTicketListResponse")
public class GetConcertTicketListResponse {

    protected List<ConcertTicketType> concertTicket;

    /**
     * Gets the value of the concertTicket property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the concertTicket property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConcertTicket().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConcertTicketType }
     * 
     * 
     */
    public List<ConcertTicketType> getConcertTicket() {
        if (concertTicket == null) {
            concertTicket = new ArrayList<ConcertTicketType>();
        }
        return this.concertTicket;
    }

    public void setConcertTicket(List<ConcertTicketType> tickets) {
        this.concertTicket = tickets;
    }

}
