package medios_uci;

public class ArrayList<Tipo> {
	Object arr[];
	int size=0;
	
	public ArrayList(){
		arr = new Object[500];
	}
	
	public int size() {
		return size;
	}
	
	public Tipo get(int index) {
		return (Tipo) arr[index];
	}
	
	public void add(Tipo object) {
		if(size==arr.length) {
			Object newArr[] = new Object[arr.length*2];
			for(int i=0;i<size;i++)
				newArr[i]=arr[i];
			arr = newArr;
		}
		arr[size++]=object;
	}
	
	public void addAll(ArrayList<Tipo> arr2) {
		for(int i=0;i<arr2.size();i++)
			arr[size++]=arr2.get(i);
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void clear() {
		for(int i=0;i<size;i++)
			arr[i]=null;
		
		size=0;
	}
	
}
