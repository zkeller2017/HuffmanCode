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
	@version 0
*/
public class HuffmanTree
{
	/**
		The very top of my tree
	*/
	private HuffmanNode root;
	
	/**
		Constructor that takes in a string to encode
		@param input The message being encoded
	*/
	public HuffmanTree(String input)
	{
		root = createTree(createNodes(createMap(input)));
		
	}
	
	/**
		Default Constructor that creates a default string to encode
	*/
	public HuffmanTree()
	{
		root = createTree(createNodes(createMap("Sam Scherl scooted school")));
		//System.out.println(root);
	}
	
	/**
		Creates and returns a HashMap with the occurrences of every letter
		@param input The message being encoded
		@return The HashMap containing the letter and occurences
	*/
	private HashMap createMap(String input)
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
	private PriorityQueue createNodes(HashMap<String,Integer> occur)
	{
		String[] keys = occur.keySet().toArray(new String[0]);
		PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>();
		for (int i = 0; i < keys.length; i++)
		{
			q.add(new HuffmanNode(occur.get(keys[i]), keys[i] ));
			System.out.println("hello");
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
	
	
}


