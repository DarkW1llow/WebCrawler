import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.regex.*;

public class WebCrawler
{
    public static void main(String[] args) throws Exception
    {
        String url = "https://vi.wikipedia.org/wiki/H%C3%A0_N%E1%BB%99i";
        Document document = Jsoup.connect(url).get();

        //String question = document.select("b").text();
        //System.out.println("Question: " + question);

        Elements answered = document.select("p a");
        for (Element answerer : answered)
        {
            System.out.println("Answerer: " + answerer.text());
        }
        String strings = answered.text();


        //System.out.println("Answerer: " + answered.text());
        /*String string = answered.text();
        String[] words = string.split(" ");

        for (String word: words)
        {
            if (word.length() > 0 && Character.isUpperCase(word.charAt(0)))
            {
                //isUp = word.replaceAll()
                System.out.print(word +  " ");
            }
            //System.out.println();
        }*/
    }
}
