package java_demo;

public class MaoPao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={7,6,8,9,2,3};
		int temp;
		//外层循环，一共比较多少轮，没比较一轮，最大的那个数都排到最后
		for(int i=0;i<a.length-1;i++){
			for(int j=0;j<a.length-1-i;j++){
				if (a[j]>a[j+1]){
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		for(int k=0;k<a.length;k++){
			System.out.println(a[k]);
		}
	}

}
