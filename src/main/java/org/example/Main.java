package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String[] searchStrings = {"aw", "aa", "dd", "ee", "oo", "ow"};
        Map<String, Integer> resultMap =countLatin(inputString, searchStrings);
        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static Map<String, Integer> countLatin(String inputString, String[] searchStrings) {
        Map<String, Integer> resultMap = new HashMap<>();
        for (String searchString : searchStrings) {
            int index = inputString.indexOf(searchString);
            while (index != -1) {
                inputString = inputString.replace(searchString, "");
                if (resultMap.containsKey(searchString)) {
                    resultMap.put(searchString, resultMap.get(searchString) + 1);
                } else {
                    resultMap.put(searchString, 1);
                }
                index = inputString.indexOf(searchString, index);
            }
        }
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == 'w') {
                if (resultMap.containsKey("w")) {
                    resultMap.put("w", resultMap.get("w") + 1);
                } else {
                    resultMap.put("w", 1);
                }
            }
        }
        return resultMap;
    }
}