//RJ Allen
public class LinkedBST <T extends Comparable<T>>
{
	private class Node
	{
		T data;
		Node leftChild;
		Node rightChild;
		public Node(T aData)
		{
			data = aData;
			leftChild = rightChild = null;
		}
	}
	private Node root;//Head
	public LinkedBST()
	{
		root = null;
	}
	public void add(T aData)
	{
		if(root == null)
			root = new Node(aData);
		else
			add(root, aData);
	}
	private Node add(Node aNode, T aData)
	{
		if(aNode == null)//Leaf
			aNode = new Node(aData);
		else if(aData.compareTo(aNode.data)<0)//GO LEFT
			aNode.leftChild = add(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data)>0)//GO RIGHT
			aNode.rightChild = add(aNode.rightChild,aData);
		return aNode;
	}
	public void printPreorder()
	{
		printPreorder(root);
	}
	private void printPreorder(Node aNode)
	{
		if(aNode == null)
			return;
		System.out.println(aNode.data);//PROCESS
		printPreorder(aNode.leftChild);//LEFT
		printPreorder(aNode.rightChild);//RIGHT
	}
	public void printInorder()
	{
		printInorder(root);
	}
	private void printInorder(Node aNode)
	{
		if(aNode == null)
			return;
		
		printInorder(aNode.leftChild);//LEFT
		System.out.println(aNode.data);//PROCESS
		printInorder(aNode.rightChild);//RIGHT
	}
	public boolean search(T aData)
	{
		return search(root, aData);
	}
	private boolean search(Node aNode, T aData)
	{
		if(aNode == null)//leaf
			return false;
		else if(aData.compareTo(aNode.data)<0)//go left
			return search(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data)>0)
			return search(aNode.rightChild,aData);
		else
			return true;
	}
	public void remove(T aData)
	{
		root = remove(root, aData);
	}
	private Node remove(Node aNode, T aData)
	{
		//Search
		if(aNode == null)//leaf value was not found
			return null;
		else if(aData.compareTo(aNode.data)<0)//go left
			aNode.leftChild = remove(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data)>0)//go left
			aNode.leftChild = remove(aNode.rightChild,aData);
		else//We found it
		{
			//Case 0 and half of Case 1
			if(aNode.rightChild == null)
				return aNode.leftChild;
			else if(aNode.leftChild == null)//Other part if Case 1.
				return aNode.rightChild;
			//if we get here aNode has two children
			//Case 2.
			Node temp = findMinInTree(aNode.rightChild);
			aNode.data = temp.data;
			//Takes care of the duplicate value
			aNode.rightChild = remove(aNode.rightChild, temp.data);
		}
		return aNode;
		
		
	}
	private Node findMinInTree(Node aNode)
	{
		if(aNode == null)
			return null;
		else if(aNode.leftChild == null)
			return aNode;
		else
			return findMinInTree(aNode.leftChild);
	}
	
}
