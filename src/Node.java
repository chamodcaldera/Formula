

import java.awt.*;
import java.util.Formatter;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Node {
    static String[] operators = {"/","*","-","+"};

    static class TreeNode{
        TreeNode left;
        TreeNode right;
        String operator;

        public TreeNode(TreeNode leftSubTree, TreeNode rightSubTree, String operator) {
            this.left = leftSubTree;
            this.right = rightSubTree;
            this.operator = operator;
        }

        @Override
        public String toString() {
            if (left == null && right == null){
                return operator;
            }else if (left==null){
                return ""+left+" "+operator+" ";
            }else if (right == null){
                return " "+operator+" "+right+"";
            }else
               return String.format("(%1$s), %2$s ,%3$s", left,operator,right);



        }


        public String toString1() {
            if (left == null && right == null){
                return operator;
            }else if (left==null){
                return ""+left+" "+operator+" ";
            }else if (right == null){
                return " "+operator+" "+right+"";
            }else
                return ""+left+""+operator+""+right+"";
        }

    }

    public static TreeNode buildTree(double numOfNodes){
        Random randNum = new Random();
        if (numOfNodes == 1){
            int value  = 1+randNum.nextInt(20);

            return new TreeNode(null, null, Integer.toString(value));
        }

        double numLeft = Math.ceil(numOfNodes/2);
        TreeNode leftSubTree = buildTree(numLeft);
        double numRight = Math.floor(numOfNodes/2);
        TreeNode rightSubTree = buildTree(numRight);

        int m = randNum.nextInt(operators.length);
        String operator = operators[m];

        return new TreeNode(leftSubTree,rightSubTree, operator);


    }



    public static int evalTree(TreeNode root)
    {

        // Empty tree
        if (root == null)
            return 0;

        // Leaf node i.e, an integer
        if (root.left == null && root.right == null)

            try{
                int number = Integer.parseInt(root.operator);
                return number; // output = 25
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }


        // Evaluate left subtree
        int leftEval = evalTree(root.left);

        // Evaluate right subtree
        int rightEval = evalTree(root.right);

        // Check which operator to apply
        if (root.operator.equals("+"))
            return leftEval + rightEval;

        if (root.operator.equals("-"))
            return leftEval - rightEval;

        if (root.operator.equals("*"))
            return leftEval * rightEval;

        return leftEval / rightEval;
    }

    public static void main(String[] args) {
//        Scanner sc= new Scanner(System.in);
//        System.out.print("Enter the level no: ");
//        double input = sc.nextDouble();
//        System.out.println(buildTree(3).toString());
        Random random=new Random();
        int ranlevel1 =1+random.nextInt(4);
        int ranlevel2 =1+random.nextInt(4);

        TreeNode newtree1= buildTree(ranlevel1);

        TreeNode newtree2=buildTree(ranlevel2);

        int validation1 =evalTree(newtree1);
        int validation2 =evalTree(newtree2);




        if (ranlevel1==2 || ranlevel2==2){
            System.out.println(newtree1.toString1());
            System.out.println(newtree2.toString1());
        }
        else {
            System.out.println(newtree1.toString());
            System.out.println(newtree2.toString());
        }









    }





}