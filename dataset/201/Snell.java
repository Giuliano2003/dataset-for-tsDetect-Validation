import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @param <K> The type of the keys of this BST. They need to be comparable by nature of the BST
 * "K extends Comparable" means that BST will only compile with classes that implement Comparable
 * interface. This is because our BST sorts entries by key. Therefore keys must be comparable.
 * @param <V> The type of the values of this BST. 
 */
public class BST<K extends Comparable<? super K>, V> implements DefaultMap<K, V> {
	/* 
	 * TODO: Add instance variables 
	 * You may add any instance variables you need, but 
	 * you may NOT use any class that implements java.util.SortedMap
	 * or any other implementation of a binary search tree
	 */

	private Node<K, V> root;
	private int size;
	
	public BST(){
		root = null;
		size = 0;
	}

	@Override
	public boolean put(K key, V value) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if(key == null) throw new IllegalArgumentException();

		if(containsKey(key)) return false;

		this.root = put_helper(root, key, value);
		size++;

		return true;
	}

	private Node<K,V> put_helper(Node<K, V> root, K key, V value){
		if (root == null) return new Node<>(key, value);

		if(key.compareTo(root.key) < 0) {
			root.left = put_helper(root.left, key, value);
		} else if(key.compareTo(root.key) > 0){
			root.right = put_helper(root.right, key, value);
		} 

		return root;
	}

	@Override
	public boolean replace(K key, V newValue) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if(key == null) throw new IllegalArgumentException(DefaultMap.ILLEGAL_ARG_NULL_KEY);
		return replace_helper(root, key, newValue);
	}

	private boolean replace_helper(Node<K, V> root, K key, V value){
		if (root == null) return false;

		if(key.compareTo(root.key) < 0) {
			return replace_helper(root.left, key, value);
		} else if(key.compareTo(root.key) > 0){
			return replace_helper(root.right, key, value);
		} else { //key == root.key
			//update new value
			root.value = value;
			return true;
		}
	}

	public ArrayList<V> getValues(){ 
		//return list of values in the tree
		ArrayList<V> arr = new ArrayList<>();
		getValues_helper(arr, root);
		return arr;
	}

	private void getValues_helper(ArrayList<V> arr, Node<K, V> root){
		if(root == null) return;
		getValues_helper(arr, root.left);
		arr.add(root.value);
		getValues_helper(arr, root.right);
	}

	
	@Override
	public boolean remove(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if(key == null) throw new IllegalArgumentException(DefaultMap.ILLEGAL_ARG_NULL_KEY);

		if(!containsKey(key)) return false; //there is no node with key in the tree

		//remove the node with given key
		root = remove_helper(root, key); //remove node
		size--; //reduce the size

		return true;
	}

	private Node<K, V> minNode(Node<K, V> root){ //return the left most node on the tree with 'root'
		if (root == null) return null;

		while (root.left != null) {
            root = root.left;
        }

        return root; //root is the left most node
	}

	private Node<K, V> remove_helper(Node<K, V> root, K key){
		if (root == null) return null;

		if(key.compareTo(root.key) < 0) {
			root.left = remove_helper(root.left, key);
		} else if(key.compareTo(root.key) > 0){
			root.right = remove_helper(root.right, key);
		} else { //key == root.key
			//remove this root
			if(root.left == null) return root.right;
			else if(root.right == null) return root.left;

			Node<K, V> min_node = minNode(root.right);
			
			//copy key and value of min_node to root
			root.key = min_node.key;
			root.value = min_node.value; 

			root.right = remove_helper(root.right, min_node.key); //remove the min_node
		}

		return root;
	}

	@Override
	public void set(K key, V value) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if(key == null) throw new IllegalArgumentException(DefaultMap.ILLEGAL_ARG_NULL_KEY);

		root = set_helper(root, key, value); 
		if(containsKey(key)) size++; //there was no node with key on the tree --> add new one --> size increased by 1

	}

	private Node<K, V> set_helper(Node<K, V> root, K key, V value){
		if (root == null) return new Node<K, V>(key, value);

		if(key.compareTo(root.key) < 0) {
			root.left = set_helper(root.left, key, value);
		} else if(key.compareTo(root.key) > 0){
			root.right = set_helper(root.right, key, value);
		} else{
			root.value = value;
		}

		return root;
	}

	@Override
	public V get(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if(key == null) throw new IllegalArgumentException(DefaultMap.ILLEGAL_ARG_NULL_KEY);

		return get_helper(root, key);
	}

	private V get_helper(Node<K, V> root, K key){
		if(root == null) return null;
		if(key.compareTo(root.key) < 0){
			return get_helper(root.left, key);
		}else if(key.compareTo(root.key) > 0){
			return get_helper(root.right, key);
		}else { //key == root.key
			return root.value;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public boolean containsKey(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if(key == null) throw new IllegalArgumentException(DefaultMap.ILLEGAL_ARG_NULL_KEY);

		return containsKey_helper(root, key);
	}

	private boolean containsKey_helper(Node<K, V> root, K key){
		if(root == null) return false;

		if(key.compareTo(root.key) < 0){
			return containsKey_helper(root.left, key);
		}else if(key.compareTo(root.key) > 0){
			return containsKey_helper(root.right, key);
		}else { //key == root.key
			return true;
		}
	}

	// Keys must be in ascending sorted order
	// You CANNOT use Collections.sort() or any other sorting implementations
	// You must do inorder traversal of the tree
	@Override
	public List<K> keys() {
		// TODO Auto-generated method stub
		List<K> arr = new ArrayList<>();
		in_order_traversal(root, arr);
		return arr;
	}
	
	private void in_order_traversal(Node<K, V> root, List<K> arr){
		if(root == null) return;
		in_order_traversal(root.left, arr);
		arr.add(root.key);
		in_order_traversal(root.right, arr);
	}

	
	//all nodes in the tree will be compared by the key
	//key has type K --> K must inherits the Comparable class to accept comparing 2 objects of K
	//for one node on the BST
	//it has: data, left and right references
	private static class Node<K extends Comparable<? super K>, V> 
								implements DefaultMap.Entry<K, V> {
		/* 
		 * TODO: Add instance variables
		 */
		K key;
		V value;

		Node<K, V> left, right; //left and right will refer to left and right children of this node

		Node (K key, V value){
			this.key = key;
			this.value = value;
			left = right = null; //we create single node --> left and right must refer to null
		}

		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return this.key;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return this.value;
		}

		@Override
		public void setValue(V value) {
			// TODO Auto-generated method stub
			this.value = value;
			
		}
		
		
	}
	 
}