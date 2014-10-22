/*
challenge: write a function that accepts a string of parentheses, and outputs True if they are correctly nested. 
For example: 
checkNesting( “(()())” ) → true

Now write a function that accepts both () and {}.
A sequence like {({})} is valid. You must decide if { ( } ) is valid also.

Accepts 2 args: the string to test, an arbitrary set of 'opening' and 'closing' characters
to compile: $ g++ ./pragprog_L2.cpp -o L2.out

some example arguments to try:
"(()())" "()"
")" "()"
"func("str_param", int_param, nestedfunc(p1, <stuff>));" "()\"\"<>"	
"abcdefghijklmnopqrstuvwxyz" "azbycxop"
//a "strict" flag could be added which still accepts the function example above but rejects the below examples.
"(((<   asdfe  <> ))>)" "()<>"
"(<+[-<[<>+)(-]]>)>" "<>(){}[]+-"
*/

#include <iostream>
#include <set>
#include <cmath>
using namespace std;
	
bool checkNesting(string input, string bracketSet)
{
	bool TRACE = false;	//enable for verbose output

	//intialize counts and add our opening and closing to set
	int counts[bracketSet.size()];
	for(unsigned int i = 0; i < bracketSet.size(); i++) 
	{
		counts[i] = 0;
	}
	
	for(unsigned int i = 0; i < input.size(); i++)
	{
	// why didn't I use a hash table here?
		for(unsigned int j = 0; j < bracketSet.size(); j++)
		{			
			if(input[i] == bracketSet[j]) {
				counts[j] += 1;
				
				if(TRACE)
				{
					cout << "input[" << i << "] is " << input[i] << endl;
					cout << "counts[" << j << "] is now " << counts[j] << endl;
				}
			}
			//if j is odd, examining closing brace.
			if(j % 2 == 1)
			{
				if(counts[j-1]-counts[j] < 0) {
					cout << "more closing than opening braces." << endl;
					return false;
				}
			}
		}
	}
	
	int finalSum = 0;
	for(unsigned int i = 0; i < bracketSet.size(); i++) 
	{
		finalSum += counts[i]*(pow(-1,i%2));//-1*(i%2));
		if(TRACE) {cout << "finalSum is " << finalSum << endl; }
	}
	if(finalSum == 0)
	{
		return true;
	}
	return false;
}

int main(int argc, char* argv[])
{	
	//accept 2 and only 2 arguments
	if(argc != 3) {
		cout << "wrong number of arguments" << endl;
		return 1;
	}
	
	bool correctlyNested;
	string parens = argv[1];	//example: "(())()()()";
	string bSet = argv[2];		//example: "(){}<>";
	
	correctlyNested = checkNesting(parens, bSet);
	
	cout << "The string is ";
	cout << (correctlyNested ? "" : "not ");
	cout << "correctly nested." << endl;
	
	return 0;
}
