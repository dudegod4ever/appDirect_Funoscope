//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.01 à 10:37:11 PM EDT 
//


package funoscope.web.generatedxml.v1.response;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="company"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="user"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="externalAccountIdentifier" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="product"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *                 &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="maxUsers" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="order"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *                   &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="paymentPlan"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                           &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="frequency" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="totalPrice" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *                   &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="orderLines"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="orderLine"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *                                       &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *                                       &lt;element name="totalPrice" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *                                       &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
    "id",
    "company",
    "user",
    "status",
    "externalAccountIdentifier",
    "product",
    "maxUsers",
    "order"
})
@XmlRootElement(name = "subscription")
public class Subscription {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected Subscription.Company company;
    @XmlElement(required = true)
    protected Subscription.User user;
    @XmlElement(required = true)
    protected String status;
    @XmlElement(required = true)
    protected BigInteger externalAccountIdentifier;
    @XmlElement(required = true)
    protected Subscription.Product product;
    @XmlElement(required = true)
    protected BigInteger maxUsers;
    @XmlElement(required = true)
    protected Subscription.Order order;

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété company.
     * 
     * @return
     *     possible object is
     *     {@link Subscription.Company }
     *     
     */
    public Subscription.Company getCompany() {
        return company;
    }

    /**
     * Définit la valeur de la propriété company.
     * 
     * @param value
     *     allowed object is
     *     {@link Subscription.Company }
     *     
     */
    public void setCompany(Subscription.Company value) {
        this.company = value;
    }

    /**
     * Obtient la valeur de la propriété user.
     * 
     * @return
     *     possible object is
     *     {@link Subscription.User }
     *     
     */
    public Subscription.User getUser() {
        return user;
    }

    /**
     * Définit la valeur de la propriété user.
     * 
     * @param value
     *     allowed object is
     *     {@link Subscription.User }
     *     
     */
    public void setUser(Subscription.User value) {
        this.user = value;
    }

    /**
     * Obtient la valeur de la propriété status.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Définit la valeur de la propriété status.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Obtient la valeur de la propriété externalAccountIdentifier.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getExternalAccountIdentifier() {
        return externalAccountIdentifier;
    }

    /**
     * Définit la valeur de la propriété externalAccountIdentifier.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setExternalAccountIdentifier(BigInteger value) {
        this.externalAccountIdentifier = value;
    }

    /**
     * Obtient la valeur de la propriété product.
     * 
     * @return
     *     possible object is
     *     {@link Subscription.Product }
     *     
     */
    public Subscription.Product getProduct() {
        return product;
    }

    /**
     * Définit la valeur de la propriété product.
     * 
     * @param value
     *     allowed object is
     *     {@link Subscription.Product }
     *     
     */
    public void setProduct(Subscription.Product value) {
        this.product = value;
    }

    /**
     * Obtient la valeur de la propriété maxUsers.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxUsers() {
        return maxUsers;
    }

    /**
     * Définit la valeur de la propriété maxUsers.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxUsers(BigInteger value) {
        this.maxUsers = value;
    }

    /**
     * Obtient la valeur de la propriété order.
     * 
     * @return
     *     possible object is
     *     {@link Subscription.Order }
     *     
     */
    public Subscription.Order getOrder() {
        return order;
    }

