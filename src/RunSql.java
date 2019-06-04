import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import jxl.Workbook;
import jxl.write.WritableWorkbook;


public class RunSql {
	public static final String ID = "id";
	public static final String SHOP_NAME = "shopName";
	public static final String BRANCH_NAME = "branchName";
	public static final String ALT_NAME = "altName";
	public static final String SHOP_TYPE = "shopType";
	public static final String SHOP_POWER = "shopPower";
	public static final String AVG_PRICE = "avgPrice";
	public static final String PRICE_TEXT = "priceText";
	public static final String PHONE_NO = "phoneNo";
	public static final String ADDRESS = "address";
	public static final String CROSS_ROAD = "crossRoad";
	public static final String LATITUDE = "latitude";
	public static final String LONGITUDE = "longitude";
	public static final String CATEGORY_NAME = "categoryName";
	public static final String REGION_ID = "regionId";
	public static final String REGION_NAME = "regionName";
	public static final String CARD = "card";
	public static final String DEFAULT_PIC = "defaultPic";
	public static final String SCORE = "score";
	public static final String SCORE1 = "score1";
	public static final String SCORE2 = "score2";
	public static final String SCORE3 = "score3";
	public static final String SCORE4 = "score4";
	public static final String SCORE_TEXT = "scoreText";
	public static final String SHOP_TAGS = "shopTags";
	public static final String DISH_TAG = "dishTags";
	public static final String WRITE_UP = "writeUp";
	public static final String CITY_ID = "city_id";
	public static final String CATEGORY_ID = "category_id";
	public static final String CURRENT_PAGE = "current_page";
	public static final String key = "yangzhou";
	
	public static void main(String []args) throws Exception {     
        String DRIVER = "org.sqlite.JDBC";  
        String URL = "jdbc:sqlite:"+key+"_dzdp.db";  
        String USERNAME = "sa";  
        String USERPASSWORD = "123";  
          
        
        String sqlCount = "Select count(*) from dianping";
        Vector<String> columnName = new Vector<String>(); // 列名     
//        columnName.add("id");  
//        columnName.add("city");
//        columnName.add("category");
//        columnName.add("business_name");
//        columnName.add("business_district");
//        columnName.add("detail");
//        columnName.add("business_contact");
//        columnName.add("tel1");
//        columnName.add("tel2");
//        columnName.add("business_pic");
//        columnName.add("url");
//        columnName.add("tel_number");
//        columnName.add("tel_len");
        columnName.add(ID);
        columnName.add(CITY_ID);
		columnName.add(CATEGORY_ID);
		columnName.add(CURRENT_PAGE);
		columnName.add(SHOP_NAME);
		columnName.add(BRANCH_NAME);
		columnName.add(ALT_NAME);
		columnName.add(SHOP_TYPE);
		columnName.add(SHOP_POWER);
		columnName.add(AVG_PRICE);
		columnName.add(PRICE_TEXT);
		columnName.add(PHONE_NO);
		columnName.add(ADDRESS);
		columnName.add(CROSS_ROAD);
		columnName.add(LATITUDE);
		columnName.add(LONGITUDE);
		columnName.add(CATEGORY_NAME);
		columnName.add(REGION_ID);
		columnName.add(CARD);
		columnName.add(DEFAULT_PIC);
		columnName.add(SCORE);
		columnName.add(SCORE1);
		columnName.add(SCORE2);
		columnName.add(SCORE3);
		columnName.add(SCORE4);
		columnName.add(SCORE_TEXT);
		columnName.add(SHOP_TAGS);
		columnName.add(DISH_TAG);
		columnName.add(WRITE_UP);
          
        // 连接数据库  
        Class.forName(DRIVER);  
        Connection conn = DriverManager.getConnection(URL);  
        PreparedStatement ps1 = conn.prepareStatement(sqlCount);
        ResultSet rs1 = ps1.executeQuery();
        int count = 0;
        int numb = 0;
        if (rs1.next()) {
            count = rs1.getInt(1); //count 便是返回的行数
        }
        ps1.close();
        rs1.close();
        numb = count/65500 + 1;
        String sql; // 查询语句 
        WritableWorkbook workbook = Workbook.createWorkbook(new File(key+"_dianping.xls")); // 创建Excel文件
        for (int i = 0; i < numb; i++) {
			sql = "select * from dianping where id >="+(i*65500+1)+" and id<"+((i+1)*65500+1);
			PreparedStatement ps = conn.prepareStatement(sql);  
	        ResultSet rs = ps.executeQuery(); 
	        new DBtoExcel().WriteExcel(rs, workbook, "sheet"+i,i, columnName);
	        ps.close();
	        ps = null;
	        rs.close();
	        rs = null;
		}
        workbook.write();  
        workbook.close();  
        conn.close();
        
    }  

}