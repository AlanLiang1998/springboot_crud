package com.gdpu.springbootcrud;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.gdpu.springbootcrud.entity.Employee;
import com.gdpu.springbootcrud.entity.User;
import com.gdpu.springbootcrud.mapper.EmployeeMapper;
import com.gdpu.springbootcrud.mapper.UserMapper;
import com.gdpu.springbootcrud.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootTest
@Slf4j
class SpringbootCrudApplicationTests {

    @Test
    void contextLoads() {
    }

//    @Test
//    void testGenerator() {
//        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
//        gc.setOutputDir(projectPath + "/src/main/java");
//        gc.setAuthor("AlanLiang");
//        gc.setOpen(false);
//        // gc.setSwagger2(true); 实体属性 Swagger2 注解
//        mpg.setGlobalConfig(gc);
//
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://localhost:3306/springbootcrud");
//        // dsc.setSchemaName("public");
//        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setUsername("root");
//        dsc.setPassword("1234");
//        mpg.setDataSource(dsc);
//
//        // 包配置
//        PackageConfig pc = new PackageConfig();
//        //pc.setModuleName(scanner("模块名"));
//        pc.setParent("com.gdpu.springbootcrud");
//        mpg.setPackageInfo(pc);
//
//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//
//        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
//        // 如果模板引擎是 velocity
//        // String templatePath = "/templates/mapper.xml.vm";
//
//        // 自定义输出配置
//        List<FileOutConfig> focList = new ArrayList<>();
//        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//        /*
//        cfg.setFileCreate(new IFileCreate() {
//            @Override
//            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
//                // 判断自定义文件夹是否需要创建
//                checkDir("调用默认方法创建的目录");
//                return false;
//            }
//        });
//        */
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//
//        // 配置模板
//        TemplateConfig templateConfig = new TemplateConfig();
//
//        // 配置自定义输出模板
//        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
//        // templateConfig.setEntity("templates/entity2.java");
//        // templateConfig.setService();
//        // templateConfig.setController();
//
//        templateConfig.setXml(null);
//        mpg.setTemplate(templateConfig);
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        //strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
//        strategy.setEntityLombokModel(true);
//        strategy.setRestControllerStyle(true);
//        // 公共父类
//        //strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
//        // 写于父类中的公共字段
//        //strategy.setSuperEntityColumns("id");
//        strategy.setInclude("user,employee,department".split(","));
//        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix(pc.getModuleName() + "_");
//        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        mpg.execute();
//    }
//
//    @Autowired
//    UserMapper userMapper;
//
//    @Autowired
//    EmployeeMapper employeeMapper;
//
//    @Test
//    void testMapper() {
//        User user = userMapper.selectById(1L);
//        log.info(String.valueOf(user));
//        Random randomAge = new Random();
//        Random randomGender = new Random();
//        long mobileValue = 18600020000L;
//        for (int i = 0; i < 200; i++) {
//            Employee employee = new Employee();
//            String uuid = UUID.randomUUID().toString().substring(0, 5);
//            employee.setEmpName(uuid);
//            int age = randomAge.nextInt(20) + 20;
//            boolean flag = randomGender.nextBoolean();
//            employee.setAge(age);
//            employee.setGender(flag ? "M" : "F");
//            employee.setMobile(String.valueOf(mobileValue));
//            mobileValue += 1;
//            employee.setDeptId(3L);
//            employeeMapper.insert(employee);
//        }
////        for(long i=500;i<800;i++){
////            employeeMapper.removeById(i);
////        }
//    }
//
//    /**
//     * 获取当前连续页码
//     *
//     * @param current      当前页码
//     * @param pages        总共页
//     * @param navigatePage 连续页数量
//     * @return 当前连续页码
//     */
//    ArrayList<Integer> getNavigatepageNums(int current, int pages, int navigatePage) {
//        int begin, end;
//        if (pages >= navigatePage) {
//            int beforeOffset, afterOffset;
//            if (navigatePage % 2 != 0) {
//                beforeOffset = afterOffset = navigatePage / 2;
//            } else {
//                beforeOffset = navigatePage / 2 - 1;
//                afterOffset = navigatePage / 2;
//            }
//            begin = current - beforeOffset;
//            end = current + afterOffset;
//            if (begin <= 0) {
//                begin = 1;
//                end = begin + navigatePage - 1;
//            }
//            if (end > pages) {
//                end = pages;
//                begin = end - (navigatePage - 1);
//            }
//        } else {
//            begin = 1;
//            end = pages;
//        }
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = begin; i <= end; i++) {
//            list.add(i);
//        }
//        return list;
//    }
//
//    @Test
//    void testNavigatepageNums() {
//        ArrayList<Integer> nums = getNavigatepageNums(4, 100, 6);
//        System.out.println(nums);
//    }
//
//    @Test
//    void testSelectPageWithDept() {
//        Page<Employee> page = new Page<>(1, 5);
//        Page<Employee> pageInfo = employeeMapper.selectPageWithDept(page, new QueryWrapper<>());
//        System.out.println(pageInfo);
//    }
//
//    @Autowired
//    private IEmployeeService employeeService;
//
//    @Test
//    void testLastPage() {
//        Page<Employee> page = new Page<>(240, 5);
//        Page<Employee> pageInfo = employeeService.pageWithDept(page);
//        List<Employee> records = pageInfo.getRecords();
//        log.info(records.toString());
////        Employee employee = employeeMapper.selectById(1506L);
////        log.info(employee.toString());
//    }
//
//    @Test
//    void testWrapper(){
//        Page<Employee> page = new Page<>(1, 5);
//        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
//        wrapper.like("emp_name","a");
//        Page<Employee> pageInfo = employeeMapper.selectPageWithDept(page, wrapper);
//        System.out.println(pageInfo);
//    }
}
