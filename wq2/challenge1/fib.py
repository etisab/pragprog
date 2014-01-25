def fibGenerator(n):
	i, j = 0, 1
	
	#2 base cases to consider
	if n == 1:
		yield 0
	elif n == 2:
		yield 1
	#for n>3, generator resumes from here each time
	else:
		for f in range(n):	
			j = i+j
			i = j - i
			yield i+j


def fibGeneratorInf():
	i, j, n = 0, 1, 1
	
	while True:
		#2 base cases to consider
		if n == 1:
			yield 0
		elif n == 2:
			yield 1
			#for n>3, generator resumes from here each time
		else:
			#for f in range(n):	
			j = i+j
			i = j - i
			yield i+j
		n += 1