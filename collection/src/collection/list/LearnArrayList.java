package collection.list;

import java.io.Console;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LearnArrayList {

	public static void main(String[] args) {
		
		List<Integer> ls= new ArrayList<>();
		Queue<Integer>lnklst=new LinkedList<>();
		System.out.println(lnklst.add(67));
		System.out.println(lnklst.offer(45));
		System.out.println(lnklst);
		
		for (int i = 0; i <=10; i++) {
			ls.add(i+i+2);
			
		}
		System.out.println(ls);
		ls.add(4, 23);
		System.out.println(ls);
		List<Integer>ls2=new ArrayList<Integer>();
		ls2.addAll(ls);
		
		System.out.println(ls2);
		int a=ls.get(5);
		System.out.println(a);
		System.out.println(ls.remove(3));
		System.out.println(ls);
		ls.clear();
		System.out.println(ls);
		Iterator<Integer>it=ls2.iterator();
		while(it.hasNext()) {
			System.out.println("elememts:"+it.next());
		}
		
		System.out.println(ls2.size()+":::"+ls.size());
		
		StringBuffer sb1= new StringBuffer("Abhishek");
		StringBuffer sb2= new StringBuffer("Kumar");
		String fname= sb1.append(" ").append(sb2).toString();
		System.out.println(fname);
		StringBuffer sb3= new StringBuffer(10);
		System.out.println(sb3.append("qwerty"));
		System.out.println(sb2.capacity());


	}

}
