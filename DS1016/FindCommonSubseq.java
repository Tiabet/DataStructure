/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DS1016;

public class FindCommonSubseq {
	


    // Compute length of LCS for all subproblems.
    public static String LongCommonSeq(String x, String y) {
        int m = x.length(), n = y.length();
        int[][] opt = new int[m+1][n+1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (x.charAt(i) == y.charAt(j)) {
                    opt[i][j] = opt[i + 1][j + 1] + 1;
                } else {
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
                }
            }
        } //우선 표에다가 숫자들을 채우는데, 같은 글자가 나오면 대각선 밑의 숫자+1을 써넣는 방식
        //같은 숫자가 나오지 않는다면 바로 옆 숫자 중 큰 숫자를 채택

        // Recover LCS itself.
        String lcs = "";
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (x.charAt(i) == y.charAt(j)) {
                lcs += x.charAt(i);
                i++;
                j++;
            } else if (opt[i + 1][j] >= opt[i][j + 1]) {
                i++;
            } else {
                j++;
            }
        }
        return lcs;
        //표의 숫자를 근거로 같은 글자들을 찾아나가는 알고리즘
        //숫자가 큰 쪽으로 따라가다 보면 숫자가 커진 순간, 즉 같은 글자가 나온 순간을 마주하게 되는데, 그러면 string에 추가하는 형식임
        //순서는 상관 없이 최대한 많이 겹치게끔 단어를 배열하는 알고리즘이기 때문에 이런 식으로 진행이 가능!
    }

    public static void main(String[] args) {
        String seq1 = "GGCACCACC";
        String seq2 = "ACGGCGGATACG";
        /**
         * - - G G C - - A - C C A C - C
         * A C G G C G G A T - - A C G
         * =>  G G C A A C
         */
        String lcs = LongCommonSeq(seq1, seq2);
        System.out.println(lcs);
    }
}
