def fibGenerator(n):
	i, j = 0, 1
	
	yield 0					#2 base cases to consider
	yield 1
	for f in range(n-2):	#resumes here for every call after base cases
		j = i+j
		i = j - i
		yield i+j

//can also implement without special cases
def fibGeneratorInf():
	i, j = 0, 1

	while True:
		yield i
		i,j = j, i+j