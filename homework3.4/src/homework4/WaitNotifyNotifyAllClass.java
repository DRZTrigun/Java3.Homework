package homework4;

public class WaitNotifyNotifyAllClass {
    static Object threadABC = new Object();
    static volatile char letter = 'A';


    public static void main(String[] args){
        new Thread(new WaitNotifyClass('A', 'B')).start();
        new Thread(new WaitNotifyClass('B', 'C')).start();
        new Thread(new WaitNotifyClass('C', 'A')).start();
    }

    // создем класс и наследуем от итрерфейса Runnable
    static class WaitNotifyClass implements Runnable {
        // создаем две переменные
        private char currentLetter;
        private char nextLetter;

        // делаем констуруктор
        public WaitNotifyClass(char currentLetter, char nextLetter) {
            this.currentLetter = currentLetter;
            this.nextLetter = nextLetter;
        }

        // переопределяем метод run
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                // синхронизируем
                synchronized (threadABC) {
                    try {
                        while (letter != currentLetter)
                            threadABC.wait();
                        System.out.print(currentLetter);
                        letter = nextLetter;
                        threadABC.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}