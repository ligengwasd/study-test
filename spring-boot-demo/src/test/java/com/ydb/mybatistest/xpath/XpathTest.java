package com.ydb.mybatistest.xpath;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;

/**
 * @Author ligeng
 * @Date 18/11/30
 * @Time 上午11:44
 */
public class XpathTest {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        // 开启验证
        documentBuilderFactory.setValidating(true);
        documentBuilderFactory.setNamespaceAware(false);
        documentBuilderFactory.setIgnoringComments(true);
        documentBuilderFactory.setIgnoringElementContentWhitespace(false);
        documentBuilderFactory.setCoalescing(false);
        documentBuilderFactory.setExpandEntityReferences(true);

        // 创建DocumentBuilder
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        builder.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) throws SAXException {
                System.out.println("error:" + exception.getMessage());
            }

            @Override
            public void error(SAXParseException exception) throws SAXException {
                System.out.println("error:" + exception.getMessage());
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                System.out.println("error:" + exception.getMessage());
            }
        });

        Document doc = builder.parse(new File("/Users/ligeng/Documents/source/study-test/spring-boot-demo/src/test/java/com/ydb/xpath/inventory.xml"));
        XPathFactory factory = XPathFactory.newInstance();
        XPath xPath = factory.newXPath();
        XPathExpression expr = xPath.compile("//book[author='Neal Stephenson']/title/text()");

        Object result = expr.evaluate(doc, XPathConstants.NODESET);
        System.out.println("作者为Neal Stephenson的图书标题：");
        NodeList nodeList = (NodeList) result;
        for (int i=0; i<nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getNodeValue());
        }
    }
}
