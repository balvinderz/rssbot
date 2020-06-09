import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.xml.XmlPage;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;

public class RssBot {
    static void print(Object  toPrint)
    {
        System.out.println(toPrint.toString());
    }


    public static void main(String[] args) throws InterruptedException {
       //  final OkHttpClient httpClient = new OkHttpClient();




        ArrayList<MyThread> myThreads = new ArrayList<>();
        long startTime = System.nanoTime();

        myThreads.add(new MyThread("One"));
        Thread.sleep(100);
        myThreads.add(new MyThread("Two"));
        Thread.sleep(100);
        myThreads.add(new MyThread("Three"));
        Thread.sleep(100);
        myThreads.add(new MyThread("Four"));
        while(true) {
            int deadCount =0;

            for (int i = 0; i < myThreads.size(); i++) {

                if (!myThreads.get(i).isAlive())
                deadCount+=1;


            }
            if(deadCount == myThreads.size())
                break;

        }
        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        System.out.println("Execution time in nanoseconds  : " + timeElapsed);

        System.out.println("Execution time in seconds : " +
                timeElapsed / (1000000*1000));

    }

}

 class MyThread extends Thread {
    static void print(Object  toPrint)
    {
        System.out.println(toPrint.toString());
    }
    String name;
    Thread t;

    MyThread(String thread) {
        name = thread;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        t.start();
    }

    public void run() {
        int count = 0;

        while(true) {
            try {
                final OkHttpClient httpClient = new OkHttpClient();

                String link = "https://gengo.com/rss/available_jobs/02f796b298216882e91ae206ad3b48f656bead633ef11436012915";
                Request request = new Request.Builder()
                        .url(link)
                        .build();
                Call call = httpClient.newCall(request);
                Response response = call.execute();
                String res = response.body().string();
                count+=1;
               // print(res);

               print("Executed " + name+":"+count );

                if(res.contains("<item")) {
                   List<RssItem> items =  RssFeedParser.parse(res);
                  print("Name : " +name +" " + items.size() );

                }
                Thread.sleep(100);
            } catch (Exception e) {

                System.out.println(name + "Interrupted");
                break;

            }
        }
    }
}