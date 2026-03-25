package abc;



public class ReversString {

	
	public static void main(String[] args) {
		wordRevers();
		//reversString("I Love My India");
		
	}
	
	public static void wordRevers() {
		String name ="Hello What is My Name";
		String rev ="";
		String word[]= name.split(" ");
		int size=word.length;
		System.out.print(word[0]+" ");
		for (int i = size-2; i >= 0; i--) {
			System.out.print(word[i]+" s");
		}
		System.out.print(word[size-1]);
	}

	
	public static void reversString(String name) {

		//    1 Approach   //

			//String name="Hello What is My Name?";
		String rev="";
		int size=name.length();
		for (int i = size-1; i >=0; i--) {
			rev+=name.charAt(i);

		}
		System.out.println("Revers String by Revers loop = "+rev);
		rev = "";
		for (int i = 0; i <size; i++) {
			char w=name.charAt(i);
			rev= w+rev;
		}
		System.out.println("Revers String by Forword loop = "+rev);


		//    2 Approach   //

		rev = "";
		char []nm=   name.toCharArray();
		size=nm.length;
		System.out.print("Second Approach is = ");
		for (int i = size-1; i >= 0; i--) {
			System.out.print(nm[i]);
		}
		System.out.println();

		//    3 Approach   //

		StringBuilder sb=	new StringBuilder(name);
		StringBuilder sr=sb.reverse();
		rev=sr.toString();
		System.out.println("Third Approach is ="+rev);		

		//	    4 Approach   //

		rev=new StringBuffer(name).reverse().toString();
		System.out.println("Fourth Approach is = "+rev);

	}


}
