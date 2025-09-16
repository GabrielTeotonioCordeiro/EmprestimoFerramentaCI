package principal;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            //  www.google.com.br  80
            String endereco = sc.next();
            int porta = sc.nextInt();
            Socket sock = new Socket(endereco, porta);
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String linha = "";
            out.println("GET / HTTP/1.0\n");
            while ((linha = in.readLine()) != null) {
                System.out.println("echo: " + linha);
            }
        } catch (IOException e) {
            System.err.println("Problemas de IO");
        }
    }
}
