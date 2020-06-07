package com.qunar.qboss.qer.common.lianxi.week07;
import lombok.Data;

import java.util.HashMap;
@Data
public class TrieNode01 {

    HashMap<Character, TrieNode01> children = new HashMap<Character, TrieNode01>();
    String word = null;
    public TrieNode01() {}
}
