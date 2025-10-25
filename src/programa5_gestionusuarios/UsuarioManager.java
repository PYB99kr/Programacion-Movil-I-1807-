import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioManager {
    private static final String ARCHIVO_USUARIOS = "usuarios.txt";

    public static List<Usuario> cargarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_USUARIOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Usuario u = Usuario.fromString(linea);
                if (u != null) {
                    usuarios.add(u);
                }
            }
        } catch (FileNotFoundException e) {
            // Archivo no existe, se devuelve una lista vacía. Es normal al inicio.
            System.out.println("Archivo de usuarios no encontrado, iniciando con lista vacía.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public static void guardarUsuarios(List<Usuario> usuarios) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_USUARIOS))) {
            for (Usuario u : usuarios) {
                bw.write(u.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}