/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Business.BusinessFacade;
import Business.Question;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



/**
 *
 * @author Pedro Cunha
 */
public class AppMain {

    //Carregar a partir de xml
    public static void readXmlFile(String filename,BusinessFacade facade) {

        try {
            String txt, opt1, opt2, opt3, opt4, file, genre;
            int correct, score;
            File fXmlFile = new File(filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            NodeList nlist = doc.getElementsByTagName("question");
            for (int counter = 0; counter < nlist.getLength(); counter++) {
                Node nNode = nlist.item(counter);

                Element eElement = (Element) nNode;
                txt = eElement.getElementsByTagName("text").item(0).getTextContent();
                opt1 = eElement.getElementsByTagName("opt1").item(0).getTextContent();
                opt2 = eElement.getElementsByTagName("opt2").item(0).getTextContent();
                opt3 = eElement.getElementsByTagName("opt3").item(0).getTextContent();
                opt4 = eElement.getElementsByTagName("opt4").item(0).getTextContent();
                file = eElement.getElementsByTagName("file").item(0).getTextContent();
                correct = Integer.parseInt(eElement.getElementsByTagName("correct").item(0).getTextContent());
                genre = eElement.getElementsByTagName("genre").item(0).getTextContent();
                score = Integer.parseInt(eElement.getElementsByTagName("score").item(0).getTextContent());
                facade.insertQuestion(new Question(txt, file, opt1, opt2, opt3, opt4, genre, correct, score));

            }

        } catch (IOException | NumberFormatException | ParserConfigurationException | SAXException exc) {
            exc.printStackTrace();
        }

    }
    
    public static void main(String[] args) {
        BusinessFacade facade=new BusinessFacade();
        final BusinessFacade facade2;
        try {
            facade=BusinessFacade.readObjFile("data.obj");
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        readXmlFile("questions.xml",facade);
        facade2=facade;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen(facade2).setVisible(true);
            }
        });
    }
}
