package com.BSTtoRS.modify;

public class RightSkew 
{
	private Node start = null;
	
	private Node prev = null;
	
	private class Node
	{
		int value;
		
		Node left;
		
		Node right;
	}
	private Node generate(int v)
	{
		Node temp = new Node();
		
		temp.value = v;
		
		return temp;
	}
	private void RSkew(Node root)
	{
		if(root == null)
		{
			return;
		}
		RSkew(root.left);
		
		if(start == null)
		{
			start = root;
			
			start.left = null;
			
			prev = start;
		}
		else
		{
			prev.right = root;
			
			prev = root;
			
			prev.left = null;
		}
		RSkew(root.right);
	}
	public void displayRSTree()
	{
		if(start == null)
		{
			return;
		}
		System.out.print(start.value + " ");
		
		start = start.right;
		
		displayRSTree();
	}
	public RightSkew()
	{
		Node tree = generate(50);
		
		tree.left = generate(30);
		
		tree.right = generate(60);
		
		tree.left.left = generate(10);
		
		tree.right.left = generate(55);
		
		RSkew(tree);
	}
}
