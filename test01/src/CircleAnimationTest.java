import java.awt.*;

public class CircleAnimationTest {
    public int x,y;//圆的圆心位置
    private  int r;//初始化指定半径 不能动态修改
    public int vx,vy;//圆的速度 可动态修改

    public CircleAnimationTest(int x, int y, int r, int vx, int vy){
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }

    public int getR(){return r;}

    public void move(int minx,int miny,int maxx,int maxy){
        x+=vx;
        y+=vy;

        checkCollision(minx, miny, maxx, maxy);
        //if(isCollided(cir)){
           // vx = -vx;
           // vy = -vy;
       // }
    }
    public void addjustMove(CircleAnimationTest cir){
        CollisionRejust(cir);
//        if(isCollided(cir)){
//         vx = -vx;
//         vy = -vy;
//         }
        //抽搐效果是因为没有逃逸 以至于在边界来回碰撞了
        //解决方法1：计算嵌入深度 然后推离
    }

    private  void checkCollision(int minx,int miny,int maxx,int maxy){
        if(x - r<minx){x = r; vx= -vx;}
        if(x+r>=maxx){x = maxx - r; vx = -vx;}
        if(y -r<miny){y = r;vy=-vy;}
        if(y+r >=maxy){y = maxy - r;vy=-vy;}
    }

    private boolean isCollided(CircleAnimationTest cir){
        double _centerDIs = centerDistance(new Point(this.x,this.y),new Point(cir.x,cir.y));
        if(_centerDIs<(this.r+cir.r)){
            return true;
        }
        return false;
    }
    private double centerDistance(Point p1, Point p2){
        return  Math.hypot((p2.x)-(p1.x),(p2.y)-(p1.y));
    }
    private Point normalizeVector(Point pVector){
        //精度丢失警告
        int length = (int)centerDistance(new Point(0,0),pVector);
        if(length!=0){
            return new Point(pVector.x/length,pVector.y/length);
        }
        else{
            return new Point(pVector.x,pVector.y);
        }

    }

    //解决碰撞抽搐问题
    //因为我们知道它们的速度 所以可以计算出嵌入深度
//    private  double qianrushendu(CircleAnimationTest cir){
//        if(isCollided(cir)){
//
//        }
//        return 0;
//    }

    //解决碰撞抽搐问题
    private void CollisionRejust(CircleAnimationTest cir){
        double _centerDIs = centerDistance(new Point(this.x,this.y),new Point(cir.x,cir.y));
        if(_centerDIs<(this.r+cir.r)){
            vx=-vx;
            vy=-vy;

            //弹出嵌入深度
            double _innerDIs = this.r + cir.r - _centerDIs;//嵌入深度
            //方向
            Point directionP = normalizeVector(new Point(this.x - cir.x,this.y - cir.y));
            this.x += (int)((directionP.x*_innerDIs+1));
            this.y += (int)((directionP.y*_innerDIs+1));


        }
        else{

        }
    }

}
