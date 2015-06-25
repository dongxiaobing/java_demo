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
		//1.�õ�����ʵ��
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		//2.�õ�������
		DocumentBuilder builder=factory.newDocumentBuilder();
		//3.�õ�Doument����
		Document doc=builder.parse("src/TestDom/dom.xml");	
		
		//4.�õ�root�ڵ�
		Element root=doc.getDocumentElement();
		
		//5.�õ�root������ӽڵ�
		NodeList book_list=root.getChildNodes();
	
		
		for(int i=0;i<book_list.getLength();i++){
			Node e=book_list.item(i);
			if(e.getNodeType()==Node.ELEMENT_NODE){
				String node_name=e.getNodeName();
				//�ֱ��������book
				System.out.println(node_name);
				
				
				//�������book������ֵ
				String attribute=e.getAttributes().getNamedItem("isbn").getNodeValue();
				System.out.println(attribute);
				
				NodeList booksub_list=e.getChildNodes();
				for(int j=0;j<booksub_list.getLength();j++){
					Node esub=booksub_list.item(j);
					if(esub.getNodeType()==Node.ELEMENT_NODE){
						//ΪʲôҪ��һ��getFirstChild????
						String sub_name=esub.getFirstChild().getNodeValue();
						//���ÿһ���ڵ��ֵ
						System.out.println(sub_name);
					}
				}
			}	
		}		
	}
}		
	
