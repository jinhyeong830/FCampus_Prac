package make_queue;

import java.util.ArrayList;

public class MakeQueue<T> {
	private ArrayList<T> queue=new ArrayList<T>();
	
	//enqueue, dequeue, isempty 메소드 구현
	public void Enqueue(T item) {
		queue.add(item);
	}
	
	public T Dequeue() {
		if(queue.isEmpty()) {
			return null;
		}
		return queue.remove(0);
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	//main

	public static void main(String[] args) {
		MakeQueue<Integer> q=new MakeQueue<Integer>();
		
		q.Enqueue(1);
		q.Enqueue(2);
		q.Enqueue(5);
		
		System.out.println(q.Dequeue());
		System.out.println(q.Dequeue());
		System.out.println(q.Dequeue());
		
		//결과: fifo->1 2 5 순으로 나올것..



		

	}

}
