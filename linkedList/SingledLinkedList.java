package linkedList;

public class SingledLinkedList<T> {
	
	public Node<T> head=null;//아래 만들 Node<T> 클래스 참조할 것
	
	@SuppressWarnings("hiding")//이건 모니? 이클립스 추천템.. class Node<T>의 제네릭에 노란밑줄 없애주네..
	public class Node<T>{//노드 선언 ::Node=data+pointer
		T data;
		Node<T> next=null;
		//data를 입력 데이터를 받고, next가 다음 주소를 의미하는 것
		
		public Node(T data) {//class Node<T>의 생성자
			this.data=data;
		}
	}
	
	//**single연결 리스트 노드추가 메소드!!
	public void addNode(T data) {
		if(head==null) {
			//head null 일땐 입력데이터 바로 head에 넣으라는 의미(첫 노드가 되는것)
			head=new Node<T>(data); //이 문법은 잘 모르겠더,,->head에 Node객체 만들어서 바로 넣어주면 됨
		}else {
			Node<T> node=this.head;
			while(node.next!=null) {//마지막 노드의next는 null이기 때문에 마지막 노드가 될 때까지 반복하겠다는 의미
				node=node.next;
			}
			
			//여기서의 node.next는 원래 null인데, 새로운 노드를 넣어주는 것(입력된 data의 노드)
			node.next=new Node<T>(data);
		}
	}
	
	public void printAll() {
		if(head!=null) {
			Node<T> node =this.head;//첫 노드는 head
			System.out.println(node.data);//첫번째 노드(head ) print
			while(node.next!=null) {//다음 노드의 주소가 있다면
				node=node.next; //다음노드를 현재노드에 저장하고
				System.out.println(node.data);//그 노드의 data 프린트
			}
		}
	}

	public static void main(String[] args) {
		
		//선언한 SingledLinkedList형 객체 선언
		SingledLinkedList<Integer> singleLL=new SingledLinkedList<Integer>();
		singleLL.addNode(1);
		singleLL.addNode(5);
		singleLL.addNode(7);//선언한 객체의 노드추가 메소드 사용해서 data넣기
		
		singleLL.printAll();

	}

}
