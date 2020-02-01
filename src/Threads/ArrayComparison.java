package Threads;

public class ArrayComparison {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    static {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
    }

    static void simpleFilling(float[] array){
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }
    static void quickFilling(float[] array) throws InterruptedException {
        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        System.arraycopy(array, 0, a1, 0, h);
        float[] a2 = new float[h];
        System.arraycopy(array, h, a2, 0, h);

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < h; i++) {
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();
        if(t1.isAlive()) t1.join();
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < h; i++) {
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        };
        Thread t2 = new Thread(r2);
        t2.start();
        if(t2.isAlive()) t2.join();
        System.arraycopy(a1, 0, array, 0, h);
        System.arraycopy(a2, 0, array, h, h);
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void main(String[] args){
        float[] newArr1 = new float[size];
        float[] newArr2 = new float[size];
        System.arraycopy(arr, 0, newArr1, 0, size);
        System.arraycopy(arr, 0, newArr2, 0, size);
        simpleFilling(newArr1);
//        System.out.println(newArr1[0] + " " + newArr1[h-1] + " " + newArr1[h] + " " + newArr1[size-1]);
        try{
            quickFilling(newArr2);
//            System.out.println(newArr2[0] + " " + newArr2[h-1] + " " + newArr2[h] + " " + newArr2[size-1]);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
