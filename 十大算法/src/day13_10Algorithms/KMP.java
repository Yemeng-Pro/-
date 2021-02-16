package day13_10Algorithms;

import com.sun.tools.javac.Main;

/**
 * @author Yemeng
 * @create 2021-01-07-13:40
 */
public class KMP {
    public static void main(String[] args) {
        char[] b = {'a','b','a','b','a','c','d'};
        char[] a = {'a','b','a','b','a','e','a','b','a','c'};
        int c = kmp(a,10,b,7);
        System.out.println(c);
    }



    // a, b分别是主串和模式串；n, m分别是主串和模式串的长度。
    public static int kmp(char[] a, int n, char[] b, int m) {
        int[] next = getNexts(b, m);
        int j = 0;
        for (int i = 0; i < n; ++i) {
            while (j > 0 && a[i] != b[j]) { // 一直找到a[i]和b[j]
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                ++j;
            }
            if (j == m) { // 找到匹配模式串的了
                return i - m + 1;
            }
        }
        return -1;
    }



    // b表示模式串，m表示模式串的长度
    private static int[] getNexts(char[] b, int m) {
        int[] next = new int[m];
        next[0] = -1;
        int k = -1; //最长可匹配前缀字符串下标
        for (int i = 1; i < m; ++i) {
            while (k != -1 && b[k + 1] != b[i]) {
            //我们可以考察完所有的 b[0, i-1]的可匹配后缀子串 b[y, i-1]，直到找到一个可匹配的后缀子串，
            // 它对应的前缀子串的下一个字符等于 b[i]，那这个 b[y, i]就是 b[0, i]的最长可匹配后缀子串
                k = next[k];
            //于是，查找 b[0, i-1]的次长可匹配后缀子串，这个问题就变成，查找 b[0, y]的最长匹配后缀子串的问题了。

            }
            if (b[k + 1] == b[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }
}
