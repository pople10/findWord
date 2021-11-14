package tests;

import java.util.*;

public class main {
	public static void main(String[] s)
	{
		String[] ex1 = {"P>E","E>R","R>U"}; 
		findWord(ex1); 
		String[] ex2 = {"I>N","A>I","P>A","S>P"}; 
		findWord(ex2);  
		String[] ex3 = {"U>N", "G>A", "R>Y", "H>U", "N>G", "A>R"};
		findWord(ex3);
		String[] ex4 = {"I>F", "W>I", "S>W", "F>T"};
		findWord(ex4);
		String[] ex5 = {"R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G"};
		findWord(ex5);
		String[] ex6 = {"W>I", "R>L", "T>Z", "Z>E", "S>W", "E>R", "L>A", "A>N", "N>D", "I>T"};
		findWord(ex6);
	}
	
	public static void findWord(String[] arr)
	{
		Map<String,Integer> num = new HashMap<String,Integer>();
		for(String i : arr)
		{
			String[] a = i.split(">");
			if(num.get(a[0])==null)
			{
				num.put(a[0], 0);
			}
			else
			{
				num.put(a[0], num.get(a[0])+1);
			}
			if(num.get(a[1])==null)
			{
				num.put(a[1], 0);
			}
			else
			{
				num.put(a[1], num.get(a[1])+1);
			}
		}
		String first = "";
		for (Map.Entry<String, Integer> entry : num.entrySet()) {
			if(entry.getValue()==0)
			{
				first = entry.getKey();
				break;
			}
		}
		String word = first;
		boolean flag=true;
		int i = 0;
		int len = arr.length;
		boolean flags=false;
		
		while(flag)
		{
			String[] a = arr[i].split(">");
			if(a[0].equals(first))
			{
				
				word = word+a[1];
				first = a[1];
			}

			if(i==len-1)
			{
				i=0;
				flags=true;
			}
			if(!flags)
			{
			i++;
			}
			flags=false;
			if(word.length()==len+1)
			{
				flag=false;
			}
		}
		System.out.println(word);
	}
}
