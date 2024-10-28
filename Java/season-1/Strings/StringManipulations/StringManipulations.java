public class StringManipulations
{
	public static void main(String[] args)
	{
		String str = "https://www.academiadecodigo.org";

		String domain = str.substring(8);

		String name = "< Academia de Codigo_ >";

		name = str.substring(12,str.length()-4); //(academiadecodigo)

		name = name.substring(0,8) + " " + name.substring(8, 10) + " " + name.substring(10); //(academia de codigo)

		name = name.substring(0,1).toUpperCase() + name.substring(1,12) + name.substring(12, 13).toUpperCase() + name.substring(13); //(Academia de Codigo)

		System.out.println("I am a Code Cadet at < " + name + "_ >, " + domain);
	}
}
