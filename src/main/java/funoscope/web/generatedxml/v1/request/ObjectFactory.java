//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.04.30 à 07:35:11 PM EDT 
//


package funoscope.web.generatedxml.v1.request;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the funoscope.web.generatedxml.v1.request package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: funoscope.web.generatedxml.v1.request
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Subscription }
     * 
     */
    public Subscription createSubscription() {
        return new Subscription();
    }

    /**
     * Create an instance of {@link Subscription.Order }
     * 
     */
    public Subscription.Order createSubscriptionOrder() {
        return new Subscription.Order();
    }

    /**
     * Create an instance of {@link Subscription.Order.OrderLines }
     * 
     */
    public Subscription.Order.OrderLines createSubscriptionOrderOrderLines() {
        return new Subscription.Order.OrderLines();
    }

    /**
     * Create an instance of {@link Subscription.Order.OrderLines.OrderLine }
     * 
     */
    public Subscription.Order.OrderLines.OrderLine createSubscriptionOrderOrderLinesOrderLine() {
        return new Subscription.Order.OrderLines.OrderLine();
    }

}
