package org.example.week_d.contest_111;

public class M_1 {
    public boolean canMakeSubsequence(String str1, String str2) {

        int idx2 = 0;

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            if (isMatch(c1, str2.charAt(idx2))) {
                idx2++;
            }
            if (idx2 == str2.length()) {
                return true;
            }
        }

        return false;
    }

    private boolean isMatch(char a, char b) {
        if ( a == b) {
            return true;
        }

        if ( a + 1 == b) {
            return true;
        }

        if (a == 'z' && b == 'a') {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        M_1 exe = new M_1();
        System.out.println(exe.canMakeSubsequence("zc", "ad"));
    }
}
