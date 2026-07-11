class Solution:
    def isPalindrome(self, x: int) -> int:
        # Negative numbers are never palindromes
        # Numbers ending in 0 are never palindromes (except 0 itself)
        if x < 0 or (x % 10 == 0 and x != 0):
            return False

        reverted = 0
        while x > reverted:
            reverted = reverted * 10 + x % 10
            x //= 10

        # For even digit count: x == reverted
        # For odd digit count: x == reverted // 10 (middle digit doesn't matter)
        return x == reverted or x == reverted // 10



        