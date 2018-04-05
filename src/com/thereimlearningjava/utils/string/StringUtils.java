package com.thereimlearningjava.utils.string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * Providing string utilities
 * @author Sergeenko
 * @version 0.1
 */
public class StringUtils {
	/**
	 * Split input string by groups of two symbols and returns a string array
	 * @param any String object
	 * @return String[] where each element contains 2 symbols (or 1 in case if input string had an odd length)
	 */
	public static String[] getPairedArray(String s) {
		
		if (s.isEmpty()) return new String[0];
		if (s.length() == 1) {
			String[] res = new String[1];
			res[0] = s;
			return res;
		}
		double l = s.length();
		String[] strMas = new String[(int) Math.ceil(l / 2)];
		
			for (int i = 2 ,j = 0, k = 0; i <= s.length(); i+=2, k++) {
				
				strMas[k] =  s.substring(j, i);
				j += 2;
				System.out.println(strMas[k]);
				if ((k - Math.ceil(l / 2) == -2) & (l % 2) != 0) {
					strMas[k + 1] = s.substring(s.length() - 1, s.length());
					break;
				}
			}
		
			for(String c : strMas) {
				System.out.println(c);
			}
			return strMas;
	}
	/**
	 * Swap symbols in input array created by getPairedArray(String s) method
	 * @param String[] where each element has 2 symbols
	 * @return String[]
	 */
	public static String[] getSwappedArray(String[] s) {
		for(int i = 0; i < s.length; i++) {
			if(s[i] == null) {
				System.out.println("Array contains a null object");
				return new String[0];
			}
			if ((s[i].length() < 2) & (i != s.length - 1))  {
				System.out.println("Array contains non-paired objects");
				return new String[0];
				}
			if(s.length == 0 || s[i].length() > 2 || "".equals(s[i])) {
				System.out.println("Array contains empty strings");
				return new String[0];
			}
			
			}
				List<String> swappedList = new ArrayList<String>(); //will store strings here
				for (String m : s) {
					if(m.length() == 2) {
						char[] out = new char[2];
						out[0] =  m.charAt(1);
						out[1] = m.charAt(0);
						String fin = new String(out);
						swappedList.add(fin);
					}
					if(m.length() == 1) {
						swappedList.add(m);
					}
				}
				return swappedList.toArray(new String[swappedList.size()]);
		}
	/**
	 * Reverse input string using Deque interface
	 * @param String
	 * @return reversed String
	 */
	public static String reverseByStack(String s) {
		Deque<Character> stack = new ArrayDeque<Character>();
		for(int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));
		}
		Character[] ch = new Character[stack.size()];
		stack.toArray(ch);
		StringBuilder sb = new StringBuilder();
		for(int j = 0; j < ch.length; j++) {
			sb.append(Character.toString(ch[j]));
		}
		return sb.toString();
	}
	
public static void main(String[] args) {
	
	System.out.println(reverseByStack("jhjbsdfskkndlkdnflknlknlsdfgsd").toString());
}
}
