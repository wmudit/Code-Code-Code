package String;

import java.util.*;

public class Trie {
	
	protected class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;
		
		public TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}
		
	}
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public TrieNode getTrieNode() {
		return root;
	}
	
	protected void insert(String wrd) {
		char[] word = wrd.toCharArray();
		TrieNode curr = root;
		for(int i = 0; i < word.length; i++) {
			if(!curr.children.containsKey(word[i])) {
				curr.children.put(word[i], new TrieNode());
			} 	
			curr = curr.children.get(word[i]);
		}
		curr.endOfWord = true;
	}
	
	protected boolean search(String wrd) {
		char[] word = wrd.toCharArray();
		TrieNode curr = root;
		for(int i = 0; i < word.length; i++) {
			if(curr.children.containsKey(word[i])) {
				curr = curr.children.get(word[i]);
			} else {
				return false;
			}
		}
		return curr.endOfWord;
	}
	
	protected boolean delete(String word) {
		return delete(root, word.toCharArray(), 0);
	}
	
	private boolean delete(TrieNode curr, char[] word, int idx) {
		
		if(idx == word.length) {
			if(curr.endOfWord == false) 
				return false;
			curr.endOfWord = false;
			return curr.children.size() == 0;
		}
		TrieNode node = curr.children.get(word[idx]);
		if(node == null)
			return false;
		boolean shouldDeleteCurrentNode = delete(node, word, idx + 1);
		if(shouldDeleteCurrentNode) {
			curr.children.remove(word[idx]);
			return curr.children.size() == 0;
		}
		return false;
		
	}
	
	/*public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("Hello");
		t.insert("Hellow");
		t.insert("Meow");
		t.insert("Meowazah");
		System.out.println(t.search("Hello"));
		System.out.println(t.search(""));
		System.out.println(t.search("Hellow"));
		System.out.println(t.search("Hellooo"));
		System.out.println(t.search("Meow"));
		System.out.println(t.search("M"));
		System.out.println(t.search("Meowazahhhhhh"));
		t.delete("Meow");
		System.out.println(t.search("Meow"));
	}*/

}
