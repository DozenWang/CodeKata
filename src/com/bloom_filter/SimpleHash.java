package com.bloom_filter;

public class SimpleHash {
    private int capacity;
    private int seed;
	public SimpleHash(int cap, int seed) {
		super();
		this.capacity = cap;
		this.seed = seed;
	}
    
    public int hash(String value)
    {
    	int reslut=0;
    	int len=value.length();
    	
    	for(int i=0;i<len;i++)
    	{
    		reslut=seed*reslut+value.charAt(i);
    	}
    	
    	return reslut&(capacity-1);
    }
}
