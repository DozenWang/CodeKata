package com.bloom_filter;

import java.util.BitSet;

public class BloomFilter {
	private final int DEFAULT_SIZE=1<<16;
    private  BitSet bitSet;
    private int[] seeds={3,7,11,13,37,41,57,77};
    private SimpleHash[] hashs=new SimpleHash[seeds.length];
    
	public BloomFilter() {
		super();
		bitSet=new BitSet(DEFAULT_SIZE);
		for(int i=0;i<seeds.length;i++)
		{
			hashs[i]=new SimpleHash(DEFAULT_SIZE, seeds[i]);
		}
	}
	
	public void add(String value)
	{
		
		for(SimpleHash f:hashs)
		{
			bitSet.set(f.hash(value),true);
		}
	}
	public boolean contain(String value)
	{
		if(value==null)
		{
			return false;
		}
		
		boolean ret=true;
		for(SimpleHash f:hashs)
		{
		  ret=ret&&bitSet.get(f.hash(value));
		
		}
		
		return ret;
	}
    
}
