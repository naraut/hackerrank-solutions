package com.hackerrank.solutions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations
{
    public static List<String> permutations(final List<String> words)
    {
        final List<String> perms = new ArrayList<String>();

        // Base case.
        if (words.size() == 1)
        {
            perms.add(words.get(0));
        }
        // Take each word and append to it the recursively computed permutations of the remaining elements.
        else
        {
            for (final String head : words)
            {
                for (final String permutation : permutations(subList(head, words)))
                {
                    perms.add(head + permutation);
                }
            }
        }
        return perms;        
    }


    public static List<String> subList(final String elementToRemove, final List<String> elements)
    {
        final List<String> subList = new ArrayList<String>();
        for (final String s : elements)
        {
            if (!s.equals(elementToRemove))
            {
                subList.add(s);
            }
        }
        return subList;
    }
    
    public static void main(final String[] args)
    {
    	List<String> s= permutations(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I","J"));
    	System.out.println(s.size());
    }
    
    
    private List<Character[]> permutations(List<Character[]> chars, Character c) {
    	List<Character[]> list = new ArrayList<>();
    	for(Character[] chArr : chars) {
    		if(chArr.length == 1) {
    			Character[] c1 = {chArr[0],c};
    			Character[] c2 = {c,chArr[0]};
    			list.add(c1);
    			list.add(c2);    			
    		}else{
    			
//    			List<Character[]> list2 = permutations(chars, c)
    			
    		}
    	}
    	return list;
    }    
    
}
