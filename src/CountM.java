
public class CountM {
	public static void main(String[] args) {
		String dataset[] = {
			    "Braund, Mr. Owen Harris",
			    "Cumings, Mrs. John Bradley (Florence Briggs Thayer)",
			    "Heikkinen, Miss. Laina",
			    "Futrelle, Mrs. Jacques Heath (Lily May Peel)",
			    "Allen, Mr. William Henry",
			    "Moran, Mr. James",
			    "McCarthy, Mr. Timothy J",
			    "Palsson, Master. Gosta Leonard",
			    "Johnson, Mrs. Oscar W (Elisabeth Vilhelmina Berg)",
			    "Nasser, Mrs. Nicholas (Adele Achem)",
			    "Sandstrom, Miss. Marguerite Rut",
			    "Bonnell, Miss. Elizabeth",
			    "Saundercock, Mr. William Henry",
			    "Andersson, Mr. Anders Johan",
			    "Vestrom, Miss. Hulda Amanda Adolfina",
			    "Hewlett, Mrs. (Mary D Kingcome) ",
			    "Rice, Master. Eugene",
			    "Williams, Mr. Charles Eugene",
			    "Vander Planke, Mrs. Julius (Emelia Maria Vandemoortele)",
			    "Masselmani, Mrs. Fatima",
			    "Fynney, Mr. Joseph J",
			    "Beesley, Mr. Lawrence",
			    "McGowan, Miss. Anna",
			    "Sloper, Mr. William Thompson",
			    "Palsson, Miss. Torborg Danira",
			    "Asplund, Mrs. Carl Oscar (Selma Augusta Emilia Johansson)",
			    "Emir, Mr. Farred Chehab",
			    "Fortune, Mr. Charles Alexander",
			    "Dwyer, Miss. Ellen",
			    "Todoroff, Mr. Lalio"
			};
		
		
		//hint: .indexOf('문자')와  .length를 사용한다.
			
		
		int count=0;
		
		for(int i=0; i<dataset.length;i++) {
			if(dataset[i].indexOf('M')!=-1) //인덱스는 0부터 시작, -1이라면 가지고 있지 않은 것
				count++;				
		}
		System.out.println(count);
		//indexOf :String과 함께 쓰이는 함수
		//A.indexOf('a'); String 변수 A에 문자a가 포함되어 있으면 처음으로  a가 위치한 인덱스를 반환, 아니면-1 반환
		//문자가 아닌 문자열'abk'도 인자로 들어갈 수 있다.
		
		
	}

}
