import com.gargoylesoftware.htmlunit.javascript.NamedNodeMap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.*;

public class RssFeedParser {
    static void print(Object  toPrint)
    {
        System.out.println(toPrint.toString());
    }

    public  static  void main(String[] args)
    {
        //File f = new File("/Users/balvinder/IdeaProjects/rssbot/src/main/java/feed_example.txt");
        File f = new File("E:\\rssbot\\src\\main\\java\\feed_example.txt");
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
            ArrayList<RssItem> rssItems = new ArrayList<>();

            for(int i =0;i<x.getLength(); i++)
            {
                Node nNode = x.item(i);
                if(nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) nNode;
                   String link =  eElement.getElementsByTagName("link").item(0).getTextContent();
                   String title = eElement.getElementsByTagName("title").item(0).getTextContent();
                    Pattern typePattern = Pattern.compile("\\(\\w*\\)");
                    Matcher m = typePattern.matcher(title);
                    m.find();
                    Pattern pricePattern  = Pattern.compile("\\$\\d\\.\\d*");
                    Matcher p = pricePattern.matcher(title);
                     p.find();
                    float price = Float.parseFloat(title.substring(p.start()+1,p.end()));
                   String type = title.substring(m.start()+1,m.end()-1);
                   rssItems.add(new RssItem(link,price,type));
                }

            }

            String type = "Edit";
            float min = 0;
            float max =4.5f;

            ArrayList<RssItem> filteredList = filterRssList(type,min,max,rssItems);
            print(rssItems.get(2).type);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static ArrayList<RssItem> filterRssList(String type, float min, float max, ArrayList<RssItem> rssItems) {
        return null;

    }

}
