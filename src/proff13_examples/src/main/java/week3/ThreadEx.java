package week3;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 1/29/14
 */
public class ThreadEx {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                int key = 0;
                while(true) {
                    try {
                        sleep(100);
                        if((key = System.in.read()) == 10) {
                            System.exit(0);
                        } else {
                            System.out.println(key);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        sleep(1000);
                        System.out.println(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
