//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.08.13 at 05:42:42 PM ICT 
//


package com.hoangytm.soapconsumer.bindings;

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
 *         &lt;element name="SignLocResult" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
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
    "signLocResult"
})
@XmlRootElement(name = "SignLocResponse")
public class SignLocResponse {

    @XmlElement(name = "SignLocResult")
    protected byte[] signLocResult;

    /**
     * Gets the value of the signLocResult property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getSignLocResult() {
        return signLocResult;
    }

    /**
     * Sets the value of the signLocResult property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setSignLocResult(byte[] value) {
        this.signLocResult = value;
    }

}
