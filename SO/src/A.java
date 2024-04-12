import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;

public class A {

	public static void main(String[] args) {
		int t,n,z;
		Scanner entry = new Scanner(System.in);
		Comparator<Integer> c = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1>o2)return 1;
				else if(o1<o2)return -1;
				return 0;
			}
		};
		
		
		t = entry.nextInt();
		for(int i=0;i<t;i++) {
			PriorityQueue<Integer> q = new PriorityQueue<>(c);
			n = entry.nextInt();
			z = entry.nextInt();
			
			for(int j=0;j<n;j++) {
				Integer temp = new Integer(entry.nextInt());
				q.add(temp);		
			}
			int cont = 0;
			System.out.println(q.size());
			/*
			while(z>0){
				int temp = q.poll();
				System.out.println(z);
				z-=temp;
				q.add(temp/2);
			}
			System.out.println(cont);*/
		}
		entry.close();
	}
}
