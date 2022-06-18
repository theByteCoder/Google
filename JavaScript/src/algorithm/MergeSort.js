let arr = [12, 11, 13, 5, 6, 7, 9, 0, 1, 2, 12];

const sort = (arr, left, right) => {
  const length = arr.length;
  if (length < 2) return arr;
  if (left < right) {
    const mid = left + parseInt((right - left) / 2);
    sort(arr, left, mid);
    sort(arr, mid + 1, right);
    merge(arr, left, mid, right);
  }
};

const merge = (arr, left, mid, right) => {
  const leftArrSize = mid - left + 1;
  const rightArrSize = right - mid;

  const leftArr = new Array(leftArrSize);
  const rightArr = new Array(rightArrSize);

  for (let i = 0; i < leftArrSize; i++) {
    leftArr[i] = arr[mid + i];
  }
  for (let j = 0; j < rightArrSize; j++) {
    rightArr[j] = arr[mid + 1 + j];
  }

  let i = 0,
    j = 0,
    k = left;

  while (i < leftArrSize && j < rightArrSize) {
    if (leftArr[i] <= rightArr[j]) {
      arr[k] = leftArr[i];
      i++;
    } else {
      arr[k] = rightArr[j];
      j++;
    }
    k++;
  }

  while (i < leftArrSize) {
    arr[k] = leftArr[i];
    i++;
    k++;
  }
  while (j < rightArrSize) {
    arr[k] = rightArr[j];
    j++;
    k++;
  }
};

sort(arr, 0, arr.length - 1);

console.log(arr);
