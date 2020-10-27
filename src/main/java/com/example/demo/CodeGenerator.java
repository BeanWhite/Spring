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

public class CodeGenerator {
    private static String USER_NAME = "www";
    private static String USER_PWD = "123456";
    private static String ROOT_PATH = "com.example.demo.mybatisPlus";
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


    private static InjectionConfig getInjectionConfig(final String moduleName) {
        return new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };
    }

    private static StrategyConfig getStrategyConfig(String tableName, String tablePrefix) {

        return new StrategyConfig()
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setSuperEntityColumns("id")
                .setInclude(tableName)
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
        String filePath = projectPath + "/" + MODULAR_NAME + SRC_MAIN_JAVA;
        return new GlobalConfig()
                .setOutputDir(filePath)
                .setAuthor("wang")
                .setOpen(false)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setDateType(DateType.ONLY_DATE)
                .setFileOverride(false)
                ;

    }

    private static TemplateConfig getTemplateConfig() {
        return new TemplateConfig()
                .setController("templates/controller.java.vm")
                .setService("templates/service.java.vm")
                .setServiceImpl("templates/serviceImpl.java.vm")
                .setEntity("templates/entity.java.vm")
                .setMapper("templates/mapper.java.vm")
                .setXml(null);
    }

    private static void autoGenerator(String moduleName, String tableName, String tablePrefix) {
        new AutoGenerator()
                .setGlobalConfig(getGlobalConfig())
                .setDataSource(getDataSourceConfig())
                .setPackageInfo(getPackageConfig(moduleName))
                .setStrategy(getStrategyConfig(tableName, tablePrefix))
                .setCfg(getInjectionConfig(moduleName))
                .setTemplate(getTemplateConfig())
                .setTemplateEngine(new VelocityTemplateEngine())
                .execute();
    }

    public static void main(String[] args) {
        //autoGenerator(MODULAR_NAME,"student,user",MODULAR_NAME);
        GL();
    }

    private static void GL() {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("jobob");
        gc.setOpen(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setIdType(IdType.INPUT);//将ID设置为自己输入的，如果id为自增，尝试设置为auto
        gc.setFileOverride(false);


        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(SQL_URL);
        dsc.setSchemaName("public");
        dsc.setDriverName(SQL_DRIVER);
        dsc.setUsername(USER_NAME);
        dsc.setPassword(USER_PWD);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(scanner("模块名"));
//        pc.setModuleName("mm");
        pc.setParent(ROOT_PATH);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };


        // 如果模板引擎是 freemarker
        String templatePath = "templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

//        // 配置模板
//        TemplateConfig templateConfig = new TemplateConfig();
//
//        // 配置自定义输出模板
//        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
//         templateConfig.setEntity("templates/entity.java.vm");
//        // templateConfig.setService();
//        // templateConfig.setController();
//
//        templateConfig.setXml(null);


        TemplateConfig templateConfig = new TemplateConfig()
                .setController("templates/controller.java")
                .setService("templates/service.java")
                .setServiceImpl("templates/serviceImpl.java")
                .setEntity("templates/entity.java")
                .setMapper("templates/mapper.java")
                .setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(false);
        strategy.setRestControllerStyle(true);
        strategy.setChainModel(true);
        strategy.setInclude("student,user".split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setEntitySerialVersionUID(false);//关闭序列化id
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