    /**
     * Définit la valeur de la propriété order.
     * 
     * @param value
     *     allowed object is
     *     {@link Subscription.Order }
     *     
     */
    public void setOrder(Subscription.Order value) {
        this.order = value;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Company {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "id")
        protected String id;
        @XmlAttribute(name = "href")
        @XmlSchemaType(name = "anyURI")
        protected String href;

        /**
         * Obtient la valeur de la propriété value.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Définit la valeur de la propriété value.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Obtient la valeur de la propriété id.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Définit la valeur de la propriété id.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }

        /**
         * Obtient la valeur de la propriété href.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHref() {
            return href;
        }

        /**
         * Définit la valeur de la propriété href.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHref(String value) {
            this.href = value;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
     *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="paymentPlan"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *                 &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="frequency" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="totalPrice" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
     *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="orderLines"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="orderLine"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
     *                             &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
     *                             &lt;element name="totalPrice" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
     *                             &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
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
        "id",
        "status",
        "paymentPlan",
        "frequency",
        "startDate",
        "endDate",
        "totalPrice",
        "currency",
        "type",
        "orderLines"
    })
    public static class Order {

        @XmlElement(required = true)
        protected BigInteger id;
        @XmlElement(required = true)
        protected String status;
        @XmlElement(required = true)
        protected Subscription.Order.PaymentPlan paymentPlan;
        @XmlElement(required = true)
        protected String frequency;
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar startDate;
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar endDate;
        @XmlElement(required = true)
        protected BigInteger totalPrice;
        @XmlElement(required = true)
        protected String currency;
        @XmlElement(required = true)
        protected String type;
        @XmlElement(required = true)
        protected Subscription.Order.OrderLines orderLines;

        /**
         * Obtient la valeur de la propriété id.
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
         * Définit la valeur de la propriété id.
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
         * Obtient la valeur de la propriété status.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatus() {
            return status;
        }

        /**
         * Définit la valeur de la propriété status.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatus(String value) {
            this.status = value;
        }

        /**
         * Obtient la valeur de la propriété paymentPlan.
         * 
         * @return
         *     possible object is
         *     {@link Subscription.Order.PaymentPlan }
         *     
         */
        public Subscription.Order.PaymentPlan getPaymentPlan() {
            return paymentPlan;
        }

        /**
         * Définit la valeur de la propriété paymentPlan.
         * 
         * @param value
         *     allowed object is
         *     {@link Subscription.Order.PaymentPlan }
         *     
         */
        public void setPaymentPlan(Subscription.Order.PaymentPlan value) {
            this.paymentPlan = value;
        }

        /**
         * Obtient la valeur de la propriété frequency.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFrequency() {
            return frequency;
        }

        /**
         * Définit la valeur de la propriété frequency.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFrequency(String value) {
            this.frequency = value;
        }

        /**
         * Obtient la valeur de la propriété startDate.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getStartDate() {
            return startDate;
        }

        /**
         * Définit la valeur de la propriété startDate.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setStartDate(XMLGregorianCalendar value) {
            this.startDate = value;
        }

        /**
         * Obtient la valeur de la propriété endDate.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEndDate() {
            return endDate;
        }

        /**
         * Définit la valeur de la propriété endDate.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEndDate(XMLGregorianCalendar value) {
            this.endDate = value;
        }

        /**
         * Obtient la valeur de la propriété totalPrice.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTotalPrice() {
            return totalPrice;
        }

        /**
         * Définit la valeur de la propriété totalPrice.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTotalPrice(BigInteger value) {
            this.totalPrice = value;
        }

        /**
         * Obtient la valeur de la propriété currency.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCurrency() {
            return currency;
        }

        /**
         * Définit la valeur de la propriété currency.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCurrency(String value) {
            this.currency = value;
        }

        /**
         * Obtient la valeur de la propriété type.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * Définit la valeur de la propriété type.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

        /**
         * Obtient la valeur de la propriété orderLines.
         * 
         * @return
         *     possible object is
         *     {@link Subscription.Order.OrderLines }
         *     
         */
        public Subscription.Order.OrderLines getOrderLines() {
            return orderLines;
        }

        /**
         * Définit la valeur de la propriété orderLines.
         * 
         * @param value
         *     allowed object is
         *     {@link Subscription.Order.OrderLines }
         *     
         */
        public void setOrderLines(Subscription.Order.OrderLines value) {
            this.orderLines = value;
        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="orderLine"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
         *                   &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
         *                   &lt;element name="totalPrice" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
         *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
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
            "orderLine"
        })
        public static class OrderLines {

