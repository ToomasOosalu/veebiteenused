
package ee.ttu.idu0075._2015.ws.concert;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ticketAreaType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ticketAreaType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="fanzone"/&gt;
 *     &lt;enumeration value="balcony"/&gt;
 *     &lt;enumeration value="regular"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ticketAreaType")
@XmlEnum
public enum TicketAreaType {

    @XmlEnumValue("fanzone")
    FANZONE("fanzone"),
    @XmlEnumValue("balcony")
    BALCONY("balcony"),
    @XmlEnumValue("regular")
    REGULAR("regular");
    private final String value;

    TicketAreaType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TicketAreaType fromValue(String v) {
        for (TicketAreaType c: TicketAreaType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
