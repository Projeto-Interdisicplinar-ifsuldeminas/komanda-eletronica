package br.com.komanda.eletronica.model;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.com.komanda.eletronica.connection.ConnectFactory;

public class Xml {
	
	private static String server, door, user, nameDB, password;
	
	public Xml() {
		
	}
	
	@SuppressWarnings("unused")
	public ConnectFactory lerXML() throws Exception{
		File fXmlFile = new File("src/main/java/configuracao/conexao.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		ConnectFactory con = null;
		NodeList nList = doc.getElementsByTagName("conexao");
		Node nNode = nList.item(0);
		//System.out.println("\nElemento corrente :" + nNode.getNodeName());
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			server = eElement.getElementsByTagName("server").item(0).getTextContent();
			door = eElement.getElementsByTagName("porta").item(0).getTextContent();
			nameDB = eElement.getElementsByTagName("base").item(0).getTextContent();
			user = eElement.getElementsByTagName("user").item(0).getTextContent();
			password = eElement.getElementsByTagName("senha").item(0).getTextContent();
			
			con = new ConnectFactory(server, door, nameDB, user, password);
		}
		return con;
	}

}
