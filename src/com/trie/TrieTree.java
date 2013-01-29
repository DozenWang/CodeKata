package com.trie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class TrieTree {
   private TrieNode rootNode;
   
   
   
   public TrieTree(TrieNode rootNode) {
	super();
	this.rootNode = rootNode;
   }



   public void addChild(String value)
   {
	   TrieNode node=rootNode;
	   for(int i=1;i<=value.length();i++)
	   {
		   String v=value.substring(0,i);
		   TrieNode temp=new TrieNode(v);
		   
		   
		   if(node.containChild(temp))
		   {
			   node=node.getChildTrieNode(temp);
		   }
		   else 
		   {
			  node.addChild(temp);
			  node=temp;
		   }
		   
	   }
	   node.setWordFlag(true);
	 
   }
   
   private 	 TrieNode  findTrieNode(String pre)
	{
		int len=pre.length();
		TrieNode node=rootNode;
		for(int i=0;i<len;i++)
		{
			int index=pre.charAt(i)-'a';
			node=node.getChildTrieNode(index);
		}
		return node;
	}
   
   public void findNodesWithPerfix(String pre)
   {
	   TrieNode node=findTrieNode(pre);
	   tranverse(node);
   }
   
   public void tranverse(TrieNode root)
   {
	   TrieNode node=root;
	   List<TrieNode> result=new ArrayList<TrieNode>();
	   List<TrieNode> list=node.getChildrenList();
	   
	   Queue<TrieNode> queue=new LinkedList<TrieNode>();
	   
	   for (Iterator iterator = list.iterator(); iterator.hasNext();) {
		TrieNode trieNode = (TrieNode) iterator.next();
		queue.add(trieNode);
		
	}
	   while(!queue.isEmpty()) 
	   {
		   TrieNode tempNode=queue.poll();
		   if(tempNode.isWord())
		   {
			   System.out.println(tempNode);
		   }
		   
		   List<TrieNode> tempList=tempNode.getChildrenList();
		   
		   for (Iterator iterator = tempList.iterator(); iterator.hasNext();) {
			TrieNode trieNode = (TrieNode) iterator.next();
			queue.add(trieNode);
			
		}
		   
	   }
		
	
   }
   
   public void tranverseAll()
   {
	  tranverse(rootNode);
   }
}
