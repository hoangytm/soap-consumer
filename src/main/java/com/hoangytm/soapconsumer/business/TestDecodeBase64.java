package com.hoangytm.soapconsumer.business;

import java.io.*;
import java.util.Base64;

/**
 * @author PhanHoang
 * 8/14/2020
 */
public class TestDecodeBase64 {
    public static void main(String[] args) {
        String SIGNATURE_FILE = "C:/Users/Dell/Desktop/signature.txt";
        try {
            FileInputStream fis = new FileInputStream(SIGNATURE_FILE);
            String result = readFromInputStream(fis);
            byte[] fileData = Base64.getDecoder().decode(result);
            FileWriter fstream = new FileWriter("C:/Users/Dell/Desktop/bcy/out.pdf");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
