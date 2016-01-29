import java.lang.Iterable;
import java.util.Iterator;
/**
	The Huffman Node class is a node of a Tree-Structure. The node has two
	pointers to a left and right subtree. This node also holds a value and letters. There are
	various accessors and modifiers in this class, as well as functions that return 
	information about the entire tree.
	@author Zachary Keller
	@version 0

*/
public class HuffmanNode implements Comparable<HuffmanNode>
{
	/**
		The value held in this node of the tree
	*/
	protected int value;
	
	/**
		The letters held in this node
	*/
	protected String letters;
	
	/**
		A pointer to the left branch subtree
	*/
	protected HuffmanNode left;
	
	/**
		A pointer to the right branch subtree
	*/
	protected HuffmanNode right;
	
	/**
		Constructor- Creates a new Binary Tree with given values
		@param v The value of this particular node of the tree
		@param l The left branch
		@param r The right branch
	*/
	public HuffmanNode(Integer v, HuffmanNode l,HuffmanNode r)
	{
		value = v;
		left = l;
		right = r;
	}
	
	/**
		Overrides the Comparable Class so it can be used in the Priority Queue
	*/
	public int compareTo(HuffmanNode other)
	{
		return value - other.value;
	}
	
	/**
		Constructor- creates a new Binary Tree with a stored value,
		but without a left or right branch
		@param v The value stored by this node
	*/
	public HuffmanNode(int v)
	{
		this(v, null, null);
	}
	
	/**
		Constructor for HuffmanNode that takes in a value and letters
		@param v Value
		@param s Letters
	*/
	public HuffmanNode(int v, String s)
	{
		value = v;
		letters = s;
	}
	
	/**
		Constructor- Calls the first Constructor with all null values
	*/
	public HuffmanNode()
	{
		this(null, null, null);
	}
	
	/**
		Returns the letters that the node holds"
		@return letters
	*/
	public String letters()
	{
		return letters;
	}
	
	/**
		Returns the left branch of the tree
		@return The left branch of the tree
	*/
	public HuffmanNode left()
	{
		return left;
	}
	
	/**
		Returns the right branch of the tree
		@return The right branch of the tree
	*/
	public HuffmanNode right()
	{
		return right;
	}
	
	/**
		Returns the value this node of the tree is holding
		@return The value this node of the tree is holding
	*/
	public int value()
	{
		return value;
	}
	

	
	/**
		Sets the left branch of the tree to a new Binary Tree
		@param The new Tree
	*/
	public void setLeft(HuffmanNode t)
	{
		left = t;
	}
	
	/**
		Sets the right branch of the tree to a new Binary Tree
		@param The new Tree
	*/
	public void setRight(HuffmanNode t)
	{
		right = t;
	}
	
	/**
		Sets or changes the value that this tree node is holding
		@param The new value
	*/
	public void setValue(int v)
	{
		value = v;
	}
	

	/**
		Determines whether or not this tree is a leaf,
		meaning that it has no subtrees
		@return Whether or not it is a leaf
	*/
	public boolean isLeaf()
	{
		return (left == null && right == null);			
	}
	
	/**
		Returns a string representation of the binary tree
		@return A string representation of the binary tree
	*/
	public String toString()
	{
		if (isLeaf())
		{		
			return  "" + letters + " : " +  value;
		}
		if (left == null)
			return letters + " : " + value + "(" + "EMPTY, " + right.toString() + ")";
		else if (right == null)
			return  letters + " : " + value + "(" + left.toString() + ", EMPTY" + ")";
		else
			return  letters + " : " + value + "(" + left.toString() + ", " + right.toString() + ")";
	}
	

	

	
	
	
	
}