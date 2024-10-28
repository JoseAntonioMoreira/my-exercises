public class ClosestNeighbours
{
	public static void main(String[] args )
	{
		int[] numbers = {0,5,1209,6,2,111,112,33};
		int smallestNumber = Integer.MAX_VALUE;
		int[] smallestNeighbours = new int[2];

		for(int i=0; i< numbers.length-1; i++)
		{
			int neighboursDifference = Math.abs(numbers[i]-numbers[i+1]);
			if(neighboursDifference < smallestNumber)
			{
				smallestNumber = neighboursDifference;
				smallestNeighbours[0] = numbers[i];
				smallestNeighbours[1] = numbers[i+1];
			}
		}
		System.out.println(smallestNeighbours[0] + " " + smallestNeighbours[1]);
	}
}
