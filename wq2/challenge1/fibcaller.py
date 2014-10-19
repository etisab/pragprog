//quick script to demonstrate fibonacci generator in fib.py
import fib, sys

try:
	g = fib.fibGenerator(long(sys.argv[1]))
except:
	print("probably didn't supply an integer CL arg")
	exit(1)
	
while True:
	try:
		print(g.next())
	except:
		print("NO MORE")
		break
		