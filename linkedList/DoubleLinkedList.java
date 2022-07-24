package linkedList;

public class DoubleLinkedList <T> {
	public Node<T> head=null;
	public Node<T> tail=null; //Node클래스에 대한 객체 head와 tail을 선언한 것
	
	@SuppressWarnings("hiding")
	public class Node<T> {
		T data;
		Node<T> prev=null;
		Node<T> next=null;
		
		public Node(T data) { //생성자
			this.data=data;
		}
	}
	
	//삽입
	//1. 차례대로 삽입
	public void addNode(T data) { 
		if(this.head==null) { //연결리스트에 데이터가 아무것도 없을 때
			this.head=new Node<T>(data); //Node의 data가 매개변수의data와 같은 head노드 생성..
			this.tail=this.head; //데이터가 하나니까 tail이  head인 것
		}else {//빈 연결리스트가 아닐 때
			Node<T> node=this.head;
			while(node.next!=null) {
				node=node.next;
			}
			node.next= new Node<T>(data);// 맨 끝노드의 next에 새로운 data를 넣은 Node생성
			//node.next가 새로운 노드가 되는 것
			node.next.prev=node; //새로운 노드의 prev는 현재노드(while로 순회한 맨 끝 노드)
			this.tail=node.next;//전체 연결 리스트의 tail은 새로운 노드가 되는 것
		}
	}
	//2.임의의 노드 앞에 노드 삽입
	//연결관계 4개를 재설정해야 해서 로직이복잡함
	public boolean insertToFront(T existedData, T addData) {
		if(this.head==null) {//1. 연결리스트가 비어있을 때
			this.head=new Node<T>(addData);
			this.tail=this.head;
			
			return true;
		}else if(this.head.data==existedData){//2. head앞에 새로운 데이터를 삽입할 때
			Node<T>newHead=new Node<T>(addData); //삽입데이터가 들어있는 새로운 노드 newHead선언
			newHead.next=this.head; //노드 연결- 원래의 ㅗㄷㅁㅇ
			this.head.prev=newHead; //내가 넣은 코드.. 
			this.head=newHead; //newHead가 새로운 헤드가 되도록
			
			return true;
		}else {//3. head가 아닌 노드 앞에 새로운 데이터를 넣고 싶을 ㄸㅐ
			Node<T> node=this.head;
			while(node.next!=null) {
				if(node.data==existedData) {
					//head---origin1-(addData)-existedData-origin---origin-tail
					//위의 구조라면 origin1이 nodePrev인 것(existedData의 바로 앞 데이터)
					Node<T> nodePrev=node.prev;//node
					nodePrev.next=new Node<T>(addData);//새로운 data값 nodePrev.next에 할당
					
					
					nodePrev.next.next=node;//새로운 노드가 nodePrev.next이니, 새노드의 next (링크) 설정
					nodePrev.next.prev=nodePrev;// 새노드의 prev 설정
					node.prev=nodePrev.next;//existedData의 prev재설정
					
					return true;
				}else {
					node=node.next;
				}
			}
			return false;
		}
	}
	
	//출력
	public void printAll() {
		if(this.head!=null) {
			Node<T> node =this.head;
			System.out.println(node.data);//일단 head의 data출력
			while(node.next!=null) {
				node=node.next;
				System.out.println(node.data);//while문 한 번 돌 때 마다 head 이후의 data하나씩 출력, 리스트의 끝까지 출력됨
			}
		}
	}
	
	//검색
	//1. head부터 검색
	public T searchFromHead(T isData) {
		if(this.head==null) { //연결리스트에 값 없을 때는 null리턴
			return null;
		}else {
			Node<T>node=this.head; //노드 한개 선언후 선언된 노드에 head값 넣기
			while(node.next!=null) {
				if(node.data==isData) {
					return node.data;
				}else {
					node=node.next;
				}
			}
			return null; // 끝까지 돌아도 isData값이 없다면null리턴
		}
	}
	//2. tail부터 검색
	public T searchFromTail(T isData) {
		if(this.head==null) {
			return null;
		}else {
			Node<T> node=this.tail;
			while(node.prev!=null) {
				if(node.data==isData) {
					return node.data;
				}else {
					node=node.prev;
				}
			}
		}
		return null;
	}
}
