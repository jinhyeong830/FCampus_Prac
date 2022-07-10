package linkedList;

public class SingledLinkedList<T> {
	
	public Node<T> head=null;//�Ʒ� ���� Node<T> Ŭ���� ������ ��
	
//	@SuppressWarnings("hiding")//�̰� ���? ��Ŭ���� ��õ��.. class Node<T>�� ���׸��� ������� �����ֳ�..
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
			System.out.println();
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
	public void insertNode(T data, T isData) {//data�� ������ �������̰� isData�� �����ִ� ������
											  //���� ����� �����Ͱ� �ʿ��� ����? ���� ����� �����͸� ã�� ������ �����͸� �� ���� ��ġ�� ��ġ��Ű����
		Node <T> searchedNode=this.search(isData); //isData�� ������ �ִ� ��� ã�Ƽ� searchedNode�� ����
		//searchedNode��� Node����
		
		if(searchedNode==null) { //isData��� �����Ͱ� ������忡 ���ٸ�
			this.addNode(data); //data����(�ǳ��� ���Ե� ��-search�޼ҵ��� ������ ����: ������ �˻��ϴϱ�?)
		}else {
			Node<T> nextNode=searchedNode.next; //nextNode: ������ ����� next�� �������� ��
			searchedNode.next=new Node<T>(data);//������������ next�� ���ο� node�� ����Ű����
			searchedNode.next.next=nextNode; //�˻��� ���(�����ִ� ���)�� ��������� next��, ������ ����� next(nodeNext)��
		}
	}
	
	//DELETE
	public boolean deleteNode(T isData) {
		if(this.head==null) {
			return false;
		}else {
			Node<T> node =this.head; 
			if(node.data==isData) { //�����ϰ� ���� �����Ͱ� head��
				this.head=this.head.next; //head�� ���� ��忡 �Ѱ���
				return true;
			}else { //head�� �ƴҶ�
				while(node!=null) { 
					if(node.next.data==isData) { //������ ��������� �����Ͱ� �����ϰ� ���� ������(isData)���
						node.next=node.next.next;//�������� next�� ��������� next �ֱ�
						return true;
					}
					node=node.next; //������� Ȯ���� ���� �������� ����
				}
				return false; //while ������ ���Ҵµ��� ������ �����͸� �߰߸��ߴٸ� ������ �����Ͱ� ���� ���̴� false.
			}
		}
	}
	

	public static void main(String[] args) {
		
		//������ SingledLinkedList�� ��ü ����
		SingledLinkedList<Integer> singleLL=new SingledLinkedList<Integer>();
		singleLL.addNode(1);
		singleLL.addNode(5);
		singleLL.addNode(7);//������ ��ü�� ����߰� �޼ҵ� ����ؼ� data�ֱ�

		
		singleLL.printAll();
		//����
		singleLL.insertNode(9,5);//5�ڿ� 9�� �ְڴ�.
		singleLL.insertNode(8,1);//1�ڿ� 8�� �ְڴ�.
		singleLL.insertNode(10,21); //���� ������ 21�ڿ� 10�� �ִ´ٸ�-> 10�� �� �ڿ� ����
		singleLL.printAll();
		
		//����
		singleLL.deleteNode(5);
		singleLL.deleteNode(1);//head ����
		singleLL.printAll();
		
		//���� ������ �����Ѵٸ�?
		singleLL.deleteNode(21); //exception���â �ߴµ��?-false�� ���ϵ��� ��

	}

}
