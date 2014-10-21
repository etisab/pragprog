#challenge 2 - write a function which returns the number of possible paths on an nxn grid.
#Pascal's triangle strikes again!
#http://math.stackexchange.com/questions/12093/counting-number-of-moves-on-a-grid

from math import factorial as fac

def numGridPaths(n):
    n = 2*n
    return fac(n)/(fac(n/2)*fac(n/2))
