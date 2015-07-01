package com.hbd.retrieval.search.manager;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import net.semanticmetadata.lire.DocumentBuilder;
import net.semanticmetadata.lire.ImageSearchHits;
import net.semanticmetadata.lire.ImageSearcher;
import net.semanticmetadata.lire.impl.GenericFastImageSearcher;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.FSDirectory;

import com.hbd.retrieval.common.domain.DocBuilderConfig;
import com.hbd.retrieval.common.util.ApplicationException;
import com.hbd.retrieval.common.util.ConfigManager;
import com.hbd.retrieval.common.util.MapToList;
import com.hbd.retrieval.common.util.UniqueMap;
import com.hbd.retrieval.search.domain.RetrievalResult;

public class SearchManagerImpl implements SearchManager{
	
	
	@Override
	public List<RetrievalResult> getRetrievalResults(String segImgPath,
			String indexPath) {
		File file = new File(segImgPath);
		
		List<RetrievalResult> retrievalResultList = new ArrayList<RetrievalResult>();
		Map<Integer ,String> tempMap = new HashMap<Integer, String>();
		ImageSearchHits hits = null;
		List<DocBuilderConfig> configList = ConfigManager.getConfigList();
		for(Iterator<DocBuilderConfig> iterator = configList.iterator(); iterator.hasNext();){
			DocBuilderConfig builderConfig = iterator.next();
			String builderName = builderConfig.getBuilderName();
			Float weight = builderConfig.getWeight();
			try {
				hits = getSearcherResult(file.getAbsolutePath(), builderName, indexPath);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			float sum = 0f;
			//��һ��
			float[] value=new float[5];
			float[] values=new float[5];
			for (int i = 0; i < hits.length() && i < 5; i++) {
				sum = sum + hits.score(i);
				value[i] = hits.score(i);
			}
			values[0] = value[0];
			for(int i = 1;i<value.length;i++){
				values[i] = values[i-1]+hits.score(i);
			}
		
			for (int i = 0; i < values.length && i <5; i++) {
				String fileName = hits.doc(i).getField(DocumentBuilder.FIELD_NAME_IDENTIFIER).stringValue();
				tempMap.put((int)((1f-weight * values[i]/ sum)*100), fileName);
			}
		}
		Map<Integer, String> resultMap = UniqueMap.removeRepetitionFromMap(tempMap);
		resultMap = UniqueMap.transferToSortedMap(resultMap);
		if(resultMap.containsKey(0)){
			resultMap.remove(0);
		}
		MapToList map_list = new MapToList();
		retrievalResultList = map_list.mapToList(resultMap);
		
		return retrievalResultList;
	}
	
	
	
	public ImageSearchHits getSearcherResult(String segImgPath, String builderName, String indexPath) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		 // Checking if imgPath is there and if it is an image.
       BufferedImage img = null;
       boolean passed = false;
       if (segImgPath.length() > 0) {
           File file = new File(segImgPath);
           if (file.exists()) {
               try {
                   img = ImageIO.read(file);
                   passed = true;
               } catch (IOException e) {
                   e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
               }
           }
       }
       if (!passed) {
           System.out.println("No image given as first argument.");
           System.exit(1);
       }

       IndexReader ir = null;
		try {
			ir = DirectoryReader.open(FSDirectory.open(new File(indexPath)));
		} catch (IOException e1) {
			e1.printStackTrace();
			throw new ApplicationException("No index");
		}
		
		ImageSearcher searcher = null;
		//ͨ��������ƴ���searcher
		Object feature  = Class.forName(builderName).newInstance();
		searcher = new GenericFastImageSearcher(5, feature.getClass());
		
       // searching with a image file ...
		ImageSearchHits hits = null;
		try {
			hits = searcher.search(img, ir);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
       return hits;
	}

}
