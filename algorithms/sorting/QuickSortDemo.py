# implementation of quick sort
# s is the array to be sorted
# a is left index of the sub-array of s
# b is right index of the sub-array of s
def quicksort(s, a, b):
    if a < b:
        x = partition(s, a, b)
        quicksort(s, a, x-1)
        quicksort(s, x+1, b)
    return s

# partition s repositioning elements such that
# pivot is in the middle
# values less than pivot on the left 
# values greater than pivot on the right 
# returns pivot index
def partition(s, a, b):
    pivot = s[b]
    left = a
    right = b-1
    while left <= right:
        while left <= right and s[left] <= pivot:
            left = left + 1
        while right >= left and s[right] >= pivot:
            right = right - 1
        if left < right:
            s[left], s[right] = s[right], s[left]
            left = left + 1
            right = right - 1
    s[left], s[b] = s[b], s[left]
    return left

# driver code to test above
s = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
print 'Given array is ', s
quicksort(s, 0, len(s)-1)
print '\nSorted array is ', s
