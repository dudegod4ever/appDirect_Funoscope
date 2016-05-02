//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.02 à 02:48:25 PM EDT 
//


package funoscope.web.generatedxml.event;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="marketplace"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="baseUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="partner" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="flag" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="creator"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="openId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="uuid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="payload"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="account"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="accountIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="company"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="uuid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="website" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="configuration"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="entry"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
 *                   &lt;element name="order"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="editionCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="pricingDuration" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="item" maxOccurs="unbounded" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *                                       &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
 *         &lt;element name="returnUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "marketplace",
    "flag",
    "creator",
    "payload",
    "returnUrl"
})
@XmlRootElement(name = "event")
public class Event {

    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected Event.Marketplace marketplace;
    @XmlElement(required = true)
    protected String flag;
    @XmlElement(required = true)
    protected Event.Creator creator;
    @XmlElement(required = true)
    protected Event.Payload payload;
    @XmlElement(required = true)
    protected String returnUrl;

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
     * Obtient la valeur de la propriété marketplace.
     * 
     * @return
     *     possible object is
     *     {@link Event.Marketplace }
     *     
     */
    public Event.Marketplace getMarketplace() {
        return marketplace;
    }

    /**
     * Définit la valeur de la propriété marketplace.
     * 
     * @param value
     *     allowed object is
     *     {@link Event.Marketplace }
     *     
     */
    public void setMarketplace(Event.Marketplace value) {
        this.marketplace = value;
    }

    /**
     * Obtient la valeur de la propriété flag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlag() {
        return flag;
    }

    /**
     * Définit la valeur de la propriété flag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlag(String value) {
        this.flag = value;
    }

    /**
     * Obtient la valeur de la propriété creator.
     * 
     * @return
     *     possible object is
     *     {@link Event.Creator }
     *     
     */
    public Event.Creator getCreator() {
        return creator;
    }

    /**
     * Définit la valeur de la propriété creator.
     * 
     * @param value
     *     allowed object is
     *     {@link Event.Creator }
     *     
     */
    public void setCreator(Event.Creator value) {
        this.creator = value;
    }

    /**
     * Obtient la valeur de la propriété payload.
     * 
     * @return
     *     possible object is
     *     {@link Event.Payload }
     *     
     */
    public Event.Payload getPayload() {
        return payload;
    }

    /**
     * Définit la valeur de la propriété payload.
     * 
     * @param value
     *     allowed object is
     *     {@link Event.Payload }
     *     
     */
    public void setPayload(Event.Payload value) {
        this.payload = value;
    }

