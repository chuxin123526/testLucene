package test;

import java.nio.file.Paths;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.PhraseQuery;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class TestParseQuery
{
	public static void main(String[] args) throws Exception
	{
		String indexPath = "C:\\Users\\Believe\\Desktop\\lucene_index" ; 
		Directory directory = FSDirectory.open(Paths.get(indexPath)) ; 
		DirectoryReader directoryReader = DirectoryReader.open(directory) ; 
		IndexSearcher indexSearcher = new IndexSearcher(directoryReader) ;
		PhraseQuery.Builder builder = new PhraseQuery.Builder() ; 
		builder.add(new Term("testContent", "test") , 1) ; 
		builder.add(new Term("testContent", "Content") , 2) ; 
		builder.setSlop(1) ; 
		PhraseQuery phraseQuery = builder.build() ; 
		TopDocs topDocs = indexSearcher.search(phraseQuery , 10000) ;
		int count = topDocs.totalHits ; 
		System.out.println(count);
		System.out.println("-----------end-----------");
		
		
		
	}
}
