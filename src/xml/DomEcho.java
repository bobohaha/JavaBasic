package xml;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DomEcho
{
  public void parseAndPrint()
  {
    Document doc = null;
    try{
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      doc = db.parse("bib.xml");
      if (doc != null)
        printDomTree(doc);
    }catch (Exception e){System.err.println("An error occurred: " + e);}
  }

  /* 以递归的方式打印出节点的内容*/
  public void printDomTree(Node node) 
  {
    int type = node.getNodeType();
    switch (type)
    {
      case Node.DOCUMENT_NODE: 
        {
          System.out.println("<?xml version=\"1.0\" ?>");
          printDomTree(((Document)node).getDocumentElement());
          break;
        }
      case Node.ELEMENT_NODE: 
        {
          System.out.print("<");
          System.out.print(node.getNodeName());
          NamedNodeMap attrs = node.getAttributes();
          for (int i = 0; i < attrs.getLength(); i++)
            printDomTree(attrs.item(i));
          System.out.print(">");
          NodeList children = node.getChildNodes();
          if (children != null)
          {
            int len = children.getLength();
            for (int i = 0; i < len; i++)
              printDomTree(children.item(i));
          }
          System.out.print("</");
          System.out.print(node.getNodeName());
          System.out.print('>');
          break;
        }
      case Node.ATTRIBUTE_NODE:
        {
          String value = ((Attr)node).getValue();
          System.out.print(" " + node.getNodeName() + 
                           "=\"" + value + "\"");
          break;
        }
      case Node.ENTITY_REFERENCE_NODE: 
        {
          System.out.print("&");
          System.out.print(node.getNodeName());
          System.out.print(";");
          break;
        }
      case Node.CDATA_SECTION_NODE: 
        {
          System.out.print("<![CDATA[");
          System.out.print(node.getNodeValue());
          System.out.print("]]>");
          break;
        }
      case Node.TEXT_NODE: 
        {
          System.out.print(node.getNodeValue());
          break;
        }
      case Node.PROCESSING_INSTRUCTION_NODE: 
        {
          System.out.print("<?");
          System.out.print(node.getNodeName());
          System.out.print(" ");
          System.out.print(node.getNodeValue());
          System.out.print("?>");
          break;
        }
      case Node.COMMENT_NODE:
      {
        System.out.print("<!-- ");
        System.out.print(node.getNodeValue());
        System.out.print("-->");
      }
    }
  }

  public static void main(String argv[]) 
  {
    DomEcho echo = new DomEcho();
    echo.parseAndPrint();
  }
}
