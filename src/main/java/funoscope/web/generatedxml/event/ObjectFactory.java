//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.02 à 03:47:42 PM EDT 
//


package funoscope.web.generatedxml.event;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the funoscope.web.generatedxml.event package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: funoscope.web.generatedxml.event
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Event }
     * 
     */
    public Event createEvent() {
        return new Event();
    }

    /**
     * Create an instance of {@link Event.Payload }
     * 
     */
    public Event.Payload createEventPayload() {
        return new Event.Payload();
    }

    /**
     * Create an instance of {@link Event.Payload.Order }
     * 
     */
    public Event.Payload.Order createEventPayloadOrder() {
        return new Event.Payload.Order();
    }

    /**
     * Create an instance of {@link Event.Payload.Configuration }
     * 
     */
    public Event.Payload.Configuration createEventPayloadConfiguration() {
        return new Event.Payload.Configuration();
    }

    /**
     * Create an instance of {@link Event.Marketplace }
     * 
     */
    public Event.Marketplace createEventMarketplace() {
        return new Event.Marketplace();
    }

    /**
     * Create an instance of {@link Event.Creator }
     * 
     */
    public Event.Creator createEventCreator() {
        return new Event.Creator();
    }

    /**
     * Create an instance of {@link Result }
     * 
     */
    public Result createResult() {
        return new Result();
    }

    /**
     * Create an instance of {@link Event.Payload.Account }
     * 
     */
    public Event.Payload.Account createEventPayloadAccount() {
        return new Event.Payload.Account();
    }

    /**
     * Create an instance of {@link Event.Payload.Company }
     * 
     */
    public Event.Payload.Company createEventPayloadCompany() {
        return new Event.Payload.Company();
    }

    /**
     * Create an instance of {@link Event.Payload.Order.Item }
     * 
     */
    public Event.Payload.Order.Item createEventPayloadOrderItem() {
        return new Event.Payload.Order.Item();
    }

    /**
     * Create an instance of {@link Event.Payload.Configuration.Entry }
     * 
     */
    public Event.Payload.Configuration.Entry createEventPayloadConfigurationEntry() {
        return new Event.Payload.Configuration.Entry();
    }

}
