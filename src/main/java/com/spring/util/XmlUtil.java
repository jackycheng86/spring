package com.spring.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author chengjian
 * xml与实体对象转换工具类
 */
public class XmlUtil {

    /**
     * xml字符串转换为实体对象
     * @param xml
     * @param clazz
     * @return
     */
    public static Object toObject(String xml,Class clazz) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringBuffer xmlStr = new StringBuffer( xml );
            StringReader reader = new StringReader(xmlStr.toString());
            Object obj = unmarshaller.unmarshal(reader);
            return obj;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 实体对象转换为xml字符串
     * @param obj
     * @param clazz
     * @return
     */
    public static String toXmlString(Object obj,Class clazz) {
        String xmlString = "";
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Marshaller marshaller = context.createMarshaller();
            StringWriter writer=new StringWriter();
            marshaller.marshal(obj,new StreamResult(writer));
            xmlString=writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlString;
    }
}
