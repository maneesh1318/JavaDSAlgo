package com.google;

import java.util.HashSet;
import java.util.Set;

public class NumberOfUniqueEmails {
    public static void main(String args[]){
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));

    }


    public static int numUniqueEmails(String[] emails) {
        Set<String> mails = new HashSet();
        for(String email: emails){
            String localname = email.split("@")[0];
            localname = processLocalName(localname);
            mails.add(localname + "@" + email.split("@")[1]);
        }
        return mails.size();
    }

    private static String processLocalName(String localname){
        return localname.replace(".","").split("\\+")[0];
    }
}
