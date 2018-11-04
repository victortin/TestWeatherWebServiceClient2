import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;
import cn.com.WebXml.*;

public class TestWs {
    public static void main(String[] args) throws ServiceException, RemoteException {
        WeatherWebServiceLocator locator = new WeatherWebServiceLocator();
        WeatherWebServiceSoapStub service = (WeatherWebServiceSoapStub) locator
                .getPort(WeatherWebServiceSoapStub.class);
        String[] str = service.getSupportProvince();
        for(int i = 0; i< str.length; i++){
            System.out.println(str[i].toString());
        }
        System.out.println("OKOOOOOOOOOOOOOOOOOOOOO");
        String[] str_city = service.getSupportCity("江苏");
        for(int i = 0; i< str_city.length; i++){
            System.out.println(str_city[i].toString());
        }
    }
}