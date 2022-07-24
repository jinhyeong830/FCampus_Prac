package linkedList;

public class DoubleLinkedList <T> {
	public Node<T> head=null;
	public Node<T> tail=null; //NodeŬ������ ���� ��ü head�� tail�� ������ ��
	
	@SuppressWarnings("hiding")
	public class Node<T> {
		T data;
		Node<T> prev=null;
		Node<T> next=null;
		
		public Node(T data) { //������
			this.data=data;
		}
	}
	
	//����
	//1. ���ʴ�� ����
	public void addNode(T data) { 
		if(this.head==null) { //���Ḯ��Ʈ�� �����Ͱ� �ƹ��͵� ���� ��
			this.head=new Node<T>(data); //Node�� data�� �Ű�������data�� ���� head��� ����..
			this.tail=this.head; //�����Ͱ� �ϳ��ϱ� tail��  head�� ��
		}else {//�� ���Ḯ��Ʈ�� �ƴ� ��
			Node<T> node=this.head;
			while(node.next!=null) {
				node=node.next;
			}
			node.next= new Node<T>(data);// �� ������� next�� ���ο� data�� ���� Node����
			//node.next�� ���ο� ��尡 �Ǵ� ��
			node.next.prev=node; //���ο� ����� prev�� ������(while�� ��ȸ�� �� �� ���)
			this.tail=node.next;//��ü ���� ����Ʈ�� tail�� ���ο� ��尡 �Ǵ� ��
		}
	}
	//2.������ ��� �տ� ��� ����
	//������� 4���� �缳���ؾ� �ؼ� �����̺�����
	public boolean insertToFront(T existedData, T addData) {
		if(this.head==null) {//1. ���Ḯ��Ʈ�� ������� ��
			this.head=new Node<T>(addData);
			this.tail=this.head;
			
			return true;
		}else if(this.head.data==existedData){//2. head�տ� ���ο� �����͸� ������ ��
			Node<T>newHead=new Node<T>(addData); //���Ե����Ͱ� ����ִ� ���ο� ��� newHead����
			newHead.next=this.head; //��� ����- ������ �Ǥ�����
			this.head.prev=newHead; //���� ���� �ڵ�.. 
			this.head=newHead; //newHead�� ���ο� ��尡 �ǵ���
			
			return true;
		}else {//3. head�� �ƴ� ��� �տ� ���ο� �����͸� �ְ� ���� ����
			Node<T> node=this.head;
			while(node.next!=null) {
				if(node.data==existedData) {
					//head---origin1-(addData)-existedData-origin---origin-tail
					//���� ������� origin1�� nodePrev�� ��(existedData�� �ٷ� �� ������)
					Node<T> nodePrev=node.prev;//node
					nodePrev.next=new Node<T>(addData);//���ο� data�� nodePrev.next�� �Ҵ�
					
					
					nodePrev.next.next=node;//���ο� ��尡 nodePrev.next�̴�, ������� next (��ũ) ����
					nodePrev.next.prev=nodePrev;// ������� prev ����
					node.prev=nodePrev.next;//existedData�� prev�缳��
					
					return true;
				}else {
					node=node.next;
				}
			}
			return false;
		}
	}
	
	//���
	public void printAll() {
		if(this.head!=null) {
			Node<T> node =this.head;
			System.out.println(node.data);//�ϴ� head�� data���
			while(node.next!=null) {
				node=node.next;
				System.out.println(node.data);//while�� �� �� �� �� ���� head ������ data�ϳ��� ���, ����Ʈ�� ������ ��µ�
			}
		}
	}
	
	//�˻�
	//1. head���� �˻�
	public T searchFromHead(T isData) {
		if(this.head==null) { //���Ḯ��Ʈ�� �� ���� ���� null����
			return null;
		}else {
			Node<T>node=this.head; //��� �Ѱ� ������ ����� ��忡 head�� �ֱ�
			while(node.next!=null) {
				if(node.data==isData) {
					return node.data;
				}else {
					node=node.next;
				}
			}
			return null; // ������ ���Ƶ� isData���� ���ٸ�null����
		}
	}
	//2. tail���� �˻�
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
