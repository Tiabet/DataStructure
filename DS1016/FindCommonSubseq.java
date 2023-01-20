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
        } //�켱 ǥ���ٰ� ���ڵ��� ä��µ�, ���� ���ڰ� ������ �밢�� ���� ����+1�� ��ִ� ���
        //���� ���ڰ� ������ �ʴ´ٸ� �ٷ� �� ���� �� ū ���ڸ� ä��

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
        //ǥ�� ���ڸ� �ٰŷ� ���� ���ڵ��� ã�Ƴ����� �˰���
        //���ڰ� ū ������ ���󰡴� ���� ���ڰ� Ŀ�� ����, �� ���� ���ڰ� ���� ������ �����ϰ� �Ǵµ�, �׷��� string�� �߰��ϴ� ������
        //������ ��� ���� �ִ��� ���� ��ġ�Բ� �ܾ �迭�ϴ� �˰����̱� ������ �̷� ������ ������ ����!
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
