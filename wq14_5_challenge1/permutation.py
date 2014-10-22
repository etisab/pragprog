#wq5 challenge 1.
#write a function which accepts 2 strings and outputs True if one is a permutation of the other.

#a first guess might be to sort, then compare the strings. 
#this will work, but runs in O(nlogn). Using dicts, the bound can be lowered to O(n).

def isPermutation(string1, string2):

    def increment(char, dict):
        if char not in dict:
            dict[char] = 1
        else:
            dict[char] += 1

    #populate dicts
    h1, h2 = {}, {}
    for c in string1:
        increment(c, h1)
    for c in string2:
        increment(c, h2)

    #short circuit if keys differ
    if h1.keys() != h2.keys():
        print("keys don\'t match")
        return(False)

    #next compare key:value pairs
    for k in h1.keys():
        if h1[k] != h2[k]:
            print("values counts don\'t match")
            return False

    #if no test fail, the strings are permutations.
    return True
