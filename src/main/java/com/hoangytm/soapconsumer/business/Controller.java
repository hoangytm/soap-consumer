package com.hoangytm.soapconsumer.business;

//import com.hoangytm.soapconsumer.testString.InputSOATest;
//import com.hoangytm.soapconsumer.testString.OutputSOATest;

import com.hoangytm.soapconsumer.testFixbug.Add;
import com.hoangytm.soapconsumer.testFixbug.AddResponse;
import com.hoangytm.soapconsumer.testString.Sign;
import com.hoangytm.soapconsumer.testString.SignResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author PhanHoang
 * 8/13/2020
 */
@RestController
public class Controller {

    @Autowired
    private Jaxb2Marshaller jaxb2Marshaller;
    private WebServiceTemplate webServiceTemplate;
    @Autowired
    private SOAPConnector soapConnector;
    public static String IMAGE_PATH = "C:\\Users\\Dell\\Desktop\\bcy-asset\\image.JPG";
    public static String FILE_PDF_PATH = "C:\\Users\\Dell\\Desktop\\bcy-asset\\maukiso.pdf";
    public static String PHONE_NUMBER = "84704038208";
    public static String TSA = "http://tsa.ca.gov.vn";
    public static String URI_SOAP = "http://14.248.82.173:8081/SignPDF.asmx";
    public static String TEST_FIX_BUG_URL = "http://www.dneonline.com/calculator.asmx";

    @GetMapping("/bcy")
    public SignResponse signDocBcySign() throws IOException {
        byte[] fileToSign = Files.readAllBytes(Paths.get(FILE_PDF_PATH));
        byte[] imageSignature = Files.readAllBytes(Paths.get(IMAGE_PATH));
        Sign sign = new Sign();
        sign.setInPdf(fileToSign);
        sign.setMessageToBeDisplayed("nothing to sign");
        sign.setPhone(PHONE_NUMBER);
        sign.setSignerName("Ha Vien Duong");
        sign.setImgBuff(imageSignature);
        sign.setHeight(10);
        sign.setWidth(10);
        sign.setTsaUrl(TSA);
        webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
//        SignResponse result = (SignResponse) webServiceTemplate.marshalSendAndReceive(URI_SOAP, sign);
        SignResponse result = (SignResponse) soapConnector.callWebService(sign, "http://ca.gov.vn/Sign");
        return result;
    }

    @GetMapping("/test-fixbug")
    public void testFixBug() {
        webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
        Add add = new Add();
        add.setIntA(10);
        add.setIntB(20);
//        AddResponse result = (AddResponse) webServiceTemplate.marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", add);
        AddResponse result = (AddResponse) soapConnector.callWebService(add, "http://tempuri.org/Add");
        System.out.println(result);
    }
}
