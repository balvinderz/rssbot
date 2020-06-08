import com.gargoylesoftware.htmlunit.javascript.NamedNodeMap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.Scanner;
import javax.xml.parsers.*;

public class RssFeedParser {
    static void print(Object  toPrint)
    {
        System.out.println(toPrint.toString());
    }

    public  static  void main(String[] args)
    {
        File f = new File("/Users/balvinder/IdeaProjects/rssbot/src/main/java/feed_example.txt");
        try {
            FileInputStream fis = new FileInputStream(f);
            byte[] data = new byte[(int) f.length()];

            fis.read(data);
            String str = new String(data, "UTF-8");
            //print(str);

            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            ByteArrayInputStream input = new ByteArrayInputStream(
                    str.toString().getBytes("UTF-8"));
            Document doc = builder.parse(input);
            NodeList x = doc.getElementsByTagName("item");
            for(int i =0;i<x.getLength(); i++)
            {
                Node nNode = x.item(i);
                if(nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) nNode;
                   String link =  eElement.getElementsByTagName("link").item(0).getTextContent();
                   String title = eElement.getElementsByTagName("title").item(0).getTextContent();
                   print(title);
                   print(link);
                }

            }
            Element root = doc.getDocumentElement();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }


    }

}
