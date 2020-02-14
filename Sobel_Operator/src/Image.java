import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//se regseste agregarea pt matrice pixel
//constructori
public class Image {

    int width,height;
    Pixel[][] imgPixels;
    String inputPath,outputPath;

    public Image()
    {

    }

    public Image(Image img)
    {
        super();
        this.width = img.getWidth();
        this.height = img.getHeight();
        imgPixels = new Pixel[height][width];
        for( int i = 0; i < height; i++ )
            for( int j = 0; j < width; j++ )
            {
                this.imgPixels[i][j] = new Pixel();
                this.imgPixels[i][j].setR(img.imgPixels[i][j].getR());
                this.imgPixels[i][j].setB(img.imgPixels[i][j].getB());
                this.imgPixels[i][j].setG(img.imgPixels[i][j].getG());
            }
    }

    public Image(int width, int height, String inputPath, String outputPath)
    {	super();
        this.width = width;
        this.height = height;
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        imgPixels = new Pixel[height][width];
        for( int i = 0; i < height; i++ )
            for( int j = 0; j < width; j++ )
            {
                imgPixels[i][j] = new Pixel();
                this.imgPixels[i][j].setR(255);
                this.imgPixels[i][j].setB(255);
                this.imgPixels[i][j].setG(255);
            }
    }

    public Image(int width, int height, String inputPath, String outputPath, Pixel[][] Pixel) {
        super();
        this.width = width;
        this.height = height;
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        imgPixels = new Pixel[height][width];
        //seteaza valorile R,G,B pentru fiecare pixel
        for( int i = 0; i < height; i++ )
            for( int j = 0; j < width; j++ )
            {
                imgPixels[i][j] = new Pixel();
                this.imgPixels[i][j].setR(Pixel[i][j].getR());
                this.imgPixels[i][j].setB(Pixel[i][j].getB());
                this.imgPixels[i][j].setG(Pixel[i][j].getG());
            }

    }

    public void read() throws IOException
    {
        //se citeste fisierul dat
        File image = new File(this.inputPath);
        if(this.inputPath.contains(".bmp"))
        {

            BufferedImage imgBuffer = ImageIO.read(image);
            this.setWidth(imgBuffer.getWidth());
            this.setHeight(imgBuffer.getHeight());
            //se genereaza o matrice de pixeli
            imgPixels = new Pixel[height][width];


            for(int i = 0; i < height; i++)
                for( int j = 0; j < width; j++)
                {	//pentru fiecare pixel din matrice se extrag valoarile din BufferedImage
                    int clr = imgBuffer.getRGB(j, i);
                    imgPixels[i][j] = new Pixel();
                    imgPixels[i][j].setR((clr & 0x00ff0000) >> 16);
                    imgPixels[i][j].setG((clr & 0x0000ff00) >> 8);
                    imgPixels[i][j].setB(clr & 0x000000ff);

                }
        }
        else
        {//daca nu este fisier bmp
            System.out.print("Introduceti un fisier .bmp");
        }
    }

    public void write()
    {
        //un bufferedImage dupa dimensiunile pozei de afisat
        BufferedImage imgBuffer = new BufferedImage(this.getWidth(), this.getHeight(),BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < height; i++)
            for(int j = 0; j < width; j++)
            {//fiecare pixel e transformat intr-o culoare
                Color clr = new Color(imgPixels[i][j].getR(),imgPixels[i][j].getG(),imgPixels[i][j].getB());
                //se seteaza culoarea
                imgBuffer.setRGB(j, i, clr.getRGB());
            }
        try {
            //se incearca salvarea fisierului nou
            File outputfile = new File(this.outputPath + "\\newImage.bmp");
            ImageIO.write(imgBuffer, "bmp", outputfile);
        }
        catch(IOException e)
        {
        }
    }
    //setters and getters

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }


    public String getInputFile() {
        return inputPath;
    }


    public void setInputFile(String inputPath) {
        this.inputPath = inputPath;
    }


    public String getOutputPath() {
        return outputPath;
    }


    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }
}
