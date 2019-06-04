

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

class GetTimeUtil{
	public static String getTime(long timestamp){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time= null;
		try {
			java.util.Date currentdate = new java.util.Date();//当前时间

			long i = (currentdate.getTime()-timestamp)/(60);
			//			System.out.println(currentdate.getTime());
			//			System.out.println(i);
			//			Timestamp now = new Timestamp(System.currentTimeMillis());//获取系统当前时间
			//			System.out.println("now-->"+now);//返回结果精确到毫秒�?

			String str = sdf.format(new Timestamp(timestamp));
			time = str.substring(11, 16);
			System.out.println(str);
			//			System.out.println(time);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
	}
	public static String timestempToString(int time) {
		StringBuffer tempTime = new StringBuffer();
		int hour = time/(60*60);
		time = (time-hour*(60*60));
		int minute = time/60;
		time = time - minute*60;
		int second = time%(60);
		tempTime.append(hour<10?"0"+hour:hour);
		tempTime.append(":");
		tempTime.append(minute<10?"0"+minute:minute);
		tempTime.append(":");
		tempTime.append(second<10?"0"+second:second);
		return tempTime.toString();
	}
	public static void main(String[] args) {
		//		getLastMonth();
		//		Date date = new Date();
		//		System.out.println(timestempToString(date.getTime()));
		//		System.out.println(timestempToString(date.getTime()+1));
		//		getLastMonth();
		//		
		//		long data1 = new Long("1366177434081");
		//		long date2 = new Long("1363499034089");
		//		System.out.println(timestempToString(23230));
		//		GetTimeUtil.getTime(new Long("1368121618000"));
		//		GetTimeUtil.getTime(new Long("1373011319255"));
		//		GetTimeUtil.getTime(new Long("1373011336703"));

		
		System.out.println(getRandom(0,2));
	}

	public static int getRandom(int start,int end){

		if(start>end || start <0 || end <0){

			return -1;

		}

		return (int)(Math.random()*(end-start+1))+start;

	}


	public static String time2String(String time){
		time = "2012-12-20 18:50:38";
		Date date1=null; 
		Calendar cal = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		try {
			date1=formatter.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long tempTime = date1.getTime();
		GetTimeUtil.getTime(tempTime);
		cal=Calendar.getInstance();
		cal.add(Calendar.MONTH, -12);    //�õ�һ��ǰ��ʱ��
		long yearTime = cal.getTimeInMillis();
		GetTimeUtil.getTime(yearTime);
		cal=Calendar.getInstance();
		cal.add(Calendar.MONTH, -6);    //�õ�����ǰ��ʱ��
		long sixMonthTime = cal.getTimeInMillis();
		GetTimeUtil.getTime(sixMonthTime);
		cal=Calendar.getInstance();
		cal.add(Calendar.MONTH, -3);    //�õ�����ǰ��ʱ��
		long threeMonthTime = cal.getTimeInMillis();
		GetTimeUtil.getTime(threeMonthTime);
		cal=Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);    //�õ�����ǰ��ʱ��
		long oneMonthTime = cal.getTimeInMillis();
		GetTimeUtil.getTime(oneMonthTime);
		//		System.out.println(tempTime);
		//		System.out.println(oneMonthTime);
		if(yearTime>tempTime){
			return "1������";
		}
		if(tempTime>=yearTime&&tempTime<sixMonthTime){
			return "1������";
		}
		if(tempTime>=sixMonthTime&&tempTime<threeMonthTime){
			return "6��������";
		}
		if(tempTime>=threeMonthTime&&tempTime<oneMonthTime){
			return "3��������";
		}
		if(tempTime>=oneMonthTime){
			return "1��������";
		}
		return null;
	}

	private static void getLastMonth(){
		long time = System.currentTimeMillis();
		Date date1 = new Date(time);
		System.out.println(date1);
		System.out.println("123123---"+date1.getTime());
		GetTimeUtil.getTime(date1.getTime());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal=Calendar.getInstance();
		//		cal.add(Calendar.DATE, );    //�õ�ǰһ�� 
		cal.add(Calendar.HOUR, +1);    //�õ�ǰһ����
		long date = cal.getTimeInMillis();
		System.out.println("asfsdfds--------"+date);
		try {
			Date kk=format.parse(format.format(new Date(date)));
			System.out.println(kk);
			GetTimeUtil.getTime(kk.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
