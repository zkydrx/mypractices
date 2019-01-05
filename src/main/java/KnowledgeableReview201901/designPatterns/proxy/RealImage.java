package KnowledgeableReview201901.designPatterns.proxy;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-22
 * Time: 09:28:49
 * Description:
 */
public class RealImage implements Image
{
    private String fileName;

    public RealImage(String fileName)
    {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName)
    {
        System.out.println("loading..."+fileName);
    }
    @Override
    public void display()
    {
        System.out.println("Displaying1"+fileName);
    }
}
