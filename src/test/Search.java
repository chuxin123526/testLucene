package test;

import java.nio.file.Paths;
import java.util.Date;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Search
{
	public static void main(String[] args) throws Exception
	{
		
		Directory directory = 
				FSDirectory.open(Paths.get("C:\\Users\\Believe\\Desktop\\lucene_index")) ; 
		DirectoryReader directoryReader = DirectoryReader.open(directory);
		Analyzer analyzer = new  StandardAnalyzer() ; 
		QueryParser queryParser = 
				new QueryParser("testContent" ,analyzer) ;
		Query query = queryParser.parse(QueryParser.escape("πÿ”⁄")) ; 
		IndexSearcher indexSearcher = new IndexSearcher(directoryReader) ; 
		Date date = new Date() ; 
		ScoreDoc[] hits = indexSearcher.search(query,10000,new Sort()).scoreDocs ; 
		System.out.println("length:"+hits.length);
		for(ScoreDoc doc : hits)
		{
			Document document = indexSearcher.doc(doc.doc) ; 
			String test = document.get("testContent") ; 
		}
		Date date3 = new Date()  ;
		System.out.println("time:" + (date3.getTime() - date.getTime()) + "∫¡√Î");
		
		
	}
}
