import java.util.Arrays;


public class ErFen {
	
	static int a[]={23,45,100,98,110,120,140};
	
	public static void main(String[] args) {
		int search = 98;
		long ss = 2<<63;
		System.out.println(ss);
//		Arrays.sort(a);ß
		
//		int index = -1;
//		int lowerIndex = 0;
//		int size;
//		size = a.length-1;
//		while (lowerIndex<=size) {
//			index = (lowerIndex+size)/2;
//			int currentValue = a[index];
//			if(currentValue == search){
//				break;
//			}
//			if(currentValue<search){
//				lowerIndex = index + 1;
//			}else{
//				size = index-1;
//			}
//		}
//		if(lowerIndex<=size){
			System.out.println(search +"在数组中的第"+Arrays.binarySearch(a, search)+"位");
//		}else{
//			System.out.println("不存在");
//		}
	}

}