    /**
     * Obtient la valeur de la propriété returnUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnUrl() {
        return returnUrl;
    }

    /**
     * Définit la valeur de la propriété returnUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnUrl(String value) {
        this.returnUrl = value;
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
     *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="openId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="uuid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
        "email",
        "firstName",
        "language",
        "lastName",
        "openId",
        "uuid"
    })
    public static class Creator {

        @XmlElement(required = true)
        protected String email;
        @XmlElement(required = true)
        protected String firstName;
        @XmlElement(required = true)
        protected String language;
        @XmlElement(required = true)
        protected String lastName;
        @XmlElement(required = true)
        protected String openId;
        @XmlElement(required = true)
        protected String uuid;

        /**
         * Obtient la valeur de la propriété email.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEmail() {
            return email;
        }

        /**
         * Définit la valeur de la propriété email.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEmail(String value) {
            this.email = value;
        }

        /**
         * Obtient la valeur de la propriété firstName.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         * Définit la valeur de la propriété firstName.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFirstName(String value) {
            this.firstName = value;
        }

        /**
         * Obtient la valeur de la propriété language.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLanguage() {
            return language;
        }

        /**
         * Définit la valeur de la propriété language.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLanguage(String value) {
            this.language = value;
        }

        /**
         * Obtient la valeur de la propriété lastName.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLastName() {
            return lastName;
        }

        /**
         * Définit la valeur de la propriété lastName.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLastName(String value) {
            this.lastName = value;
        }

        /**
         * Obtient la valeur de la propriété openId.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOpenId() {
            return openId;
        }

        /**
         * Définit la valeur de la propriété openId.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOpenId(String value) {
            this.openId = value;
        }

        /**
         * Obtient la valeur de la propriété uuid.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUuid() {
            return uuid;
        }

        /**
         * Définit la valeur de la propriété uuid.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUuid(String value) {
            this.uuid = value;
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
     *         &lt;element name="baseUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="partner" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
        "baseUrl",
        "partner"
    })
    public static class Marketplace {

        @XmlElement(required = true)
        protected String baseUrl;
        @XmlElement(required = true)
        protected String partner;

        /**
         * Obtient la valeur de la propriété baseUrl.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBaseUrl() {
            return baseUrl;
        }

        /**
         * Définit la valeur de la propriété baseUrl.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBaseUrl(String value) {
            this.baseUrl = value;
        }

        /**
         * Obtient la valeur de la propriété partner.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPartner() {
            return partner;
        }

        /**
         * Définit la valeur de la propriété partner.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPartner(String value) {
            this.partner = value;
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
     *         &lt;element name="account"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="accountIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="company"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="uuid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="website" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="configuration"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="entry"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
     *         &lt;element name="order"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="editionCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="pricingDuration" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="item" maxOccurs="unbounded" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
     *                             &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
        "account",
        "company",
        "configuration",
        "order"
    })
    public static class Payload {

        @XmlElement(required = true)
        protected Event.Payload.Account account;
        @XmlElement(required = true)
        protected Event.Payload.Company company;
        @XmlElement(required = true)
        protected Event.Payload.Configuration configuration;
        @XmlElement(required = true)
        protected Event.Payload.Order order;

        /**
         * Obtient la valeur de la propriété account.
         * 
         * @return
         *     possible object is
         *     {@link Event.Payload.Account }
         *     
         */
        public Event.Payload.Account getAccount() {
            return account;
        }

        /**
         * Définit la valeur de la propriété account.
         * 
         * @param value
         *     allowed object is
         *     {@link Event.Payload.Account }
         *     
         */
        public void setAccount(Event.Payload.Account value) {
            this.account = value;
        }

        /**
         * Obtient la valeur de la propriété company.
         * 
         * @return
         *     possible object is
         *     {@link Event.Payload.Company }
         *     
         */
        public Event.Payload.Company getCompany() {
            return company;
        }

        /**
         * Définit la valeur de la propriété company.
         * 
         * @param value
         *     allowed object is
         *     {@link Event.Payload.Company }
         *     
         */
        public void setCompany(Event.Payload.Company value) {
            this.company = value;
        }

        /**
         * Obtient la valeur de la propriété configuration.
         * 
         * @return
         *     possible object is
         *     {@link Event.Payload.Configuration }
         *     
         */
        public Event.Payload.Configuration getConfiguration() {
            return configuration;
        }

        /**
         * Définit la valeur de la propriété configuration.
         * 
         * @param value
         *     allowed object is
         *     {@link Event.Payload.Configuration }
         *     
         */
        public void setConfiguration(Event.Payload.Configuration value) {
            this.configuration = value;
        }

        /**
         * Obtient la valeur de la propriété order.
         * 
         * @return
         *     possible object is
         *     {@link Event.Payload.Order }
         *     
         */
        public Event.Payload.Order getOrder() {
            return order;
        }

