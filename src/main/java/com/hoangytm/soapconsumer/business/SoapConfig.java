package com.hoangytm.soapconsumer.business;

import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 * @author PhanHoang
 * 8/13/2020
 */
@Component
public class SoapConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        try {
            JAXBContext jb = JAXBContext.newInstance(com.hoangytm.soapconsumer.testFixbug.ObjectFactory.class.getPackage().getName(),
                    com.hoangytm.soapconsumer.testFixbug.ObjectFactory.class.getClassLoader());
            //Jaxb2Marshaller marshaller = (Jaxb2Marshaller) jb.createMarshaller();
            Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
            marshaller.setPackagesToScan("com.hoangytm.soapconsumer.testString");
            //marshaller.setContextPath("com.dxc.service.soap.calc");
            return marshaller;
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public SOAPConnector soapConnector(Jaxb2Marshaller marshaller) {
        SOAPConnector client = new SOAPConnector();
        client.setDefaultUri("http://14.248.82.173:8081/SignPDF.asmx");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
//    @Bean
//    public Jaxb2Marshaller marshaller(){
//        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
//        String[] packagesToScan= {"com.hoangytm.soapconsumer.testFixbug"};
//        jaxb2Marshaller.setPackagesToScan(packagesToScan);
//        return jaxb2Marshaller;
//    }
}
