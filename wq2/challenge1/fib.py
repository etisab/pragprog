def fibGenerator(n):
	i, j = 0, 1
	
	yield 0					#2 base cases to consider
	yield 1
	for f in range(n-2):	#resumes here for every call after base cases
		j = i+j
		i = j - i
		yield i+j

def fibGeneratorInf():
	i, j = 0, 1
	
	yield 0				#2 base cases to consider
	yield 1
	while True:			#resumes here for every call after base cases
		j = i+j
		i = j - i
		yield i+j