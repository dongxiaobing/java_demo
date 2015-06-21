package dom;

import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DomDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("查看所有学生的成绩------view");
		System.out.println("按照学生id号码查询学生成绩-----view of");
		System.out.println("退出系统 exit");
		String opType=sc.next();
		Service service=new Service();
		String fileName="src/dom/stus.xml";
		Document doc=service.getDocument(fileName);
		if(opType.equals("view")){
			service.getAllInfo(doc);
		}
		
	}

}
class Service{
	public static Document getDocument(String fileName) throws Exception{
		
		DocumentBuilderFactory fa=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=fa.newDocumentBuilder();
		Document doc=builder.parse(fileName);
		return doc;
	}
	public static void getAllInfo(Document doc){
		NodeList nl1=doc.getElementsByTagName("student");
		for(int i=0;i<nl1.getLength();i++){
			System.out.println("sid"+nl1.item(i).getAttributes().item(0));
			Element e=(Element)nl1.item(i);
			System.out.println("name"+e.getElementsByTagName("name").item(i).getTextContent());
		}
	}
}

class Studens{
	private String sid=null;
	private String name=null;
	private String myjava=null;
	private String myoracle=null;
	private String myvb=null;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMyjava() {
		return myjava;
	}
	public void setMyjava(String myjava) {
		this.myjava = myjava;
	}
	public String getMyoracle() {
		return myoracle;
	}
	public void setMyoracle(String myoracle) {
		this.myoracle = myoracle;
	}
	public String getMyvb() {
		return myvb;
	}
	public void setMyvb(String myvb) {
		this.myvb = myvb;
	}
	
}
