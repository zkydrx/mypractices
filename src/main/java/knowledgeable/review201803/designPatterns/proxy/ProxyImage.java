package knowledgeable.review201803.designPatterns.proxy;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-22
 * Time: 09:31:21
 * Description:
 */
public class ProxyImage implements Image
{

    private RealImage realImage;
    private String fileName;
    public ProxyImage(String fileName)
    {
        this.fileName = fileName;
    }

    @Override
    public void display()
    {
        if(realImage ==null)
        {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
