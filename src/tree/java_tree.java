package tree;
import java.util.ArrayList;
import java.util.Stack;
public  class java_tree {
    //先定义一个结点类，方便后续操作
     class TreeNode {
        int val;        //结点的值大小
        TreeNode left;  //左节点
        TreeNode right;  //右节点
        TreeNode(int x) {
            val = x;
        }
    }
   static TreeNode[] node = new TreeNode[10];//以数组形式定义一棵完全二叉树，作为java_tree的成员变量

    public void init() {      //初始化方法,用来生成完全二叉树
        for (int i = 0;i < 10; i++) {
            node[i] = new TreeNode(i);
        }
        for (int i = 0;i < 10; i++) {
            if (i * 2 + 1 < 10)
                node[i].left = node[i * 2 + 1];
            if (i * 2 + 2 < 10)
                node[i].right = node[i * 2 + 2];
        }
    }
//----------------------------------------------前序遍历-----------------------------------------------------------------
//递归实现
    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);   //左结点遍历完了就遍历右结点。
            preOrder(root.right);
        }

    }
//非递归实现
        public ArrayList preOrder1(TreeNode root) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            ArrayList alist = new ArrayList(); //用来存放遍历结果
            TreeNode p = root;
            while (p != null || !stack.empty()) {
                while (p != null) {     //这里while语句是一直遍历左结点，直到所有左结点遍历完
                    alist.add(p.val);
                    stack.push(p);
                    p = p.left;
                }
                if (!stack.empty()) {    //到哪个结点遍历结束左边结点，就弹出这个这个结点，开始遍历又结点
                    TreeNode temp = stack.pop();
                    p = temp.right;
                }
            }
            return alist;
        }
//----------------------------------------------中序遍历-----------------------------------------------------------------
//----------------------------------------------后序遍历-----------------------------------------------------------------



    //测试方法
    public static void main(String[] args) {
        java_tree test=new java_tree();
        test.init();  //执行初始化方法
        System.out.print("前序遍历(递归)：");
        test.preOrder(node[0]);   //前序，递归实现
        System.out.println();
        System.out.print("前序遍历(非递归)：");
        System.out.println(test.preOrder1(node[0]));
    }
}