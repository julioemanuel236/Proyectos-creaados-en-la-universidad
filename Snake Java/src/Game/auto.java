package Game;

import java.util.LinkedList;
import java.util.Queue;

public class auto{
	int[] di= {0,1,0,-1};
	int[] dj= {-1,0,1,0};
	boolean[][] vi;
	public int cmax=0;
	public int Dir;

	public static boolean outBody(Snake snake,int x,int y) {
		for(int i=0;i<snake.size;i++)
			if(snake.Snake[i].X==x&&snake.Snake[i].Y==y) {
				//System.out.println("se choca");
				return false;
			}
		//System.out.println("to bien");
		return true;
	}	
	
	public int encierro(int x,int y,Snake snake,Field field,Food food,int n,int m,int dir,int cant) {
		System.out.println(cant);
		/*for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++)
				System.out.print((vi[i][j]? 1:0)+" ");
			System.out.print('\n');
		}
		System.out.println("---------------------------------------------------------");
		*///System.out.println("PASO VERIFICAION");
		
		if(cant>cmax) {
			cmax=cant;
			Dir=dir;
		}
		
		for(int i=0;i<4;i++) {
			int dx=x+di[i];
			int dy=y+dj[i];
			if(dx<0||dy<0||dx==4||dy==4||vi[dx][dy]||!outBody(snake,dx*20,dy*20));
			else {
				//System.out.println("Voy para "+dx+" "+dy);
				vi[dx][dy]=true;
				encierro(dx,dy,snake,field,food,n,m,i+1,cant+1);
				vi[dx][dy]=false;
			}
		}
		return Dir;
		
	}
	
	public int Where(Field field,Snake snake,Food food){
		int n=field.getWidth()/20;
		int m=field.getHeight()/20;
		int[][] v=new int[n][m];
		int udv = 3;
		Queue<int[]> q=new LinkedList<int[]>();
		int[] t= {(snake.Snake[0].X/20),(snake.Snake[0].Y/20)};
		int[] T= new int[2];

		q.add(t.clone());
		v[t[0]][t[1]]=-1;
		while(!q.isEmpty()) {
			t= q.poll();		
			//snake.Snake[0].xSystem.out.println(t[0]*20+" "+t[1]*20+" "+t[2]);
			for(int i=0;i<4;i++) {
				int dx=t[0]+di[i];
				int dy=t[1]+dj[i];
				//System.out.println(dx+" "+dy+" "+t[2]);
				
				if(dx==-1)dx=n-1;
				else if(dx==n)dx=0;
				if(dy==-1)dy=m-1;
				if(dx==-1||dy==-1)continue;				
				if(dx==field.getWidth()/20||dy==field.getHeight()/20)continue;
				if(dx == -1 || dy == -1)continue;
				if(dy==m)dy=0;
					//System.out.println("dentro del campo "+dx*20+" "+dy*20);
					if(food.X==dx*20&&food.Y==dy*20) {
						//System.out.println("Encontre la comida caminado por " +v[t[0]][t[1]]);
						if(v[t[0]][t[1]]==-1)return i+1;
						return v[t[0]][t[1]];
					}
					if(v[dx][dy]==0&&outBody(snake,dx*20,dy*20)) {
						if(v[t[0]][t[1]]==-1)v[dx][dy]=i+1;
						else v[dx][dy] = v[t[0]][t[1]];
						T[0]=dx;
						T[1]=dy;
						q.add(T.clone());
						udv=v[dx][dy];
						//System.out.println("Se a�adio: "+T[0]*20+" "+T[1]*20+" "+T[2]);
					}
				
			}
		
		}
		//TODO si esta encerrado caminar de forma que recorra todas las casillas disponibles

		return udv;
	}
	
}

