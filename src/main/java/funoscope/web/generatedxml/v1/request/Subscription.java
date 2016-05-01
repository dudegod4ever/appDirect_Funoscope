//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.04.30 à 07:35:11 PM EDT 
//


package funoscope.web.generatedxml.v1.request;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="order"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="paymentPlanId" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *                   &lt;element name="discountId" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
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
 *                                       &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
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
    "order"
})
@XmlRootElement(name = "subscription")
public class Subscription {

    @XmlElement(required = true)
    protected Subscription.Order order;

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
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="paymentPlanId" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
     *         &lt;element name="discountId" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
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
     *                             &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
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
        "paymentPlanId",
        "discountId",
        "orderLines"
    })
    public static class Order {

        @XmlElement(required = true)
        protected BigInteger paymentPlanId;
        @XmlElement(required = true)
        protected BigInteger discountId;
        @XmlElement(required = true)
        protected Subscription.Order.OrderLines orderLines;

        /**
         * Obtient la valeur de la propriété paymentPlanId.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getPaymentPlanId() {
            return paymentPlanId;
        }

        /**
         * Définit la valeur de la propriété paymentPlanId.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setPaymentPlanId(BigInteger value) {
            this.paymentPlanId = value;
        }

        /**
         * Obtient la valeur de la propriété discountId.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getDiscountId() {
            return discountId;
        }

        /**
         * Définit la valeur de la propriété discountId.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setDiscountId(BigInteger value) {
            this.discountId = value;
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
         *                   &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
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
             *         &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
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
                "unit",
                "quantity"
            })
            public static class OrderLine {

                @XmlElement(required = true)
                protected String unit;
                @XmlElement(required = true)
                protected BigInteger quantity;

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

            }

        }

    }

}
