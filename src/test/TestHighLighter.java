package test;

import java.nio.file.Paths;
import java.util.Date;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.TextFragment;
import org.apache.lucene.search.highlight.TokenSources;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class TestHighLighter
{
	public static void main(String[] args) throws Exception
	{
		Date date = new Date() ; 
		Analyzer analyzer = new StandardAnalyzer() ; 
		Directory directory = FSDirectory.open(Paths.get("C:\\Users\\Believe\\Desktop\\lucene_index")) ; 
		DirectoryReader directoryReader = DirectoryReader.open(directory) ; 

		IndexSearcher searcher = new IndexSearcher(directoryReader);
		QueryParser parser = new QueryParser("testContent", analyzer);
		Query query = parser.parse(" ±π‚");

		TopDocs hits = searcher.search(query, 10);

		SimpleHTMLFormatter htmlFormatter = new SimpleHTMLFormatter("<span style = 'color:red'>" , "</span>");
		Highlighter highlighter = new Highlighter(htmlFormatter, new QueryScorer(query));
		for (int i = 0; i < hits.scoreDocs.length; i++)
		{
			int id = hits.scoreDocs[i].doc;
			Document doc = searcher.doc(id);
			String text = doc.get("testContent");
			TokenStream tokenStream = TokenSources.getAnyTokenStream(searcher.getIndexReader(), id, "testContent", analyzer);
			TextFragment[] frag = highlighter.getBestTextFragments(tokenStream, text, false, 10);
			for (int j = 0; j < frag.length; j++)
			{
				if ((frag[j] != null) && (frag[j].getScore() > 0))
				{
					System.out.println((frag[j].toString()));
				}
			}
			
		}
		
		Date date2 = new Date() ; 
		System.out.println("∫ƒ ±£∫" + (date2.getTime() - date.getTime()) + "∫¡√Î");
	}
}
