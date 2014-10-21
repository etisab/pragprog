#dynamic programming solution to stair-stepping question
#calculates next step using O(1) time AND space complexity.

def countSteps():

    steps = [1, 2, 4]

    #iteration at i=0 represents countSteps(1) 
    i = 0
    while True:
        yield (i+1, steps[i%3])
        steps[i%3] = steps[(i-1)%3] + steps[(i-2)%3] + steps[(i-3)%3]
        i += 1
