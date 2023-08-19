package org.example.s0000_1000;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class S833_FindAndReplaceinString {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {


        String result = String.valueOf(s);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < indices.length; i++) {
            treeMap.put(indices[i], i);
        }


        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            Integer val = entry.getValue();
            int index = indices[val];
            int slen = sources[val].length();
            if (s.substring(index, index + slen).equals(sources[val])) {
                result = result.substring(0, index) + targets[val] + result.substring(index + sources[val].length());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcd";
        int[] indexes = {0, 2};
        String[] sources = {"a", "cd"};
        String[] targets = {"eee", "ffff"};

        S833_FindAndReplaceinString s833 = new S833_FindAndReplaceinString();
        System.out.println(s833.findReplaceString(s, indexes, sources, targets));

        s = "abcd";
        indexes = new int[]{0, 2};
        sources = new String[]{"ab", "ec"};
        targets = new String[]{"eee", "ffff"};
        System.out.println(s833.findReplaceString(s, indexes, sources, targets));

        s = "vmokgggqzp";
        indexes = new int[]{3, 5, 1};
        sources = new String[]{"kg", "ggq", "mo"};
        targets = new String[]{"s", "so", "bfr"};
        String result = s833.findReplaceString(s, indexes, sources, targets);
        System.out.print(result + "   ");
        System.out.println(result.equals("vbfrssozp"));

    }
}
