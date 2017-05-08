package com.example.weightconverter;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.os.AsyncTask;
import android.util.Log;

public class ConvertWeightTask extends AsyncTask<String, Void, String>{
	
	private final String NAMESPACE = "http://www.webserviceX.NET/";
	private final String URL = "http://www.webservicex.net/ConvertWeight.asmx";
	private final String SOAP_ACTION = "http://www.webserviceX.NET/ConvertWeight";
	private final String METHOD_NAME = "ConvertWeight";
	
	private WeightConverter wa;
	private String weight;
	
	public ConvertWeightTask(WeightConverter wa, String weight) {
		this.wa = wa;
		this.weight = weight;
		System.out.println("Weight = "+weight);
		}
	

	@Override
	protected String doInBackground(String... arg0) {
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		//String weight = "37000";
		String fromUnit = "Grams";
		String toUnit = "Kilograms";
		PropertyInfo weightProp =new PropertyInfo();
		weightProp.setName("Weight");
		weightProp.setType(double.class);
		weightProp.setValue(weight);
		request.addProperty(weightProp);
		PropertyInfo fromProp =new PropertyInfo();
		fromProp.setName("FromUnit");
		fromProp.setType(String.class);
		fromProp.setValue(fromUnit);
		request.addProperty(fromProp);
		
		PropertyInfo toProp =new PropertyInfo();
		toProp.setName("ToUnit");
		toProp.setType(String.class);
		toProp.setValue(toUnit);
		request.addProperty(toProp);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		
		try {
			androidHttpTransport.call(SOAP_ACTION, envelope);
			SoapPrimitive response = (SoapPrimitive)envelope.getResponse();
			Log.i("myApp", response.toString());
			return (weight+" "+fromUnit+" equal "+response.toString()+ " "+toUnit);
			} catch (Exception e) {
			e.printStackTrace();
			}
			return null;
	} 

}
