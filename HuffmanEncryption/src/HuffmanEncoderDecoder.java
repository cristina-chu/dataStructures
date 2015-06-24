import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;

/**
 * This class creates a Huffman Encoder/Decoder
 * @author cristinachu
 * @version 1.0
 */
public class HuffmanEncoderDecoder {

	private Map<Character, Integer> frequencies;
	private Map<Character, String> encoder; 
	private Map<String, Character> decoder;
	private final String data;
	
	/**
	 * constructor
	 * @param frequencyData - what we are going to use to create the encoder/decoder
	 */
	public HuffmanEncoderDecoder(String frequencyData){
		data = frequencyData;
		frequencies = new HashMap();
		
		if (frequencyData == null) {
			return;
		}
		
		for (int i=0; i<data.length(); i++) {
			int f = getFrequencyForCharacter(data.charAt(i));
			frequencies.put(data.charAt(i), f);
		}
		
		initializeHuffmanEncoderDecoder();
	}
	
	/**
	 * creates encoder and decoder i.e. populates hashmaps of encoder/decoder
	 */
	public void initializeHuffmanEncoderDecoder(){
		encoder = new HashMap();
		decoder = new HashMap();
		
		constructEncoder();
		constructDecoder();
	}
	
	/**
	 * creates encoder by creating Huffman tree
	 */
	private void constructEncoder() {
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		Node root = null;
		
		for (char x: frequencies.keySet()) {
			q.add(new Node(x, frequencies.get(x), true));
		}
		
		while (q.size() > 1) {
			Node x = q.poll();
			Node y = q.poll();
			
			//Node newNode = merge(x,y);
			
			root = new Node(x.f+y.f);
			root.left = x;
			root.right = y;
			q.add(root);
		}
		
		encodeTree(root, "");
	}
	
	/**
	 * merges 2 nodes
	 * @param x
	 * @param y
	 * @return new merged node
	 */
	private Node merge(Node x, Node y) {
		Node newNode = null;
		int newF = (x.f)+(y.f);
		
		if (x.compareTo(y) == 1) {
			newNode = new Node(newF);
			newNode.left = y;
			newNode.right = x;
		}
		else {
			newNode = new Node(newF);
			newNode.left = x;
			newNode.right = y;
		}
		
		return newNode;
	}
	
	/**
	 * creates a codeword, given a node and a current string of 1 and 0's
	 * @param root
	 * @param output
	 */
	private void encodeTree(Node root, String output) {
		if (root.leaf == false) {
			encodeTree(root.left, output + "0");
			encodeTree(root.right, output + "1");
		} 
		else {
			encoder.put(root.c, output);
		}
	}
	
	/**
	 * makes decoder
	 */
	private void constructDecoder() {
		for (char c: encoder.keySet()) {
			decoder.put(encoder.get(c), c);
		}
	}
	
	/**
	 * checks for the frequency of each character in the given encoder-word
	 * @param char c  
	 * @return int frequency of char c
	 */
	public int getFrequencyForCharacter(char c){
		int i = 0;
		int total = 0;
		
		while (i<data.length()) {
			if (data.charAt(i) == c) {
				total++;
			}
			i++;
		}
		
		return total;
	}
	
	/**
	 * returns the codeword for a character
	 * @param rawCharacter
	 * @return
	 */
	public String encodeCharacter(char rawCharacter){
		return encoder.get(rawCharacter);
	}
	
	/**
	 * returns the character given a codeword
	 * @param encodedCharacter
	 * @return
	 */
	public char decodeCharacter(String encodedCharacter){
		return decoder.get(encodedCharacter);
	}
	
	/**
	 * encodes a given string
	 * @param input
	 * @return
	 */
	public String encodeString(String input){
		String result = "";
		
		for (int i=0; i<input.length(); i++) {
			String x = encoder.get(input.charAt(i));
			result = result+x;
		}
		
		return result;
	}
		
	/**
	 * decodes a given string
	 * @param input
	 * @return
	 */
	public String decodeString(String input){
		String result = "";
		int start = 0;
		int end = 1;
		
		while (end<=input.length()) {
			if (decoder.containsKey(input.substring(start,end))) {
				result = result+decoder.get(input.subSequence(start, end));
				start = end;
				end++;
			}
			else 
				end++;
		}
		
		return result;
	}
	
	/**
	 * node class use to create Huffman tree
	 * @author cristinachu
	 *
	 * @param <CHAR>
	 * @param <FREQUENCY>
	 */
	private static class Node<CHAR,FREQUENCY> implements Comparable {
		private char c; //character
		private int f; //frequency of character

		public Node left;
		public Node right;
		public boolean leaf;
		
		public Node(char c, int f, Node<CHAR,FREQUENCY> left, Node<CHAR,FREQUENCY> right) {
			this.c = c;
			this.f = f;
			this.left = left;
			this.right = right;
		}
		
		public Node(char c, int f, boolean leaf) {
			this(c,f,null,null);
			this.leaf = leaf;
		}
		
		public Node(char c, int f) {
			this(c,f,null,null);
		}

		public Node(int f) {
			this('0',f,null, null);
		}

		public int compareTo(Object y) {
			if (this.f > ((Node)y).f) 
				return 1;
			else if (this.f < ((Node)y).f)
				return -1;
			
			return 0;
		}
	}
	

	//TEST CASE

	public static void main(String[] args) {
		String first = "getting";
		
		System.out.println(first.substring(0,1));
		
		
		
		HuffmanEncoderDecoder ed = new HuffmanEncoderDecoder(first);

		/*
		for (char c: (ed.frequencies).keySet()) {
			System.out.println(c+" "+(ed.frequencies.get(c)));
		}*/
		
		//look at encoder
		for (char c: (ed.encoder).keySet()) {
			System.out.println(c+" "+(ed.encoder.get(c)));
		}
		
		String i = "giggeeegnting";
		
		String d = ed.encodeString(i);		
		System.out.println(d);
		
		String m = ed.decodeString(d);
		

		System.out.println(m);
		
	}
}