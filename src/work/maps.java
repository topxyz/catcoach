package work;

import java.util.Random;

/**
 * 
 * @author Mr JIAN
 *
 */
public class maps {
	private final static int SIZE = 40;//游戏地图长宽
	//private final int CELL_SIZE = 2;//格子长宽
	//private final static int row = 20;
	//private final static int col = 20;
	//private int[][] Maps = new int [SIZE][SIZE]; 
	static boolean[][] table= new boolean [SIZE][SIZE];
	static int[][] neigh = new int [SIZE][SIZE];//当前细胞周围细胞个数
	
	//初始化游戏地图
	public void initMap(){
		Random random = new Random();
		for(int i = 0;i < SIZE; i++ )
			for(int j = 0;j < SIZE; j++ )
			{
				table[i][j] = random.nextBoolean();
			}
	}
	//刷新table
	public static void flush(){
		for(int i = 0;i < SIZE; i++ )
			for(int j = 0;j < SIZE; j++ )
			{
				neigh[i][j] = 0;
			}
	}
	//得到每个细胞相邻存活细胞数
	public static void GetNeigh(){
		flush();
		for(int i = 0;i < SIZE; i++ )
			for(int j = 0;j < SIZE; j++ )
			{
				if(i-1>=0&&j-1>=0&&table[i-1][j-1]) neigh[i][j]++;
				if(i-1>=0        &&table[i-1][j]) neigh[i][j]++;
				if(i-1>=0&&j+1<=19&&table[i-1][j+1]) neigh[i][j]++;
				if(        j-1>=0&&table[i][j-1]) neigh[i][j]++;
				if(        j+1>=0&&table[i][j+1]) neigh[i][j]++;
				if(i+1<=19&&j-1>=0&&table[i+1][j-1]) neigh[i][j]++;
				if(i+1<=19        &&table[i+1][j]) neigh[i][j]++;
				if(i+1<=19&&j+1>=0&&table[i+1][j+1]) neigh[i][j]++;
			}
}
	//得到次代细胞图
	public static void nexttable(){
		for(int i = 0;i < SIZE; i++ )
			for(int j = 0;j < SIZE; j++ ){
				if(neigh[i][j]==3) table[i][j]=true;
				else if(neigh[i][j]==2) table[i][j]=table[i][j];
				else table[i][j]=false;
			}
	}
}
