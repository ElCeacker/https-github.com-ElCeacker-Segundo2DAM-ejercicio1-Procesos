import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner teclado = new Scanner(System.in);
        ProcessBuilder pb = new ProcessBuilder("notepad.exe");
        Process process = null;


        System.out.println("¿Cuantos procesos quieres?");
        int numeroTeclado = teclado.nextInt();

        ArrayList<Process> cargadeProcesos = new ArrayList<>();

        for (int i = 0; i < numeroTeclado; i++) {
            process = pb.start();
            cargadeProcesos.add(process);
        }

        for (int i = 0; i < cargadeProcesos.size(); i++) {
            Process misProcesos = cargadeProcesos.get(i);
            while (misProcesos.isAlive()) {}
        }

        try {
            int exitCode = process.waitFor();
            System.out.println("procesos terminados " + exitCode);
        } catch (InterruptedException e) {
            System.out.println("Ta petao");
            System.err.println("El proceso no se ha podido ejecutar");
            System.err.println("Esto hizo Cascaso");
        }
    }
}
