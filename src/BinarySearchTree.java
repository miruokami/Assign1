// Hussein's Binary Search Tree
// 27 March 2017
// Hussein Suleman

public class BinarySearchTree<GenericsKb extends Comparable<? super GenericsKb>> extends BinaryTree<GenericsKb>
{
   public void insert ( GenericsKb d )
   {
      if (root == null)
         root = new BinaryTreeNode<GenericsKb> (d, null, null);
      else
         insert (d, root);
   }
   public void insert ( GenericsKb d, BinaryTreeNode<GenericsKb> node )
   {
      if (d.compareTo (node.data) <= 0)
      {
         if (node.left == null)
            node.left = new BinaryTreeNode<GenericsKb> (d, null, null);
         else
            insert (d, node.left);
      }
      else
      {
         if (node.right == null)
            node.right = new BinaryTreeNode<GenericsKb> (d, null, null);
         else
            insert (d, node.right);
      }
   }
   
   public BinaryTreeNode<GenericsKb> find ( GenericsKb d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   public BinaryTreeNode<GenericsKb> find ( GenericsKb d, BinaryTreeNode<GenericsKb> node )
   {
      if (d.compareTo (node.data) == 0) 
         return node;
      else if (d.compareTo (node.data) < 0)
         return (node.left == null) ? null : find (d, node.left);
      else
         return (node.right == null) ? null : find (d, node.right);
   }
   
   public void delete ( GenericsKb d )
   {
      root = delete (d, root);
   }   
   public BinaryTreeNode<GenericsKb> delete ( GenericsKb d, BinaryTreeNode<GenericsKb> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else if (node.left != null && node.right != null )
      {
         node.data = findMin (node.right).data;
         node.right = removeMin (node.right);
      }
      else
         if (node.left != null)
            node = node.left;
         else
            node = node.right;
      return node;
   }
   
   public BinaryTreeNode<GenericsKb> findMin ( BinaryTreeNode<GenericsKb> node )
   {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }

   public BinaryTreeNode<GenericsKb> removeMin ( BinaryTreeNode<GenericsKb> node )
   {
      if (node == null)
         return null;
      else if (node.left != null)
      {
         node.left = removeMin (node.left);
         return node;
      }
      else
         return node.right;
   }
   
}
