class Solution:
    def checkSubarraySum(self, nums, k):
        seen = {0: -1}
        s = 0

        for i, x in enumerate(nums):
            s = (s + x) % k

            if s in seen:
                if i - seen[s] >= 2:
                    return True
            else:
                seen[s] = i

        return False