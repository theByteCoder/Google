const arr = [0, 1, 2, 3, 4];
const length = arr.length
const kTerm = 2

const maxSum = (array, n, k) => {
    if (n < k) {
        return 0;
    }

    let sum = 0
    for (let counter = 0; counter < k; counter++) {
        sum += array[counter]
    }
    let windowSum = sum
    for (let counter = k; counter < n; counter++) {
        const next = array[counter]
        const prev = array[counter - k]
        windowSum += next - prev
        sum = Math.max(windowSum, sum)
    }
    return sum
}

console.log(maxSum(arr, length, kTerm))