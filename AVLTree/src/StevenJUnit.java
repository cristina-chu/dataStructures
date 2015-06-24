import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StevenJUnit{
	AVLTree<Integer> h,g,f,newTree,tree,tree2,tree3,tree4;
	Integer[] listf = {1,2,3,4,5,6,7,14,15,16};
	Integer[] listNew = {null};

	@org.junit.Before public void setUp(){
		newTree = new AVLTree<Integer>();

		tree=new AVLTree<Integer>();
		tree2=new AVLTree<Integer>();
		tree3=new AVLTree<Integer>();
		tree4=new AVLTree<Integer>();

		f = new AVLTree<Integer>();
		f.add(3);
		f.add(2);
		f.add(1); 
		f.add(4);
		f.add(5);
		f.add(6);
		f.add(7);
		f.add(16);
		f.add(15);
		f.add(14);
		
		g = new AVLTree<Integer>();
		g.add(5);
		g.add(7);
		g.add(3);
	}

	@Test(timeout = 2000)
	public void testCompiler(){
		AVLTree<Integer> h = new AVLTree<Integer>();
		assertEquals("check compiler",null,data(h,""));
		assertEquals("check compiler",0,h.size());
		assertTrue("check compiler",h.isEmpty());
	}

	@Test(timeout = 2000)
	public void testAdd1(){
		newTree.add(3);
		newTree.add(2);
		newTree.add(1);
		assertEquals("check add: single right rotation",2,(int)newTree.getRoot().getData());
		assertEquals("check add: single right rotation",3,(int)data(newTree,"r"));
		assertEquals("check add: single right rotation",1,(int)data(newTree,"l"));
		assertEquals("check add: size incorrect",3,g.size());
	}

	@Test(timeout = 2000)
	public void testAdd2(){
		newTree.add(3);
		newTree.add(2);
		newTree.add(1); 
		newTree.add(4);
		newTree.add(5);
		assertEquals("check add: single left rotation",4,(int)data(newTree,"r"));
		assertEquals("check add: single left rotation",3,(int)data(newTree, "rl"));
		assertEquals("check add: single left rotation",5,(int)data(newTree, "rr"));
		assertEquals("check add: size incorrect",5,newTree.size());
	}

	@Test(timeout = 2000)
	public void testAdd3(){
		newTree.add(3);
		newTree.add(2);
		newTree.add(1); 
		newTree.add(4);
		newTree.add(5);
		newTree.add(6);
		assertEquals("check add: pivot is at root",4,(int)data(newTree,""));
		assertEquals("check add: pivot is at root",2,(int)data(newTree,"l"));
		assertEquals("check add: pivot is at root",3,(int)data(newTree,"lr"));
	}

	@Test(timeout = 2000)
	public void testAdd4(){
		newTree.add(3);
		newTree.add(2);
		newTree.add(1); 
		newTree.add(4);
		newTree.add(5);
		newTree.add(6);
		newTree.add(7);
		newTree.add(16);
		//System.out.println(newTree.asSortedList());
		newTree.add(15);
		//System.out.println(newTree.asSortedList());
		//System.out.println(newTree.getRoot().getData());
		assertEquals("check add: left right rotation",15,(int)data(newTree,"rr"));
		assertEquals("check add: left right rotation",7,(int)data(newTree,"rrl"));
		assertEquals("check add: left right rotation",16,(int)data(newTree,"rrr"));
	}
	
	
	@Test(timeout = 2000)
	public void testAdd5(){
		newTree.add(3);
		newTree.add(2);
		newTree.add(1); 
		newTree.add(4);
		newTree.add(5);
		newTree.add(6);
		newTree.add(7);
		newTree.add(16);
		newTree.add(15);
		newTree.add(14);
		assertEquals("check add: right left rotation",7,(int)data(newTree,"r"));
		assertEquals("check add: left right rotation",6,(int)data(newTree,"rl"));
		assertEquals("check add: left right rotation",5,(int)data(newTree,"rll"));
		assertEquals("check add: left right rotation",15,(int)data(newTree,"rr"));
		assertEquals("check add: left right rotation",16,(int)data(newTree,"rrr"));
		assertEquals("check add: left right rotation",14,(int)data(newTree,"rrl"));
	}

	@Test(timeout = 2000)
	public void testTree(){
		assertEquals("failed constructing tree",4,(int)data(f,""));
		assertEquals("failed constructing tree",7,(int)data(f,"r"));
		assertEquals("failed constructing tree",2,(int)data(f,"l"));
		assertEquals("failed constructing tree",1,(int)data(f,"ll"));
		assertEquals("failed constructing tree",3,(int)data(f,"lr"));
		assertEquals("failed constructing tree",6,(int)data(f,"rl"));
		assertEquals("failed constructing tree",5,(int)data(f,"rll"));
		assertEquals("failed constructing tree",15,(int)data(f,"rr"));
		assertEquals("failed constructing tree",14,(int)data(f,"rrl"));
		assertEquals("failed constructing tree",16,(int)data(f,"rrr"));
		assertEquals("check size method",10,f.size());
	}

	@Test(timeout = 2000)
	public void testAdd6(){
		f.add(null); //test what happens when adding null
	}

	@Test(timeout = 2000)
	public void testAdd7(){
		f.add(1);
		assertEquals("what happens when you add same numbers?",4,(int)data(f,""));
		assertEquals("what happens when you add same numbers?",7,(int)data(f,"r"));
		assertEquals("what happens when you add same numbers?",2,(int)data(f,"l"));
		assertEquals("what happens when you add same numbers?",1,(int)data(f,"ll"));
		assertEquals("what happens when you add same numbers?",3,(int)data(f,"lr"));
		assertEquals("what happens when you add same numbers?",6,(int)data(f,"rl"));
		assertEquals("what happens when you add same numbers?",5,(int)data(f,"rll"));
		assertEquals("what happens when you add same numbers?",15,(int)data(f,"rr"));
		assertEquals("what happens when you add same numbers?",14,(int)data(f,"rrl"));
		assertEquals("what happens when you add same numbers?",16,(int)data(f,"rrr"));
		//System.out.println(f.size());
		//System.out.println(f.asSortedList());
		assertEquals("check size method",10,f.size());	
	}

	@Test(timeout = 2000)
	public void testIsEmpty1(){
		assertTrue("check isEmpty: case true",newTree.isEmpty());
		assertTrue("check size", newTree.size()==0);
	}

	@Test(timeout = 2000)
	public void testIsEmpty2(){
		assertFalse("check isEmpty: case false", f.isEmpty());
	}
/*
	@Test(timeout = 2000)
	public void testClear1(){
		f.clear();
		assertTrue("fail clearing a full tree",f.isEmpty());
		assertEquals("fail to reset the size",0,f.size());
		assertEquals("failed to reset nodes",null,f.getRoot().getData());
	}
	@Test(timeout = 2000)
	public void testClear2(){
		newTree.clear();
		assertTrue("fail clearing empty tree",newTree.isEmpty());
		assertTrue("fail clearing empty tree", newTree.getRoot().getData()==null);
	}
*/
	
	@Test(timeout = 2000)
	public void testSize1(){
		AVLTree<Integer> h = new AVLTree<Integer>();
		assertEquals("failed to get size of new tree",0,(int)h.size());
		assertEquals("failed to get size of a tree",10,(int)f.size());
	}

	@Test(timeout = 2000)
	public void testSize2(){
		f.add(40);
		assertEquals("fail to update size when adding",11,(int)f.size());
		f.remove(1);
		f.remove(2);
		assertEquals("fail to update size when removing",9,(int)f.size());
	}

	@Test(timeout = 2000)
	public void testGet1(){
		assertEquals("check get method",15,(int)f.get(15));
		assertEquals("check get: get root",4,(int)f.get(4));
		//System.out.println(f.asSortedList());
		//System.out.println(f.getRoot().getData());
		assertEquals("check get: get from bottom",5,(int)f.get(5));
		//System.out.println(f.get(5));
		
		//not getting from the bottom
	}

	@Test(timeout = 2000)
	public void testGet2(){
		assertTrue("check get: get from empty tree",null == newTree.get(3));
	}

	@Test(timeout = 2000)
	public void testGet3(){
		f.clear();
		assertTrue("check get: get from cleared tree",null == f.get(15));
		assertTrue("check get: get from cleared tree",null == f.get(4)); // this was the root
	}

	@Test(timeout = 2000)
	public void testGet4(){
		newTree.add(4);
		assertEquals("check get: get just added", 4,(int)f.get(4));
	}

	@Test(timeout = 2000)
	public void testGet5(){
		f.remove(3);
		assertTrue("check get: get just removed", null == f.get(3));
	}

	@Test(timeout = 2000)
	public void testGet6(){
		assertTrue("check get: get somethign that doesn't exist",null == f.get(100));
	}

	@Test(timeout = 2000)
	public void testGet7(){
		assertTrue("check get: getting null",null == f.get(null));
	}

	@Test(timeout = 2000)
	public void testTraverse1(){
		int counter = 0;
		boolean correct = true;
		String l ="";
		for (Integer i : f.asSortedList()){
			if (!(i==listf[counter])){
				correct = false;
				break;
			}
			counter++;
		}
		for (Integer i : f.asSortedList()){
			l = l+" "+i;
		}
		assertTrue("traverse not correct: "+l,correct);
	}

	@Test(timeout = 2000)
	public void testTraversal2(){
		boolean correct = true;
		for(Integer i : newTree.asSortedList()){
			if(i !=null){
				correct = false;
				break;
			}
		}
		assertTrue("failed traversing an empty tree",correct);
	}
	
	@Test(timeout = 2000)
	public void testRemove1(){
		assertEquals("failed to return deleted",1,(int)f.remove(1));
		assertEquals("failed to update size()",9,f.size());
	}

	@Test(timeout = 2000)
	public void testRemove2(){
		assertEquals("failed to return deleted",5,(int)f.remove(5));
		assertEquals("failed to return deleted",14,(int)f.remove(14));
		assertEquals("failed to update size()",8,f.size());
		assertEquals("failed to actually remove",null,f.getRoot().getRight().getLeft().getLeft());
		assertEquals("failed to actually remove",null,f.getRoot().getRight().getRight().getLeft());
	}
	
	@Test(timeout = 2000)
	public void testRemove3(){
		assertEquals("failed removing from empty tree",null,newTree.remove(5));
	}

	@Test(timeout = 2000)
	public void testRemove4(){
		assertEquals("failed removing non-existing node",null,f.remove(100));
	}

	@Test(timeout = 2000)
	public void testRemove5(){
		assertEquals("failed removing null",null,f.remove(null));
	}

	@Test(timeout = 2000)
	public void testRemove6(){
		assertEquals("fail to return correct data",4,(int)f.remove(4));
		assertEquals("failed to remove root",5,(int)f.getRoot().getData());
		assertEquals("failed to link right after removing from root",7,(int)data(f,"r"));
		assertEquals("failed to link left after removing from root",2,(int)data(f,"l"));
		assertEquals("failed to remove the replaced node after removing from root",null,f.getRoot().getRight().getLeft().getLeft());
	}

	@Test(timeout = 2000)
	public void testRemove7(){
		System.out.println("START!");
		
		System.out.println(f.getRoot().getRight().getData()+":"+f.getRoot().getRight().getParent().getData());
		System.out.println(f.getRoot().getLeft().getData()+":"+f.getRoot().getLeft().getParent().getData());
		
		System.out.println(f.getRoot().getLeft().getRight().getData()+":"+f.getRoot().getLeft().getRight().getParent().getData());
		
		assertEquals("failed to return correct data",1,(int)f.remove(1));
		System.out.println("parent of 3:"+f.getRoot().getLeft().getData()+"man");
		assertEquals("failed to return correct data",3,(int)f.remove(3));
		//System.out.println(f.asSortedList());
		//System.out.println(f.getRoot().getData());
		assertEquals("failed to rotate after remove",6,(int)data(f,""));
		//System.out.println("remove 6"+f.asSortedList());
		assertEquals("failed to rotate after remove",4,(int)data(f,"l"));
		assertEquals("failed to rotate after remove",7,(int)data(f,"r"));
	}

	@Test(timeout = 2000)
	public void testRemove8(){
		assertEquals("failed to return correct data",3,(int)g.remove(3));
		assertEquals("failed to return correct data",5,(int)g.remove(5));
		assertEquals("failed to return correct data",7,(int)g.remove(7));
		assertTrue("failed to remove everything", g.isEmpty());
		assertEquals("failed to remove everything",0,(int)g.size());
	}

	@Test(timeout = 2000)
	public void testIlyssa1tree1(){
		assertTrue("failed isEmpty",tree.isEmpty());
		assertTrue("failed size()",tree.size()==0);
	}

	@Test(timeout = 2000)
	public void testIlyssa1tree2(){
		tree.add(5);
		assertEquals("wrong size",1,(int)tree.size());
		assertEquals("wrong root",5,(int)(tree.getRoot()).getData());
		assertEquals("wrong bf",0,(int)(tree.getRoot()).getBf());
		assertEquals("wrong height",1,(int)(tree.getRoot()).getHeight());
		}	

	@Test(timeout = 2000)
	public void testIlyssa1tree3(){
		tree.add(5);
		tree.add(6);
		assertEquals("didn't add",6,(int)((tree.getRoot()).getRight()).getData());
		assertEquals("wrong size",2,(int)tree.size());
		assertEquals("wrong height",2,(int)(tree.getRoot()).getHeight());
		assertEquals("wrong bf",-1,(int)(tree.getRoot()).getBf());
		assertEquals("wrong child height",1,(int)tree.getRoot().getRight().getHeight());
		assertEquals("wrong child bf",0,(int)tree.getRoot().getRight().getBf());
		assertEquals("added wrong way",null,tree.getRoot().getLeft());
		}

	@Test(timeout = 2000)
	public void testIlyssa1tree4(){
		tree.add(5);
		tree.add(6);	
		tree.add(3);
		assertEquals("didn't add",3,(int)(tree.getRoot()).getLeft().getData());
		assertEquals("wrong size",3,(int)tree.size());
		assertEquals("wrong height",2,(int)(tree.getRoot()).getHeight());
		assertEquals("wrong bf",0,(int)(tree.getRoot()).getBf());
		assertEquals("wrong child height",1,(int)(tree.getRoot()).getLeft().getHeight());
		}

	@Test(timeout = 2000)
	public void testIlyssatree5(){
		tree.add(5);
		tree.add(6);	
		tree.add(3);
		tree.add(7);
		assertEquals("wrong size",4,(int)tree.size());
		assertEquals("wrong height",3,(int)(tree.getRoot()).getHeight());
		assertEquals("wrong bf",-1,(int)(tree.getRoot()).getBf());
		assertEquals("wrong child bf",-1,(int)((tree.getRoot()).getRight()).getBf());
		assertEquals("wrong child height",2,(int)(tree.getRoot()).getRight().getHeight());
		assertEquals("wrong add",7,(int)((((tree.getRoot()).getRight())).getRight()).getData());
	}
		
	@Test(timeout = 2000)
	public void testIlyssatree6(){
		tree.add(5);
		tree.add(6);	
		tree.add(3);
		tree.add(7);
		tree.add(2);
		assertEquals("wrong size",5,(int)tree.size());
		assertEquals("wrong height",3,(int)tree.getRoot().getHeight());
		assertEquals("wrong bf",0,(int)tree.getRoot().getBf());
		assertEquals("wrong child bf",1,(int)((tree.getRoot()).getLeft()).getBf());
		assertEquals("wrong child height",2,(int)((tree.getRoot()).getLeft()).getHeight());
		}

	@Test(timeout = 2000)
	public void testIlyssa1tree7(){
		tree.add(5);
		tree.add(6);	
		tree.add(3);
		tree.add(7);
		tree.add(2);
		tree.remove(2);
		assertEquals("wrong size",4,(int)tree.size());
		assertEquals("wrong bf",-1,(int)tree.getRoot().getBf());
		assertEquals("wrong adding",3,(int)((tree.getRoot()).getLeft()).getData());
		assertEquals("didn't add right",null,((tree.getRoot()).getLeft()).getLeft());
	}
		
	@Test(timeout = 2000)
	public void testIlyssa1tree8(){
		tree.add(5);
		tree.add(6);	
		tree.add(3);
		tree.add(7);
		tree.add(2);
		tree.remove(2);
		tree.remove(6);
		assertEquals("wrong data right of root",7,(int)((tree.getRoot()).getRight()).getData());
		assertEquals("wrong tree size",3,(int)tree.size());
		assertEquals("wrong tree height",2,(int)tree.getRoot().getHeight());
		assertEquals("wrong tree bf",0,(int)tree.getRoot().getBf());
		tree.clear();
		assertTrue("didn't clear",tree.isEmpty());
	}

	@Test(timeout = 2000)
	public void testIlyssa2tree1(){
		tree2.add(3);
		tree2.add(2);
		tree2.add(1);
		assertEquals("wrong tree bf should be 0",0,(int)tree2.getRoot().getBf());
		assertEquals("wrong tree Bf",0,(int)(tree2.getRoot()).getBf());
		assertEquals("wrong left child bf",0,(int)((tree2.getRoot()).getLeft()).getBf());
		assertEquals("wrong root",2,(int)(tree2.getRoot()).getData());
		assertEquals("wrong right node",3,(int)((tree2.getRoot()).getRight()).getData());
		assertEquals("wrong left node",1,(int)((tree2.getRoot()).getLeft()).getData());
	}
	
	@Test(timeout = 2000)
	public void testIlyssa2tree2(){
		tree2.add(3);
		tree2.add(2);
		tree2.add(1);
		tree2.add(4);
		assertEquals("wrong data added",4,(int)tree2.getRoot().getRight().getRight().getData());
	}

	@Test(timeout = 2000)
	public void testIlyssa2tree3(){
		tree2.add(3);
		tree2.add(2);
		tree2.add(1);
		tree2.add(4);		
		tree2.add(5);
		assertEquals("Wrong right node",4,(int)tree2.getRoot().getRight().getData());
		assertEquals("wrong right left node",3,(int)tree2.getRoot().getRight().getLeft().getData());
		assertEquals("wrong right right node",5,(int)tree2.getRoot().getRight().getRight().getData());
	}
	
	@Test(timeout = 2000)
	public void testIlyssa2tree4(){
		tree2.add(3);
		tree2.add(2);
		tree2.add(1);
		tree2.add(4);		
		tree2.add(5);
		tree2.add(6);
		tree2.add(4);
		assertEquals("wrong root",4,(int)tree2.getRoot().getData());
		assertEquals("wrong right node",5,(int)tree2.getRoot().getRight().getData());
		assertEquals("wrong left node",2,(int)tree2.getRoot().getLeft().getData());
	}
	
	@Test(timeout = 2000)
	public void testIlyssa3tree1(){
		tree3.add(3);
		tree3.add(4);
		tree3.add(5);
		assertEquals("wrong tree bf",0,(int)tree3.getRoot().getBf());
		assertEquals("wrong tree height",2,(int)tree3.getRoot().getHeight());
		assertEquals("wrong root node",4,(int)tree3.getRoot().getData());
		assertEquals("wrong right node",5,(int)tree3.getRoot().getRight().getData());
		assertEquals("wrong left node",3,(int)tree3.getRoot().getLeft().getData());
		assertEquals("check get method",3,(int)tree3.get(3));
		assertEquals("check get method",4,(int)tree3.get(4));		
		assertEquals("check get method",5,(int)tree3.get(5));
	}

	@Test(timeout = 2000)
	public void testIlyssa4tree(){
		tree4.add(4);
		tree4.add(5);
		tree4.add(6);
		tree4.add(3);
		tree4.remove(5);
		assertEquals("wrong root/didn't rotate after remove",4,(int)tree4.getRoot().getData()); 
		assertEquals("wrong left data",3,(int)tree4.getRoot().getLeft().getData());
		assertEquals("wrong height",2,(int)tree4.getRoot().getHeight());
	}

	private Integer data(AVLTree<Integer> tree,String path){
		Node<Integer> node = tree.getRoot();
		for (int i=0;i<path.length();i++){
			if (((Character)path.charAt(i)).compareTo('l')==0)
				node = node.getLeft();
			else if (((Character)path.charAt(i)).compareTo('r')==0){
				node = node.getRight();
			}
		}
		if (node == null)
			return null;
		return (Integer) node.getData();
	}
}
