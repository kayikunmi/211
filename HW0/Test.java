public class Test {
    public static void main (String [] args){
        String s = "s";
        String r = "r";
        String k = "k";
        String a = "a";
        String t = "t";
        int p = 3;
        LinkedList list = new LinkedList();
        list.add(s);
        list.add(t);
        list.add(a);
        list.add(r);
        list.add(k);//add(s) works
        System.out.println("The traversered list: " + list.traverse()); //traverse works
        System.out.println("Count of 's': " + list.count(s));//count(s) works
        list.add(s, p);
        System.out.println("The list after adding at 3: " + list.traverse());//add(s,p) works
        System.out.println("Count of 's': " + list.count(s));
        System.out.println("Remove k: " + list.remove(k));

        list.reverse();
        System.out.println("The reversed list: " + list.traverse());
        // System.out.println("Remove at p: " + list.remove(2)); //rn, it correctly ids what is at p, but doesn't remove it
        // System.out.println("The traversered list after removig 2: " + list.traverse());
        // System.out.println("Remove FO: " + list.remove(s));
        // System.out.println("The list after remove: " + list.traverse());
    }

}