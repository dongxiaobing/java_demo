/**
 * josephu问题为：设编号为1,2,...n的n个人围坐一圈，
 * 约定编号为k(1<=k<=n)的人从1开始报数，数到m的那个人出列，
 * 它的下一位又从1开始报数，数到m的那个人又出列，依次类推，直到所有人出列为止，由此产生一个出队编号的序列。
 * 提示：用一个不带头结点的循环链表来处理josephu问题：
 * 先构成一个有n个结点的单循环链表，然后由k结点起从1开始计数，计到m时，
 * 对应结点的人从链表中删除，然后再从被删除结点的下一个结点又从1开始计数，直到最后一个结点从链表中删除算法结束。
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
				//创建第一个小孩
				Child ch=new Child(1);
				this.firstChild=ch;
				this.temp=ch;
			}
			else {
				//创建中间的小孩，不是第一个，不是最后一个
				if (i!=this.len){
					Child ch=new Child(i);
					temp.nextChild=ch;
					temp=ch;
				}
				else{
					//创建最后一个小孩，最后一个小孩的下一个小孩是第一个小孩
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
		//从第k个人开始玩，那么找到第k个人
		for (int i=1;i<this.k;i++){
			temp=temp.nextChild;
		}
		//从第k个人开始数m下
		for (int j=1;j<this.m;j++){
			temp=temp.nextChild;
		}
		//找到要出列的前一个人
		Child temp2=temp;
		while(temp2.nextChild!=temp){
			temp2=temp2.nextChild;
		}
		//出列
		temp2.nextChild=temp.nextChild;
		//下一个数数
		temp=temp.nextChild;
		System.out.print(temp.num);
	}
}