public class MissingChar
{
	public static void main(String[] args)
	{
		String word = "ABCDEF";
		int n = 3;

		String NewWord = word.substring(0,n-1) + word.substring(n++);
		System.out.println(NewWord);
	}
}
