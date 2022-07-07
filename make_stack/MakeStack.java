package make_stack;

import java.util.ArrayList;

public class MakeStack<T> {
//제네릭 타입 사용시 <T> 를 클래스 뒤에 써줘야 하는걸까?
	
//제네릭 타입 사용시 <T> 를 클래스 뒤에 써줘야 하는걸까?
		
	//	private로 어레이 리스트 선언
		private ArrayList<T> stack_arr=new ArrayList<T>();

	//push pop isEmpty메소드 구현
	
	//push- 반환형 없음..?
	public void push(T data) {
		stack_arr.add(data);
		System.out.println(stack_arr);
	}
	
	//pop- 반환형 T
	public T pop() {
		if(stack_arr.isEmpty()) {
			return null;
		}
		else
			return stack_arr.remove(stack_arr.size()-1);
		
	}
	
	//isEmpty 다시 선언??
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
