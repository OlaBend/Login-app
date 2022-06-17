package com.company;

import java.util.Scanner;

public class Main {
    static User[] users = {
            new User("admin", "pass", "token"),
            new User("adam", "passw0rd", "token"),
            new User("adm", "haslo", "token"),
            new User("ad", "haslo1", "token"),
            new User("a", "Haslo", "token")

};

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in); //jak console.ReadLine()
    boolean authenticated = false;
    while (!authenticated) {
        System.out.println("Podaj login: ");
        var userName = scanner.next();
        System.out.println("Podaj hasło: ");
        var userPassword = scanner.next();
        for(int i=0; i<5; i++)
        {
            if(users[i].authenticate(userName, userPassword) == true)
            {
                authenticated = true;

                System.out.println("Witaj " + userName + "!");
                break;
            }
        }
        if(!authenticated)
        {
            System.out.println("Podano nieprawidlowe dane, sprobuj ponownie ");
        }
    }


    }
}

class User {
    private String password;
    private String username;
    private String secret;

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    public boolean authenticate(String secret) {
            return this.secret.equals(secret) && !this.secret.equals("---");
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getSecret() {
        return secret;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public User(String username, String password , String secret) {
        this.password = password;
        this.username = username;
        this.secret = secret;
    }

    public User(String password, String username) {
        this(username, password, "---");
    }


}