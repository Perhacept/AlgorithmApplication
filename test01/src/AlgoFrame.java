import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
//import java.awt.geom.Ellipse2D;

public class AlgoFrame extends JFrame {
    private int canvasWidth;
    private  int canvasHeight;

    //告诉框架需要绘制什么
    private CircleAnimationTest[] _circles;
    public void render(CircleAnimationTest[] crils)
    {
        this._circles = crils;
        this.repaint();//重新绘制 会重新调用paintComponent方法
    }

    public AlgoFrame(String title,int canvasWidth,int canvasHeight){
        //调用父类构造函数
        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        //canvas.setPreferredSize(new Dimension(canvasWidth,canvasHeight));
        //setSize(canvasWidth,canvasHeight);
        setContentPane(canvas);
        pack();//根据加载内容自动调整画布大小

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public AlgoFrame(String title){
        this(title, 1024,768);
    }

    public int getCanvasWitdh(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}




    //内部类  为了帮助实现面板绘制
    private class AlgoCanvas extends JPanel{

        //(默认)支持双缓冲
      //  public AlgoCanvas(){
       //     super(true);//打开双缓冲
      //  }

        //g连接了上下文 绘制函数都定义在g中
        //JPanel override 减少bug出现概率
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;

            //抗锯齿
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);

            //具体绘制
            /*
            //内部参数定义出一个包围盒 正方形就是圆形 长方形就是椭圆
            //左上角坐标 长宽
            //屏幕坐标系在屏幕左上角 x轴正方向一致 y相反
            //g.drawOval(50,50,300,300);

            //int strokeWidth = 10;
            //g2d.setStroke(new BasicStroke(strokeWidth));
            AlgoVisHelper.setStrokeWidth(g2d,5);

            g2d.setColor(Color.BLUE);
            //Ellipse2D circle2 = new Ellipse2D.Double(60,60,280,280);
            Ellipse2D circle2 = new Ellipse2D.Double(50,50,300,300);
            g2d.fill(circle2);

            g2d.setColor(Color.RED);
            Ellipse2D circle= new Ellipse2D.Double(50,50,300,300);
            g2d.draw(circle);
            */
            //具体绘制
            AlgoVisHelper.setStrokeWidth(g2d,1);
            AlgoVisHelper.setColor(g2d,Color.red);
            for(CircleAnimationTest circle:_circles)
                AlgoVisHelper.strokeCircle(g2d,circle.x,circle.y,circle.getR());

        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth,canvasHeight);
        }

    }





}
