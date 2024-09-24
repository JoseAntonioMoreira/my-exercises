public class FrontBack
{
	public static void main(String[] args)
	{
		String word = "heisenberg";
		System.out.println(word.substring(word.length()-1) + word.substring(1, word.length()-2) + word.substring(0,1));
	}
}
