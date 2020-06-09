import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.xml.XmlPage;
import org.apache.http.impl.client.CloseableHttpClient;
import java.io.IOException;

public class RssBot {
    static void print(Object  toPrint)
    {
        System.out.print(toPrint.toString());
    }


    public static void main(String[] args) {

        long startTime = System.nanoTime();

        int count = 0;
        String link ="https://gengo.com/rss/available_jobs/b960e2f373b946308d64688336d03bd05bdbfeddecf00091603459";
        while (count<=10) {
            try {




            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        System.out.println("Execution time in nanoseconds  : " + timeElapsed);

        System.out.println("Execution time in milliseconds : " +
                timeElapsed / 1000000);

    }
}
