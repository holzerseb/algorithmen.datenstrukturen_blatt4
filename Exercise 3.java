They look all bigger than they actually are, and more complicated than they are
but hey, they all run in O(n) worst case!

##################################################################
#																 #
#    						PRE-ORDER							 #
#																 #
##################################################################

//Runs in O(n) worst case
//p is the "last" visited position
//and it will return the position of the node after p in preorder traversal of T
private void preorderNext(TreeNode p)
{
	if(T == null || p == null)
		throw new Exception("Invalid Parameters");
	
	return preorderNextRec(p, p, 0);
}

//p is the node we currently are visiting
//s is the node we are searching for (the last visited node)
//position is the current position of the visited node
private int preorderNextRec(TreeNode p, TreeNode s, int position)
{
	if(p == s)
	{
		if(p.left != null)
			return 2*position + 1;
		else if(p.right != null)
			return 2*position + 2;
		else
			return -1; //-1 indicates the caller that the node was found,
					//but it has no childs, so the caller must determine
					//the next position
	}
	
	if(p.left != null)
	{
		int returnVal = preorderNextRec(p.left, s, 2*position + 1);
		
		if(returnVal == -1)
		{
			if(p.right != null)
				return 2*position + 2;
				//what this means is, that the very right external child
				//was the found node, and we now return the position
				//of the right sibling, who is the next visited node
			else
				return -1;
		}
		else if (returnVal >= 0)
			return returnVal; //if any recursive called function returns a val above
							//0, it must have found the correct next node
	}
	
	//if its not in the left child-hierarchy, maybe in the right one?
	if(p.right != null)
	{
		int returnVal = preorderNextRec(p.right, s, 2*position + 2);
		
		if(returnVal == -1)
		{
			if(p.right != null)
				return 2*position + 2;
			else
				return -1;
		}
		else if (returnVal >= 0)
			return returnVal;
	}
	
	//otherwise, we found nothin
	return -2;
}


##################################################################
#																 #
#    						IN-ORDER							 #
#																 #
##################################################################



private void inorderNext(TreeNode p)
{
	if(T == null || p == null)
		throw new Exception("Invalid Parameters");
	
	return inorderNextRec(p, p, 0);
}

//p is the node we currently are visiting
//s is the node we are searching for (the last visited node)
//position is the current position of the visited node
private int inorderNextRec(TreeNode p, TreeNode s, int position)
{
	/* All we did here was to move the if(s=p) between the childs */
	
	if(p.left != null)
	{
		int returnVal = inorderNextRec(p.left, s, 2*position + 1);
		
		if(returnVal == -1)
		{
			if(p.right != null)
				return 2*position + 2;
				//what this means is, that the very right external child
				//was the found node, and we now return the position
				//of the right sibling, who is the next visited node
			else
				return -1;
		}
		else if (returnVal >= 0)
			return returnVal; //if any recursive called function returns a val above
							//0, it must have found the correct next node
	}
	
	if(p == s)
	{
		if(p.left != null)
			return 2*position + 1;
		else if(p.right != null)
			return 2*position + 2;
		else
			return -1; //-1 indicates the caller that the node was found,
					//but it has no childs, so the caller must determine
					//the next position
	}
	
	//if its not in the left child-hierarchy, maybe in the right one?
	if(p.right != null)
	{
		int returnVal = inorderNextRec(p.right, s, 2*position + 2);
		
		if(returnVal == -1)
		{
			if(p.right != null)
				return 2*position + 2;
			else
				return -1;
		}
		else if (returnVal >= 0)
			return returnVal;
	}
	
	//otherwise, we found nothin
	return -2;
}


##################################################################
#																 #
#    						POST-ORDER							 #
#																 #
##################################################################


//Runs in O(n) worst case
//p is the "last" visited position
//and it will return the position of the node after p in preorder traversal of T
private int postorderNext(TreeNode p)
{
	if(T == null || p == null)
		throw new Exception("Invalid Parameters");
	
	return postorderNextRec(p, p, 0);
}

//p is the node we currently are visiting
//s is the node we are searching for (the last visited node)
//position is the current position of the visited node
private int postorderNextRec(TreeNode p, TreeNode s, int position)
{	
	/* Basically the same as preorder, just we check childs first */
	
	if(p.left != null)
	{
		int returnVal = postorderNextRec(p.left, s, 2*position + 1);
		
		if(returnVal == -1)
		{
			if(p.right != null)
				return 2*position + 2;
				//what this means is, that the very right external child
				//was the found node, and we now return the position
				//of the right sibling, who is the next visited node
			else
				return -1;
		}
		else if (returnVal >= 0)
			return returnVal; //if any recursive called function returns a val above
							//0, it must have found the correct next node
	}
	
	//if its not in the left child-hierarchy, maybe in the right one?
	if(p.right != null)
	{
		int returnVal = postorderNextRec(p.right, s, 2*position + 2);
		
		if(returnVal == -1)
		{
			if(p.right != null)
				return 2*position + 2;
			else
				return -1;
		}
		else if (returnVal >= 0)
			return returnVal;
	}
	
	
	if(p == s)
	{
		if(p.left != null)
			return 2*position + 1;
		else if(p.right != null)
			return 2*position + 2;
		else
			return -1; //-1 indicates the caller that the node was found,
					//but it has no childs, so the caller must determine
					//the next position
	}
	
	
	//otherwise, we found nothin
	return -2;
}