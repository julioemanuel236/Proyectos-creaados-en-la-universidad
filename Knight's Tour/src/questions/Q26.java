package questions;

public class Q26 {
	public class MyData implements Comparable{

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	private MyData[] myList = null;
	private int numberOfElements = 0;
	
	public int recBinarySearch(MyData pTarget,int bottom,int top) {
		if(bottom == top) {
			if(myList[bottom].compareTo(pTarget) == 0 )return bottom;
			else return -1;
		}
		int m = (top+bottom)/2;
		
		if(myList[m].compareTo(pTarget)==0) return m;
		if(pTarget.compareTo(myList[m]) == -1)return recBinarySearch(pTarget,bottom,m-1);
		else return recBinarySearch(pTarget,m+1,top);
	}
	
	public void removeKnowValue(MyData pValue) {
		if(myList[numberOfElements-1].compareTo(pValue) == 0) {
			myList[numberOfElements-1] = null;
			numberOfElements--;
		}
		numberOfElements--;
		for(int i=0;i<numberOfElements;i++) {
			if(myList[i].compareTo(pValue) == 0) {
				for(int j=i;j<numberOfElements;j++) {
					MyData temp = myList[j+1];
					myList[j+1] = myList[j];
					myList[j] = temp;
				}
				myList[numberOfElements] = null;
				return;
			}
		}
	}
}