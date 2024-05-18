/*
 * Name: Antony Munkhchuluun
 * PID:  A17710282
 */

import java.util.*;

/**
 * Binary search tree implementation.
 * 
 * @author Antony Munkhchuluuun
 * @since  05/13/24
 */
public class BSTree<T extends Comparable<? super T>> implements Iterable {

    /* * * * * BST Instance Variables * * * * */

    private int nelems; // number of elements stored
    private BSTNode root; // reference to root node
    private static int heightCounter;

    /* * * * * BST Node Inner Class * * * * */

    protected class BSTNode {

        T key;
        LinkedList<T> dataList;
        BSTNode left;
        BSTNode right;

        /**
         * A constructor that initializes the BSTNode instance variables.
         *
         * @param left     Left child
         * @param right    Right child
         * @param dataList Linked list of related info
         * @param key      Node's key
         */
        public BSTNode(BSTNode left, BSTNode right, LinkedList<T> dataList, T key) {
            this.left = left;
            this.right = right;
            this.dataList = dataList;
            this.key = key;
        }

        /**
         * A constructor that initializes BSTNode variables. Note: This constructor is
         * used when you want to add a key with no related information yet. In this
         * case, you must create an empty LinkedList for the node.
         *
         * @param left  Left child
         * @param right Right child
         * @param key   Node's key
         */
        public BSTNode(BSTNode left, BSTNode right, T key) {
            this.left = left;
            this.right = right;
            this.dataList = new LinkedList<>();
            this.key = key;
        }

        /**
         * Return the key
         *
         * @return The key
         */
        public T getKey() {
            return this.key;
        }

        /**
         * Return the left child of the node
         *
         * @return The left child of the node
         */
        public BSTNode getLeft() {
            return this.left;
        }

        /**
         * Return the right child of the node
         *
         * @return The right child of the node
         */
        public BSTNode getRight() {
            return this.right;
        }

        /**
         * Return the linked list of the node
         *
         * @return The linked list of the node
         */
        public LinkedList<T> getDataList() {
            return this.dataList;
        }

        /**
         * Setter for left child of the node
         *
         * @param newleft New left child
         */
        public void setLeft(BSTNode newleft) {
            this.left = newleft;
        }

        /**
         * Setter for right child of the node
         *
         * @param newright New right child
         */
        public void setRight(BSTNode newright) {
            this.right = newright;
        }

        /**
         * Setter for the linked list of the node
         *
         * @param newData New linked list
         */
        public void setDataList(LinkedList<T> newData) {
            this.dataList = newData;
        }

        /**
         * Append new data to the end of the existing linked list of the node
         *
         * @param data New data to be appended
         */
        public void addNewInfo(T data) {
            this.dataList.add(data);
        }

        /**
         * Remove 'data' from the linked list of the node and return true. If the linked
         * list does not contain the value 'data', return false.
         *
         * @param data Info to be removed
         * @return True if data was found, false otherwise
         */
        public boolean removeInfo(T data) {
            if(this.dataList.contains(data)) {
                this.dataList.remove(data);
                return true;
            }
            else{
                return false;
            }
        }
    }

    /* * * * * BST Methods * * * * */

    /**
     * 0-arg constructor that initializes root to null and nelems to 0
     */
    public BSTree() {
        this.root = null;
        this.nelems = 0;
    }

    /**
     * Return the root of BSTree. Returns null if the tree is empty
     *
     * @return The root of BSTree, null if the tree is empty
     */
    public BSTNode getRoot() {
        if(nelems == 0){
            return null;
        }
        else{
            return this.root;
        }
    }

    /**
     * Return the BST size
     *
     * @return The BST size
     */
    public int getSize() {
        return this.nelems;
    }

    /**
     * @param currNode pointer to the node it is currently at
     * @param toInsert the key to insert
     * @return the node if it is in the BST, otherwise fa;se
     */
    private void insertHelper(BSTNode currNode, T toInsert){
        if(currNode.key.compareTo(toInsert) > 0){
            if(currNode.getLeft() == null) {
                currNode.setLeft(new BSTNode(null,null, toInsert));
            }
            else{
                insertHelper(currNode.getLeft(), toInsert);
            }
        }
        else if(currNode.key.compareTo(toInsert) < 0){
            if(currNode.getRight() == null) {
                currNode.setRight(new BSTNode(null,null, toInsert));
            }
            else{
                insertHelper(currNode.getRight(), toInsert);
            }
        }
    }

    /**
     * Insert a key into BST
     * 
     * @param key
     * @return true if insertion is successful and false otherwise
     */
    public boolean insert(T key) {
        if(key == null){
            throw new NullPointerException();
        }
        if(findKey(key)){
            return false;
        }
        else {
            if(root == null) {
                root = new BSTNode(null, null, key);
                nelems++;
                return true;
            }
            else{
                insertHelper(this.root, key);
                nelems++;
                return true;
            }
        }
    }

