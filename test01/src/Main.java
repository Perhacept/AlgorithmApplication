import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        /*
        //将初始化方法放入java事件分发线程中
        //lamda表达式
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setSize(500,500);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);//使窗口可视
        });
        */

        /*
        EventQueue.invokeLater(() -> {
            //AlgoFrame frame = new AlgoFrame("Welcome");
            AlgoFrame frame2 = new AlgoFrame("Welcome",500,500);
        });
        */

        //动画test
        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 10;//画10个圆

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth,sceneHeight,N);



    }
}
