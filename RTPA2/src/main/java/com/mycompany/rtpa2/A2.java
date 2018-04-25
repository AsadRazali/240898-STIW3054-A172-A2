package com.mycompany.rtpa2;

import java.io.IOException;

public class A2 implements readwrite, countwordandchar {

    public void run() throws IOException {

       readwrite.run();
       countwordandchar.countwordandcharacter();
       github.githubpush();
    }

    public static void main(String[] args) throws IOException {

        A2 obj = new A2();
        double t1 = System.nanoTime();
        obj.run();

        double t2 = System.nanoTime();

        System.out.println("Completing the execution = " + ((t2 - t1) / 1000000000) + " second");

    }

}
