import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server extends Thread {
    static boolean socket;
    static int skore = 999;
    static Socket s1;
    static Socket s2;
    static BufferedReader i1;
    static BufferedReader i2;
    static PrintWriter o1;
    static PrintWriter o2;
    public static void main(String[] args) throws IOException, InterruptedException {
        skore = 999;
        for (;;) {
            socket = true;
            ServerSocket ss1 = new ServerSocket(27513);
            s1 = ss1.accept();
            Random rn = new Random();
            int rand = rn.nextInt(7) + 1;
            o1.println(rand);
            o1 = new PrintWriter(s1.getOutputStream(), true);
            i1 = new BufferedReader(new InputStreamReader(s1.getInputStream()));
            ServerSocket ss2 = new ServerSocket(27513);
            s2 = ss2.accept();
            o2 = new PrintWriter(s2.getOutputStream(), true);
            i2 = new BufferedReader(new InputStreamReader(s2.getInputStream()));
            o2.println(rand);
            Server t1 = new Server();
            Server t2 = new Server();
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        }
    }

    @Override
    public void run() {
        if (socket) {
            int vysledek;
            try {
                vysledek = Integer.parseInt(i1.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (skore != 999) {
                skore = vysledek;
            } else {
                if (skore >= vysledek) {
                    o1.println(false);
                    o2.println(true);
                } else {
                    o1.println(true);
                    o2.println(false);
                }
            }
        } else {
            int vysledek;
            try {
                vysledek = Integer.parseInt(i2.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (skore != 999) {
                skore = vysledek;
            } else {
                if (skore >= vysledek) {
                    o1.println(true);
                    o2.println(false);
                } else {
                    o1.println(false);
                    o2.println(true);
                }
            }
        }
    }
}