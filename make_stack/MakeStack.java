package make_stack;

import java.util.ArrayList;

public class MakeStack<T> {
//���׸� Ÿ�� ���� <T> �� Ŭ���� �ڿ� ����� �ϴ°ɱ�?
	
//���׸� Ÿ�� ���� <T> �� Ŭ���� �ڿ� ����� �ϴ°ɱ�?
		
	//	private�� ��� ����Ʈ ����
		private ArrayList<T> stack_arr=new ArrayList<T>();

	//push pop isEmpty�޼ҵ� ����
	
	//push- ��ȯ�� ����..?
	public void push(T data) {
		stack_arr.add(data);
		System.out.println(stack_arr);
	}
	
	//pop- ��ȯ�� T
	public T pop() {
		if(stack_arr.isEmpty()) {
			return null;
		}
		else
			return stack_arr.remove(stack_arr.size()-1);
		
	}
	
	//isEmpty �ٽ� ����??
	public boolean isEmpty() {
		return stack_arr.isEmpty();
	}

	public static void main(String[] args) {
		MakeStack<Integer> intSt=new MakeStack<Integer>();
		
		intSt.push(1);
		intSt.push(4);
		intSt.push(5);
		intSt.push(7);
		
		System.out.println("pop: "+intSt.pop());
		
	}

}
