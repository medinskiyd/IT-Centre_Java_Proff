package week3.WindowWithThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreadInWindow {
    public synchronized static void main(String[] args) {
        JFrame frame = new JFrame("Поток чисел:");
        frame.setBounds(200, 200, 350, 100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponents(frame);
        frame.setVisible(true);
    }

    private synchronized static void addComponents(JFrame frame) {
        final JTextField field = new JTextField();
        field.setPreferredSize(new Dimension(150, 50));
        frame.setLayout(new FlowLayout());
        frame.add(field);

        JButton start = new JButton("Start");
        frame.add(start);
        JButton stop = new JButton("Stop");
        frame.add(stop);
        final Synchronizer synchronizer = new Synchronizer();
        final CountThread countThread = new CountThread(field, synchronizer);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(countThread.getState() == Thread.State.NEW) {
                    countThread.start();
                } else {
                    countThread.wakeUp();
                }
            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countThread.pleaseWait();
            }
        });
    }

    private static class CountThread extends Thread {
        private JTextField field;
        private Synchronizer synchronizer;
        private boolean isWait;

        public CountThread(JTextField field, Synchronizer sync) {
            this.field = field;
            this.synchronizer = sync;

        }

        public void pleaseWait() {
            isWait = true;
        }

        public void wakeUp() {
            synchronizer.signal();
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10 && !currentThread().isInterrupted(); i++) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
                if(isWait) {
                    synchronizer.await();
                    isWait = false;
                }
                field.setText(field.getText() + String.valueOf(i));
            }
        }
    }

    private static class Synchronizer {
        public synchronized void await() {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void signal() {
            notify();
        }
    }
}
