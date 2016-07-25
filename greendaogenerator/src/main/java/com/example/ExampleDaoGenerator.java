package com.example;


import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.DaoGenerator;


public class ExampleDaoGenerator {

    public static void main(String []args){
        //生成实体类entity 即对应的表
        Schema schema = new Schema(1, "com.magicweight.entity");
        //添加节点
        addTables(schema);

        schema.setDefaultJavaPackageDao("com.magicweight.dao");// 设置数据的会话层 *注意查看dao下文件，表结构名可能出错*

        //将生成的内容放在指定的路径下/Users/sdbean-zlh/Documents/android/zlhDemo/MagicWeight/app/src/main/java-gen
        try {
            new DaoGenerator().generateAll(schema, "/Users/sdbean-zlh/Documents/android/zlhDemo/MagicWeight/app/src/main/java-gen");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //创建数据库的表
    private static void addTables(Schema schema) {

        Entity entityContents = schema.addEntity("ArticlesContents"); //创建数据库的表
        Entity entityRecommend = schema.addEntity("ArticlesRecommend"); //创建数据库的表


        /**
         * 设置字符串获其他类型为主键
         * entity.addStringProperty("身份证号").primaryKey();
         */
        //当前表中的列

        entityContents.addIdProperty();// 主键
        entityContents.addStringProperty("url");
        entityContents.addStringProperty("type");
        entityContents.addStringProperty("name");
        entityContents.addStringProperty("image");
        entityContents.addStringProperty("isSee");
        entityContents.addStringProperty("isDo");
        entityContents.addStringProperty("delsign");

        //当前表中的列

        entityRecommend.addIdProperty();// 主键
        entityRecommend.addIntProperty("no");
        entityRecommend.addStringProperty("name");
        entityRecommend.addStringProperty("image");
        entityRecommend.addStringProperty("delsign");

    }
}
