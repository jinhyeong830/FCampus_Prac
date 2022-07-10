package linkedList;

public class SingledLinkedList<T> {
	
	public Node<T> head=null;//아래 만들 Node<T> 클래스 참조할 것
	
//	@SuppressWarnings("hiding")//이건 모니? 이클립스 추천템.. class Node<T>의 제네릭에 노란밑줄 없애주네..
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
			System.out.println();
		}
	}
	
	//SEARCH
	public Node<T> search(T data) {//data가 찾고 싶은 데이터!
		if(this.head==null) {
			return null;
		}else {
			Node<T> node=this.head; //첫 노드를 head에 대입
			while(node!=null) { //노드 끝까지 돌려라!
				if(node.data==data) {//연결리스트 노드의 데이터가 찾고 있는data라면
					return node; //현재 노드 리턴
				}else {
					node=node.next; //data못찾았으니 다음 데이터검색
				}
			}
			return null; //노드 끝까지 돌렸는데도 찾고 있는 data를 못찾았다묜 null 리턴
		}
		
	}
	
	//INSERT
	public void insertNode(T data, T isData) {//data는 삽입할 데이터이고 isData는 원래있던 데이터
											  //원래 노드의 데이터가 필요한 이유? 원래 노드의 데이터를 찾고 삽입할 데이터를 그 다음 위치에 위치시키려구
		Node <T> searchedNode=this.search(isData); //isData를 가지고 있는 노드 찾아서 searchedNode에 대입
		//searchedNode라는 Node선언
		
		if(searchedNode==null) { //isData라는 데이터가 원래노드에 없다면
			this.addNode(data); //data삽입(맨끝에 삽입될 것-search메소드의 로직에 의해: 끝까지 검색하니까?)
		}else {
			Node<T> nextNode=searchedNode.next; //nextNode: 삽입할 노드의 next를 선언해준 것
			searchedNode.next=new Node<T>(data);//원래데이터의 next가 새로운 node를 가리키도록
			searchedNode.next.next=nextNode; //검색된 노드(원래있던 노드)의 다음노드의 next를, 삽입할 노드의 next(nodeNext)에
		}
	}
	
	//DELETE
	public boolean deleteNode(T isData) {
		if(this.head==null) {
			return false;
		}else {
			Node<T> node =this.head; 
			if(node.data==isData) { //삭제하고 싶은 데이터가 head라묜
				this.head=this.head.next; //head를 다음 노드에 넘갸줌
				return true;
			}else { //head가 아닐때
				while(node!=null) { 
					if(node.next.data==isData) { //현재노드 다음노드의 데이터가 삭제하고 싶은 데이터(isData)라면
						node.next=node.next.next;//현재노드의 next에 다음노드의 next 넣기
						return true;
					}
					node=node.next; //다음노드 확인을 위해 다음노드로 진행
				}
				return false; //while 끝까지 돌았는데도 삭제할 데이터를 발견못했다면 삭제할 데이터가 없는 것이니 false.
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
		//삽입
		singleLL.insertNode(9,5);//5뒤에 9를 넣겠다.
		singleLL.insertNode(8,1);//1뒤에 8을 넣겠다.
		singleLL.insertNode(10,21); //없는 데이터 21뒤에 10을 넣는다면-> 10은 맨 뒤에 삽입
		singleLL.printAll();
		
		//삭제
		singleLL.deleteNode(5);
		singleLL.deleteNode(1);//head 삭제
		singleLL.printAll();
		
		//없는 데이터 삭제한다면?
		singleLL.deleteNode(21); //exception경고창 뜨는디용?-false가 리턴됐을 것

	}

}
