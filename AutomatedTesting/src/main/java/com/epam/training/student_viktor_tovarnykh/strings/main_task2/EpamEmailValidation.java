package com.epam.training.student_viktor_tovarnykh.strings.main_task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {

        if(email == null || email.equals("")){
            return false;
        }

        Pattern emailPattern = Pattern.compile("^([a-zA-z]+)" +
                "_" +
                "([a-zA-z]+)" +
                "([\\d]*)" +
                "@epam.com" +
                "$"
        );

        Matcher m = emailPattern.matcher(email);

        if(m.matches()){
            return true;
        }

        return false;

    }
}





