package xml;
import java.io.File;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.dom4j.ElementPath;
import org.dom4j.io.SAXReader;


public class dom4jElementHandlerTest {

	
	public static void main(String[] args) {
		
		SAXReader saxReader=new SAXReader();
		saxReader.addHandler("/students/student", new StudentHandler());
		
		try {
			saxReader.read(new File("students.xml"));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private static class StudentHandler implements ElementHandler {

		@Override
		public void onEnd(ElementPath path) {
			
			path.removeHandler("name");
		}

		@Override
		public void onStart(ElementPath path) {
			
			Element elt=path.getCurrent();
			System.out.println("Found student  "+ elt.attributeValue("sn"));
			path.addHandler("name", new NameHandler());
				
		}	
		
	}
	
	private static class NameHandler implements ElementHandler {

		@Override
		public void onEnd(ElementPath path) {
			
			Element elt=path.getCurrent();
			System.out.println(elt.getName()+":"+elt.getText());
		}

		@Override
		public void onStart(ElementPath path) {
			
			System.out.println(path.getPath());		
				
		}
	}
}
