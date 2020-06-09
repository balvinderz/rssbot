//import com.gargoylesoftware.css.parser.CSSErrorHandler;
//import com.gargoylesoftware.css.parser.CSSException;
//import com.gargoylesoftware.css.parser.CSSParseException;
//import com.gargoylesoftware.htmlunit.*;
//import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
//import com.gargoylesoftware.htmlunit.html.HtmlButton;
//import com.gargoylesoftware.htmlunit.html.HtmlPage;
//import com.gargoylesoftware.htmlunit.html.parser.HTMLParserListener;
//import com.gargoylesoftware.htmlunit.javascript.JavaScriptErrorListener;
//import com.gargoylesoftware.htmlunit.util.Cookie;
//import org.xml.sax.ErrorHandler;
//import org.xml.sax.SAXException;
//import org.xml.sax.SAXParseException;
//
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.logging.Level;
//
//public class GengoHtmlUnit {
//    static void print(Object  toPrint)
//    {
//        System.out.println(toPrint.toString());
//    }
//    public static void main(String args[]){
//
//        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
//        java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);
//        final BrowserVersion browser =
//                new BrowserVersion.BrowserVersionBuilder(BrowserVersion.CHROME)
//                        .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36")
//                        .build();
//        WebClient webClient = new WebClient(BrowserVersion.BEST_SUPPORTED);
//        CookieManager cookieManager = webClient.getCookieManager();
//
//        webClient.getOptions().setJavaScriptEnabled(true);
////        webClient.getOptions().setActiveXNative(false);
////        webClient.getOptions().setAppletEnabled(false);
//       webClient.getOptions().setCssEnabled(false);
////        webClient.getOptions().setPopupBlockerEnabled(false);
//        webClient.getOptions().setPrintContentOnFailingStatusCode(false);
//        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
//        webClient.getOptions().setThrowExceptionOnScriptError(false);
//        webClient.getOptions().setTimeout(10000);
//        webClient.getOptions().setThrowExceptionOnScriptError(false);
//        webClient.getOptions().setDoNotTrackEnabled(false);
//        cookieManager.clearCookies();
//        cookieManager.addCookie(new Cookie("https://gengo.com/","myG_myGSession_","610520f34d56769ba3096bfbaee659934c8cad14"));
//
//        String link = "https://gengo.com/auth/form/login/";
//
//        try {
//            webClient.getPage(link);
//
//
//            String url = webClient.getCurrentWindow().getEnclosedPage().getUrl().toString();
//            print(url);
//
//
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
