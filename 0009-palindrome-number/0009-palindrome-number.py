class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0 or (x % 10 == 0 and x != 0):
            return False
        
        num = x
        res = 0
        while num > 0:
            ld = num % 10
            res = (res * 10) + ld
            num = num // 10
        
        return x == res
        

        