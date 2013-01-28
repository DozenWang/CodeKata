package com.anagrams;

import com.bloom_filter.BloomFilter;

public class Anagrams {
    public boolean isAnagram(String value)
    {
    	if(value==null) return false;
    	if(value.length()==1) return true;
    	
    	char [] array=value.toCharArray();
    	int start=0;
    	int end=array.length-1;
    	
        while(start<end)
        {
        	
        	if(array[start]==array[end])
        	{              
        	   start++;
        	   end--;
        	}
        	else {
				return false;
			}
        }
        
        return true;
    }
    
    public String reverse(String v)
    {
    	char[] array=v.toCharArray();
    	int start=0,end=array.length-1;
    	char temp;
    	while(start<end)
    	{
    		 temp=array[start];
    		array[start]=array[end];
    		array[end]=temp;
    		
    		start++;
    		end--;
    	}
    	
    	return new String (array);
    }
    
    public boolean findAnagramPair(BloomFilter filter,String value)
    {
    	String temp=reverse(value);
    	 return filter.contain(temp);
    		
    	
    }
} 