    /**
     *
     * @param currNode the node the recursion is currently at.
     * @param toFind the Node to find
     * @return true if node is found(if node is already in the BST Tree), otherwise false
     */
    private boolean containsHelper(BSTNode currNode, T toFind){
        if (currNode == null){
            return false;
        }
        if(currNode.key.compareTo(toFind) > 0){
            return containsHelper(currNode.getLeft(), toFind);
        }
        else if(currNode.key.compareTo(toFind) < 0){
            return containsHelper(currNode.getRight(), toFind);
        }
        else{
            return true;
        }
    }


    /**
     * Return true if the 'key' is found in the tree, false otherwise
     *
     * @param key To be searched
     * @return True if the 'key' is found, false otherwise
     * @throws NullPointerException If key is null
     */

    public boolean findKey(T key) {
        if(key == null){
            throw new NullPointerException();
        }
        if(containsHelper(this.root, key)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     *
     * @param currNode the current Node the recursion is at
     * @param key the key of the Node you are trying to add Data to
     * @param data the data to be added to LinkedList of the node
     */
    private void insertDataHelper(BSTNode currNode, T key, T data){
        if(currNode.getKey() == key){
            currNode.addNewInfo(data);
        }
        else {
            if (currNode.key.compareTo(key) > 0) {
                insertDataHelper(currNode.getLeft(), key, data);
            }
            else if(currNode.key.compareTo(key) < 0) {
                insertDataHelper(currNode.getRight(), key, data);
            }
        }
    }

    /**
     * Insert 'data' into the LinkedList of the node whose key is 'key'
     *
     * @param key  Target key
     * @param data To be added to key's LinkedList
     * @throws NullPointerException     If eaither key or data is null
     * @throws IllegalArgumentException If key is not found in the BST
     */
    public void insertData(T key, T data) {
        if(key == null || data == null){
            throw new NullPointerException();
        }
        if (findKey(key) == false){
            throw new IllegalArgumentException();
        }
        else{
            insertDataHelper(this.root, key, data);
        }
    }

    /**
     *
     * @param currNode the Node the recursion is currently at
     * @param key the key of the Node you are trying to find the DataList of
     * @return the LinkedList of the desired key
     */
    private LinkedList<T> findDataListHelper(BSTNode currNode, T key){
        if (currNode.key.compareTo(key) > 0) {
            return findDataListHelper(currNode.getLeft(), key);
        }
        else if(currNode.key.compareTo(key) < 0) {
            return findDataListHelper(currNode.getRight(), key);
        }
        else{
            return currNode.getDataList();
        }
    }

    /**
     * Return the LinkedList of the node with key value 'key'
     *
     * @param key Target key
     * @return LinkedList of the node whose key value is 'key'
     * @throws NullPointerException     If key is null
     * @throws IllegalArgumentException If key is not found in the BST
     */
    public LinkedList<T> findDataList(T key) {
        if(key == null){
            throw new NullPointerException();
        }
        if (findKey(key) == false){
            throw new IllegalArgumentException();
        }
        else{
            return findDataListHelper(this.root, key);
        }
    }

    /**
     * Return the height of the tree
     *
     * @return The height of the tree, -1 if BST is empty
     */
    public int findHeight() {
        return findHeightHelper(this.root);
    }

    /**
     * Helper for the findHeight method
     *
     * @param root Root node
     * @return The height of the tree, -1 if BST is empty
     */
    private int findHeightHelper(BSTNode root) {
        if(nelems == 0){
            return -1;
        }
        if(root.getLeft() == null && root.getRight() == null){
            int locaHeightCounter = heightCounter;
            heightCounter = 0;
            return locaHeightCounter;
        }
        else{
            if(root.getLeft() != null) {
                heightCounter++;
                return findHeightHelper(root.getLeft());
            }
            else{
                heightCounter++;
                return findHeightHelper(root.getRight());
            }
        }
    }

    /* * * * * BST Iterator * * * * */

    public class BSTree_Iterator implements Iterator<T> {

        private Stack<BSTNode> stack;
        private BSTNode currNodeCursor;

        public BSTree_Iterator() {
            currNodeCursor = root;
            stack = new Stack<>();
            if(root != null){
                stack.push(root);
            }
            BSTNode currNode = root;
            while(currNode.getLeft() != null) {
                stack.push(currNode.getLeft());
                currNode = currNode.getLeft();
            }
        }

        public boolean hasNext() {
            if(stack.isEmpty()){
                return false;
            }
            else{
                return true;
            }
        }

        public T next() {
            if (hasNext() == false){
                throw new NoSuchElementException();
            }
            BSTNode currNode = stack.pop();
            BSTNode poppedNode = currNode;
            if(currNode.getRight() != null){
                stack.push(currNode.getRight());
                currNode = currNode.getRight();
            }
            while(currNode.getLeft() != null) {
                stack.push(currNode.getLeft());
                currNode = currNode.getLeft();
            }
            return poppedNode.getKey();
        }
    }

    public Iterator<T> iterator() {
        return new BSTree_Iterator();
    }

    /* * * * * Extra Credit Methods * * * * */

    public ArrayList<T> intersection(Iterator<T> iter1, Iterator<T> iter2) {
        /* TODO */
        return null;
    }

    public T levelMax(int level) {
        /* TODO */
        return null;
    }
}