            @XmlElement(required = true)
            protected Subscription.Order.OrderLines.OrderLine orderLine;

            /**
             * Obtient la valeur de la propriété orderLine.
             * 
             * @return
             *     possible object is
             *     {@link Subscription.Order.OrderLines.OrderLine }
             *     
             */
            public Subscription.Order.OrderLines.OrderLine getOrderLine() {
                return orderLine;
            }

            /**
             * Définit la valeur de la propriété orderLine.
             * 
             * @param value
             *     allowed object is
             *     {@link Subscription.Order.OrderLines.OrderLine }
             *     
             */
            public void setOrderLine(Subscription.Order.OrderLines.OrderLine value) {
                this.orderLine = value;
            }


            /**
             * <p>Classe Java pour anonymous complex type.
             * 
             * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
             *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
             *         &lt;element name="totalPrice" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
             *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
                "type",
                "unit",
                "price",
                "quantity",
                "totalPrice",
                "description"
            })
            public static class OrderLine {

                @XmlElement(required = true)
                protected String type;
                @XmlElement(required = true)
                protected String unit;
                @XmlElement(required = true)
                protected BigInteger price;
                @XmlElement(required = true)
                protected BigInteger quantity;
                @XmlElement(required = true)
                protected BigInteger totalPrice;
                @XmlElement(required = true)
                protected String description;

                /**
                 * Obtient la valeur de la propriété type.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getType() {
                    return type;
                }

                /**
                 * Définit la valeur de la propriété type.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setType(String value) {
                    this.type = value;
                }

                /**
                 * Obtient la valeur de la propriété unit.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUnit() {
                    return unit;
                }

                /**
                 * Définit la valeur de la propriété unit.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUnit(String value) {
                    this.unit = value;
                }

                /**
                 * Obtient la valeur de la propriété price.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getPrice() {
                    return price;
                }

                /**
                 * Définit la valeur de la propriété price.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setPrice(BigInteger value) {
                    this.price = value;
                }

                /**
                 * Obtient la valeur de la propriété quantity.
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
                 * Définit la valeur de la propriété quantity.
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
                 * Obtient la valeur de la propriété totalPrice.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTotalPrice() {
                    return totalPrice;
                }

                /**
                 * Définit la valeur de la propriété totalPrice.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTotalPrice(BigInteger value) {
                    this.totalPrice = value;
                }

                /**
                 * Obtient la valeur de la propriété description.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDescription() {
                    return description;
                }

                /**
                 * Définit la valeur de la propriété description.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDescription(String value) {
                    this.description = value;
                }

            }

        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
         *       &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class PaymentPlan {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "href")
            protected String href;

            /**
             * Obtient la valeur de la propriété value.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Définit la valeur de la propriété value.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Obtient la valeur de la propriété href.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHref() {
                return href;
            }

            /**
             * Définit la valeur de la propriété href.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHref(String value) {
                this.href = value;
            }

        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
     *       &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Product {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "id")
        protected BigInteger id;
        @XmlAttribute(name = "href")
        protected String href;

        /**
         * Obtient la valeur de la propriété value.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Définit la valeur de la propriété value.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Obtient la valeur de la propriété id.
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
         * Définit la valeur de la propriété id.
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
         * Obtient la valeur de la propriété href.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHref() {
            return href;
        }

        /**
         * Définit la valeur de la propriété href.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHref(String value) {
            this.href = value;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class User {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "id")
        protected String id;
        @XmlAttribute(name = "href")
        @XmlSchemaType(name = "anyURI")
        protected String href;

        /**
         * Obtient la valeur de la propriété value.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Définit la valeur de la propriété value.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Obtient la valeur de la propriété id.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Définit la valeur de la propriété id.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }

        /**
         * Obtient la valeur de la propriété href.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHref() {
            return href;
        }

        /**
         * Définit la valeur de la propriété href.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHref(String value) {
            this.href = value;
        }

    }

}
