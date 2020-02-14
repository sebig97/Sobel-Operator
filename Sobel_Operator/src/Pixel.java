public class Pixel {
    int r,g,b;

    //3 var de tip int care daca se modifica, se poate genera orice culoare aplicata unui pixel
    //constructor pixel
    public Pixel()
    {
    }


    public Pixel(int r, int g, int b) {
        super();
        this.r = r;
        this.g = g;
        this.b = b;
    }



    //setters and getters
    public void setR(int r) {
        this.r = r;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }


}
