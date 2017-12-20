public class PictureQuestion extends Question {

    String picture;
    int X1;
    int X2;
    int Y1;
    int Y2;

    public PictureQuestion (String question, String picture, int X1, int X2, int Y1, int Y2)
    {
        super(question);
        this.picture = picture;
        this.X1 = X1;
        this.X2 = X2;
        this.Y1 = Y1;
        this.Y2 = Y2;
    }

    public void setPicture(String fileName)
    {
        picture = fileName;
    }

    public String getPicture()
    {
        return picture;
    }

    public void print()
    {
        System.out.println(question);
    }

    public int getX1()
    {
        return X1;
    }

    public int getX2()
    {
        return X2;
    }

    public int getY1()
    {
        return Y1;
    }

    public int getY2()
    {
        return Y2;
    }

    public void setX1(int X1)
    {
        this.X1 = X1;
    }

    public void setX2(int X2)
    {
        this.X2 = X2;
    }

    public void setY1(int Y1)
    {
        this.Y1 = Y1;
    }

    public void setY2(int Y2)
    {
        this.Y2 = Y2;
    }

    public boolean equals(Object other)
    {
        if (other instanceof PictureQuestion)
        {
            PictureQuestion otherQ = (PictureQuestion)other;
            if (otherQ.question == this.question &&
                otherQ.picture == this.picture &&
                otherQ.X1 == this.X1 &&
                otherQ.X2 == this.X2 &&
                otherQ.Y1 == this.Y1 &&
                otherQ.Y2 == this.Y2)
            {
                return true;
            }
        }
        return false;
    }
}
