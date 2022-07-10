package linkedList;

public class SingledLinkedList<T> {
	
	public Node<T> head=null;//�Ʒ� ���� Node<T> Ŭ���� ������ ��
	
	@SuppressWarnings("hiding")//�̰� ���? ��Ŭ���� ��õ��.. class Node<T>�� ���׸��� ������� �����ֳ�..
	public class Node<T>{//��� ���� ::Node=data+pointer
		T data;
		Node<T> next=null;
		//data�� �Է� �����͸� �ް�, next�� ���� �ּҸ� �ǹ��ϴ� ��
		
		public Node(T data) {//class Node<T>�� ������
			this.data=data;
		}
	}
	
	//**single���� ����Ʈ ����߰� �޼ҵ�!!
	public void addNode(T data) {
		if(head==null) {
			//head null �϶� �Էµ����� �ٷ� head�� ������� �ǹ�(ù ��尡 �Ǵ°�)
			head=new Node<T>(data); //�� ������ �� �𸣰ڴ�,,->head�� Node��ü ���� �ٷ� �־��ָ� ��
		}else {
			Node<T> node=this.head;
			while(node.next!=null) {//������ �����next�� null�̱� ������ ������ ��尡 �� ������ �ݺ��ϰڴٴ� �ǹ�
				node=node.next;
			}
			
			//���⼭�� node.next�� ���� null�ε�, ���ο� ��带 �־��ִ� ��(�Էµ� data�� ���)
			node.next=new Node<T>(data);
		}
	}
	
	public void printAll() {
		if(head!=null) {
			Node<T> node =this.head;//ù ���� head
			System.out.println(node.data);//ù��° ���(head ) print
			while(node.next!=null) {//���� ����� �ּҰ� �ִٸ�
				node=node.next; //������带 �����忡 �����ϰ�
				System.out.println(node.data);//�� ����� data ����Ʈ
			}
		}
	}
	
	//SEARCH
	public Node<T> search(T data) {//data�� ã�� ���� ������!
		if(this.head==null) {
			return null;
		}else {
			Node<T> node=this.head; //ù ��带 head�� ����
			while(node!=null) { //��� ������ ������!
				if(node.data==data) {//���Ḯ��Ʈ ����� �����Ͱ� ã�� �ִ�data���
					return node; //���� ��� ����
				}else {
					node=node.next; //data��ã������ ���� �����Ͱ˻�
				}
			}
			return null; //��� ������ ���ȴµ��� ã�� �ִ� data�� ��ã�Ҵٹ� null ����
		}
		
	}
	
	//INSERT
	public void insertNode(T data, T isData) {//data�� ���� ����� �������̰� isData�� ������ ������
											  //���� ����� �����Ͱ� �ʿ��� ����? ���� ����� �����͸� ã�� ������ �����͸� �� ���� ��ġ�� ��ġ��Ű����
		Node <T> searchedNode=this.search(isData);
		//searchedNode��� Node����
		
		if(search(data)==null) { //���� �����Ͱ� ���ٸ�
			this.addNode(data); //data����(�ǳ��� ���Ե� ��-search�޼ҵ��� ������ ����: ������ �˻��ϴϱ�?)
		}else {
			Node<T> nextNode=searchedNode.next;
			searchedNode.next=new Node<T>(data);
			searchedNode.next.next=nextNode;
		}
	}
	

	public static void main(String[] args) {
		
		//������ SingledLinkedList�� ��ü ����
		SingledLinkedList<Integer> singleLL=new SingledLinkedList<Integer>();
		singleLL.addNode(1);
		singleLL.addNode(5);
		singleLL.addNode(7);//������ ��ü�� ����߰� �޼ҵ� ����ؼ� data�ֱ�
		
		singleLL.printAll();

	}

}
