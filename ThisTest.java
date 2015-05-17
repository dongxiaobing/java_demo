package java_demo;

public class ThisTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog1=new Dog("gou",3);
		People p1=new People(dog1,"dxb",20);
		p1.show_info();
		p1.dog.show_info();
		People p2=new People(dog1,"yl",19);
		p2.show_info();
		p2.dog.show_info();
		System.out.println("@");
		System.out.println(People.total);
		
		
		System.out.println(p1.total);
		System.out.println(p2.total);

	}

}
class People{
	String name;
	int age;
	Dog dog;
	static int total=0;
	public  People(Dog dog,String name,int age){
		this.name=name;
		this.age=age;
		this.dog=dog;
	}
	public void show_info(){
		System.out.println("我的名字"+this.name);
		total++;
	}
}
class Dog{
	String name;
	int age;
	public Dog(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void show_info(){
		System.out.print("狗名是"+this.name);
	}
}