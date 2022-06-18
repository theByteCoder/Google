arr = [12, 11, 13, 5, 6, 7, 9, 0, 1, 2, 12]


def sort(array, left, right):
    if len(array) < 2:
        return
    if left < right:
        mid = left + int((right - left) / 2)
        sort(array, left, mid)
        sort(array, mid + 1, right)
        merge(array, left, mid, right)


def merge(array, left, mid, right):
    left_arr_size = mid - left + 1
    right_arr_size = right - mid

    left_arr = list(range(left_arr_size))
    right_arr = list(range(right_arr_size))

    for i in range(left_arr_size):
        left_arr[i] = array[mid + i]
    for j in range(right_arr_size):
        right_arr[j] = array[mid + 1 + j]

    i = 0
    j = 0
    k = left

    while i < left_arr_size and j < right_arr_size:
        if left_arr[i] <= right_arr[j]:
            array[k] = left_arr[i]
            i += 1
        else:
            array[k] = right_arr[j]
            j += 1
        k += 1

    while i < left_arr_size:
        array[k] = left_arr[i]
        i += 1
        k += 1
    while j < right_arr_size:
        array[k] = right_arr[j]
        j += 1
        k += 1


sort(arr, 0, len(arr) - 1)

print(arr)
