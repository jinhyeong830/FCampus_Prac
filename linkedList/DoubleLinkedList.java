package linkedList;

public class DoubleLinkedList <T> {
	public Node<T> head=null;
	public Node<T> tail=null; //Node클래스에 대한 객체 head와 tail을 선언한 것
	
	public class Node<T> {
		T data;
		Node<T> prev=null;
		Node<T> next=null;
		
		public Node(T data) { //생성자
			this.data=data;
		}
	}
	
	//삽입
	public void addNode(T data) { 
		if(this.head==null) { //연결리스트에 데이터가 아무것도 없을 때
			this.head=new Node<T>(data); //Node의 data가 매개변수의data와 같은 head노드 생성..
			this.tail=this.head; //데이터가 하나니까 tail이  head인 것
		}else {//빈 연결리스트가 아닐 때
			Node<T> node=this.head;
			while(node.next!=null) {
				node=node.next;
			}
			node.next= new Node<T>(data);
			node.next.prev=node;
			this.tail=node.next;
		}
	}
}
