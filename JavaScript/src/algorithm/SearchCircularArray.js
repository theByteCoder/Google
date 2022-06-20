const arr = [8, 9, 10, 2, 5, 6];

const searchCircularArray = (array, target) => {
    const length = array.length;
    let left = 0;
    let right = length - 1;

    while (left <= right) {
        const mid = left + Math.floor((right - left) / 2);
        if (array[mid] === target) {
            return mid;
        }
        if (array[mid] <= array[right]) {
            if (target > array[mid] && target <= array[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        } else if (array[mid] >= array[left]) {
            if (target < array[mid] && target >= array[left]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }
    return -1;
};

console.log(searchCircularArray(arr, 2));
