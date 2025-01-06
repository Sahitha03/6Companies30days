class Solution {
    int maxProductValue = Integer.MIN_VALUE;

    void recur(String currentSubsequence, int totalLength, int currentIndex, String inputString, List<Integer> includedIndices) {
        if (currentIndex == totalLength) {
            if (isPalindrome(currentSubsequence)) {
                String excludedSubsequence = "";
                for (int i = 0; i < totalLength; i++) {
                    if (!includedIndices.contains(i)) {
                        excludedSubsequence += inputString.charAt(i);
                    }
                }
                calculateMaxProduct("", excludedSubsequence.length(), 0, excludedSubsequence, currentSubsequence);
            }
            return;
        }

        recur(currentSubsequence, totalLength, currentIndex + 1, inputString, new ArrayList<>(includedIndices));

        currentSubsequence += inputString.charAt(currentIndex);
        includedIndices.add(currentIndex);
        recur(currentSubsequence, totalLength, currentIndex + 1, inputString, new ArrayList<>(includedIndices));
    }

    void calculateMaxProduct(String tempSubsequence, int totalLength, int currentIndex, String excludedSubsequence, String palindromeSubsequence) {
        if (currentIndex == totalLength) {
            if (isPalindrome(tempSubsequence)) {
                maxProductValue = Math.max(maxProductValue, palindromeSubsequence.length() * tempSubsequence.length());
            }
            return;
        }

        calculateMaxProduct(tempSubsequence, totalLength, currentIndex + 1, excludedSubsequence, palindromeSubsequence);

        tempSubsequence += excludedSubsequence.charAt(currentIndex);
        calculateMaxProduct(tempSubsequence, totalLength, currentIndex + 1, excludedSubsequence, palindromeSubsequence);
    }

    boolean isPalindrome(String sequence) {
        int start = 0, end = sequence.length() - 1;
        while (start < end) {
            if (sequence.charAt(start) != sequence.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public int maxProduct(String inputString) {
        recur("", inputString.length(), 0, inputString, new ArrayList<>());
        return maxProductValue;
    }
}
