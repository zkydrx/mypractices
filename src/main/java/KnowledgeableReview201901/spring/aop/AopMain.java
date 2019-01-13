package KnowledgeableReview201901.spring.aop;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-13
 * Time: 17:31:12
 * Description:
 */
public class AopMain
{
    private static Logger logger = Logger.getLogger(AopMain.class);
    public static void f()
    {
        go();
    }

    public static void go()
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-aop.xml");

        Calculator addCal = (Calculator) ctx.getBean("addCalculator");
        Calculator subCal = (Calculator) ctx.getBean("subCalculator");

        System.out.println(addCal.getResult(3, 1));
        System.out.println(subCal.getResult(3, 1));
    }

    public static void main(String[] args)
    {
        f();
        logger.debug("this is debug message.");
        logger.info("this is info message.");
        logger.error("this is error message.");
    }

}
