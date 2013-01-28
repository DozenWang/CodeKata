package com.concate_word;

import com.bloom_filter.BloomFilter;

public class ConcateWord {
	private BloomFilter filter;
	
   public ConcateWord(BloomFilter filter) {
		super();
		this.filter = filter;
	}

 public String[] findConcatPair(String value)
 {
	 int len=value.length();
		String[] result=null;
		for(int i=1;i<len;i++)
		{
			String pre=value.substring(0, i);
			String post=value.substring(i);
	
			if(filter.contain(pre)&&filter.contain(post))
			{
			
				result=new String[2];
				result[0]=pre;
				result[1]=post;
				break;
			}
			
		}
		return result;
 }
}
