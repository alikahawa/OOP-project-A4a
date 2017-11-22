import java.util.ArrayList;
import java.util.List;

public class QuestionList {

    List<Question> qList;

    public QuestionList()
    {
        qList = new ArrayList<Question>();
    }

    public List<Question> getQList()
    {
        return qList;
    }

    public void setQList(List<Question> qList)
    {
        this.qList = qList;
    }

}
