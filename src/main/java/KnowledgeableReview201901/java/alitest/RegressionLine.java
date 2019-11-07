package KnowledgeableReview201901.java.alitest;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-02-03
 * Time: 17:16:28
 * Description:
 */
//RegressionLine类，用于处理一元线性回归问题

import java.math.BigDecimal;
import java.util.ArrayList;

public class RegressionLine
{
    private double sumX = 0;//训练集x的和
    private double sumY = 0;//训练集y的和
    private double sumXX = 0;//x*x的和
    private double sumYY = 0;//y*y的和
    private double sumXY = 0;//x*y的和
    private double sumDeltaY;//y与yi的差
    private double sumDeltaY2; // sumDeltaY的平方和
    //误差
    private double sse;//残差平方和
    private double sst;//总平方和
    private double E;
    private double[] xy;
    private ArrayList<String> listX;//x的链表
    private ArrayList<String> listY;//y的链表
    private double XMin, XMax, YMin, YMax;
    private double a0;//线性系数a0
    private double a1;//线性系数a1
    private int pn;  //训练集数据个数
    private boolean coefsValid;

    //类RegressionLine的构造函数
    public RegressionLine()
    {
        XMax = 0;
        YMax = 0;
        pn = 0;
        xy = new double[2];
        listX = new ArrayList<>();
        listY = new ArrayList<>();
    }

    //类RegressionLine的有参构造函数
    public RegressionLine(DataPoint data[])
    {
        pn = 0;
        xy = new double[2];
        listX = new ArrayList();
        listY = new ArrayList();
        for (int i = 0; i < data.length; ++i)
        {
            addDatapoint(data[i]);//添加数据集的方法addDatapoint
        }
    }

    public int getDataPointCount()
    {
        return pn;
    }

    public double getA0()
    {
        validateCoefficients();
        return a0;
    }

    public double getA1()
    {
        validateCoefficients();
        return a1;
    }

    public double getSumX()
    {
        return sumX;
    }

    public double getSumY()
    {
        return sumY;
    }

    public double getSumXX()
    {
        return sumXX;
    }

    public double getSumYY()
    {
        return sumYY;
    }

    public double getSumXY()
    {
        return sumXY;
    }

    public double getXMin()
    {
        return XMin;
    }

    public double getXMax()
    {
        return XMax;
    }

    public double getYMax()
    {
        return YMax;
    }

    public double getYMin()
    {
        return YMin;
    }

    //添加训练集数据的方法
    public void addDatapoint(DataPoint dataPoint)
    {
        sumX += dataPoint.x;
        sumY += dataPoint.y;
        sumXX += dataPoint.x * dataPoint.x;
        sumYY += dataPoint.y * dataPoint.y;
        sumXY += dataPoint.x * dataPoint.y;

        if (dataPoint.x > XMax)
        {
            XMax = dataPoint.x;
        }
        if (dataPoint.y > YMax)
        {
            YMax = dataPoint.y;
        }
        xy[0] = dataPoint.x;//?
        xy[1] = dataPoint.y;//?
        if (dataPoint.x != 0 && dataPoint.y != 0)
        {
            System.out.print("(" + xy[0] + ",");
            System.out.println(xy[1] + ")");
            try
            {
                listX.add(pn, String.valueOf(xy[0]));
                listY.add(pn, String.valueOf(xy[1]));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        ++pn;
        coefsValid = false;
    }

    //计算预测值y的方法
    public double at(double x)
    {
        if (pn < 2)
        {
            return Float.NaN;
        }
        validateCoefficients();
        return a0 + a1 * x;
    }

    //重置此类的方法
    public void reset()
    {
        pn = 0;
        sumX = sumY = sumXX = sumXY = 0;
        coefsValid = false;
    }

    //计算系数a0，a1的方法
    private void validateCoefficients()
    {
        if (coefsValid)
        {
            return;
        }
        if (pn >= 2)
        {
            double xBar = (double) sumX / pn;
            double yBar = (double) sumY / pn;
            a1 = (double) ((pn * sumXY - sumX * sumY) / (pn * sumXX - sumX * sumX));
            a0 = (yBar - a1 * xBar);
        }
        else
        {
            a0 = a1 = Float.NaN;
        }
        coefsValid = true;
    }

    //计算判定系数R^2的方法
    public double getR()
    {
        for (int i = 0; i < pn; i++)
        {
            double Yi = Float.parseFloat(listY.get(i).toString());
            double Y = at(Float.parseFloat(listX.get(i).toString()));
            double deltaY = Yi - Y;
            double deltaY2 = deltaY * deltaY;
            sumDeltaY2 += deltaY2;
            double deltaY1 = (Yi - (double) (sumY / pn)) * (Yi - (double) (sumY / pn));
            sst += deltaY1;
        }
        //sst = sumYY - (sumY*sumY)/pn;
        E = 1 - sumDeltaY2 / sst;
        return round(E, 4);
    }

    //返回经处理过的判定系数的方法
    public double round(double v, int scale)
    {
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}

