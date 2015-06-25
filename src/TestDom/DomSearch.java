package TestDom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomSearch {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//1.得到工厂实例
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		//2.得到解析器
		DocumentBuilder builder=factory.newDocumentBuilder();
		//3.得到Doument对象
		Document doc=builder.parse("src/TestDom/dom.xml");	
		
		//4.得到root节点
		Element root=doc.getDocumentElement();
		
		//5.得到root下面的子节点
		NodeList book_list=root.getChildNodes();
	
		
		for(int i=0;i<book_list.getLength();i++){
			Node e=book_list.item(i);
			if(e.getNodeType()==Node.ELEMENT_NODE){
				String node_name=e.getNodeName();
				//分别输出三个book
				System.out.println(node_name);
				
				
				//输出三个book的属性值
				String attribute=e.getAttributes().getNamedItem("isbn").getNodeValue();
				System.out.println(attribute);
				
				NodeList booksub_list=e.getChildNodes();
				for(int j=0;j<booksub_list.getLength();j++){
					Node esub=booksub_list.item(j);
					if(esub.getNodeType()==Node.ELEMENT_NODE){
						//为什么要加一个getFirstChild????
						String sub_name=esub.getFirstChild().getNodeValue();
						//输出每一个节点的值
						System.out.println(sub_name);
					}
				}
			}	
		}		
	}
}		
	
