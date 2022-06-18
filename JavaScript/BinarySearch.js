const arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0];
const left = 0;
const right = arr.length;

const binarySearch = (arr, left, right, target) => {
  while (left < right) {
    const mid = (right - left) / 2;
    if (arr[mid] === target) {
      return mid;
    } else if (arr[mid] > target) {
      left = mid + 1;
    } else if (arr[mid] < target) {
      right = mid - 1;
    }
  }
  return -1;
};

console.log(binarySearch(arr, left, right, 3));
