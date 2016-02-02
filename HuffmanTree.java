import java.util.PriorityQueue;
import java.util.HashMap;
/**
	This HuffmanTree class begins by making a map of the occurences of each letter in
	a given string. Then I use that map to create HuffmanNodes, one for each letter. Then
	I put those nodes in a priority queue, and use that to make the tree that will eventually solve
	the Huffman Code. To create the tree, I take the first two nodes in the queue, combine them,
	make that the parent node of the two first nodes, and put that parent node back into the queue. Once
	the tree is finished, it can be used to find letters given only bits of 1s and 0s.
	@author Zachary Keller
	@version final
*/
public class HuffmanTree
{
	/**
		The very top of my tree
	*/
	private HuffmanNode root;
	
	/**
		The phrase being encrypted
	*/
	private String phrase;
	
	/**
		Constructor that takes in a string to encode
		@param input The message being encoded
	*/
	public HuffmanTree(String input)
	{
		phrase = input;
		root = createTree(createNodes(createMap(input)));

		
	}
	
	/**
		Default Constructor that creates a default string to encode
	*/
	public HuffmanTree()
	{
		phrase = "sam scherl scooted school";
		root = createTree(createNodes(createMap(phrase)));
		//System.out.println(root);
	}
	
	/**
		Creates and returns a HashMap with the occurrences of every letter
		@param input The message being encoded
		@return The HashMap containing the letter and occurences
	*/
	private HashMap<String, Integer> createMap(String input)
	{
		HashMap<String, Integer> occur = new HashMap<String, Integer>();
		for (int i = 0; i < input.length(); i++)
		{
			if (occur.containsKey("" + input.charAt(i)))
			{
				occur.put("" + input.charAt(i),occur.get("" + input.charAt(i)) +1);
			}
			else
			{
				occur.put("" + input.charAt(i),1);
			}
		}
		return occur;
		
	}
	
	/**
		Creates HuffmanNodes from the HashMap and puts them into a Priority Queue
		@param occur The HashMap with letters and occurences
		@return A priority Queue with the HuffmanNodes in it
	*/
	private PriorityQueue<HuffmanNode> createNodes(HashMap<String,Integer> occur)
	{
		String[] keys = occur.keySet().toArray(new String[0]);
		PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>();
		for (int i = 0; i < keys.length; i++)
		{
			q.add(new HuffmanNode(occur.get(keys[i]), keys[i] ));
			//System.out.println("hello");
		}
		/*
		for (HuffmanNode node : q)
		{
			System.out.println(node);
		}
		*/
		return q;
	}
	
	/**
		Uses the priority Queue with the HuffmanNodes in it to create the Huffman Tree.
		It polls the first two nodes in the queue, combines them,
		makes that the parent node of the two first nodes, and puts that parent 
		node back into the queue.
		@param q The Priority Queue that will be used to make the Tree
		@returns the root of the HuffmanTree created from the Priority Queue
	*/
	private HuffmanNode createTree(PriorityQueue<HuffmanNode> q)
	{
		while (q.toArray().length > 1)
		{
			HuffmanNode first = q.poll();
			HuffmanNode second = q.poll();
			HuffmanNode parent = new HuffmanNode(first.value() + second.value(), first.letters() + second.letters());
			//System.out.println("parent: " + parent);
			parent.setLeft(first);
			parent.setRight(second);
			q.offer(parent);		
		}
		//System.out.println(q.peek());
		return q.poll();
	}
	
	/**
		Turns the input phrase into a string of 1s and 0s based off 
		of the binary tree
		@return The string of bits
	
	*/
	public String encode()
	{
		String code = "";
		for (int i = 0; i < phrase.length(); i++)
		{
			code += findCode("" + phrase.charAt(i), root);
		}
		return code;
	}
	
	/**
		Te recursive helper method to encode
		@param letter a specific letter being converted to bits
		@param curr the HuffmanNode that is where the code is focused
		@return the bit representation of the letter
	*/
	private String findCode(String letter, HuffmanNode curr)
	{
		if (curr.isLeaf())
		{
			return "";
		}
		if (curr.left().letters().contains(letter))
		{
			return "0" + findCode(letter, curr.left());
		}
		else
		{
			return "1" + findCode(letter,curr.right());
		}
		
	}
	
	/**
		Turns the string of bits back into letters
		@param bits The string of 1s and 0s that are being turned back
		into letters using the binary tree
		@return the phrase
	*/
	public String decode(String bits)
	{
		return decodeHelper(bits, root);
	}
	
	/**
		The recursive helper function that turns the string of bits back
		into letters
		@param bits The 1s and 0s that are being turned back into a phrase
		@param curr The huffman node that it is currently on
		@return the original phrase of letters
	*/
	private String decodeHelper(String bits, HuffmanNode curr)
	{
		if (curr.isLeaf())
		{
			if (bits.length() > 0)
			{
				//System.out.print(curr.letters());
				return curr.letters() + decodeHelper(bits, root);
			}
			else
				return curr.letters();		
		}
		else if (("" + bits.charAt(0)).equals("0"))
		{
			return decodeHelper(bits.substring(1), curr.left());
		}
		else
		{
			return decodeHelper(bits.substring(1), curr.right());
		}
	}
	
	
}


