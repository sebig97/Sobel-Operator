import java.awt.*;
import java.io.IOException;

//este o clasa abstracta. retine img initala si o compara cu cea finala, dupa aplicarea algoritmului.
abstract class FiltruImagine implements Algoritm{

    Image imgInitial, imgNoua;

    //constructor FiltruImagine
    public FiltruImagine(String inputPath, String outputPath)
    {
        imgInitial = new Image();
        try {
            long startTime = System.currentTimeMillis();
            //seteaza calea de input
            this.imgInitial.setInputFile(inputPath);
            //seteaza calea de output
            this.imgInitial.setOutputPath(outputPath);
            this.imgInitial.read();
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println("citire"+elapsedTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //declararea imaginii noi, pe baza celei vechi
        this.imgNoua = new Image(imgInitial.getWidth(),imgInitial.getHeight(),imgInitial.getInputFile(),imgInitial.getOutputPath());
    }
}
