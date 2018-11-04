package utils;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import static org.junit.Assert.*;

/**
 * [Project]:demo-master  <br/>
 * [Email]:moy25@foxmail.com  <br/>
 * [Date]:2018/5/2  <br/>
 * [Description]:  <br/>
 *
 * @author YeXiangYang
 */
public class XmlUtilsTest {

	 @Test
	    public void xmlFileToObject() {
		 CityList cityList = XmlUtils.xmlFileToObject("utils/cityList.xml", CityList.class);
	        System.out.println(cityList);
	    }

    @Test
    public void xmlStringToObject() {
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<c c1=\"0\">\n" +
                "    <d d1=\"101020100\" d2=\"上海\" d3=\"shanghai\" d4=\"上海\"/>\n" +
                "    <d d1=\"101220101\" d2=\"合肥\" d3=\"hefei\" d4=\"安徽\"/>\n" +
                "    <d d1=\"101190101\" d2=\"南京\" d3=\"jiangshu\" d4=\"江蘇\"/>\n" +
                "    <d d1=\"101010100\" d2=\"北京\" d3=\"beijing\" d4=\"北京\"/>\n" +
                "    <d d1=\"101270101\" d2=\"成都\" d3=\"chengdu\" d4=\"四川\"/>\n" +
                "</c>";

        CityList cityList = XmlUtils.xmlStringToObject(xmlString, CityList.class);
        //System.out.println(cityList);
        List<City> xx = cityList.getCityList();
        for (City str : xx) {
        	            System.out.println("CityName Item is: " + str.getCityName());
        	         }
        
        
        
        Iterator<City> it = xx.iterator();
        
        while (it.hasNext()) {
        	City cc = it.next();
        System.out.println(cc.getCityCode());
//        System.out.println(it.next());
//        System.out.println(it.next());
        }

       
        
        //City xx = (City) cityList.getCityList();
       // System.out.println(xx.getCityId());
        JAXBContext jAXBContextW;
       
       // jAXBContextW = JAXBContext.newInstance(City.class);
       // FileReader categoryFileRead = new FileReader("E:\\TEST\\category.xml");
      //  Unmarshaller unmarshaller = jAXBContextW.createUnmarshaller();
        
        //City categoryW = (City) unmarshaller.unmarshal(cityList);
        
       // System.out.println("种类的名称为："+categoryW.getCityCode());
        
        
        
        
        
        
    }
    
    public Map<Integer, City> convertListBeforeJava8(List<City> list) {
        Map<Integer, City> map = new HashMap<>();
        for (City animal : list) {
            map.put(111, animal);
        }
        return map;
    }

}