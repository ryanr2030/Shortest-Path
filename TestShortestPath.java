import java.util.*;
import java.io.*;

public class TestShortestPath {
    public static void main (String[] args) throws FileNotFoundException {
    	int startVertex;
    	Scanner s = null;
    	
    	ShortestPath test = new ShortestPath();
    	
    	 try {
             s = new Scanner(new File("/Users/ryanreynolds/Documents/CSU Class Folders/Fall 2017/CIS 265 Data structure and algorithms/Project/Part 2/Graph.txt"));  
         } catch (IOException i) {
             System.out.println("Problems..");
         }
    	 
    	 
    	 String  list = s.nextLine();
    	 String [] words = list.split(" ");
    	 int i=Integer.parseInt(words[3]);
    	 int matrix[][] = new int[i][i];
    	 String  list1 = s.nextLine();
    	 String [] word1 = list1.split(" ");
    	 int j=Integer.parseInt(word1[2]);
    	 startVertex=j;
    	 
    	 int row = 0;
    	 
    	 while (s.hasNextLine()){
        	 String  list2 = s.nextLine();
        	 String [] word2 = list2.split("\t");
        			 while (row < matrix.length) {
                         for (int col = 0; col < matrix[row].length ; col++) {
                             matrix[row][col] = Integer.parseInt(word2[col]);
                          }
                         row++;
                         break;
                  }
 	
    	 }
    	 
    	
        File file = new File("/Users/ryanreynolds/Documents/CSU Class Folders/Fall 2017/CIS 265 Data structure and algorithms/Project/Part 2/SSADResults.txt");
        FileOutputStream fos = new FileOutputStream(file);
          // Create new print stream for file.
        PrintStream output = new PrintStream(fos);
          // Set file print stream.
        System.setOut(output);
        System.out.println("Node\t | Out-Neigbors"); 
        System.out.println("--------------------------------------------------------------" );
        test.weightedAdjacency(matrix);
        System.out.println();
        System.out.println("Start vertex is: "+startVertex ); 
        System.out.println();
        System.out.println("Dest | Total Weight| Path");
        System.out.println("--------------------------------------------------------------" );
        test.dijkstraShortestPath(matrix, startVertex);
    	
   }
}


