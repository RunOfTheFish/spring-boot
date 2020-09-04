package com.example.three;

import com.example.three.jna.Clibrary;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by admin on 2017/8/17.
 */
public class test {







	/*Calendar calendar = Calendar.getInstance();
	calendar.set(Calendar.HOUR_OF_DAY, 13); // 控制时
	calendar.set(Calendar.MINUTE, 32);       // 控制分
	calendar.set(Calendar.SECOND, 0);
	Date time = calendar.getTime();
	Timer timer = new Timer();
	timer.scheduleAtFixedRate(new TimerTask() {
		public void run() {

			long startTime = System.currentTimeMillis();

			int num = 0;

			while(true)
			{
				try {
					TextAntispam contentTest = textAntispamDetection.textAntispamDetection("测试数量");
					if("pass ".equals(contentTest.getSuggestion())) {
						System.out.println("pass");
					}else if("block ".equals(contentTest.getSuggestion())){
						System.out.println("block");
					}
					num = num + 1;
					System.out.println(num);
				} catch (Exception e) {
					System.out.println("errorTime:" + System.currentTimeMillis());
					break;
				}

				long endTime=System.currentTimeMillis();
				if(endTime-startTime > 60*1000) {
					break;
				}
			}
			System.out.println("end:" + num);

		}
	}, time, 1000 * 60 * 60 * 24);*/

    /*public static void main(String[] args) throws UnsupportedEncodingException {
        System.setProperty("jna.library.path", "D:\\dll");
        System.setProperty("jna.debug_load", "true");
        System.setProperty("jna.encoding", "GBK");

        String one = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA9IYtm7PRKhgCrrdFyFiE" +
                "cnaRuksgvdGhA821YACAAgPzaT+tpbZBbBrgTzs07uPOSZwUSZPC48bVvlmcyB0/" +
                "ttK32DFS1KxZeN5O8c1Vh5jGNUvmZMjL+tTY+8BUCY2Sm12rmZnzA0j9eCcUvip5" +
                "A0FM3taGUAlxL4gAXxhzkI9j6d5G9G8611K8IjiIeUtPk0obtkl7hT+59wO2O9Yi" +
                "53AreylsREsfppOyh0NiFEmPCib+1dJf8KhQxwUjrqMS342NJIVKQwqzyBiWT3mL" +
                "wvaiG40GpJL6YbRl7vYauZdXPjEp2wOxkK5gpzadfte8bWh7elgcuPjVtJQRFPbc" +
                "xwIDAQAB";

        String two = "{'eventId':'393284669688991744106d3444101c41','eventName':'receiveCommand','eventTime':637185035741290000,'eventData':{'destDevList':['54CF048A638E1DCB274CD8F5E4846179'],'devSpecToken':'f924aece-91fc-4eb2-9426-77b8e2ba92b5','cmdTime':'1582877982372','cmdName':'CMD_BUSI_ZNWXBGG_pushVerifiEmpeInfResult2Device','cmdParas':{'mnpltStffId':'96016770','cmpRsltInd':'1'},'cmdMetaInfo':{}}}";

        String result = Clibrary.INSTANCE.encrypt(one, two);

        System.out.println(result);

    }*/
    private static double PI = Math.PI;
    private static double X_PI = PI * 3000.0 / 180.0;

    public static void main(String[] args) {
        double lon = 112.96782436211265;
        double lat = 28.338648895583457;

        double[] aa = gcj2BD09(lat, lon);

        Arrays.stream(aa).forEach(x -> {
            System.out.println(x);
        });

    }

    public static double[] gcj2BD09(double glat, double glon) {
        double x = glon;
        double y = glat;
        double[] latlon = new double[2];
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * X_PI);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * X_PI);
        latlon[0] = z * Math.sin(theta) + 0.006;
        latlon[1] = z * Math.cos(theta) + 0.0065;
        return latlon;
    }

}
