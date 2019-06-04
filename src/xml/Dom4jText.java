package xml;


import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;




public class Dom4jText {

	
	public static void main(String[] args) {
		
		Document doc=DocumentHelper.createDocument();
		Element root=DocumentHelper.createElement("students");
		doc.setRootElement(root);
		
		Element eltStu1=root.addElement("student");
		Element eltName1=eltStu1.addElement("name");
		Element eltAge1=eltStu1.addElement("age");
		eltName1.setText("张三");
		eltAge1.setText("18");
		
		Element eltStu2=root.addElement("student");
		Element eltName2=eltStu2.addElement("name");
		Element eltAge2=eltStu2.addElement("age");
		eltName2.setText("李四");
		eltAge2.setText("20");
		
		//PrintWriter pw=new PrintWriter(System.out);
		OutputFormat outFmt=new OutputFormat("    ", true, "gb2312");
		try {
			//doc.write(pw);
			//pw.close();
			XMLWriter xmlw=new XMLWriter(new FileWriter("dom4jTest.xml"), outFmt);
			xmlw.write(doc);					
			xmlw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
