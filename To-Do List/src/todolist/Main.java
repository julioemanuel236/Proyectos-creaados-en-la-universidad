package todolist;

public class Main {

	public static void main(String[] args) {
		HeapPriQueue pq = new HeapPriQueue(10);
		for(int i=0 ; i < 10 ;i++)
			pq.enqueue(new Task(i));
		System.out.println("Default list:");
		pq.printList();
		System.out.println("Promote a Task with ID 1");
		pq.promote(1);
		System.out.println("list:");
		pq.printList();
		System.out.println("Demote a Task with ID 2");
		pq.demote(2);
		System.out.println("list:");
		pq.printList();
		System.out.println("try to add a new Item");
		try {
			pq.enqueue(new Task(11));
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("Dequee a Item");
		try {
			pq.dequeue();
		}
		catch(Exception e) {
			
		}
		System.out.println("list:");
		pq.printList();
	}
		
}