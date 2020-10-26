package com.example.demo;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Test {


    private static String USER_NAME = "www";
    private static String USER_PWD = "123456";
    private static String ROOT_PATH = "com.example.demo1.mybatisPlus";
    private static String SQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String SQL_DRIVER_OLD = "com.mysql.jdbc.Driver";
    private static String SQL_URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai&autoReconnect=true&characterEncoding=UTF-8";

    /**
     * modular 名字
     */
    public static final String MODULAR_NAME = "";

    /**
     * 基本路径
     */
    public static final String SRC_MAIN_JAVA = "/src/main/java";

    private static InjectionConfig getInjectionConfig(final String moduleName){
        return new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };
    }

    private static StrategyConfig getStrategyConfig(String tableName, String tablePrefix) {
        System.out.println(tableName.split(","));
        return new StrategyConfig()
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setSuperEntityColumns("id")
                .setInclude(tableName.split(","))
                .setControllerMappingHyphenStyle(true)
                .setEntityBuilderModel(true)
                .setTablePrefix(tablePrefix + "_")
                .setEntityTableFieldAnnotationEnable(true);
    }


    private static PackageConfig getPackageConfig(String moduleName) {
        return new PackageConfig()
//                .setModuleName(moduleName)
                .setParent(ROOT_PATH)
//                .setService("service")
//                .setController("controller")
//                .setMapper("dao")
//                .setEntity("entity")
                ;
    }

    private static DataSourceConfig getDataSourceConfig() {
        return new DataSourceConfig()
                .setSchemaName("public")
                .setUrl(SQL_URL)
                .setDriverName(SQL_DRIVER)
                .setUsername(USER_NAME)
                .setPassword(USER_PWD);
    }

    private static GlobalConfig getGlobalConfig() {

        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath +MODULAR_NAME+SRC_MAIN_JAVA;
        return new GlobalConfig()
                .setOutputDir(filePath)
                .setAuthor("wang")
                .setOpen(false)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
//                .setDateType(DateType.ONLY_DATE)
//                .setFileOverride(false)
                ;

    }

    private static TemplateConfig getTemplateConfig() {
        return new TemplateConfig()
                .setController("templates/controller.java.vm")
                .setService("templates/service.java.vm")
                .setServiceImpl("templates/serviceImpl.java.vm")
                .setEntity("templates/entity.java.vm")
                .setMapper("templates/mapper.java.vm")
                .setXml("");
    }
    private static void autoGenerator(String moduleName,String tableName,String tablePrefix){
        new AutoGenerator()
                .setGlobalConfig(getGlobalConfig())
                .setDataSource(getDataSourceConfig())
                .setPackageInfo(getPackageConfig(moduleName))
                .setStrategy(getStrategyConfig(tableName,tablePrefix))
                .setCfg(getInjectionConfig(moduleName))
                .setTemplate(getTemplateConfig())
                .setTemplateEngine(new VelocityTemplateEngine())
                .execute();
    }

    public static void main(String[] args) {
        autoGenerator(MODULAR_NAME,"student,user",MODULAR_NAME);
    }

}
