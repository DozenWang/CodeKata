package com.trie;

import java.util.ArrayList;
import java.util.List;


public class TrieNode {

    private  String  data;
    private  TrieNode[] children;
    
    private boolean wordFlag;
    
	public TrieNode(String data) {
		super();
		this.data = data;
		this.children = new TrieNode[26];
		this.wordFlag=false;
	}
	
	public int getNodeIndexForParent()
	{
		return data.charAt(data.length()-1)-'a';
	}
	
	public void addChild(TrieNode node)
	{
	
		int index=node.getNodeIndexForParent();
		children[index]=node;
	}
	public boolean containChild(TrieNode node)
	{
		int index=node.getNodeIndexForParent();
		
		return children[index]!=null  ;
		 
			
	}
	
	public TrieNode getChildTrieNode(TrieNode o)
	{
	   int index=o.getNodeIndexForParent();
	   return	children[index];
	}
	public TrieNode getChildTrieNode (int index)
	{
		return children[index];
	}
	
	public void setWordFlag(boolean f)
	{
		this.wordFlag=f;
	}
	public boolean isWord()
	{
		return wordFlag;
	}
	
	public List<TrieNode>  getChildrenList()
	{
		List<TrieNode> list=new ArrayList<TrieNode>(26);
		for(int i=0;i<26;i++)
		{
			if(children[i]!=null) list.add(children[i]);
		}
		
		return list;
	}
    
   

	@Override
	public String toString() {
		return "TrieNode [data=" + data + "]";
	}
	
	
    
    
}
