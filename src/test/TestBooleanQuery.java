package test;

import java.nio.file.Paths;

import javax.management.Query;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class TestBooleanQuery
{
	public static void main(String[] args) throws Exception
	{
		String indexPath = "C:\\Users\\Believe\\Desktop\\lucene_index" ; 
		Directory directory = FSDirectory.open(Paths.get(indexPath)) ; 
		DirectoryReader directoryReader = DirectoryReader.open(directory) ; 
		IndexSearcher indexSearcher = new IndexSearcher(directoryReader) ; 
		BooleanQuery.Builder builder = new BooleanQuery.Builder() ; 
		TermQuery termQuery = new TermQuery(new Term("id" , "1")) ; 
		BooleanClause booleanClause = new BooleanClause(termQuery, Occur.SHOULD) ; 
		builder.add(booleanClause) ; 
		
		TermQuery termQuery2 = new TermQuery(new Term("testContent" , "¹ØÓÚ")) ; 
		BooleanClause booleanClause2 = new BooleanClause(termQuery2, Occur.SHOULD) ; 
		builder.add(booleanClause2) ; 
		
		BooleanQuery booleanQuery = builder.build() ; 
		
		TopDocs topDocs = indexSearcher.search(booleanQuery, 10000) ; 
		ScoreDoc[] scoreDocs = topDocs.scoreDocs ; 
		System.out.println(scoreDocs.length);
		System.out.println("------------end------------");
		
		
		
		
	}
}
