package com.example.three;

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
}
