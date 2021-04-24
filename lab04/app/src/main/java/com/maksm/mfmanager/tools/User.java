package com.hongjolim.mfmanager.tools;

public class User {
    public String id, email, password, security_question_num, security_answer;

    public User() {
    }

    public User(String id, String email, String password, String security_question_num, String security_answer) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.security_question_num = security_question_num;
        this.security_answer = security_answer;
    }
}
