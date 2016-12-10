
package ee.ttu.idu0075._2015.ws.concert;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addConcertTicketType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addConcertTicketType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ticketId" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="concertId" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="sold" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addConcertTicketType", propOrder = {
    "ticketId",
    "concertId",
    "quantity",
    "sold"
})
public class AddConcertTicketType {

    @XmlElement(required = true)
    protected BigInteger ticketId;
    @XmlElement(required = true)
    protected BigInteger concertId;
    @XmlElement(required = true)
    protected BigInteger quantity;
    protected boolean sold;

    /**
     * Gets the value of the ticketId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTicketId() {
        return ticketId;
    }

    /**
     * Sets the value of the ticketId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTicketId(BigInteger value) {
        this.ticketId = value;
    }

    /**
     * Gets the value of the concertId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getConcertId() {
        return concertId;
    }

    /**
     * Sets the value of the concertId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setConcertId(BigInteger value) {
        this.concertId = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQuantity(BigInteger value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the sold property.
     * 
     */
    public boolean isSold() {
        return sold;
    }

    /**
     * Sets the value of the sold property.
     * 
     */
    public void setSold(boolean value) {
        this.sold = value;
    }

}
