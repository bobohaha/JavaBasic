package xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SAXPrinter extends DefaultHandler {

	@Override
	public void startDocument() throws SAXException {
		System.out.println("<?xml version=\"1.0\" encoding='UTF-8' ?>");
	}
	
	@Override
	public void processingInstruction(String target, String data)
			throws SAXException {
		System.out.println("<?"+target+" "+data+"?>");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attrs) throws SAXException {

		System.out.print("<"+qName);
		
		int len=attrs.getLength();
		for(int i=0;i<len;i++)
		{
			System.out.print(" ");
			System.out.print(attrs.getQName(i));
			System.out.print("=\"");
			System.out.print(attrs.getValue(i));
			System.out.print("\"");
		}
	
		System.out.print(">");

	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.print(new String(ch,start,length));
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("</"+qName+">");
	}

	

	public static void main(String[] args) {

		SAXParserFactory spf=SAXParserFactory.newInstance();
		
				
		try {
			javax.xml.parsers.SAXParser sp=spf.newSAXParser();
			
			sp.parse(new File("myclasses3.xml"), new SAXPrinter());
			 
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
