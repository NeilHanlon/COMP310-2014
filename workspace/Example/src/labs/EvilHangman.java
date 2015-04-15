package labs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.HashSet;

public class EvilHangman extends Hangman
{
    private String word = "";
    private Set<Character> guess_history = new HashSet<>();
    private int remaining_guesses;
    private int possible_words = 0;
    private String state = "";
    private char guess;
    private ArrayList<String> word_list = new ArrayList<>();
    private int word_length = 0;

    private boolean result = false;

    public EvilHangman(int string_length, int num_guesses)
    {
        this.remaining_guesses = num_guesses;
        this.word_length = string_length;

        try (Scanner s = new Scanner(new File("resources/dictionary.txt")))
        {
            while (s.hasNext())
            {
                String temp = s.nextLine().toLowerCase();
                if (temp.length() == string_length)
                {
                    this.word_list.add(temp);
                    this.possible_words++;
                }
            }
            for (int i = 0; i < string_length; i++)
            {
                this.state += "_ ";
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public int guessesRemaining()
    {
        return this.remaining_guesses;
    }

    @Override
    public String getWord()
    {
        return this.word;
    }


    public Set<Character> getGuesses()
    {
        return guess_history;
    }

    @Override
    public boolean won()
    {
        return word.equals(visible());
    }

    public boolean EvilChoose(char ch)
    {
        int temp_word_num = 0;
        ArrayList<String> temp = new ArrayList<String>();

        for(String word : word_list)
        {
            for (int i = 0; i < word_length; i++)
            {
                if(word.charAt(i) == ch)
                {
                    break;
                } else
                {
                    if(i == word_length -1 && word.charAt(i) != ch)
                    {
                        temp_word_num++;
                        temp.add(word);
                    }
                }
            }
        }
        if(temp_word_num == 0)
        {
            this.word = word_list.get(0);
            return false;
        }
        this.word = temp.get(0);
        this.possible_words = temp_word_num;
        this.word_list = temp;
        return true;
    }

    public boolean makeGuess(char ch)
    {
        this.result = false;
        this.guess = ch;
        System.out.println(this.guess_history.toString().toString());
        if(!repeat_input(this.guess))
        {
            this.guess_history.add(this.guess);
            if (EvilChoose(this.guess))
            {
                this.remaining_guesses--;
                this.result = true;
            } else
            {
                this.result = false;
            }
        } else
        {
            System.out.println("already guessed that letter!");
            this.result = false;
        }
        System.out.printf("\n\nThe word is now %s\n\n", this.word);
        return this.result;
    }

    public boolean repeat_input(char guess)
    {
        if(guess_history.contains(guess))
        {
            return true;
        }
        return false;
    }

    @Override
    public String visible() {
        StringBuilder b = new StringBuilder();
        for (char letter : word.toCharArray()) {
            b.append(guess_history.contains(letter) ? letter : '*');
        }
        System.out.println(b.toString());
        return this.state;
    }

}
