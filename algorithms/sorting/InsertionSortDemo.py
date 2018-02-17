# implementation of insertion sort
# s is the array to be sorted
def insertionsort(s):
    for i in range(1, len(s)):
        temp = s[i]
        j = i
        while j>0 and s[j-1]>temp:
            s[j] = s[j-1]
            j = j-1
        s[j] = temp
    return s

# driver code to test above
s = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
print 'Given array is ', s
insertionsort(s)
print '\nSorted array is ', s
