package edu.pitt.sis.infsci2591;

import java.util.Scanner;

public class NQueen {
	static int count = 0;//the count of the permutations of the qualified placement.
      //return true the two queens are not conflict//
	public static boolean canPlaceQueen(int[] q, int n) {
		for (int i = 0; i < n; i++) {
			if ((q[i] == q[n])
					|| ((Math.abs(q[i] - q[n]) == Math.abs(((n - i)))))) {
				return false; // same column and same diagona are equals.

			}
		}
		return true;
	}
              // print out N by N all the qualified solutions//
	public static void printQueens(int[] q) {
		int N = q.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (q[i] == j)
					System.out.print("Q ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}

		System.out.println();
	}

	public static void callplaceNqueen(int N) {
		int[] a = new int[N];
		enumerate(a, 0);//innitial emumerate
	}
             //try all the permutations//
	public static void enumerate(int[] q, int n) {
		int N = q.length;
		if (n == N) {//the right postion of the last one chess have been found,prin
			         //  the solution
			//printQueens(q);
			count++;
		} else {
			for (int i = 0; i < N; i++) {
				q[n] = i;
				if (canPlaceQueen(q, n)) {
					enumerate(q, n + 1);//if the chess can put in this position,continue 
					                    // to the next one.
				} else {
					continue;//if not, move to the next one in the same row,if still can 
				}            //can not find until i=N-1,then jump out to the previous column,
				             //to find the right one.
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("please input the numbers of queens required:");
		int N = sc.nextInt();//the size(N*N)of the chess board
		long begin = System.nanoTime();
		callplaceNqueen(N);
		long end = System.nanoTime(); // achieve the end time
		System.out.println(end - begin + "ns");
		//System.out.println("The number of the possible sollution is " + count);
	}

}
