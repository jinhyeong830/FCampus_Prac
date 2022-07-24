package linkedList;

public class DoubleLinkedList <T> {
	public Node<T> head=null;
	public Node<T> tail=null; //NodeŬ������ ���� ��ü head�� tail�� ������ ��
	
	public class Node<T> {
		T data;
		Node<T> prev=null;
		Node<T> next=null;
		
		public Node(T data) { //������
			this.data=data;
		}
	}
	
	//����
	public void addNode(T data) { 
		if(this.head==null) { //���Ḯ��Ʈ�� �����Ͱ� �ƹ��͵� ���� ��
			this.head=new Node<T>(data); //Node�� data�� �Ű�������data�� ���� head��� ����..
			this.tail=this.head; //�����Ͱ� �ϳ��ϱ� tail��  head�� ��
		}else {//�� ���Ḯ��Ʈ�� �ƴ� ��
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
