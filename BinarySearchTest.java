package java_demo;

public class BinarySearchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={1,3,5,7,9,10,14};
		BinarySearch bs=new BinarySearch();
		bs.find(0,arr.length,10,arr);
	}

}

class BinarySearch{
	public void find(int left,int right,int value,int arr[]){
		int middleIndex=(left+right)/2;
		int middleValue=arr[middleIndex];
		if (right>=left){
			if (middleValue<value){
				//���ұ߲���
				find(middleIndex+1,right,value,arr);
			}
			else if(middleValue>value){
				//����߲���
				find(left,middleIndex-1,value,arr);
			}
			else if(middleValue==value){
				System.out.println("�����ҵ�ֵ���ǵ�"+(middleIndex+1)+"����");
			}
			else{
				System.out.print("no!!!");
			}
		}
	}
}
