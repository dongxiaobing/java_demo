package java_demo;

public class StaticTest {
    static int i=1;
    //没有实例化也会执行，但是只执行一次，跟实例化多少次没有关系
    static{
    		System.out.println("aaaaa");
    		i++;
    }
    //每次初始化实例的时候都执行
    public StaticTest(){
    		System.out.println("bbbbb");
    		i++;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticTest t1=new StaticTest();
		System.out.println(t1.i);
		StaticTest t2=new StaticTest();
		System.out.println(t2.i);
		
		Stu stu1=new Stu(20,"s1",120);
		Stu stu2=new Stu(21,"s2",320);
		System.out.print(stu1.get());
		System.out.print(stu2.get());
		System.out.print(Stu.total);
		System.out.print(Stu.get());
		
	}

}
class Stu{
	int age;
	String name;
	int xuefei;
	static int total;
	public Stu(int age,String name,int xuefei){
		this.age=age;
		this.name=name;
		this.xuefei=xuefei;
		total+=xuefei;
	}
	public static int get(){
		return total;
	}
}
