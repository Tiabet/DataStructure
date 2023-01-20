package DS1122;


// class TreeNode definition
class TreeNode 
{
   // package access members
   TreeNode leftNode; // left node  
   int data; // node value
   TreeNode rightNode; // right node

   // constructor initializes data and makes this a leaf node
   public TreeNode( int nodeData )
   { 
      data = nodeData;              
      leftNode = rightNode = null; // node has no children
   } // end TreeNode no-argument constructor

   // locate insertion point and insert new node; ignore duplicate values
   public void insert( int insertValue )//대소 비교해서 작으면 왼쪽 크면 오른쪽
   {
      // insert in left subtree
      if ( insertValue < data )  
      {
         // insert new TreeNode
         if ( leftNode == null )
            leftNode = new TreeNode( insertValue );
         else // continue traversing left subtree
            leftNode.insert( insertValue ); 
      } // end if
      else if ( insertValue > data ) // insert in right subtree
      {
         // insert new TreeNode
         if ( rightNode == null )
            rightNode = new TreeNode( insertValue );
         else // continue traversing right subtree
            rightNode.insert( insertValue ); 
      } // end else if
   } // end method insert
} // end class TreeNode

// class Tree definition
public class Tree 
{
   private TreeNode root; //자식에서 부모로 올라오는 방법은 없음

   // constructor initializes an empty Tree of integers
   public Tree() 
   { 
      root = null; 
   } // end Tree no-argument constructor

   // insert a new node in the binary search tree
   public void insertNode( int insertValue )
   {
      if ( root == null )
         root = new TreeNode( insertValue ); // create the root node here
      else
         root.insert( insertValue ); // call the insert method
   } // end method insertNode

   // begin preorder traversal
   public void preorderTraversal()
   { 
      preorderHelper( root ); 
   } // end method preorderTraversal

   // recursive method to perform preorder traversal
   private void preorderHelper( TreeNode node ) //Root부터 출력하고 밑으로 내려가면서 동시에 출력
   {
      if ( node == null )
         return;

      System.out.printf( "%d ", node.data ); // output node data
      preorderHelper( node.leftNode );       // traverse left subtree
      preorderHelper( node.rightNode );      // traverse right subtree
   } // end method preorderHelper

   // begin inorder traversal
   public void inorderTraversal()
   { 
      inorderHelper( root ); 
   } // end method inorderTraversal

   // recursive method to perform inorder traversal
   private void inorderHelper( TreeNode node ) //왼쪽으로 쭉 내려간 다음에 출력하고 오른쪽으로 감
   //출력하면 작은거부터 큰거까지 순서대로 나옴
   {
      if ( node == null )
         return;

      inorderHelper( node.leftNode );        // traverse left subtree
      System.out.printf( "%d ", node.data ); // output node data
      inorderHelper( node.rightNode );       // traverse right subtree
   } // end method inorderHelper

   // begin postorder traversal
   public void postorderTraversal()
   { 
      postorderHelper( root ); 
   } // end method postorderTraversal

   // recursive method to perform postorder traversal
   private void postorderHelper( TreeNode node ) //끝까지 내려간 더 내려갈 곳 없으면 출력하고 올라갔다가 다시 내려가서 출력
   {
      if ( node == null )
         return;
  
      postorderHelper( node.leftNode );      // traverse left subtree
      postorderHelper( node.rightNode );     // traverse right subtree
      System.out.printf( "%d ", node.data ); // output node data
   } // end method postorderHelper
} // end class Tree

