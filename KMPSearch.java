public class KMPSearch {
    private int[] generateNext(String str) {
        int len = str.length();
        int[] next = new int[len];
t
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < len - 1) {
            //p[k]表示前缀，p[j]表示后缀
            if (k == -1 || str.charAt(j) == str.charAt(k)) {
                ++k;
                ++j;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
    public int search(String str1, String str2) {
        if(str1 == null || str2 == null || str1.length() == 0)
            return -1;
        int len1 = str1.length(),  len2 = str2.length();

        int[] next = generateNext(str2);
        int i = 0, j = 0;
        while(i < len1 && j < len2) {
            if(j == -1 || str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else
                j = next[j];
        }
        if(j == len2)
            return i - j;
        return -1;
    }
}