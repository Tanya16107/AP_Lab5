//Tanya Gupta 
//2016107
import java.util.*;
import java.io.*;


/*Reader class*/
class Reader
{
    BufferedReader br;
    StringTokenizer tk;
    Reader() throws IOException
    {
        br=new BufferedReader(new InputStreamReader(System.in));
        tk=new StringTokenizer("");
    }
    public int nextInt() throws IOException
    {
        while(!tk.hasMoreTokens())
        {
            tk=new StringTokenizer(br.readLine().replaceAll("\r",""));
        }
        return Integer.parseInt(tk.nextToken());
    }
    public Float nextFloat() throws IOException
    {
        while(!tk.hasMoreTokens())
        {
            tk=new StringTokenizer(br.readLine().replaceAll("\r",""));
        }
        return Float.parseFloat(tk.nextToken());
    }
    public String next() throws IOException
    {
        return br.readLine();
    }
}

class TreeNode<T extends Comparable<T>> implements Comparable<TreeNode<T>>{
    private T engraving;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T engraving){
        this.engraving = engraving;
    }

    public T getEngraving(){
        return engraving;
    }

    public TreeNode<T> getRight(){
        return right;
    }

    public TreeNode<T> getLeft(){
        return left;
    }

    public void setRight(TreeNode<T> t){
        right = t;
    }

    public void setLeft(TreeNode<T> t){
        left = t;
    }

    @Override
    public int compareTo(TreeNode<T> t){
        return engraving.compareTo(t.getEngraving());
    }
}

class Tree<T extends Comparable<T>>{
    private TreeNode<T> root;

    public Tree(){
        this.root = null;
    }

    public TreeNode<T> getRoot(){
        return root;
    }

    public void insert(T engraving){
        TreeNode<T> newNode = new TreeNode<T>(engraving);

        if(root==null){
            root = newNode;
        }
        else{
            TreeNode<T> currentNode = root;
            TreeNode<T> parent;
            while(true){
                parent = currentNode;
                if(newNode.compareTo(parent)<0){
                    currentNode = currentNode.getLeft();
                    if(currentNode==null){
                        parent.setLeft(newNode);
                        return;
                    }
                }

                if(newNode.compareTo(parent)>0){
                    currentNode = currentNode.getRight();
                    if(currentNode==null){
                        parent.setRight(newNode);
                        return;
                    }

                }

            }
        }
    }

    public void inOrder(TreeNode<T> t){
        if(t==null){
            return;
        }
        inOrder(t.getLeft());
        System.out.println(t.getEngraving()+" ");
        inOrder(t.getRight());

    }
}

class App{
    public static void main(String[] args) throws IOException {

        Reader rd = new Reader();

        int numTrees = rd.nextInt();
        int numStudents = rd.nextInt();

        



        
        

        
    }
}
