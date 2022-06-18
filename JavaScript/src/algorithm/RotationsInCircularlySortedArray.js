const arr = [12, 14, 16, 18, 20, 2, 4, 6, 8, 10];

const findRotationCount = (array) => {
  const length = array.length;
  let left = 0;
  let right = length - 1;

  while (left < right) {
    if (array[left] <= array[right]) {
      return left;
    }
    const mid = left + parseInt((right - left) / 2);
    const next = (mid + 1) % length;
    const prev = (mid - 1 + length) % length;

    if (array[mid] <= array[next] && array[mid] <= array[prev]) {
      return mid;
    } else if (array[mid] <= array[right]) {
      right = mid - 1;
    } else if (array[mid] >= array[left]) {
      left = mid + 1;
    }
  }
  return -1;
};

console.log(findRotationCount(arr));
