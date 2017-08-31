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
    private boolean _isRoot;
    private TreeNode<T> left;
    private TreeNode<T> right;


    public TreeNode(T engraving){
        this.engraving = engraving;
        _isRoot = false;
    }

    public T getEngraving(){
        return engraving;
    }

    public void setisRoot(){
        this._isRoot = true;
    }

    public boolean getisRoot(){
        return this._isRoot;
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
            this.root.setisRoot();
        }
        else{
            TreeNode<T> currentNode = root;
            TreeNode<T> parent;
            while(true){
                parent = currentNode;
                if(newNode.compareTo(parent)<=0){
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

    int pos = 0;
    int c = 0;
    String sout = "";

    int iout = 0;

    float fout = 0;

        public void inOrderPrint(TreeNode<T> t){
        if(t==null){
            return;
        }
        inOrderPrint(t.getLeft());
        System.out.println(t.getEngraving()+" ");
        inOrderPrint(t.getRight());

    }

    public void inOrder(TreeNode<T> t){

        if(t==null){
            return;
        }
        
        inOrder(t.getLeft());
        justDoIt(t);
        inOrder(t.getRight());
    }

    private void justDoIt(TreeNode<T> t){

        if(t.getEngraving() instanceof String){
            sout+=(String)t.getEngraving();
        }
        if(t.getEngraving() instanceof Integer){
            iout+=(Integer)t.getEngraving();
        }
        if(t.getEngraving() instanceof Float){
            fout+=(Float)t.getEngraving();
        }
        c++;
        
        if(t.getisRoot()==true){
            pos = c;
        }
    }

    public int getPos(){
        return pos;
    }

    public String sgetOut(){
            return sout;
    }

    public int igetOut(){
            return iout;
    }

    public float fgetOut(){
            return fout;
    }
}

class Process{
    public void lol(int index, ArrayList<ArrayList<Object>> list) throws IOException{
        FileReader reader = new FileReader("./" + index + ".txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            line = bufferedReader.readLine();

            if(line.equals("String")){
         
                Tree<String> tree = new Tree<String>();

                line = bufferedReader.readLine();
                line = bufferedReader.readLine();
                //System.out.println(line);
                String[] arr = line.split(" ");
                //System.out.println(arr.length);
                for(int i=0; i<arr.length; i++){
                  
                    tree.insert(arr[i]);
                }
                //tree.inOrderPrint(tree.getRoot());

                tree.inOrder(tree.getRoot());
                int posOfRoot = tree.getPos();
                String concatString = tree.sgetOut();
                list.get(posOfRoot-1).add(concatString);
                return;


            }

            if(line.equals("Float")){
        
                Tree<Float> tree = new Tree<Float>();

                line = bufferedReader.readLine();
                line = bufferedReader.readLine();
               // System.out.println(line);
                String[] arr = line.split(" ");
                for(int i=0; i<arr.length; i++){

                    tree.insert(Float.valueOf(arr[i]));
                }

                //tree.inOrderPrint(tree.getRoot());

                tree.inOrder(tree.getRoot());
                int posOfRoot = tree.getPos();
                float sum = tree.fgetOut();
                list.get(posOfRoot-1).add(sum);
                return;

                
            }

            if(line.equals("Integer")){

                Tree<Integer> tree = new Tree<Integer>();
       
                line = bufferedReader.readLine();
                line = bufferedReader.readLine();
                //System.out.println(line);
                String[] arr = line.split(" ");
                for(int i=0; i<arr.length; i++){
      
                    tree.insert(Integer.valueOf(arr[i]));
                }

                //tree.inOrderPrint(tree.getRoot());

                tree.inOrder(tree.getRoot());
                int posOfRoot = tree.getPos();
                int sum = tree.igetOut();
                list.get(posOfRoot-1).add(sum);
                return;

                
            }



        
            reader.close();
 
    }

}



class App{
    public static void Print(ArrayList<?>  list, PrintWriter w){
        for(Object o: list)
            w.print(o+" ");
    }
    public static void main(String[] args) throws IOException {

        Reader rd = new Reader();
        
        System.out.println("Enter number of trees");
        int numTrees = rd.nextInt();
        System.out.println("Enter number of students");
        int numStudents = rd.nextInt();

        BSTFilesBuilder.createBSTFiles(numStudents, numTrees);

        ArrayList<ArrayList<Object>> serialNoStudents = new ArrayList<ArrayList<Object>>();

        for(int i=1; i<=numStudents; i++){
        ArrayList<Object> inner= new ArrayList<Object>();
        serialNoStudents.add(inner);
        }

        Process processor = new Process();

        for (int i=1; i<=numTrees ; i++) {
            processor.lol(i, serialNoStudents);
        }

        int numChocolates = 0;

        PrintWriter w = new PrintWriter(new FileWriter("./answer.txt"), true );
                
        
        for(int i=0; i<numStudents; i++){
            if(serialNoStudents.get(i).size()==0){
                numChocolates+=1;
            }
            else{
                w.print((i+1)+" ");
                Print(serialNoStudents.get(i), w);
                w.println();
            }
        }
        w.println(numChocolates);

        
    }
}