        /**
         * Définit la valeur de la propriété order.
         * 
         * @param value
         *     allowed object is
         *     {@link Event.Payload.Order }
         *     
         */
        public void setOrder(Event.Payload.Order value) {
            this.order = value;
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
         *         &lt;element name="accountIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
            "accountIdentifier",
            "status"
        })
        public static class Account {

            @XmlElement(required = true)
            protected String accountIdentifier;
            @XmlElement(required = true)
            protected String status;

            /**
             * Obtient la valeur de la propriété accountIdentifier.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAccountIdentifier() {
                return accountIdentifier;
            }

            /**
             * Définit la valeur de la propriété accountIdentifier.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAccountIdentifier(String value) {
                this.accountIdentifier = value;
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
         *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="uuid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="website" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
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
            "country",
            "email",
            "name",
            "phoneNumber",
            "uuid",
            "website"
        })
        public static class Company {

            @XmlElement(required = true)
            protected String country;
            @XmlElement(required = true)
            protected String email;
            @XmlElement(required = true)
            protected String name;
            @XmlElement(required = true)
            protected String phoneNumber;
            @XmlElement(required = true)
            protected String uuid;
            @XmlElement(required = true)
            @XmlSchemaType(name = "anyURI")
            protected String website;

            /**
             * Obtient la valeur de la propriété country.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCountry() {
                return country;
            }

            /**
             * Définit la valeur de la propriété country.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCountry(String value) {
                this.country = value;
            }

            /**
             * Obtient la valeur de la propriété email.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEmail() {
                return email;
            }

            /**
             * Définit la valeur de la propriété email.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEmail(String value) {
                this.email = value;
            }

            /**
             * Obtient la valeur de la propriété name.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Définit la valeur de la propriété name.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Obtient la valeur de la propriété phoneNumber.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPhoneNumber() {
                return phoneNumber;
            }

            /**
             * Définit la valeur de la propriété phoneNumber.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPhoneNumber(String value) {
                this.phoneNumber = value;
            }

            /**
             * Obtient la valeur de la propriété uuid.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUuid() {
                return uuid;
            }

            /**
             * Définit la valeur de la propriété uuid.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUuid(String value) {
                this.uuid = value;
            }

            /**
             * Obtient la valeur de la propriété website.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWebsite() {
                return website;
            }

            /**
             * Définit la valeur de la propriété website.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWebsite(String value) {
                this.website = value;
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
         *         &lt;element name="entry"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
            "entry"
        })
        public static class Configuration {

            @XmlElement(required = true)
            protected Event.Payload.Configuration.Entry entry;

            /**
             * Obtient la valeur de la propriété entry.
             * 
             * @return
             *     possible object is
             *     {@link Event.Payload.Configuration.Entry }
             *     
             */
            public Event.Payload.Configuration.Entry getEntry() {
                return entry;
            }

            /**
             * Définit la valeur de la propriété entry.
             * 
             * @param value
             *     allowed object is
             *     {@link Event.Payload.Configuration.Entry }
             *     
             */
            public void setEntry(Event.Payload.Configuration.Entry value) {
                this.entry = value;
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
             *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
                "key",
                "value"
            })
            public static class Entry {

                @XmlElement(required = true)
                protected String key;
                @XmlElement(required = true)
                protected String value;

                /**
                 * Obtient la valeur de la propriété key.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getKey() {
                    return key;
                }

                /**
                 * Définit la valeur de la propriété key.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setKey(String value) {
                    this.key = value;
                }

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
         *         &lt;element name="editionCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="pricingDuration" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="item" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
         *                   &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
            "editionCode",
            "pricingDuration",
            "item"
        })
        public static class Order {

            @XmlElement(required = true)
            protected String editionCode;
            @XmlElement(required = true)
            protected String pricingDuration;
            protected List<Event.Payload.Order.Item> item;

            /**
             * Obtient la valeur de la propriété editionCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEditionCode() {
                return editionCode;
            }

            /**
             * Définit la valeur de la propriété editionCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEditionCode(String value) {
                this.editionCode = value;
            }

            /**
             * Obtient la valeur de la propriété pricingDuration.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPricingDuration() {
                return pricingDuration;
            }

            /**
             * Définit la valeur de la propriété pricingDuration.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPricingDuration(String value) {
                this.pricingDuration = value;
            }

            /**
             * Gets the value of the item property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the item property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getItem().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Event.Payload.Order.Item }
             * 
             * 
             */
            public List<Event.Payload.Order.Item> getItem() {
                if (item == null) {
                    item = new ArrayList<Event.Payload.Order.Item>();
                }
                return this.item;
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
             *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
             *         &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
                "quantity",
                "unit"
            })
            public static class Item {

                @XmlElement(required = true)
                protected BigInteger quantity;
                @XmlElement(required = true)
                protected String unit;

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

            }

        }

    }

}
