# implementation of selection sort
# s is the array to be sorted
def selectionsort(s):
    for i in range(len(s)):
        min = i;
        for j in range(i, len(s)):
            if s[j] < s[min]:
                min = j
        s[i], s[min] = s[min], s[i]
    return s

# driver code to test above
s = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
print 'Given array is ', s
selectionsort(s)
print '\nSorted array is ', s
