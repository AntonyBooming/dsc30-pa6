/*
 * Name: Antony Munkhchuluun
 * PID:  A17710282
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Search Engine implementation.
 * 
 * @author Antony Munkhchuluun
 * @since  05/17/23
 */
public class SearchEngine {

    /**
     * Populate BSTrees from a file
     * 
     * @param movieTree  - BST to be populated with actors
     * @param studioTree - BST to be populated with studios
     * @param ratingTree - BST to be populated with ratings
     * @param fileName   - name of the input file
     * @returns false if file not found, true otherwise
     */
    public static boolean populateSearchTrees(
            BSTree<String> movieTree, BSTree<String> studioTree,
            BSTree<String> ratingTree, String fileName
    ) {
        // open and read file
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                // read 5 lines per batch:
                // movie, cast, studios, rating, trailing hyphen
                String movie = scanner.nextLine().trim();
                String cast[] = scanner.nextLine().split(" ");
                String studios[] = scanner.nextLine().split(" ");
                String rating = scanner.nextLine().trim();
                scanner.nextLine();

                /* TODO */
                for(int i = 0; i < cast.length; i++){
                    if(movieTree.findKey(cast[i].toLowerCase()) == false) {
                        movieTree.insert(cast[i].toLowerCase());
                        movieTree.findDataList(cast[i]).add(movie);
                    }
                    else{
                        if(movieTree.findDataList(cast[i]).contains(movie)){
                            continue;
                        }
                        else {
                            movieTree.findDataList(cast[i]).add(movie);
                        }
                    }
                }
                for(int i = 0; i < studios.length; i++){
                    if(studioTree.findKey(studios[i].toLowerCase()) == false) {
                        studioTree.insert(studios[i].toLowerCase());
                        studioTree.findDataList(studios[i]).add(movie);
                    }
                    else{
                        if(studioTree.findDataList(studios[i]).contains(movie)){
                            continue;
                        }
                        else {
                            studioTree.findDataList(studios[i]).add(movie);
                        }
                    }
                }
                for(int i = 0; i < cast.length; i++){
                    if(ratingTree.findKey(cast[i].toLowerCase()) == false) {
                        ratingTree.insert(cast[i].toLowerCase());
                        ratingTree.findDataList(cast[i]).add(rating);
                    }
                    else{
                        if(ratingTree.findDataList(cast[i]).contains(rating)){
                            continue;
                        }
                        else {
                            ratingTree.findDataList(cast[i]).add(rating);
                        }
                    }
                }

                // populate three trees with the information you just read
                // hint: create a helper function and reuse it to build all three trees

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }

    /**
     * Search a query in a BST
     * 
     * @param searchTree - BST to be searched
     * @param query      - query string
     */
    public static void searchMyQuery(BSTree<String> searchTree, String query) {

        /* TODO */
        // process query
        String[] keys = query.toLowerCase().split(" ");

        // search and output intersection results
        // hint: list's addAll() and retainAll() methods could be helpful
        LinkedList<String> intersection = new LinkedList<>();
        if(keys.length > 0){
            intersection.addAll(searchTree.findDataList(keys[0]));
            for(int i = 0; i < keys.length; i++){
                intersection.retainAll(searchTree.findDataList(keys[i]));
            }
            print(query, intersection);
        }

        // search and output individual results
        // hint: list's addAll() and removeAll() methods could be helpful
        for(int i = 0; i < keys.length; i++){
            LinkedList<String> individual = new LinkedList<>(searchTree.findDataList(keys[i]));
            individual.removeAll(intersection);
            if(!individual.isEmpty()){
                print(keys[i], individual);
            }
        }

    }

    /**
     * Print output of query
     * 
     * @param query     Query used to search tree
     * @param documents Output of documents from query
     */
    public static void print(String query, LinkedList<String> documents) {
        if (documents == null || documents.isEmpty())
            System.out.println("The search yielded no results for " + query);
        else {
            Object[] converted = documents.toArray();
            Arrays.sort(converted);
            System.out.println("Documents related to " + query
                    + " are: " + Arrays.toString(converted));
        }
    }

    /**
     * Main method that processes and query the given arguments
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {

        /* TODO */
        // initialize search trees
        BSTree<String> movieTree = new BSTree<>();
        BSTree<String> studioTree = new BSTree<>();
        BSTree<String> ratingTree = new BSTree<>();

        // process command line arguments
        String fileName = args[0];
        int searchKind = Integer.parseInt(args[1]);

        // populate search trees
        populateSearchTrees(movieTree, studioTree, ratingTree, fileName);

        String query = "";
        for(int i = 2; i < args.length; i++){
            query += args[i] + " ";
        }
        // choose the right tree to query
        if(searchKind == 0){
            searchMyQuery(movieTree, query);
        }
        else if(searchKind == 1){
            searchMyQuery(studioTree, query);
        }
        else{
            searchMyQuery(ratingTree, query);
        }
    }
}
