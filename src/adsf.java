import java.util.ArrayList;
import java.util.List;


public class adsf implements adsfds{
	
	public static void main(String[] args) {
		String temp = "baoxianfuwu	caishui	fanyi	zhuce	huoyun	shangbiaozhli	danbaobaoxiantouzi	yinshua";
	    temp = temp.replaceAll("	", "\",\"");
	    System.out.println(temp);
	    String ts[] = {"kuaican","zhongcanyin","waimai"};
	    System.out.println(ts.toString());
	    String ss = "sfdsfdsfsff,";
	    System.out.println(ss.substring(0,ss.length()-1));
	    
	    StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM "+ "(SELECT * FROM "+ "TABLE_NAME" +" where attributesValues like '%"+"gender"
				+"%' and attributesValues like '%"+"build"
				+"%' and attributesValues like '%"+"archType"
				+"%' and attributesValues like '%"+"biome"
				+"%' and attributesValues like '%"+"activity"+"%') where ");
	    List<String> surfaceList = new ArrayList<String>();
	    surfaceList.add("测试1");
	    surfaceList.add("测试2");
	    if(surfaceList.size() > 0){
			StringBuffer sqlBuffer = new StringBuffer();
			for (int i = 0; i < surfaceList.size(); i++) {
				String condition = surfaceList.get(i);
				sqlBuffer.append(" or attributesValues like '%"+condition+"%'");
			}
			sqlBuffer.delete(0, 4).insert(0, "(").insert(sqlBuffer.length(), ")");
			sql.append(sqlBuffer.toString()+" and ");
		}
	    if (surfaceList.size()>0) {
			StringBuffer sqlBuffer = new StringBuffer();
			for (int i = 0; i < surfaceList.size(); i++) {
				String condition = surfaceList.get(i);
				sqlBuffer.append(" or attributesValues like '%"+condition+"%'");
			}
			sqlBuffer.delete(0, 4).insert(0, "(").insert(sqlBuffer.length(), ")");
			sql.append(sqlBuffer.toString()+" and ");
		}
		if (surfaceList.size()>0) {
			StringBuffer sqlBuffer = new StringBuffer();
			for (int i = 0; i < surfaceList.size(); i++) {
				String condition = surfaceList.get(i);
				sqlBuffer.append(" or attributesValues like '%"+condition+"%'");
			}
			sqlBuffer.delete(0, 4).insert(0, "(").insert(sqlBuffer.length(), ")");
			sql.append(sqlBuffer.toString());
		}
		System.out.println(sql.toString());
		
		String sss = "The “Shoe Finder” software application (the “App”) and the services, information, content and/or data contained therein (collectively, “Information”) have been created for information purposes only. Rebel Sport Limited (“Rebel”) does not endorse and/or necessarily approve the Information and does not make any warranties or representations regarding the quality, accuracy, merchantability or fitness for purpose of the Information. The App is not intended to provide any medical advice, and the Information provided should not be so construed or used as medical advice. You acknowledge and agree that using, accessing, and/or browsing the App does not create a doctor-patient relationship between you, the authors of the App and/or Rebel. Nothing contained in the App is intended to create a doctor-patient relationship, to replace the services of a licensed and trained doctor or medical professional, or to be a substitute for medical advice of a licensed and trained doctor or medical professional. By using the App, you agree not to rely on the Information, and to consult a licensed and trained doctor and/or medical professional in all matters relating to your health and wellbeing. You further agree that you shall not make any health or medical related decision based in whole or in part on the Information. To the extent permitted by law, Rebel disclaims (and you agree to release Rebel from) all liability for all loss, damages, expense and costs incurred by you as a result of accessing, using or relying on any Information and/or using the App.";
	    int[] number = {3248,3258,3257,3251,3253,3259,3232,3256,3228,3270,3265,3222,3223,3224,3225,3230,3231,3233,3234,3235,3239,3241,3227,3229,3226,3242,3238,3228};
	    System.out.println(number.length);
	    
	    String sd = null;
	    String sfs = "dsf";
	    System.out.println(sfs.equals(sd));
	}

	@Override
	public void dsfds() {
		// TODO Auto-generated method stub
		
	}

}
