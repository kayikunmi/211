public class Test {
    public static void main (String [] args){
        String s = "s";
        String r = "r";
        String k = "k";
        String a = "a";
        String t = "t";
        String y = "y";
        String m = "m";
        int p = 1;
        int q = 5;
        LinkedList list = new LinkedList();
        list.add(s);
        list.add(t);
        list.add(a);
        list.add(r);
        list.add(k);
        list.add(y);//add(s) works
        System.out.println("The traversered list: " + list.traverse()); //traverse works
        System.out.println("Count of 's': " + list.count(s));//count(s) works
        list.add(m, q);
        System.out.println("The list after adding at 3: " + list.traverse());//add(s,p) works
        System.out.println("Count of 's': " + list.count(s));
        System.out.println("Remove k: " + list.remove(k));
        list.add("e");
        System.out.println("list without k: " + list.traverse()); //traverse works
        //System.out.println("sawp: " + list.swap(p,q));
        list.swap(p,q);
        System.out.println("Swaped list: " + list.traverse()); //swap works
        System.out.println("Remove all: " + list.removeAll(s)); //traverse works
        //System.out.println("Remove at q: " + list.remove(q)); //traverse works
        
        list.reverse();
        
        System.out.println("The reversed list: " + list.traverse());
    }

} 