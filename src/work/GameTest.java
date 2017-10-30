package work;

public class GameTest {
	public static void main(String args[]){
		
		Timecontrol test = new Timecontrol();
		test.flush();
		for(int x = 0;x < test.SIZE;x++)
			for(int y=0;y < test.SIZE;y++){
				test.table[x][y] = true;
			}
		test.GetNeigh();
		int judge[][] = new int[test.SIZE][test.SIZE];
		for(int x = 0;x < test.SIZE;x++)
			for(int y=0;y < test.SIZE;y++){
				judge[x][y] = 8;
			}
		for(int i=1;i<test.SIZE-1;i++){
			judge[0][i] = judge[i][0] = 5;
			judge[test.SIZE-1][i] = judge[i][test.SIZE-1] = 5;
		}
		judge[0][0] = judge[test.SIZE-1][test.SIZE-1] = judge[test.SIZE-1][0] = judge[0][test.SIZE-1] = 3;
		for(int x = 0;x < test.SIZE;x++)
		for(int y=0;y < test.SIZE;y++){
			System.out.print(test.neigh[x][y]);
			if(y==test.SIZE-1) System.out.println();
		}
		for(int x = 0;x < test.SIZE;x++)
		for(int y=0;y < test.SIZE;y++){
			System.out.print(judge[x][y]);
			if(y==test.SIZE-1) System.out.println();
		}
	}
}

