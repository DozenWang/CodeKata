package com.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.anagrams.Anagrams;
import com.bloom_filter.BloomFilter;

public class Test {
	//private static BloomFilter filter=new BloomFilter();
	private static Anagrams anagrams=new Anagrams();
	private static List<String> wordsList=new ArrayList<String> ();
	
  	private static BloomFilter buildFilter(File file) throws IOException
	{
  		    BloomFilter filter=new BloomFilter();
		    BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
	        String string=null;
	        while((string=bufferedReader.readLine())!=null)
	        {
//	        	if(anagrams.isAnagram(string))
//	        	 System.out.println(string);
	        	filter.add(string);
	        	
	            wordsList.add(string);
	        	
	        }
	        
	
	    
	        
	        return filter;
	}
	

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stu
		
        File file=new File("wordlist .dat");
        BloomFilter filter= buildFilter(file);
        
        for (Iterator iterator = wordsList.iterator(); iterator.hasNext();) {
			String value = (String) iterator.next();
	//		System.out.println(value);
			if(anagrams.findAnagramPair(filter, value))
	        {
	        	System.out.println(value+","+anagrams.reverse(value));
	        }
			
		}
//        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
//        String string=null;
//        while((string=bufferedReader.readLine())!=null)
//        {
////        	if(anagrams.isAnagram(string))
////        	 System.out.println(string);
//        	if(anagrams.findAnagramPair(filter, string))
//        	{
//        		System.out.println(string+","+anagrams.reverse(string));
//        	}
//
//        	
//        }
        
	}

}