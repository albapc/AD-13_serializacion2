package serializacion2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Alba
 */
public class Serializacion2 {

//    private static FileOutputStream fos;
    private static ObjectOutputStream oos;
//    private static FileInputStream fis;
    private static ObjectInputStream ois;

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"cravos", "parafusos", "tachas"};
        double[] prezo = {3.0, 4.0, 5.0};

        //fos = new FileOutputStream("serial.dat");
        //oos = new ObjectOutputStream(fos);
        //fis = new FileInputStream("serial.dat");
        //ois = new ObjectInputStream(fis);
        
        oos = new ObjectOutputStream(new FileOutputStream("serial.dat"));
        ois = new ObjectInputStream(new FileInputStream("serial.dat"));

        for (int i = 0; i < cod.length; i++) {
            Products pr = new Products(cod[i], desc[i], prezo[i]);
            oos.writeObject(pr);
        }

        oos.writeObject(null);
        oos.close();
        //fos.close();

        Products pr2 = (Products) ois.readObject();
        while (pr2 != null) {
            System.out.println(pr2.toString());
            pr2 = (Products) ois.readObject();
        }

        ois.close();
        //fis.close();
    }

}
