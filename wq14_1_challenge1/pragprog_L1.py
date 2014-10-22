//challenge: reverse a string
//using built-in python string slicing:  http://docs.python.org/release/2.3.5/whatsnew/section-slices.html
def rev(s):
	return s[::-1]

#usage example
s = "The quick brown fox jumps over the lazy dog.       "
print(rev(s))