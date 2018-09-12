package com.myjava.concurrent.cn.itcast.heima2;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedThread {
/**
 * AtomicInteger
 * @author flyap
 *
 */
    class Bank {

        private AtomicInteger account=new AtomicInteger(100);
		public int getAccount() {
            return account.get();
        }

        /*
         * ��ͬ������ʵ��
         * 
         * @param money
         */
        public void save(int money) {
            account.getAndAdd(money);
        }

    }

    class NewThread implements Runnable {
    	
        private Bank bank;

        public NewThread(Bank bank) {
            this.bank = bank;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                bank.save(10);
                System.out.println(i + "�˻����Ϊ��" + bank.getAccount());
            }
        }

    }

    /*
     * �����̣߳������ڲ���
     */
    public void useThread() {
        Bank bank = new Bank();
        NewThread new_thread = new NewThread(bank);
        System.out.println("�߳�1");
        Thread thread1 = new Thread(new_thread);
        thread1.start();
        System.out.println("�߳�2");
        Thread thread2 = new Thread(new_thread);
        thread2.start();
    }

    public static void main(String[] args) {
        SynchronizedThread st = new SynchronizedThread();
        st.useThread();
    }

}
