
package ee.ttu.idu0075._2015.ws.concert;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ticketType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ticketType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="type" type="{http://www.ttu.ee/idu0075/2015/ws/concert}ticketAreaType"/&gt;
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="standing" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ticketType", propOrder = {
    "id",
    "type",
    "price",
    "standing"
})
public class TicketType {

    @XmlElement(required = true)
    protected BigInteger id;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TicketAreaType type;
    @XmlElement(required = true)
    protected BigDecimal price;
    protected boolean standing;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link TicketAreaType }
     *     
     */
    public TicketAreaType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link TicketAreaType }
     *     
     */
    public void setType(TicketAreaType value) {
        this.type = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the standing property.
     * 
     */
    public boolean isStanding() {
        return standing;
    }

    /**
     * Sets the value of the standing property.
     * 
     */
    public void setStanding(boolean value) {
        this.standing = value;
    }

}
