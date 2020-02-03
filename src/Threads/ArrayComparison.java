package Threads;

public class ArrayComparison {
    static Object monitor = new Object();
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    static float[] a1 = new float[size];
    static float[] a2 = new float[h];

    static {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        System.arraycopy(arr, 0, a1, 0, size);
    }
    static void filling(float[] array, int start, int length){
        synchronized (monitor){
            for (int i = start; i < length; i++) {
                array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }
    static void simpleFilling(){
        long a = System.currentTimeMillis();
        filling(a1,0,size);
        System.out.println(System.currentTimeMillis() - a);
    }
    static void quickFilling() throws InterruptedException {
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a2, 0, h);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                if(a2[h - 1] == 1) filling(a2,0,h);
                else filling(arr,h,size);
            }
        };
        Thread t1 = new Thread(r);
        t1.start();
        if(t1.isAlive()) t1.join();
        Thread t2 = new Thread(r);
        t2.start();
        if(t2.isAlive()) t2.join();
        System.arraycopy(a2, 0, arr, 0, h);
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void main(String[] args){
        simpleFilling();
        try{
            quickFilling();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(a1[0] + " " + a1[h-1] + " " + a1[h] + " " + a1[h+1] + " " + a1[size-1]);
        System.out.println(arr[0] + " " + arr[h-1] + " " + arr[h] + " " + arr[h+1] + " " + arr[size-1]);
    }
}
