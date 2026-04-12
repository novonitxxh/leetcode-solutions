class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        
        int[] freq = new int[size + 1];
        int repeated = -1;
        int sum = 0;
        
        for (int[] row : grid) {
            for (int num : row) {
                sum += num;
                freq[num]++;
                if (freq[num] == 2) {
                    repeated = num;
                }
            }
        }
        
        int expectedSum = size * (size + 1) / 2;
        int missing = expectedSum - (sum - repeated);
        
        return new int[]{repeated, missing};
    }
}