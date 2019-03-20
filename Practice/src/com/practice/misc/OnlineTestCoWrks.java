package com.practice.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class OnlineTestCoWrks {
    public static void main(String args[]) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long l = Long.parseLong(bufferedReader.readLine().trim());

        int entitiesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> entities = new ArrayList<>();

        IntStream.range(0, entitiesCount).forEach(i -> {
            try {
                entities.add(bufferedReader.readLine());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        entityExpansion(l, entities);

        bufferedReader.close();
    }

    static void entityExpansion(long l, List<String> entities) {
        long length = entities.size();
        long count = 0;
        for(int i = 0;i<length;i++){
            String entity = entities.get(i);
            entity = entity.replaceAll("\\s{2,}", " ").trim();
            if(!valid(entity)){
                System.out.println("()");
                return;
            }
            entity = entity.replace("<!ENTITY", "").replace(">","").trim();
            String[] entityParts = entity.split(" ");
            String entityVal = entityParts[1];
            if(entityVal.contains(";")) count += entityVal.split(";").length;
            else count++;
        }
        System.out.print(((count <= l)?1:0) + " " + count);
        System.out.println();
    }

    static boolean valid(String str){
        if(str.substring(0,8).equals("<!ENTITY") && str.charAt(str.length() -1) == '>') return true;
        return false;
    }
}
