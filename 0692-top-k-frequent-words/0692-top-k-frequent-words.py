from collections import Counter
class Solution:
    def topKFrequent(self, words, k):
        c= Counter(words)
        return sorted(c, key=lambda x: (-c[x], x))[:k]