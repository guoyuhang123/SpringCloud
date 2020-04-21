package com.gyh.util;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;

/**
 * 
 * 创建人：FH 创建时间：2015年2月8日
 * @version
 */
public class Freemarker {
	//ftl模板文件路径
	public static String ftlpath=getResouce()+"freemarkerftl";

	private static String rootPath = "com.gyh";// 目录
	private static String tableName = "user";// 表名
	private static String entityName = "User";// 类名
	private static String path = System.getProperty("user.dir") + "/src/mian/java";// 项目路径
    private static String driverClassName="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/1704v";
	private static String username="root";
	private static String password="123";
	public static void main(String[] args) {
		List<String[]> fields = getFields(tableName);
		for(int i=0;i<fields.size();i++){
			String[] str = fields.get(i);
			System.out.println("字段名称:"+str[0]+"==字段类型"+str[1]+"==字段注释"+str[2]+"==是否是日期"+str[3]);
		}
		//Map<String,Object> data = new HashMap<String,Object>();		//创建数据模型
		// data.put("fieldList", getFields(tableName));//获取数据库所有字段
		/*data.put("tableName", tableName);						//包名
		data.put("packageName", packageName);						//包名
		data.put("entityName", entityName);							//类名
		data.put("entityNameLower", entityName.toLowerCase());		//类名(全小写)
		data.put("nowDate", new Date());*/
		/*Freemarker.printFile(ftlname, data, savepath);*/

	}
	/**
	 * 打印到控制台(测试用)
	 *  @param ftlName
	 */
	public static void print(String ftlName, Map<String,Object> root) throws Exception{
		try {
			Template temp = getTemplate(ftlName);		//通过Template可以将模板文件输出到相应的流
			temp.process(root, new PrintWriter(System.out));
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 输出到输出到文件
	 * @param ftlName   ftl文件名
	 * @param root		传入的map
	 * @param outFile	输出后的文件全部路径
	 */
	private static void printFile(String ftlName, Map<String,Object> root, String outFile){
		try {
			File file = new File(outFile);
			if(!file.getParentFile().exists()){				//判断有没有父路径，就是判断文件整个路径是否存在
				file.getParentFile().mkdirs();				//不存在就全部创建
			}
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
			Template template = getTemplate(ftlName);
			template.process(root, out);					//模版输出
			out.flush();
			out.close();
			System.out.println("======创建成功======"+outFile);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 通过文件名加载模版
	 * @param ftlName
	 */
	public static Template getTemplate(String ftlName) throws Exception{
		try {
			Configuration cfg = new Configuration();  	//通过Freemaker的Configuration读取相应的ftl
			cfg.setEncoding(Locale.CHINA, "utf-8");
			cfg.setDirectoryForTemplateLoading(new File(ftlpath));		//设定去哪里读取相应的ftl模板文件
			Template temp = cfg.getTemplate(ftlName);		//在模板文件目录中找到名称为name的文件
			return temp;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取发布根目录
	 * 2017年3月16日下午8:06:09
	 *  wangyue
	 */
	private static String getResouce() {
		String path =  (String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))).replaceAll("file:/", "").replaceAll("%20", " ").trim();	
		if(path.indexOf(":") != 1){
			path = File.separator + path;
		}
		return path;
	}
	/**
	 * 获取字段信息
	 * @return
	 */
	public static List<String[]> getFields(String tableName) {
		List<String[]> fieldList = new ArrayList<String[]>();  
		try {
			Class.forName(driverClassName);
			Connection conn = DriverManager.getConnection(url, username, password);
            DatabaseMetaData dbmd=conn.getMetaData();
            ResultSet rs = dbmd.getColumns(null, "%", tableName, "%");
            while(rs.next()) { 
            	String type = rs.getString("TYPE_NAME");//字段类型
            	String name = rs.getString("COLUMN_NAME");//字段名称
            	String remark = rs.getString("REMARKS");//字段注释
            	String[] field= new String[4];
            	field[0]=name;
            	field[2]=remark;
        		if(type.equals("DATETIME") || type.equals("DATE")){
        			field[1]="Date";
            		field[3]="是";
        		} else	if(type.equals("INT")){
            			field[1]="Integer";
                		field[3]="否";
        		} else{
        			field[1]="String";
            		field[3]="否";
        		}
            	fieldList.add(field);
            }
    		return fieldList;
        } catch (Exception e) {
            e.printStackTrace();
            return fieldList;
        }
	}
}
