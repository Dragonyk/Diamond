public class Diamond {
	protected int size;
	private int e;
	public String caracter;
	private String b = " ";
	private String ss = "#";
	public Diamond(int num){
		this.size = num;
		e=(num-1)/2;
		
		caracter = "";
		
		for(int i=0;i<=num/2;i++){
			for(int j=0;j<e;j++){
				System.out.print(b);
				caracter += b;
			}
			
			for(int z=0;z<num-(e*2);z++){
				System.out.print(ss);
				caracter += ss;
			}
			
			for(int x=0;x<e;x++){
				System.out.print(b);
				caracter += b;
			}
			e--;
			System.out.println();
			caracter += "\n";
		}
		
		e+=2;
	//esp=(num-1)/2;
		for(int i=0;i<num/2;i++){
			
			for(int j=0;j<e;j++){
				System.out.print(b);
				caracter += b;
			}
			
			for(int z=0;z<num-(e*2);z++){
				System.out.print(ss);
				caracter += ss;
			}
			
			for(int x=0;x<e;x++){
				System.out.print(b);
				caracter += b;
			}
			e++;
			System.out.println();
			caracter += "\n";
		}
	}
	

	public static void main(String[] args) {
		new Diamond(31);
	}

}
