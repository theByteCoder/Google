def find_rotation_count(array):
    length = len(array)
    left = 0
    right = length - 1
    while left < right:
        if array[left] <= array[right]:
            return left
        mid = left + int((right - left) / 2)
        next_item = (mid + 1) % length
        prev_item = (mid - 1 + length) % length

        if array[mid] <= array[next_item] and array[mid] <= array[prev_item]:
            return mid
        elif array[mid] <= array[right]:
            right = mid - 1
        elif array[mid] >= array[left]:
            left = mid + 1
    return -1


def main():
    arr = [12, 14, 16, 18, 20, 2, 4, 6, 8, 10]
    print(find_rotation_count(arr))


if __name__ == "__main__":
    main()
