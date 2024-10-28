public class NotString
{
	public static void main(String[] args)
	{
		String word = "Java";

		if(!word.substring(0,3).equals("not"))
		{
			System.out.println("not " + word);
		}
		else
			System.out.println("Word unchanged: " + word);
	}
}
