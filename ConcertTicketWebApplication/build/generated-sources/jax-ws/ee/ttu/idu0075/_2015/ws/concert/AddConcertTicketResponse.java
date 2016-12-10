
package ee.ttu.idu0075._2015.ws.concert;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="concertTickets" type="{http://www.ttu.ee/idu0075/2015/ws/concert}concertTicketType" maxOccurs="unbounded"/&gt;
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
    "concertTickets"
})
@XmlRootElement(name = "addConcertTicketResponse")
public class AddConcertTicketResponse {

    @XmlElement(required = true)
    protected List<ConcertTicketType> concertTickets;

    /**
     * Gets the value of the concertTickets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the concertTickets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConcertTickets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConcertTicketType }
     * 
     * 
     */
    public List<ConcertTicketType> getConcertTickets() {
        if (concertTickets == null) {
            concertTickets = new ArrayList<ConcertTicketType>();
        }
        return this.concertTickets;
    }

    public void setConcertTickets(List<ConcertTicketType> ticketsToAdd) {
        this.concertTickets = ticketsToAdd;
    }

}
