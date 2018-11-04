/**
 * 
 */
package utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * [Project]:cloud-demo-master  <br/>
 * [Email]:moy25@foxmail.com  <br/>
 * [Date]:2018/4/30  <br/>
 * [Description]:  <br/>
 *
 * @author YeXiangYang
 */
public abstract class XmlUtils {

	
	public static String  xmlFile2Object(){
		
		
		
		CityList city = new CityList();
    	try{ JAXBContext jaxbContext = JAXBContext.newInstance(City.class);
         Marshaller marshaller = jaxbContext.createMarshaller();
         marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
         marshaller.marshal(city, new File("d:\\cityList.xml"));
         marshaller.marshal(city, System.out);
         return "ddd";
//         return city;
    	
//        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
//        try (InputStream inputStream = contextClassLoader.getResourceAsStream(xmlFilePath)) {
//            JAXBContext context = JAXBContext.newInstance(clazz);
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//            @SuppressWarnings("unchecked")
//			T result = (T) unmarshaller.unmarshal(inputStream);
//            return result;
        } catch (Exception e) {
            throw new RuntimeException("convert xml to POJO failure!" + e.getMessage(), e);
        }
		
	}
	
    public static <T> T xmlFileToObject(String xmlFilePath, Class<T> clazz) {
    	//System.out.println(xmlFile2Object());
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = contextClassLoader.getResourceAsStream(xmlFilePath)) {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            @SuppressWarnings("unchecked")
			T result = (T) unmarshaller.unmarshal(inputStream);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("convert xml to POJO failure!" + e.getMessage(), e);
        }
    }

    public static <T> T xmlStringToObject(String xmlString, Class<T> clazz) {
        try (Reader reader = new StringReader(xmlString)) {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            T result = (T) unmarshaller.unmarshal(reader);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("convert xml string to POJO failure!", e);
        }
    }
}