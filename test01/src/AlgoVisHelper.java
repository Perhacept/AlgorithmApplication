import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AlgoVisHelper {

    //不能实例化对象的工具类 方法全为static

    private AlgoVisHelper(){}

    public static void setStrokeWidth(Graphics2D g2d,int w){
        int strokeWidth = w;
        g2d.setStroke(new BasicStroke(strokeWidth,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
    }

    public static void strokeCircle(Graphics2D g2d,int x,int y,int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r,y-r,2*r,2*r);
        g2d.draw(circle);
    }
    public static void fillCircle(Graphics2D g2d,int x,int y,int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r,y-r,2*r,2*r);
        g2d.fill(circle);
    }

    public static void setColor(Graphics2D g2d,Color color){
        g2d.setColor(color);
    }

    public static void pause(int t){
        //t:  单位为毫秒
        //java中thread可能抛出异常 为对这个异常处理 将其封装在这个类的功能中
        try{
            //try中存放可能出现异常的代码
            Thread.sleep(t);
        }
        catch (InterruptedException e){
            System.out.println("Error in sleeping.");
        }

    }

}
