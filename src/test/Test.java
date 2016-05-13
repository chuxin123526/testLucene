package test;

import java.nio.file.Paths;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Test
{
	public static void main(String[] args) throws Exception
	{
		IndexWriter indexWriter = null ; 
		for(int i = 0 ; i < 10 ; i++)
		{
			//����������
			StandardAnalyzer analyzer = new StandardAnalyzer() ; 
			//
			Directory directory = FSDirectory.open(Paths.get("C:\\Users\\Believe\\Desktop\\lucene_index")) ;  
			//д����������
			IndexWriterConfig config = new IndexWriterConfig(analyzer) ; 
			//����д�����
			indexWriter = new IndexWriter(directory, config) ;
			//�ĵ�����
			Document document = new Document() ; 
			//content
			String content = "testContent" ; 
			document.add(new Field("test Content", content, TextField.TYPE_STORED));
			document.add(new Field("id" , i+"" , TextField.TYPE_STORED));
			//add index
			indexWriter.addDocument(document);
			indexWriter.close();  
			System.out.println(i);
		}
		
		
		
	}
	
	
}
