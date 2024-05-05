package projectmicroservice.projectcrawl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.swing.text.Element;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

@EnableScheduling
@SpringBootApplication
public class ProjectCrawlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectCrawlApplication.class, args);
    }

    // find all list chap
    private ArrayList<Chap> getAllChapInPage(String urls) throws IOException {
        ArrayList<Chap> chaps = new ArrayList<>();
        Document document = Jsoup.connect(urls).get();
        Elements elms = document.getElementsByClass("row");
        for (int i = 0; i < elms.size(); i++) {
            Elements elm_row = elms.get(i).getElementsByTag("a");
            for (int j = 0; j < elm_row.size(); j++) {
                String link_chap = elm_row.first().absUrl("href");
                chaps.add(new Chap(link_chap));
            }
        }

        return chaps;
    }

    // find all image
    private ArrayList<String> listImgOnPage(String pageUrl) throws IOException {
        Document document = Jsoup.connect(pageUrl).get();
        ArrayList<String> list_img = new ArrayList<>();
        Elements elms = document.getElementsByClass("grab-content-chap");
        Elements e = document.getElementsByTag("img");
        for (int i = 0; i < e.size(); i++) {
            String url = e.get(i).absUrl("src");
            if (url.equals("")) {
                continue;
            }
            list_img.add(url);
        }
        return list_img;
    }

    // luu image
    private void saveImg(String src_image, String name, String dir) {
        try {
            URL url = new URL(src_image);
            InputStream in = url.openStream();
            OutputStream out = new BufferedOutputStream(new FileOutputStream(dir + "\\" + name));
            for (int b; (b = in.read()) != -1;) {
                out.write(b);
            }
            out.close();
            in.close();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
