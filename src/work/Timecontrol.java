package work;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;


/**
 * 
 * @author CYW AND YP
 *
 * start���ո�|��S��
 * 
 * ���������Ƴ�ʼ��ͼϸ��״̬
 *
 * Ctrl+���������ϸ��
 */

@SuppressWarnings("serial")
public class Timecontrol extends Applet implements Runnable,MouseListener,MouseMotionListener,KeyListener{
	final int SIZE = 40;
	final int Cell_SIZE = 10;
	private Color cell = new Color(32,98,40);
	private Color space = new Color(226,245,226);
	boolean[][] table= new boolean [SIZE][SIZE];
	int[][] neigh = new int [SIZE][SIZE];//��ǰϸ����Χϸ������
	private Thread animator;
	private int delay;//�ӳ�
	private boolean running;//�������

	
	@Override public void run(){
		long tm = System.currentTimeMillis();
		while(Thread.currentThread()==animator){
			if(running==true){
				GetNeigh();
				nexttable();
				repaint();
			}
		    //if(running == false){
			//	flush();
			//	nexttable();
			//	repaint();
			//}
			try{
				tm += delay;
				Thread.sleep(Math.max(0, tm-System.currentTimeMillis()));
			}catch(InterruptedException e){
				break;
			}
		}
	}
	@Override public void init(){
		animator = new Thread(this);
		for(int x = 0;x < SIZE;x++)
			for(int y=0;y < SIZE;y++){
				table[x][y] = false;
			}
		delay =  100;
		running = false;
		setBackground(new Color(199,237,204));
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
	}
	@Override public void start(){
		animator.start();
	}
	@Override public void stop(){
		animator = null;
	}
	@Override public void paint(Graphics g){
		update(g);
	}
	@Override public void update(Graphics g){
		for(int x = 0;x < SIZE;x++)
			for(int y=0;y < SIZE;y++){
				g.setColor(table[x][y]?cell:space);
				g.fillRect(x * Cell_SIZE, y*Cell_SIZE, Cell_SIZE-1,Cell_SIZE-1);
			}
	}
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if(e.getKeyChar()==' '){
		running = !running;
		repaint();
	}
	if(e.getKeyChar()=='S'){
		running = !running;
		repaint();
	}
}

@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	this.mousePressed(e);
}

@Override
public void mouseMoved(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	int cellX = e.getX()/Cell_SIZE;
	int cellY = e.getY()/Cell_SIZE;
	table[cellX][cellY] = !e.isControlDown();
	repaint();
}
@Override
public void mouseReleased(MouseEvent arg0) {

	// TODO Auto-generated method stub
	
}
//ˢ��table
	public void flush(){
		for(int i = 0;i < SIZE; i++ ){
			for(int j = 0;j < SIZE; j++ )
			{
				neigh[i][j] = 0;
			}}
	}
	//�õ�ÿ��ϸ�����ڴ��ϸ����
	public  void  GetNeigh(){
		flush();
		for(int i = 0;i < SIZE; i++ ){
			for(int j = 0;j < SIZE; j++ )
			{
				if(i-1>=0&&j-1>=0&&table[i-1][j-1]) neigh[i][j]++;
				if(i-1>=0        &&table[i-1][j]) neigh[i][j]++;
				if(i-1>=0&&j+1<SIZE&&table[i-1][j+1]) neigh[i][j]++;
				if(        j-1>=0&&table[i][j-1]) neigh[i][j]++;
				if(        j+1<SIZE&&table[i][j+1]) neigh[i][j]++;
				if(i+1<SIZE&&j-1>=0&&table[i+1][j-1]) neigh[i][j]++;
				if(i+1<SIZE        &&table[i+1][j]) neigh[i][j]++;
				if(i+1<SIZE&&j+1<SIZE&&table[i+1][j+1]) neigh[i][j]++;
			}
}}
	//�õ��δ�ϸ��ͼ
	public  void nexttable(){
		for(int i = 0;i < SIZE; i++ ){
			for(int j = 0;j < SIZE; j++ ){
				if(neigh[i][j]==3) table[i][j]=true;
				else if(neigh[i][j]==2) table[i][j]=table[i][j];
				else table[i][j]=false;
			}
	}}

}
