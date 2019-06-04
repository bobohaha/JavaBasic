import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SumDemo {
	private static HashMap<String, DataModel> regionMap = new HashMap<>();
	private static String startString = "\"xiaomi\",\"";
	private static String secondString = "android\",\"";
	private static String endString = "\",\"";
	private static String FILE_PATH = "/home/bobo/data/";
	private static String FILE_PATH_SUMMARY = "/home/bobo/data/result/";
	private static String SUMMARY_FILE = "summary_file";
	public static String firstTime = null;
	public static int dailySize = 0;
	public static String SHEET_NAME = "sheet1";

	public static void main(String[] args) {
		queryData();
		createExcel();
	}
	public static void createExcel(){
		SUMMARY_FILE = SUMMARY_FILE+"_"+getCurrentDate()+ ".xlsx";
		if(ExcelWrite.fileExist(FILE_PATH_SUMMARY+SUMMARY_FILE)){
			ExcelWrite.deleteExcel(FILE_PATH_SUMMARY+SUMMARY_FILE);
		}
		System.out.println("���ڻ�ȡ�����������ǣ�"+firstTime);
		HashMap<String, String> map = regionMap.get(firstTime).getMap();
		ArrayList<String> regions = new ArrayList<String>();
		for (String key : map.keySet()) { 
			if ("time".equals(key)) {
				continue;
			}
			regions.add(key);
			System.out.print(key+"  ");
		} 
		String title[] = new String[regions.size()+1];
		System.out.println("title������Ϊ��"+title.length);
		title[0] = "time";
		for (int i = 0; i < regions.size(); i++) {
			title[i+1] = regions.get(i);
		} 
		try {
			ExcelWrite.createExcel(FILE_PATH_SUMMARY+SUMMARY_FILE, SHEET_NAME, title);
		} catch (Exception e) {
			System.out.println("����excel���ʧ�ܣ�"+e.toString());
			e.printStackTrace();
			return;
		}
		List<Map> list = new ArrayList<>();
		for (String key : regionMap.keySet()) { 
			System.out.println("region�������У�"+key);
			list.add(regionMap.get(key).getMap());
		} 
		try {
			ExcelWrite.writeToExcel(FILE_PATH_SUMMARY+SUMMARY_FILE, SHEET_NAME, list);
		} catch (Exception e) {
			System.out.println("д��excel���ʧ�ܣ�"+e.toString());
			e.printStackTrace();
			return;
		}
		System.out.println("���ݽ�����ɣ�����ͳ�����ݱ�ɹ�������");
	}
	public static String getCurrentDate(){
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");//���Է�����޸����ڸ�ʽ
		String hehe = dateFormat.format(now); 
		System.out.println(hehe); 
		return hehe;
	}
	public static void queryData(){
		File csvFolder = new File(FILE_PATH);  // CSV�ļ�·��
		if(csvFolder.exists()){
			File[] files = csvFolder.listFiles();
			if(files == null){
				System.out.println("�������κ��ļ�������");
			}
			List<File> fileList = new ArrayList<File>();
			for (File f : files) {
				if(f.isDirectory()||f.isHidden()){
					continue;
				}
			    fileList.add(f);
			}
			Collections.sort(fileList, new Comparator<File>() {
			    @Override
			    public int compare(File o1, File o2) {
			        if (o1.isDirectory() && o2.isFile())
			            return -1;
			        if (o1.isFile() && o2.isDirectory())
			            return 1;
			        return o2.getName().compareTo(o1.getName());
			    }
			});
			System.out.println("�ļ�����Ϊ��"+files.length);
			for(int i = 0;i<fileList.size();i++){
				File file = fileList.get(i);
				String fileName = file.getName();
				int fileIndex = i+1;
				System.out.println("��"+ fileIndex +"���ļ��������ǣ�"+file.getName());
				String time = fileName.substring(fileName.length()-15,fileName.length()-7);
				System.out.println(time);
				int totalNumber = 0;
				DataModel model = new DataModel();
				HashMap<String, String> map = new HashMap<>();
				BufferedReader br = null;
				try
				{
					br = new BufferedReader(new FileReader(file));
				} catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
				String line = "";
				String everyLine = "";
				try {
					while ((line = br.readLine()) != null)  //��ȡ�������ݸ�line����
					{
						everyLine = line;
						if(!everyLine.isEmpty()&&everyLine.startsWith("\"xiaomi")){
							System.out.println(everyLine);
							String newString = everyLine.substring(startString.length(),everyLine.length());
							int endIndex = newString.indexOf(endString);
							String region = newString.substring(0,endIndex);
							newString = newString.substring(endIndex+endString.length(),newString.length());
							String secondNewString = newString.substring(secondString.length(),newString.length());
//							int secondEndIndex = secondNewString.indexOf(endString);
//							String number = secondNewString.substring(0,secondEndIndex);
							String validNumber = secondNewString.split(endString)[1];
							int numberInt = Integer.parseInt(validNumber);
							totalNumber += numberInt;
							map.put(region, String.valueOf(numberInt));
							map.put("time", time);
						}
						
					}
					model.setTotal(totalNumber);
					model.setMap(map);
					regionMap.put(time, model);
					if (map.size()>dailySize) {
						dailySize = map.size();
						firstTime = time;
					}
					System.out.println("csv���������������"+regionMap.get(time).getMap().size());


				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}


	public static class DataModel{
		private HashMap<String, String> map = new HashMap<>();
		private int total;
		public DataModel() {
			// TODO Auto-generated constructor stub
		}
		public HashMap<String, String> getMap() {
			return map;
		}

		public void setMap(HashMap<String, String> map) {
			this.map = map;
		}

		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}

	}

}
