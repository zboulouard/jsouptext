import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) throws Exception {
		List<String> companies = new ArrayList<String>();
		companies.add("Bayer");
		companies.add("Sygnature Discovery");
		Document doc = Jsoup.connect("http://www.biospace.com/news_subject_all_results.aspx?CatagoryId=40103").get();
		Elements spanTags = doc.getElementsByTag("span");
		for (Element spanTag : spanTags) {
			Elements companyNodes = spanTag.getElementsByTag("b");
			if(companyNodes.size()==0) {
				continue;
			} else {
				if(companies.get(0).equals(companyNodes.get(0).text())) {
					String text = spanTag.ownText();
			        System.out.println(text);
				}
			}
		}
	}
	
}
