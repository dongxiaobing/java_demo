/**
 * josephu����Ϊ������Ϊ1,2,...n��n����Χ��һȦ��
 * Լ�����Ϊk(1<=k<=n)���˴�1��ʼ����������m���Ǹ��˳��У�
 * ������һλ�ִ�1��ʼ����������m���Ǹ����ֳ��У��������ƣ�ֱ�������˳���Ϊֹ���ɴ˲���һ�����ӱ�ŵ����С�
 * ��ʾ����һ������ͷ����ѭ������������josephu���⣺
 * �ȹ���һ����n�����ĵ�ѭ������Ȼ����k������1��ʼ�������Ƶ�mʱ��
 * ��Ӧ�����˴�������ɾ����Ȼ���ٴӱ�ɾ��������һ������ִ�1��ʼ������ֱ�����һ������������ɾ���㷨������
 */
package java_demo;

public class Josephu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkTable lt=new LinkTable();
		lt.setLen(5);
		lt.createLinkTable();
		lt.showLink();
		lt.setK(2);
		lt.setM(2);
		lt.play();
	}

}
class Child{
	int num;
	Child nextChild;
	public Child(int num){
		this.num=num;
	}
	
}
class LinkTable{
	int len;
	int k;
	int m;
	Child firstChild=null;
	Child temp=null;
	public void setLen(int len){
		this.len=len;
	}
	public void createLinkTable(){
		for (int i=1;i<=this.len;i++){
			if (i==1){
				//������һ��С��
				Child ch=new Child(1);
				this.firstChild=ch;
				this.temp=ch;
			}
			else {
				//�����м��С�������ǵ�һ�����������һ��
				if (i!=this.len){
					Child ch=new Child(i);
					temp.nextChild=ch;
					temp=ch;
				}
				else{
					//�������һ��С�������һ��С������һ��С���ǵ�һ��С��
					Child ch=new Child(i);
					temp.nextChild=ch;
					temp=ch;
					temp.nextChild=this.firstChild;
				}
			}
		}
	}
	public void showLink(){
		Child temp=this.firstChild;
		do{
			System.out.println(temp.num);
			temp=temp.nextChild;
		}while(temp!=this.firstChild);
	}
	public void setK(int k){
		this.k=k;
	}
	public void setM(int m){
		this.m=m;
	}
	public void play(){
		Child temp=this.firstChild;
		//�ӵ�k���˿�ʼ�棬��ô�ҵ���k����
		for (int i=1;i<this.k;i++){
			temp=temp.nextChild;
		}
		//�ӵ�k���˿�ʼ��m��
		for (int j=1;j<this.m;j++){
			temp=temp.nextChild;
		}
		//�ҵ�Ҫ���е�ǰһ����
		Child temp2=temp;
		while(temp2.nextChild!=temp){
			temp2=temp2.nextChild;
		}
		//����
		temp2.nextChild=temp.nextChild;
		//��һ������
		temp=temp.nextChild;
		System.out.print(temp.num);
	}
}