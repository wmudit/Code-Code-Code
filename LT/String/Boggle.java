package String;

import java.util.*;

import String.Trie.TrieNode;

public class Boggle {
	
	static int[] dx = {-1, -1, 0, 1, 1,  1,  0, -1};
	static int[] dy = { 0,  1, 1, 1, 0, -1, -1, -1};
	static int[] idx = {0, 1, 2, 3, 4, 5, 6, 7};
	static List<String> res;
	
	public static List<String> findWords(char[][] board, String[] words) {
		Trie trie = new Trie();
		for(String s : words)
			trie.insert(s);
		boolean[][] visited = new boolean[board.length][board[0].length];
		res = new ArrayList<>();
		TrieNode root = trie.getTrieNode();
		findWords(board, root, visited, 0, 0, new StringBuilder(""));
		return res;
	}
	
	public static void findWords(char[][] board, TrieNode node, boolean[][] visited, int i, int j, StringBuilder s) {
		if(i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || node == null || visited[i][j])
			return;
		visited[i][j] = true;
		if(node.children != null && node.children.get(board[i][j]) != null)
			if(node.children.get(board[i][j]).endOfWord)
				res.add(s.toString());
		//if(node.children.get(board[i][j]).endOfWord)
		//	res.add(s.toString());
		if(node.children.containsKey(board[i][j])) {
			node = node.children.get(board[i][j]);
			for(int ind : idx)
				findWords(board, node.children.get(board[i][j]), visited, i + dx[ind], j + dy[ind], s.append(board[i][j]));
		}
		visited[i][j] = false;
	}

	public static void main(String[] args) {
		char[][] board = {{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
		String[] words = {"oath", "pea", "eat", "rain"};
		//Boggle b = new Boggle();
		//List<String> res1 = new ArrayList<>();
		res = findWords(board, words);
		for(String s : res)
			System.out.println(s);
	}

}
