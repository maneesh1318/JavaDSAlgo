package com.practice.misc;

import java.util.*;

/**
 * Created by Manish Richhariya(manish.richhariya@99acres.com) on 8/7/18.
 */
public class NoTwoAdjacentCharactersSame {
    public static void main(String agr[]){
        //System.out.println(rearrange("geeksforgeeks"));
        int T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        s.nextLine();
        for(int t = 0;t < T; t++){
            String str = s.nextLine();
            System.out.println(rearrange(str));
        }

    }

    private static int rearrange(String str){
        if(str == null || str.length() == 0)
            return 0;
        Map<Character,Integer> M = new LinkedHashMap<>();
        M.put('#',0);
        for(int i=0;i<str.length();i++){
            if(M.containsKey(str.charAt(i))){
                M.put(str.charAt(i),M.get(str.charAt(i)) + 1);
            }
            else{
                M.put(str.charAt(i),1);
            }
        }

        class CharacterComparator implements Comparator<Character>{
            private Map<Character,Integer> M;
            CharacterComparator(Map M){
                this.M = M;
            }
            public int compare(Character o1, Character o2) {
                if(M.get(o1) > M.get(o2)){
                    return -1;
                }
                else if(M.get(o1) < M.get(o2)){
                    return 1;
                }
                return 0;
            }
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(new CharacterComparator(M));
        for (Character key:M.keySet()){
            if(key != '#')
                pq.add(key);
        }
        String toRet = "";
        Character prev = '#';
       while (toRet.length() < str.length() && !pq.isEmpty()){
           Character c = pq.poll();
           if(M.get(prev) > 0) pq.add(prev);
           toRet += c;
           M.put(c,M.get(c) - 1);
           prev = c;
       }
       if(toRet.length() == str.length()){
           return 1;
       }
        return 0;
    }
}

