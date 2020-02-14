//implementeaza filtrul sobel, aceasta fiind derivata din filtru imagine.
public class OperatorSobel extends FiltruImagine {

    int[][] Gx,Gy;

    public OperatorSobel(String inputPath, String outputPath)
    {
        //se face super()
        super(inputPath,outputPath);
        Gx = new int[][] {
                {-1, 0, 1},
                {-2, 0, 2},
                {-1, 0, 1}
        };
        Gy = new int[][] {
                {-1, -2, -1},
                {0, 0, 0},
                {1, 2, 1}
        };
    }

    public static void aplica(int ...a){

            System.out.println("Number of arguments: " + a.length);

            // for each loop pentru a afisa continutul lui a
            for (int i: a)
                System.out.print(i + " ");
            System.out.println();
    }

    //e necesara deoarece filtrul se aplica numai pe imagini alb negru
    public void AplicareGrayScale()
    {
        //aplicare gray scale ca fiind media aritmetica a R,G,B pentru fiecare pixel in parte
        for(int i = 0 ; i < super.imgInitial.height; i++)
            for(int j = 0; j < super.imgInitial.width; j++)
            {	int avg = (super.imgInitial.imgPixels[i][j].getR() + super.imgInitial.imgPixels[i][j].getG() + super.imgInitial.imgPixels[i][j].getB())/3;
                super.imgNoua.imgPixels[i][j].setR(avg);
                super.imgNoua.imgPixels[i][j].setG(avg);
                super.imgNoua.imgPixels[i][j].setB(avg);
            }

    }

    public void AplicareAlgoritm() {
        long startTime = System.currentTimeMillis();
        AplicareGrayScale();
        //se parcurge matricea pana la height-2, width-2
        for(int i = 0; i < super.imgNoua.getHeight() - 2; i++)
            for(int j = 0; j < super.imgNoua.getWidth() - 2; j++)
            {
                int sumGx = 0;
                int sumGy = 0;
                //pentru fiecare element se ia un bloc de 3x3
                for(int x = i; x < i + 3; x++)
                    for(int y = j; y < j + 3; y++)
                    {
                        //se aduna dupa regula data
                        sumGx += super.imgNoua.imgPixels[x][y].getR() * Gx[2-(x-i)][2-(y-j)];
                        sumGy += super.imgNoua.imgPixels[x][y].getR() * Gy[2-(x-i)][2-(y-j)];
                    }
                //valoarea finala a noului pixel
                int G = (int) Math.sqrt(sumGx*sumGx + sumGy*sumGy);

                super.imgNoua.imgPixels[i][j].setR(G);
                super.imgNoua.imgPixels[i][j].setG(G);
                super.imgNoua.imgPixels[i][j].setB(G);
            }
        //daca >255 se seteaza 255
        for(int i = 0; i < super.imgNoua.getHeight() ; i++)
            for(int j = 0; j < super.imgNoua.getWidth() ; j++)
            {
                if(imgNoua.imgPixels[i][j].getR()>255)
                {
                    super.imgNoua.imgPixels[i][j].setR(255);
                    super.imgNoua.imgPixels[i][j].setG(255);
                    super.imgNoua.imgPixels[i][j].setB(255);
                }
            }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("aplicare filtru"+elapsedTime);
        startTime = System.currentTimeMillis();
        //generarea noului fisier
        imgNoua.write();
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        System.out.println("afisare"+elapsedTime);

    }


}
