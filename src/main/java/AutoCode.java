package com.xn;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AutoCode {

    private final String db_driver = "com.mysql.cj.jdbc.Driver";
    String db_url = "jdbc:mysql://127.0.0.1:3306/xn?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT";
    private final String db_userName = "root";
    private final String db_password = "root";

    private String tableName;
    private String beanName;
    private String packageName;
    private String codePath;
    private String smallName;

    /**
     *
     * @param tableName 表名
     * @param beanName 类名
     * @param packageName 包名
     * @param codePath 文件生成的路径
     */
    public AutoCode(String tableName, String beanName, String packageName, String codePath){
        this.tableName = tableName;
        this.beanName = beanName;
        this.packageName = packageName;
        this.codePath = codePath;
        this.smallName = beanName.substring(0,1).toLowerCase()+beanName.substring(1);
    }



    /**
     * 创建数据库连接
     * @return Connection
     */
    public Connection getConnection(){
        Connection connection= null;
        try {
            Class.forName(db_driver);

            connection = DriverManager.getConnection(db_url, db_userName, db_password);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;

    }


    /**
     * 获取表的字段信息
     * table name
     */
    public List<Map<String,String>> getColumns(){
        String script = "show full columns from " + tableName;
        Connection conn = getConnection();
        Statement stm = null;
        ResultSet rs = null;
        List<Map<String,String>> columns = new ArrayList<Map<String,String>>();
        Map<String,String> columnMap = null;
        System.out.println("table name : " + tableName);
        try {
            stm = conn.createStatement();
            stm.execute(script);
            rs = stm.getResultSet();
            String column = null;
            while(rs.next()){
                columnMap = new HashMap<String,String>();
                column = rs.getString("FIELD");
                columnMap.put("column", column);
                columnMap.put("prop", convertColumn(column));
                columnMap.put("jdbcType",getJdbcType(rs.getString("TYPE")));
                columnMap.put("javaType",Convert2JavaType(rs.getString("TYPE")));
                columnMap.put("comment",rs.getString("COMMENT"));
                columns.add(columnMap);
                System.out.println(column + " " + rs.getString("TYPE") + " " + rs.getString("COMMENT"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return columns;
    }

    private String convertColumn(String column){
        String property = null;
        if(column.indexOf("_") != -1){
            String[] parts = column.split("_");
            for(String p : parts){
                if(property == null) {
                    property = p;
                }else{
                    property += (p.charAt(0)+"").toUpperCase() + p.substring(1);
                }
            }
        }else{
            property = column;
        }
        return property;
    }


    public String Convert2JavaType(String type){
        String javaType = "";
        type = type.toLowerCase();
        if(type.startsWith("int") || type.startsWith("tinyint")){
            javaType = "Integer";
        }else if(type.startsWith("float")){
            javaType = "Float";
        }else if(type.startsWith("bigint")){
            javaType = "Long";
        }else if(type.startsWith("decimal")){
            javaType = "BigDecimal";
        }else if(type.startsWith("varchar") || type.startsWith("datetime") || type.startsWith("date")){
            javaType = "String";
        }else{
            javaType = " ";
        }
        return javaType;
    }

    public String getJdbcType(String type){
        String javaType = "";
        type = type.toLowerCase();
        if(type.startsWith("int") || type.startsWith("tinyint")){
            javaType = "INTEGER";
        }else if(type.startsWith("float")){
            javaType = "FLOAT";
        }else if(type.startsWith("bigint")){
            javaType = "BIGINT";
        }else if(type.startsWith("varchar")){
            javaType = "VARCHAR";
        }else if(type.startsWith("decimal")){
            javaType = "DECIMAL";
        }else{
            javaType = " ";
        }
        return javaType;
    }



    /**
     * &#x751f;&#x6210;bean
     * List<Map<String,String>> columns
     */
    public void buildBean(List<Map<String,String>> columns){
        System.out.println("build bean");
        try {
            String beanPath = codePath + File.separator + "domain";
            File file = new File(beanPath);

            if(!file.exists())  file.mkdirs();

            file = new File(beanPath + File.separator+ beanName+".java");

            StringBuffer props = new StringBuffer();
            StringBuffer gsmds = new StringBuffer();
            props.append("package "+packageName+".domain;\r\n\r\nimport lombok.Data;\r\n\r\n@Data\r\n");
            props.append("public class " + beanName +"{\r\n\r\n");
            String type,prop = "";
            for(Map<String,String> cmap : columns){
                type = cmap.get("javaType");
                prop = convertColumn(cmap.get("prop"));
                props.append("\tprivate " + type + " " + prop +";//"+cmap.get("comment")+"\r\n");

				/* 使用lombok.Data 注解生成getter setter
				gsmds.append("\r\t\tpublic void set"+prop.substring(0, 1).toUpperCase()+prop.substring(1, prop.length())+"(" + type+ " "+prop+"){\r\t");
				gsmds.append("\t\tthis." + prop + " = " + prop + ";\r\t\t}\r\t");

				gsmds.append("\tpublic "+type+" get"+prop.substring(0, 1).toUpperCase()+prop.substring(1, prop.length())+"(){\r\t");
				gsmds.append("\t\treturn " + prop + ";\r\t\t}\r\t");*/
            }
            props.append(gsmds);
            props.append("\r\n}");

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(props.toString().getBytes());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    /**
     *
     * @Description 生成dao service类
     * @author wangmeng
     * @date 2015年12月12日 上午11:42:24
     */
    public void buildDaoService(){
        System.out.println("build dao and service");
        try {
            File file = new File(codePath);
            if(!file.exists()) file.mkdir();
            String str = "";
            StringBuffer sbf = new StringBuffer();
            sbf.append("package ^;\r\n\r\n");
            sbf.append("import java.util.List;\r\nimport "+packageName+".domain."+beanName+";\r\nimport org.springframework.stereotype.%;\r\n\n");
            sbf.append("@%\r\n");
            sbf.append("public interface ${\r\n\r\n");
            sbf.append("\t"+beanName+" getById(Integer id);\r\t\r");
            sbf.append("\tList<"+beanName+"> query("+beanName+" "+smallName+");\r\t\r");
            sbf.append("\tInteger count("+beanName+" "+smallName+");\r\n\r\n");
            sbf.append("\tInteger insert("+beanName+" "+smallName+");\r\n\r\n");
            sbf.append("\tInteger update("+beanName+" "+smallName+");\r\n\r\n");
            sbf.append("\tInteger updateSelected("+beanName+" "+smallName+");\r\n\r\n");
            sbf.append("\tInteger deleteById(Integer id);\r\n\r\n");
            sbf.append("}");

            //创建dao 接口
            FileOutputStream fos = null;
            String daoPath = codePath + File.separator + "dao";
            File daoFile = new File(daoPath);
            if(!daoFile.exists()) daoFile.mkdir();

            file = new File(daoPath + File.separator + beanName + "Dao.java");
            fos = new FileOutputStream(file);
            str = sbf.toString();
            //fos.write(str.replace("^", packageName+".dao").replace("%", "Repository").replace("#", smallName+"Dao").replace("$", beanName+"Dao").getBytes());
            fos.write(str.replace("^", packageName+".dao").replace("%", "Repository").replace("$", beanName+"Dao").getBytes());
            fos.flush();
            fos.close();

            //创建service 接口
            String servicePath = codePath + File.separator + "service";
            File serviceFile = new File(servicePath);
            if(!serviceFile.exists()) serviceFile.mkdir();

            file = new File(servicePath + File.separator + beanName + "Service.java");
            fos = new FileOutputStream(file);
            str = sbf.toString();
            str = str.replace("^", packageName+".service").replace("@%\r\n", "").replace("$", beanName+"Service").replace("import org.springframework.stereotype.%;", "");
            fos.write(str.getBytes());
            fos.flush();
            fos.close();

            //创建service实现
            file = new File(servicePath + File.separator +  beanName+"ServiceImpl.java");
            fos = new FileOutputStream(file);
            sbf = new StringBuffer();
            sbf.append("package "+packageName+".service;\r\n\r\n");
            sbf.append("import java.util.List;\r\nimport "+packageName+".domain."+beanName+";\r\nimport "+packageName+".dao."+beanName+"Dao;\r\nimport org.springframework.stereotype.Service;\r\nimport org.springframework.beans.factory.annotation.Autowired;\r\n\r\n");
            sbf.append("@Service\r\n");
            sbf.append("public class ${\r\n\r\n");
            sbf.append("\t@Autowired\r\n\tprivate "+beanName+"Dao "+smallName+"Dao;\r\n\r\n");
            sbf.append("\tpublic "+beanName+" getById(Integer id){\r\n");
            sbf.append("\t\treturn "+smallName+"Dao.getById(id);\r\n\t}\r\n");
            sbf.append("\tpublic List<"+beanName+"> query("+beanName+" "+smallName+"){\r\n");
            sbf.append("\t\treturn "+smallName+"Dao.query("+smallName+");\r\n\t}\r\n\n");
            sbf.append("\tpublic Integer count("+beanName+" "+smallName+"){\r\n");
            sbf.append("\t\treturn "+smallName+"Dao.count("+smallName+");\r\n\t}\r\n\n");
            sbf.append("\tpublic Integer insert("+beanName+" "+smallName+"){\r\n");
            sbf.append("\t\treturn "+smallName+"Dao.insert("+smallName+");\r\n\t}\r\n\n");
            sbf.append("\tpublic Integer update("+beanName+" "+smallName+"){\r\n");
            sbf.append("\t\treturn "+smallName+"Dao.update("+smallName+");\r\n\t}\r\n\n");
            sbf.append("\tpublic Integer updateSelected("+beanName+" "+smallName+"){\r\n");
            sbf.append("\t\treturn "+smallName+"Dao.updateSelected("+smallName+");\r\n\t}\r\n\n");
            sbf.append("\tpublic Integer deleteById(Integer id){\r\n");
            sbf.append("\t\treturn "+smallName+"Dao.deleteById(id);\r\n\t}\r\n\n");
            sbf.append("}");
            str = sbf.toString();
            //fos.write(str.replace("%", "Service").replace("#", smallName+"Service").replace("$", beanName+"ServiceImpl implements "+beanName+"Service").getBytes());
            fos.write(str.replace("%", "Service").replace("$", beanName+"ServiceImpl implements "+beanName+"Service").getBytes());
            fos.flush();
            fos.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void buildController(){

        StringBuffer conBuffer = new StringBuffer("package " + packageName + ".controller;\r\r");
        conBuffer.append("import com.yh.commons.domain.Result;\r");
        conBuffer.append("import "+ packageName + ".domain."+ beanName + ";\r");
        conBuffer.append("import " + packageName + ".service."+ beanName + "Service;\r");
        conBuffer.append("import org.springframework.beans.factory.annotation.Autowired;\r");
        conBuffer.append("import org.springframework.web.bind.annotation.*;\r\r");

        conBuffer.append("@RestController\r@RequestMapping(\"/"+smallName+"\")\r");

        conBuffer.append("public class " + beanName + "Controller {\r\r");
        conBuffer.append("\t@Autowired\r");
        conBuffer.append("\tprivate "+beanName+"Service "+smallName+"Service;\r\r");

        conBuffer.append("\t@PostMapping(\"/1.0/insert\")\r");
        conBuffer.append("\tpublic Result insert("+beanName+" "+ smallName +"){\r");
        conBuffer.append("\t\t"+smallName+"Service.insert("+smallName+");\r");
        conBuffer.append("\t\treturn Result.OK();\r\t}\r\r");

        conBuffer.append("\t@GetMapping(\"/1.0/query\")\r");
        conBuffer.append("\tpublic Result query("+beanName+" "+ smallName +"){\r");
        conBuffer.append("\t\treturn Result.OK("+smallName+"Service.query("+smallName+"));\r\t}\r\r");

        conBuffer.append("\t@PostMapping(\"/1.0/update\")\r");
        conBuffer.append("\tpublic Result update("+beanName+" "+ smallName +"){\r");
        conBuffer.append("\t\t"+smallName+"Service.updateSelected("+smallName+");\r");
        conBuffer.append("\t\treturn Result.OK();\r\t}\r\r");

        conBuffer.append("\t@PostMapping(\"/1.0/delete\")\r");
        conBuffer.append("\tpublic Result delete(Integer id){\r");
        conBuffer.append("\t\t"+smallName+"Service.deleteById(id);\r");
        conBuffer.append("\t\treturn Result.OK();\r\t}\r\r");

        conBuffer.append("\r}");

        //创建controller 接口
        FileOutputStream fos;
        String conPath = codePath + File.separator + "controller";
        File conFile = new File(conPath);
        if(!conFile.exists()) conFile.mkdir();

        try {
            fos = new FileOutputStream(new File(conPath + File.separator + beanName + "Controller.java"));
            fos.write(conBuffer.toString().getBytes());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    /**
     * 创建 xml
     * bean name
     * package name
     */
    public void buildXML(List<Map<String,String>> columns){
        System.out.println("build xml");
        StringBuffer xml = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r");
        xml.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\r");
        xml.append("<mapper namespace=\""+packageName+".dao."+beanName+"Dao\">\r\r");

        String basic_column = new String();
        String column = "",prop = "";
        StringBuffer baseMap = new StringBuffer("\t<resultMap id=\"BaseResultMap\" type=\""+packageName+".domain."+beanName+"\">\r");

        StringBuffer getById = new StringBuffer("\t<select id=\"getById\" resultMap=\"BaseResultMap\">\r");
        StringBuffer query = new StringBuffer("\t<select id=\"query\" parameterType=\""+packageName+".domain."+beanName+"\" resultMap=\"BaseResultMap\">\r");
        StringBuffer query_test = new StringBuffer("\twhere 1=1 \r");
        StringBuffer count = new StringBuffer("\t<select id=\"count\" parameterType=\""+packageName+".domain."+beanName+"\" resultType=\"Integer\">\r");

        StringBuffer insert = new StringBuffer("\t<insert id=\"insert\" parameterType=\""+packageName+".domain."+beanName+"\" >\r");
        insert.append("\t\tinsert into "+tableName+" \r\n\t\t<trim prefix=\"(\" suffix= \")\" suffixOverrides =\",\">\r\n");

        StringBuffer insert_values = new StringBuffer();
        StringBuffer insert_columns = new StringBuffer();

        StringBuffer update = new StringBuffer("\t<update id=\"update\" parameterType=\""+packageName+".domain."+beanName+"\" >\r");
        update.append("\t\tupdate "+tableName+ "\r\n\t\t set \r\n \t\t<trim suffix= \"\" suffixOverrides =\",\">\r");

        StringBuffer update_selected = new StringBuffer("\t<update id=\"updateSelected\" parameterType=\""+packageName+".domain."+beanName+"\" >\r");
        update_selected.append("\t\tupdate "+tableName+ " \r\n\t<set> \r\n\t\t<trim suffix= \"\" suffixOverrides =\",\">\r");

        StringBuffer delete = new StringBuffer("\r\n\t<delete id=\"deleteById\">\r\n\t\tdelete from "+tableName+" where id = #{id}\r\t</delete>\r\r");

        for(Map<String,String> map : columns){
            column = map.get("column");
            prop = map.get("prop");
            baseMap.append("\t\t<result column=\""+column+"\" jdbcType=\""+ map.get("jdbcType") +"\" property=\""+prop+"\"/>\r");

            basic_column += column+",";
            query_test.append("\t\t<if test=\""+prop+" != null\" >\r\n\t\t\tand "+column+"=#{"+prop+"}\r\t\t</if>\r");

            insert_columns.append("\t\t<if test=\""+prop+" != null\" >\r\n\t\t\t"+column+",\r\t\t</if>\r");
            insert_values.append("\t\t<if test=\""+prop+" != null\" >\r\n\t\t\t#{"+prop+"},\r\t\t</if>\r");

            if(!column.toLowerCase().equals("id")) update.append("\t\t\t"+column+ " = #{"+prop+"},\r");

            update_selected.append("\t\t<if test=\""+prop+" != null\" >\r\n\t\t\t"+column+" = #{"+prop+"},\r\t\t</if>\r");

        }
        baseMap.append("\t</resultMap>\r\n\r\n");
        basic_column = basic_column.substring(0, basic_column.length()-1);
        getById.append("\t\tselect "+basic_column+" from "+tableName+"\r");
        getById.append("\t\twhere id = #{id,jdbcType=INTEGER}\r\n\t</select>\r\r\r");

        query.append("\t\tselect "+basic_column+" from "+tableName+"\r\t");
        query.append(query_test+"\r\n\t</select>\r\n\r\n\r\n");

        count.append("\t\tselect count(id) from "+tableName+"\r\r");
        count.append(query_test+"\t</select>\r\r");

        insert.append(insert_columns +"\t\t</trim>\r\t\t\tvalues \r\t\t<trim prefix=\"(\" suffix= \")\" suffixOverrides =\",\">\r");
        insert.append(insert_values+"\t\t</trim>\r\t\t</insert>\r\r");

        update.append("\t\t</trim>\r\t\t\t\twhere id = #{id}\r\t</update>\r\r");

        update_selected.append("\t\t</trim>\r\t\t</set>\r\t\twhere id = #{id}\r\t</update>\r\r");

        xml.append(baseMap);
        xml.append(getById);
        xml.append(query);
        xml.append(count);
        xml.append(insert);
        xml.append(update);
        xml.append(update_selected);
        xml.append(delete);
        xml.append("</mapper>");

        try {
            File file = new File(codePath);
            if(!file.exists()) file.mkdirs();
            FileOutputStream fos = new FileOutputStream(codePath+File.separator+beanName+"Mapper.xml");
            fos.write(xml.toString().getBytes());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }

    public static void main(String[] args){
        try {
            //AutoCode auto = new AutoCode("t_teacher_video", "TeacherVideo","com.xn.teacher", "/Users/lesliechen/Desktop/temp");
            AutoCode auto = new AutoCode("t_article_collect", "ArticleCollect","com.xn.index", "/Users/user/Desktop/temp");
            List<Map<String, String>> list = auto.getColumns();
            auto.buildBean(list);
           /* auto.buildDaoService();
            auto.buildController();
            auto.buildXML(list);*/
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
