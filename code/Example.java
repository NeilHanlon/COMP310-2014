

public class Example
{
	public static void main(String[] args)
	{
		for(int i = 0; i <= 100; ++i)
		{
			if(i % 3 == 0)
				System.out.print("Fizz");

			if(i % 5 == 0)
			{
				System.out.print("Buzz");
				continue;
			}

			else
				System.out.print(i);

			System.out.print("\n");

		}
	}
}