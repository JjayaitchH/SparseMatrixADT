public class Matrix
{
	//Constructor 
	Matrix(int n)
	{

	}

	//~~~Start access Functions~~~

	//returns number of rows  and colums of matrix
	int getSize()
	{

	}

	//returns number of non-zero entries in matrix
	int getNNZ()
	{

	}

	//overide Object's equals() method
	public boolean equals(Object x)
	{

	}

	//~~~End Access functions~~~

	//~~~Start manipulation functions~~~

	//sets matrix to zero state
	void makeZero()
	{

	}

	//copies and returns a new matrix
	//holding enries from this matrix
	Matrix copy()
	{

	}

	//changes ith row, jth column of matrix to x
	//pre: 1<=i<=getSize(), 1<=i<=getSize()
	void changeEntry(int i, int j, double x)
	{

	}

	//return new Matrix that is scalar product of
	//this matrix with x
	Matrix scalarMult(double x)
	{

	}

	//return new matrix which is the sum of this matrix 
	//with Matrix M
	//pre: getSize() == M.getSize()
	Matrix add(Matrix M)
	{

	}

	//return new matrix that is the difference of this 
	//matrix and matrix M
	//pre: getSize() == M.getSize()
	Matrix sub(Matrix M)
	{

	}

	//returns new matrix that is the transpose of this Matrix
	Matrix transpose()
	{

	}

	//returns new matrix that is the product of this Matrix and 
	//Matrix M
	//pre: getSize() == M.getSize()
	Matrix mult(Matrix M)
	{

	}

	//~~~End manipulation functions~~~

	//~~~Start other functions~~~

	//overrides Object's toString() method
	public String toString()
	{

	}
	
	//~~~End other functions~~~
}