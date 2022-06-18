const arr = [1, [2, 3], [4, [5, [6, 7], 8]], 9, [10]];

Array.prototype.flattenMap = function () {
  let res = [];
  this.forEach((item, _index) => {
    if (Array.isArray(item)) {
      res = [...res, ...this[_index].flattenMap()];
    } else res.push(item);
  });
  return res;
};

console.log(arr.flattenMap());
