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
import com.concate_word.ConcateWord;
import com.trie.TrieNode;
import com.trie.TrieTree;

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
		
//        File file=new File("wordlist .dat");
//        BloomFilter filter= buildFilter(file);
//        ConcateWord finder=new ConcateWord(filter);
//        String[] concateStrings=null;
//        
//        for (Iterator iterator = wordsList.iterator(); iterator.hasNext();) {
//			String value = (String) iterator.next();
//			
//			if((concateStrings=finder.findConcatPair(value))!=null)
//			{
//				System.out.println(concateStrings[0]+"+"+concateStrings[1]+"=>"+value);
//			}
//			
//      
//			
//		}

        String v1="abc";
        String v2="acd";
        String v3="int";
        String v4="inn";
        String v5="aef";
        String v6="acm";
        TrieNode rooTrieNode=new TrieNode("");
        TrieTree tree=new TrieTree(rooTrieNode);
        
        tree.addChild(v1);
        tree.addChild(v2);
        tree.addChild(v3);
        tree.addChild(v4);
        tree.addChild(v5);
        tree.addChild(v6);
        
     //   tree.tranverseAll();
        tree.findNodesWithPerfix("i");
        System.out.println();
	}
	
	

}
