package work;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TimecontrolTest {
	
	//public static void assertEquals(int a[][] ,int b[][]){
		//if(a == null && b == null) return;
		//if(a != null && a.equals(b)) return;

	//}
	private static Timecontrol test = new Timecontrol();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test.flush();
		for(int x = 0;x < test.SIZE;x++)
			for(int y=0;y < test.SIZE;y++){
				test.table[x][y] = true;
			}

	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetNeigh() {
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
				assertEquals(judge[x][y],test.neigh[x][y]);
		   }
		for(int x = 0;x < test.SIZE;x++)
			for(int y=0;y < test.SIZE;y++){
				System.out.print(test.neigh[x][y]);
				if(y==test.SIZE-1) System.out.println();
			}
		//fail("Not yet implemented");
	}

	@Test
	public void testNexttable() {
		for(int x = 0;x < test.SIZE;x++)
			for(int y=0;y < test.SIZE;y++){
				test.neigh[x][y] = 8;
			}
		for(int i=1;i<test.SIZE-1;i++){
			test.neigh[0][i] = test.neigh[i][0] = 5;
			test.neigh[test.SIZE-1][i] = test.neigh[i][test.SIZE-1] = 5;
		}
		test.neigh[0][0] = test.neigh[test.SIZE-1][test.SIZE-1] = test.neigh[test.SIZE-1][0] = test.neigh[0][test.SIZE-1] = 3;
		test.nexttable();
		boolean jud[][] = new boolean[test.SIZE][test.SIZE];
		for(int x = 0;x < test.SIZE;x++)
			for(int y=0;y < test.SIZE;y++){
				jud[x][y] = false;
			}
		jud[0][0]=jud[0][test.SIZE-1]=jud[test.SIZE-1][0]=jud[test.SIZE-1][test.SIZE-1]=true;
		for(int x = 0;x < test.SIZE;x++)
			for(int y=0;y < test.SIZE;y++){
				assertEquals(jud[x][y],test.table[x][y]);
		   }
		//fail("Not yet implemented");
	}

}
