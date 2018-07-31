
import java.util.*;
import java.lang.*;
import java.io.*;

public class ShortestPath {

	
	//implements Dijkstra's SSAD algorithm
    void dijkstraShortestPath(int graph[][], int source) {
    	  int[] parent= new int[V];
        String distance[] = new String[V]; //distance[i] will holds shortest distance from source to i, output array 
        Boolean sptSet[] = new Boolean[V]; 
        int [] distance1= new int [V]; //distance[i] will holds shortest distance from source to i, output array
        //sptSet[i] is true if vertex i is included in shortest path tree or shortest distance from source to i is finalized
        // Initializes all distances as infinite and stpSet[] as false
        for (int i = 0; i < V; i++) {
        	distance[i] = "inf";
        	distance1[i]= Integer.MAX_VALUE;
         sptSet[i] = false;
         parent[0]=-1;
        }
        
        distance[source] = "0";
        distance1[source] = 0;
        int i=0;
        //finds shortest path for all vertices
        for (int count = 0; count < V-1; count++) {  
            int u = minDistance(distance1,sptSet); //picks the minimum distance vertex from the set of vertices
            sptSet[u] = true; //marks the selected vertex as visited
            
            //updates the distance value of adjacent vertices of selected vertex.
            for (int v = 0; v < V; v++) {

            	//if total weight of path from source to v through u is less than distance[v], 
            	//is edge from u to v, is not in sptSet, then update distance[v]
                if (!sptSet[v] && graph[u][v]!=0 && distance1[u] != Integer.MAX_VALUE && distance1[u]+graph[u][v] <= distance1[v]) {
                	parent[v]=u;
                	distance1[v] = (distance1[u] + graph[u][v]);
                	if(distance1[v]<=Integer.MAX_VALUE){
                		distance[v]=distance1[v]+"";
                }
                }
            }
            
            
        }
        System.out.println("");
        printSolution( V, distance, parent, source);
    }
	
	public static int V = 11;
	
	int minDistance(int dist[], Boolean sptSet[]) {
		
		//initializes min value
	    int min = Integer.MAX_VALUE;
	    int min_index = -1; 

	    for (int v = 0; v < V; v++) {
	       if (sptSet[v] == false && dist[v] <= min) {
	           min=dist[v];
	           min_index=v;
	       }
	    }
	return min_index;
	}
	
	void printSolution(int n, String dista[], int[] parent, int source) {

	    for (int i = 0; i < n; i++) {
	            System.out.print(i+"\t "+dista[i]+"\t\t ");
	            printPath(parent,i, source);
               System.out.println();
	    }
	}

	public void printPath(int parent[], int j, int source){
      if(parent[j]==-1 || parent[j]==0){
         return;
      }
      printPath(parent, parent[j], source);
     if(j!=source){
         System.out.print(j+" ");
      }

   
   }
	public void weightedAdjacency(int [][] mat){
		for(int i = 0; i<mat.length; i++){
			System.out.print(i+"\t");
			for(int j = 0; j<mat[i].length;j++){
				if (mat[i][j]>0){
					System.out.print(j+": "+mat[i][j]+"\t");
				}
			}
			System.out.println();	
		}
		
	}
}
