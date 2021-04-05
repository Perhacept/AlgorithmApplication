import java.awt.*;

//MVC中的控制层
public class AlgoVisualizer {
    private CircleAnimationTest[] circles;//数据信息
    private  AlgoFrame frame;//视图层

    public AlgoVisualizer(int sceneWidth, int sceneHeight,int N){
        //CircleAnimationTest[]
        circles = new CircleAnimationTest[N];
        int R=50;
        for (int i = 0;i<N;i++){
            int x = (int)(Math.random()*(sceneWidth-2*R))+R;
            int y=(int)(Math.random()*(sceneHeight-2*R))+R;;
            int vx=(int)(Math.random()*11) - 5;
            int vy=(int)(Math.random()*11) - 5;
            circles[i] = new CircleAnimationTest(x,y,R,vx,vy);
            //rand(0,sceneWidth-2R)+R
        }
        EventQueue.invokeLater(() -> {
            //AlgoFrame frame = new AlgoFrame("Welcome");
            frame = new AlgoFrame("Welcome",sceneWidth,sceneHeight);
            //AlgoFrame
            //不能直接放进事件队列里 以防事件阻塞 new一个thread
            new Thread(() -> {
                run();
            }).start();
        });



    }

    private void run(){
        while(true){
            //绘制数据
            frame.render(circles);
            AlgoVisHelper.pause(20);

            //更新数据
            for(CircleAnimationTest circle: circles){
                circle.move(0,0,frame.getCanvasWitdh(),frame.getCanvasHeight());
            }
            for(int p =0;p<circles.length;p++){
                for(int i = 0; i<p; i++){
                    circles[p].addjustMove(circles[i]);
                }
                for(int i = p+1; i<circles.length; i++){
                    circles[p].addjustMove(circles[i]);
                }
            }
        }
    }




}
