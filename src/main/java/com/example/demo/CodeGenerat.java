package com.example.demo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGenerat {

    private static String USER_NAME = "www";
    private static String USER_PWD = "123456";
    private static String ROOT_PATH = "com.example.demo.mybatisPlus2";
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
    public static final String SRC_MAIN_JAVA = "src/main/java";


    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }


    private static InjectionConfig getInjectionConfig() {
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        String templatePath = "templates/mapper.xml.ftl";
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return System.getProperty("user.dir") + "/src/main/resources/mapper/" +MODULAR_NAME
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        return new InjectionConfig() {
            @Override
            public void initMap() {

            }
        }.setFileOutConfigList(focList);
    }

    private static StrategyConfig getStrategyConfig(String tableName, String tablePrefix) {

        return new StrategyConfig()
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(false)
                .setRestControllerStyle(true)
                .setChainModel(true)
                .setInclude(tableName.split(","))
                .setControllerMappingHyphenStyle(true)
                .setEntitySerialVersionUID(false)
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
        String filePath = projectPath + "/" + MODULAR_NAME + SRC_MAIN_JAVA;
        System.out.println(filePath);
        return new GlobalConfig()
                .setOutputDir(filePath)
                .setAuthor("wang")
                .setOpen(false)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
//                .setDateType(DateType.TIME_PACK)
                .setIdType(IdType.INPUT)
                .setFileOverride(false)
                ;

    }

    private static TemplateConfig getTemplateConfig() {
        return new TemplateConfig()
                .setController("templates/controller.java")
                .setService("templates/service.java")
                .setServiceImpl("templates/serviceImpl.java")
                .setEntity("templates/entity.java")
                .setMapper("templates/mapper.java")
                .setXml(null);
    }

    private static void autoGenerator(String moduleName, String tableName, String tablePrefix) {


        new AutoGenerator()
                .setGlobalConfig(getGlobalConfig())
                .setDataSource(getDataSourceConfig())
                .setPackageInfo(getPackageConfig(moduleName))
                .setStrategy(getStrategyConfig(tableName, tablePrefix))
                .setCfg(getInjectionConfig())
                .setTemplate(getTemplateConfig())
                .setTemplateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    public static void main(String[] args) {
        autoGenerator(MODULAR_NAME,"student,user",MODULAR_NAME);
    }
}
