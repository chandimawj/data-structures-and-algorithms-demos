# implementation of bubble sort
# s is the array to be sorted
def bubblesort(s):
    for i in range(len(s)-2, -1, -1):
        for j in range(i+1):
            if s[j] > s[j+1]:
                s[j], s[j+1] = s[j+1], s[j]
    return s

# driver code to test above
s = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
print 'Given array is ', s
bubblesort(s)
print '\nSorted array is ', s
