package labs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * In Evil Hangman, the computer maintains a list of every word in the
 * English language, then continuously pares down the word list to try
 * to dodge the player's guesses as much as possible.
 *
 * Details here:
 * http://nifty.stanford.edu/2011/schwarz-evil-hangman/Evil_Hangman.pdf
 */
public class EvilHangman extends Hangman {
	public int max_len, min_len;
	EvilHangman() throws FileNotFoundException {
		super();
		File file = new File("resources/dictionary.txt");
		FileReader reader = new FileReader(file);
		Scanner scanner = new Scanner(reader);

		int[] min_max = this.get_min_max(scanner);
		min_len = min_max[0];
		max_len = min_max[1];

		WordList wl = new WordList(scanner);

		while (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
	}
	int[] get_min_max(Scanner scanner)
	{
		int[] arr = new int[2];
		int min = 2, max = 0;
		while(scanner.hasNextLine())
		{
			String word = scanner.nextLine();
			if(word.length() > max)
			{
				max = word.length();
			} else if(word.length() < min)
			{
				min = word.length();
			}
		}
		arr[0] = min;
		arr[1] = max;
		return arr;
	}
}
