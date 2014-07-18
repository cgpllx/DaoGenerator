package eee;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

/**
 * Generates entities and DAOs for the example project DaoExample.
 *
 * Run it as a Java application (not Android).
 *
 * @author Markus
 */
public class ExampleDaoGenerator {

	public static void main(String[] args) throws Exception {
//		Schema schema = new Schema(1, "com.konka.appdownload.db");//com.konka.appdownload.fragment.ClassifyFragment
		Schema schema = new Schema(1, "com.kumi.manage.db");//com.konka.appdownload.fragment.ClassifyFragment
		//        Schema schema = new Schema(3, "de.greenrobot.daoexample");

//		addNote1(schema);
		addNote2(schema);
		//        addCustomerOrder(schema);

		new DaoGenerator().generateAll(schema, "D:\\sjk");
	}
//	private String name;
//	private String project;
//	private String xym;
//	private String sbm;
//	private String number;
	private static void addNote2(Schema schema) {
		Entity groupImageInfo = schema.addEntity("Sendinfo");
		groupImageInfo.addIdProperty().autoincrement().primaryKey();
		groupImageInfo.addStringProperty("name").notNull();
		groupImageInfo.addStringProperty("project").notNull();
		groupImageInfo.addStringProperty("xym");
		groupImageInfo.addStringProperty("sbm");
		groupImageInfo.addStringProperty("number");
		groupImageInfo.addStringProperty("fwm");
		//        groupImageInfo.addIntProperty("downloadstatus");
		//        groupImageInfo.addLongProperty("downId");
		//        groupImageInfo.addIntProperty("uploaded");
		//        note.add
		//        note.addDateProperty("date");
	}

	private static void addNote1(Schema schema) {
		Entity groupImageInfo = schema.addEntity("WebAppInfo");
		groupImageInfo.addIdProperty().autoincrement().primaryKey(); // 主键
		groupImageInfo.addStringProperty("title").notNull();//标题
		groupImageInfo.addStringProperty("iconurl").notNull();//appicon
		groupImageInfo.addStringProperty("size");//大小
		groupImageInfo.addIntProperty("downloadcount");//下载数
		groupImageInfo.addStringProperty("apkurl").unique().notNull();//下载路径
		groupImageInfo.addStringProperty("previewurls");//效果图
		groupImageInfo.addStringProperty("content");//介绍
		groupImageInfo.addStringProperty("banner");//
		groupImageInfo.addIntProperty("tag");//0游戏  1应用  2主题
		groupImageInfo.addStringProperty("specialname");//ad
		groupImageInfo.addStringProperty("classify");//休闲
		groupImageInfo.addStringProperty("version");//版本
		groupImageInfo.addIntProperty("sort_order");//排序
		groupImageInfo.addDoubleProperty("star");//星星
		
		//sort_order排序

		// groupImageInfo.addStringProperty("apkfilepath");// apk 本地文件路径  
		// groupImageInfo.addIntProperty("downed");//下载的标志

		Entity groupImageInfo1 = schema.addEntity("Special");//专辑
		groupImageInfo1.addIdProperty().autoincrement().primaryKey();
		groupImageInfo1.addStringProperty("logo_path").notNull();
		groupImageInfo1.addStringProperty("name").notNull();
		
		Entity groupImageInfo2 = schema.addEntity("Statistical");//统计
		groupImageInfo2.addIdProperty().autoincrement().primaryKey();
		groupImageInfo2.addIntProperty("startcount");
		groupImageInfo2.addIntProperty("readcount");
		groupImageInfo2.addIntProperty("downloadcount");
		groupImageInfo2.addStringProperty("data");
		

//		Entity groupImageInfo2 = schema.addEntity("AppDownLoad");//下载维护表
//		groupImageInfo2.addIdProperty().autoincrement().primaryKey();//安卓端的id主键
// 		groupImageInfo2.addLongProperty("appid");//后台的ip
//		groupImageInfo2.addStringProperty("apkpath");//apk path 本地保存路径
//		groupImageInfo2.addStringProperty("title").notNull();//标题
//		groupImageInfo2.addStringProperty("iconurl").notNull();//appicon
//		groupImageInfo2.addStringProperty("size");//大小
//		groupImageInfo2.addStringProperty("apkurl").unique().notNull();//下载路径  网络端
//		groupImageInfo2.addStringProperty("version");//版本号
//
//		groupImageInfo2.addLongProperty("downloadId");//下载id 
//		groupImageInfo2.addIntProperty("progress");//百分比
//		groupImageInfo2.addIntProperty("status");//下载状态 完成 失败 继续 等等
//		groupImageInfo2.addIntProperty("normal");
//		
//		groupImageInfo2.addStringProperty("packagename");//包名
		
		
		
		
		//groupImageInfo.addStringProperty("unique").unique().notNull();
		//groupImageInfo.addIntProperty("downloadstatus");
		//groupImageInfo.addLongProperty("downId");
		//groupImageInfo.addIntProperty("uploaded");
		//note.add
		//note.addDateProperty("date");
	}

	private static void addNote3(Schema schema) {
		Entity groupImageInfo = schema.addEntity("Special");//专辑
		groupImageInfo.addIdProperty().autoincrement().primaryKey();
		groupImageInfo.addStringProperty("logo_path").notNull();
		groupImageInfo.addStringProperty("name").notNull();

		//    	groupImageInfo.addStringProperty("unique").unique().notNull();
		//        groupImageInfo.addIntProperty("downloadstatus");
		//        groupImageInfo.addLongProperty("downId");
		//        groupImageInfo.addIntProperty("uploaded");
		//        note.add
		//        note.addDateProperty("date");
	}

	private static void addNote(Schema schema) {
		Entity groupImageInfo = schema.addEntity("GroupImageInfo");
		groupImageInfo.addIdProperty().autoincrement().primaryKey();
		groupImageInfo.addStringProperty("title").notNull();
		groupImageInfo.addStringProperty("fromurl").notNull().unique();
		groupImageInfo.addStringProperty("imageurls");
		groupImageInfo.addIntProperty("type").notNull();
		groupImageInfo.addIntProperty("readed");
		//        groupImageInfo.addIntProperty("uploaded");
		//        note.add
		//        note.addDateProperty("date");
	}

	private static void addCustomerOrder(Schema schema) {
		Entity customer = schema.addEntity("Customer");
		customer.addIdProperty();
		customer.addStringProperty("name").notNull();

		Entity order = schema.addEntity("Order");
		order.setTableName("ORDERS"); // "ORDER" is a reserved keyword
		order.addIdProperty();
		Property orderDate = order.addDateProperty("date").getProperty();
		Property customerId = order.addLongProperty("customerId").notNull().getProperty();
		order.addToOne(customer, customerId);

		ToMany customerToOrders = customer.addToMany(order, customerId);
		customerToOrders.setName("orders");
		customerToOrders.orderAsc(orderDate);
	}

}
