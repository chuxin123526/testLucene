package test;

import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class TestDeleteDocument
{
	public static void main(String[] args) throws Exception
	{
		Analyzer analyzer = new StandardAnalyzer() ; 
		Directory directory = FSDirectory.open(Paths.get("C:\\Users\\Believe\\Desktop\\lucene_index")) ; 
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer) ; 
		IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig) ;
		indexWriter.deleteDocuments(new Term("id", "1"));
		
		indexWriter.close();
	}
}
