
package xml;

import java.io.File;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.VisitorSupport;
import org.dom4j.io.SAXReader;


public class VisitorTest {

	
	public static void main(String[] args) {
		SAXReader saxReader=new SAXReader();
		try {
			Document doc=saxReader.read(new File("myclasses3.xml"));
			doc.accept(new MyVisitor());
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	private static class MyVisitor extends VisitorSupport{

		@Override
		public void visit(Attribute node) {
			System.out.println("Attribute:"+node.getName()+"="+node.getValue());
		}

		@Override
		public void visit(Element node) {
			if (node.isTextOnly())
			{
				System.out.println("Element:"+node.getName()+"  "+node.getText());
			}
			else
			{
				System.out.println("-----------"+node.getName()+"-------------");
			}
		}
		
	}
	
}
