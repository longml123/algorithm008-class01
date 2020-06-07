package com.qunar.qboss.qer.common.lianxi.week07;

public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar,new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = searchprefix(word);
        return  node != null && node.isEnd();
    }

    private TrieNode searchprefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node.containsKey(currentChar)){
                node = node.get(currentChar);
            }else {
                return null;
            }
        }
        return node;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchprefix(prefix);
        return node != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));// 返回 true
        System.out.println(trie.search("app"));    // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));    // 返回 true
    }
}
