import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HelloXlassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            new HelloXlassLoader().findClass("Hello").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("./Week_01/Hello.xlass"));
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (255 - bytes[i]);
            }
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
