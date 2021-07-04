package com.google;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RuleConflict {

    static class Node {
        Map<String, Node> children = new LinkedHashMap<>();
        Set<String> found = new LinkedHashSet<>();
    }

    public static void main(String[] args){
        List<String> R1 = Arrays.asList("A1","B1","C1");
        List<String> R2 = Arrays.asList("A2","B2","C2");
        List<String> R3 = Arrays.asList("A1","B1","C1");
        List<String> R4 = Arrays.asList("A1","B1","*");
        List<String> R5 = Arrays.asList("*","*","*");
        Node root = insert(null,"R1", R1, 0);
        root = insert(root,"R2", R2, 0);
        root = insert(root,"R3", R3, 0);
        root = insert(root,"R4", R4, 0);
        root = insert(root,"R5", R5, 0);
         System.out.println("Done");
    }

    private static Node insert(Node root, String ruleID, List<String> rule, int index){
        if(ruleID == null || ruleID.isEmpty() || rule == null || rule.isEmpty() ){
            return null;
        }
        if(index >= rule.size()){
            return null;
        }
        if(root == null && index < rule.size() - 1){
            Node node = new Node();
            node.children.put(rule.get(index), insert(null,ruleID,rule,index + 1));
            return node;
        }
        if(root == null && index == rule.size() - 1){
            Node node = new Node();
            node.children.put(rule.get(index), null);
            if(node.found.size() > 0){
                System.out.println("The rule with ruleID:" + ruleID + " Conflicts with " + String.join("", node.found));
            }
            node.found.add(ruleID);
            return node;
        }

        if(index == rule.size() - 1){
            root.children.put(rule.get(index),null);
            if(root.found.size() > 0){
                System.out.println("The rule with ruleID:" + ruleID + " Conflicts with " + String.join(",", root.found));
            }
            root.found.add(ruleID);
            return root;
        }
        if(rule.get(index).equals("*")){
            root.children.put("*",null);
            for (String key : root.children.keySet()){
                root.children.put(key,insert(root.children.get(key), ruleID, rule, index + 1));
            }
            return root;
        }
        if(root.children.containsKey("*")){
            root.children.put("*",insert(root.children.get("*"),ruleID, rule, index + 1));
        }
        root.children.put(rule.get(index), insert(root.children.get(rule.get(index)), ruleID,rule,index +1 ));
        return root;
    }


}
