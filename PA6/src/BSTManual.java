/**
 * From the worksheet
 */

import java.util.*;

public class BSTManual {

/**
 * Worksheet of BST
 * @author Antony Munkhchuluun
 * @since  05/13/24
 */

// No style for this file.	

public static ArrayList<String>  insertElements() {

	ArrayList<String> answer_pr1 = new ArrayList<>(11);

	/*
	 * make sure you add your answers in the following format:
	 * 
	 * answer_pr1.add("1"); --> level 1 (root level) of the output BST
	 * answer_pr1.add("2, X"); --> level 2 of the output BST
	 * answer_pr1.add("3, X, X, X"); --> level 3 of the output BST 
	 * 
	 * the above example is the same as the second pictoral example on your
	 * worksheet
	 */

	//TODO: add strings that represent the BST after insertion.
	answer_pr1.add("50");
	answer_pr1.add("15, 37");
	answer_pr1.add("38, 61, 65, 13");
	answer_pr1.add("25, 92, 21, X, X, X, X, X");
	return answer_pr1;

}

public static ArrayList<String>  deleteElements() {

	ArrayList<String> answer_pr2 = new ArrayList<>(11);
	
	/*
	 * Please refer to the example in insertElements() if you lose track
	 * of how to properly enter your answers
	 */

	//TODO: add strings that represent the BST after 5 deletions.
	answer_pr2.add("57");
	answer_pr2.add("47, 60");
	answer_pr2.add("20, X, X, 94");
	answer_pr2.add("X, 21, X, X, X, X, X, X");
	return answer_pr2;

}

public static ArrayList<String>  traversals() {

	ArrayList<String> answer_pr3 = new ArrayList<>(11);
	
	/*
	 * In this one, you will add ONLY and EXACTLY 3 strings to answer_pr3
	 * 
	 * here's how you do it:
	 * 
	 * answer_pr3.add("1, 2, 3, 4, 5") --> in-order traversal result
	 * answer_pr3.add("1, 2, 3, 4, 5") --> pre-order traversal result
	 * answer_pr3.add("1, 2, 3, 4, 5") --> post-order traversal result
	 * 
	 * replace "1, 2, 3, 4, 5" with your actual answers
	 */
	//TODO: add 3 strings that represent 3 traversals.
	answer_pr3.add("4, 19, 22, 28, 39, 56, 64, 68, 93, 95, 96, 97, 98");
	answer_pr3.add("39, 19, 4, 22, 28, 93, 64, 56, 68, 96, 95, 98, 97");
	answer_pr3.add("4, 28, 22, 19, 56, 68, 64, 95, 97, 98, 96, 93, 39");
	return answer_pr3;

}


}