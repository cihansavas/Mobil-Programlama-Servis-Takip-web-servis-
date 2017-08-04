package com.example.cihan_sf2ak5t.mobilservis;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Created by Hakan on 30.12.2016.
 */

public class CallSoap {

    public String Guncelle(String id,String durum,String yorum)
    {
        String result=null;
        String SOAP_ACTION="http://tempuri.org/Guncelle";
        String OPERATION_NAME="Guncelle";
        String WSDL_TARGET_NAMESPACE="http://tempuri.org/";

        String SOAP_ADDRESS="http://hakan.ysmyazilim.com/Service1.asmx";

        SoapObject soapObject;
        SoapSerializationEnvelope soapSerializationEnvelope;
        HttpTransportSE httpTransportSE;

        soapObject=new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
        soapObject.addProperty("id",id);
        soapObject.addProperty("durum",durum);
        soapObject.addProperty("yorum",yorum);

        soapSerializationEnvelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapSerializationEnvelope.dotNet=true;
        soapSerializationEnvelope.setOutputSoapObject(soapObject);

        httpTransportSE=new HttpTransportSE(SOAP_ADDRESS);
        httpTransportSE.debug=true;
        try {
            httpTransportSE.call(SOAP_ACTION,soapSerializationEnvelope);
            SoapPrimitive soapPrimitive=(SoapPrimitive)soapSerializationEnvelope.getResponse();
            result=soapPrimitive.toString();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return result;

    }

    public String StringVeri()
    {
        String result=null;
        String SOAP_ACTION="http://tempuri.org/StringVeri";
        String OPERATION_NAME="StringVeri";
        String WSDL_TARGET_NAMESPACE="http://tempuri.org/";

        String SOAP_ADDRESS="http://hakan.ysmyazilim.com/Service1.asmx";

        SoapObject soapObject;
        SoapSerializationEnvelope soapSerializationEnvelope;
        HttpTransportSE httpTransportSE;

        soapObject=new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
        //soapObject.addProperty("id",id);
        //soapObject.addProperty("durum",durum);
        //soapObject.addProperty("yorum",yorum);

        soapSerializationEnvelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapSerializationEnvelope.dotNet=true;
        soapSerializationEnvelope.setOutputSoapObject(soapObject);

        httpTransportSE=new HttpTransportSE(SOAP_ADDRESS);
        httpTransportSE.debug=true;
        try {
            httpTransportSE.call(SOAP_ACTION,soapSerializationEnvelope);
            SoapPrimitive soapPrimitive=(SoapPrimitive)soapSerializationEnvelope.getResponse();
            result=soapPrimitive.toString();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return result;

    }


}
