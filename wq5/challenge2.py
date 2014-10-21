#challenge 2 - write a function which returns the number of possible paths on an nxn grid.
#Pascal's triangle strikes again!
#http://math.stackexchange.com/questions/12093/counting-number-of-moves-on-a-grid

from math import factorial as fac

def numGridPaths(n):
    return fac(2*n)/(fac(n)*fac(n))
