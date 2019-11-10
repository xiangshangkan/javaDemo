package concurrency_in_practice.jmm;

/**
 * 演示可见性带来的问题
 */
public class FieldVisibility {

     int a = 1, b = 2;

    public static void main(String[] args) {
        do {
            FieldVisibility test = new FieldVisibility();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.change();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.print();
                }
            }).start();
        }while (true);
    }

    private void change() {
        a = 3;
        b = a;
    }

    private void print() {
        System.out.println("b = " + b +"；a = " + a);
    }
}
