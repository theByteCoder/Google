def binary_search(arr, left, right, target):
    while left < right:
        mid = int((right - left) / 2)
        if arr[mid] == target:
            return mid
        elif arr[mid] > target:
            left = mid + 1
        elif arr[mid] < target:
            right = mid - 1
    return -1


def main():
    array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
    print(binary_search(arr=array, left=0, right=len(array), target=3))


if __name__ == "__main__":
    main()
