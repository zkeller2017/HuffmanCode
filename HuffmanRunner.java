/**
	Runner to test the HuffmanNode and HuffmanTree functions
	@author Zachary Keller
	@version 1
*/
public class HuffmanRunner
{
	public static void main(String[] args)
	{
		HuffmanTree tree = new HuffmanTree();
		String bits = tree.encode();
		System.out.println("Decoded: " + tree.decode(bits));
		
	}
}