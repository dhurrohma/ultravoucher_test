package org.example;

import java.util.ArrayList;
import java.util.List;

public class LogicTest {
    public static List<List<String>> groupAnagrams(String[] words) {
        List<List<String>> anagramGroups = new ArrayList<>();

        for (String word : words) {
            boolean addedToGroup = false;
            for (List<String> group : anagramGroups) {
                if (isAnagram(word, group.get(0))) {
                    group.add(word);
                    addedToGroup = true;
                    break;
                }
            }

            if (!addedToGroup) {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(word);
                anagramGroups.add(newGroup);
            }
        }
        return anagramGroups;
    }
    private static boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] charCount = new int[26];

        for (char ch : word1.toCharArray()) {
            charCount[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            charCount[ch - 'a']--;
        }

        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"cook", "save", "taste", "aves", "vase", "state", "map"};
        List<List<String>> result = groupAnagrams(words);
        System.out.println(result);
    }
}
