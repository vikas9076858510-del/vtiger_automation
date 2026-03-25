package abc;


public class Practice {

	public static void main(String[] args) {

		int number =10;
		int binary[]=new int[10];
		int index =0;
		while(number>0) {
			binary[index]=number%2;
			number=number/2;
			index++;
		}
		for (int i = index-1; i >=0; i--)  {

			System.out.println(binary[i]);


		}
		String str=("Apple,Banana,Grapes");
		int start=0;
		for (int i = 0; i <str.length(); i++) {
			if(str.charAt(i)==','){
        char ch=str.charAt(i);
        System.out.println(ch);
			}
		}


	}
}