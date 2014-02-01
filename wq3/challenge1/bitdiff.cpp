/*
Write a function to determin the number of bits you would need to flip 
to convert integer A to integer B. EXAMPLE:
input: 29, 15
output: 2
*/

#include <iostream>
using namespace std;

int compare(unsigned int A, unsigned int B) {
	register unsigned int C = A ^ B;
	register unsigned int count = 0;

	//hopefully, compiler will unroll this loop
	for(int i = 0; i < sizeof(unsigned int)*8; ++i) {
		count += (1 & C);	//bit mask is 1
		C = C >> 1;
	}
	
	return count;
}

int main(int argc, char* argv[])
{	
	//accept 2 and only 2 CL arguments
	if(argc != 3) {
		cout << "wrong number of arguments" << endl;
		return 1;
	}
	
	cout << endl << "flipped bits: " << compare(atoi(argv[1]), atoi(argv[2])) << endl;
	return 0;
}