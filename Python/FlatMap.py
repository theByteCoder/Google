arr = [1, [2, 3], [4, [5, [6, 7], 8]], 9, [10]]


def flat_map(array):
    res = []
    for item in array:
        if type(item) == list:
            res = [*res, *flat_map(item)] # unpacking list with *
        else:
            res.append(item)
    return res


print(flat_map(arr))
