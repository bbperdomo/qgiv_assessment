package com.example.androidtechnical;

public class Gift {

    private double amount;
    private String timeElapsed;

    public Gift(double amount, String timeAgo) {
        this.amount = amount;
        this.timeElapsed = timeAgo;
    }

    public double getAmount() {
        return amount;
    }

    public String getTimeElapsed() {
        return timeElapsed;
    }
}
