//Jesus Hernandez
//jherna83
//pa3
//Sparse.java
//Makes 2 arrays, fills them with the values from inout file and 
//does some arithmetic on them
import java.util.Scanner;
import java.io.*;
public class Sparse
{
	public static void main(String[] args) 
	{
		if(args.length != 2)
		{
			System.err.println("Usage: Sparse [inputFile] [outputFile]");
			System.exit(1);
		}

        Scanner fileIn = null;
        PrintWriter fileOut = null;
        try
        {
			fileIn = new Scanner(new File(args[0]));
		}
		catch(FileNotFoundException error)
		{
			System.err.println("No input file found. Usage: Sparse [inputFile] [outputFile");
			System.exit(1);
		}

		try
		{
			fileOut = new PrintWriter(new FileWriter(args[1]));
		}
		catch(IOException error)
		{
			System.err.println("No output file found. Usage: Sparse [inputFile] [outputFile]");
			System.exit(1);
		}
		//variables for array size and non zero entries
		int size = 0;
		int A_nonZ = 0;
		int B_nonZ = 0;

		if(fileIn.hasNextLine())
		{
			String line = fileIn.nextLine();

			//take the input for specifications of array as a String then split it by spaces and parse as integers
			String[] specs = line.split("\\s");

			size = Integer.parseInt(specs[0]);
			A_nonZ = Integer.parseInt(specs[1]);
			B_nonZ = Integer.parseInt(specs[2]);	
		}

		//array variables
		int entryRow = 0;
		int entryColumn = 0;
		double entryVal = 0;

		//create 2 matricies for the arithmetic operations
		Matrix A = new Matrix(size);
		Matrix B = new Matrix(size);

		//this for loop also takes in the vector values as strings and then splits them on the spaces
		//then it parses them as the correct data type and loads them into the matrix.
		for(int i = 0; i < A_nonZ; i++)
		{
			if(fileIn.hasNextLine())
			{
				String line = fileIn.nextLine();
				while(line.isEmpty() && fileIn.hasNextLine())
				{
					line = fileIn.nextLine();
				}
				String[] vals = line.split("\\s");
				entryRow = Integer.parseInt(vals[0]);
				entryColumn = Integer.parseInt(vals[1]);
				entryVal = Double.parseDouble(vals[2]);
			}
			A.changeEntry(entryRow, entryColumn, entryVal);
		}

		//this for loop is the same as the top but for matrix B.
		for(int i = 0; i < B_nonZ; i++)
		{
			if(fileIn.hasNextLine())
			{
				String line = fileIn.nextLine();
				while(line.isEmpty() && fileIn.hasNextLine())
				{
					line = fileIn.nextLine();
				}
				String[] vals = line.split("\\s");
				entryRow = Integer.parseInt(vals[0]);
				entryColumn = Integer.parseInt(vals[1]);
				entryVal = Double.parseDouble(vals[2]);
			}
			B.changeEntry(entryRow, entryColumn, entryVal);
		}

		//do the operations specified in the PDF and then write them to the output file. 
		fileOut.println("A has " + A.getNNZ() + "non-zero entries:");
		fileOut.println(A.toString());
		if(A.getNNZ() != 0)
		{
			fileOut.println("");
		}

		fileOut.println("B has " + B.getNNZ() + "non-zero entries");
		fileOut.println(B.toString());
		if(B.getNNZ() != 0)
		{
			fileOut.println("");
		}

		Matrix outM;

		fileOut.println("(1.5) * A = ");
		outM = A.scalarMult(1.5);
		fileOut.println(outM.toString());
		if(outM.getNNZ() != 0)
		{
			fileOut.println("");
		}

		fileOut.println("A + B = ");
		outM = A.add(B);
		fileOut.println(outM.toString());
		if(outM.getNNZ() != 0)
		{
			fileOut.println("");
		}

		fileOut.println("A + A = ");
		outM = A.add(A);
		fileOut.println(outM.toString());
		if(outM.getNNZ() != 0)
		{
			fileOut.println("");
		}

		fileOut.println("B - A = ");
		outM = B.sub(A);
		fileOut.println(outM.toString());
		if(outM.getNNZ() != 0)
		{
			fileOut.println("");
		}

		fileOut.println("A - A = ");
		outM = A.sub(A);
		fileOut.println(outM.toString());
		if(outM.getNNZ() != 0)
		{
			fileOut.println("");
		}

		fileOut.println("A * B = ");
		outM = A.mult(B);
		fileOut.println(outM.toString());
		if(outM.getNNZ() != 0)
		{
			fileOut.println("");
		}

		fileOut.println("B * B = ");
		outM = B.mult(B);
		fileOut.println(outM.toString());
		if(outM.getNNZ() != 0)
		{
			fileOut.println("");
		}
		fileIn.close();
		fileOut.close();
	}
}