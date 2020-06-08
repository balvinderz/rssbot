import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.xml.XmlPage;
import java.io.IOException;

public class RssBot {
    static void print(Object  toPrint)
    {
        System.out.print(toPrint.toString());
    }


    public static void main(String[] args) {
        WebClient webClient = new WebClient();
        // webClient = new WebClient();
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setAppletEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setPopupBlockerEnabled(false);
        webClient.getOptions().setPrintContentOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setTimeout(1000);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setDoNotTrackEnabled(false);
        long startTime = System.nanoTime();

        int count = 0;

        while (true) {
            try {

                XmlPage currentPage = webClient.getPage("https://gengo.com/rss/available_jobs/b960e2f373b946308d64688336d03bd05bdbfeddecf00091603459");

                //print(currentPage.asXml());
                count += 1;
                String xml = currentPage.asXml().toLowerCase();


                if (xml.contains("<item"))
                // print("");
                {
                    print(currentPage.asXml());

                }
                Thread.sleep(100);

            } catch (IOException e) {
                //e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        long endTime = System.nanoTime();
//
//        long timeElapsed = endTime - startTime;
//
//        System.out.println("Execution time in nanoseconds  : " + timeElapsed);
//
//        System.out.println("Execution time in milliseconds : " +
//                timeElapsed / 1000000);

    }
}
