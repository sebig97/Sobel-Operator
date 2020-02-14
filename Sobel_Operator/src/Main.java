import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String inputPath = "E:\\Sobel_Operator\\src\\1.bmp";
        String outputPath = "E:\\Sobel_Operator\\src\\";

        //pentru aplicarea filtrului e nevoie de un obiect de tip operatorSobel ce primeste parametri de intrare si iesire.
        OperatorSobel os = new OperatorSobel(inputPath, outputPath);
        os.AplicareAlgoritm();
    }
}
