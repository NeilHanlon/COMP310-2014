package labs;

import java.util.*;

/**
 * Created by Neil on 2/5/2015.
 */
public class WordList
{
    private ArrayList<String> raw_word_list = new ArrayList<String>();
    private HashMap<Integer, TreeSet<String>> list = new HashMap<Integer, TreeSet<String>>();
    private static int _LENGTH;
    public WordList(Scanner scanner)
    {
        //Because list is a TreeSet, it is of SortedList type, and therefore doesn't need to be sorted alphabetically.
        this.create_list(scanner);
    }
    private void create_list(Scanner scanner)
    {
        String word = "";
        while((word = scanner.nextLine()) != null)
        {
            int len = word.length();
            if(list.containsKey(len))
            {
                list.get(len).add(word);
            }
            else
            {
                TreeSet set = new TreeSet<String>();
                set.add(word);
                list.put(len,set);
            }
        }
    }
    public TreeSet<String> search(char letter)
    {
        return new TreeSet<String>();
    }
}
