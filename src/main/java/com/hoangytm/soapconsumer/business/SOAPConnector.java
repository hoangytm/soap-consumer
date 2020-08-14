package com.hoangytm.soapconsumer.business;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * @author PhanHoang
 * 8/14/2020
 */
public class SOAPConnector extends WebServiceGatewaySupport {

//    public Object callWebService(String url, Object request){
//        return getWebServiceTemplate().marshalSendAndReceive(url, request);
//    }
    public Object callWebService(Object request, String soapAction){
//        String url= "http://www.dneonline.com/calculator.asmx";
        return getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(soapAction));
    }
}

