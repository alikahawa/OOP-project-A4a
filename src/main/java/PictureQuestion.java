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

    public void print()
    {
        System.out.println(question);
    }

}
