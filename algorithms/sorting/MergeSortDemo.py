# implementation of merge sort
# s is the array to be sorted
# a is left index of the sub-array of s
# b is right index of the sub-array of s
def mergesort(s, a, b):
    if a < b:
        m = (a + b) / 2
        mergesort(s, a, m)
        mergesort(s, m+1, b)
        merge(s, a, m, b)

# merges two sub-arrays of s
# first subarray is s[a..m]
# second subarray is s[m+1..b]
def merge(s, a, m, b):
    t = [0] * len(s)
    for i in range(a, b+1):
        t[i] = s[i]
    s1 = a
    s2 = m + 1
    k = a
    while s1 <= m and s2 <= b:
        if t[s1] < t[s2]:
            s[k] = t[s1]
            s1 = s1 + 1
        else:
            s[k] = t[s2]
            s2 = s2 + 1
        k = k + 1
    for i in range(s1, m+1):
        s[k] = t[i]
        k = k + 1
    for j in range(s2, b+1):
        s[k] = t[j]
        k = k + 1

# driver code to test above
s = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
print 'Given array is ', s
mergesort(s, 0, len(s)-1)
print '\nSorted array is ', s

