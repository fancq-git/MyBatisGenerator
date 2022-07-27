package com.fancq.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author fancq
 * @since 2022/7/27 11:54
 */
public class App {

    public static void main(String[] args) {
        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = "C:\\Users\\Administrator\\Desktop\\";
        gc.setOutputDir(projectPath + "dq");
        gc.setAuthor("fancq");
        // 生成后是否打开资源管理器
        gc.setOpen(false);
        // 重新生成时文件是否覆盖
        gc.setFileOverride(false);
        // 去掉Service接口的首字母I
        gc.setServiceName("%sService");
        // 主键策略
        gc.setIdType(IdType.ID_WORKER_STR);
        // 定义生成的实体类中日期类型
        gc.setDateType(DateType.ONLY_DATE);
        // 开启Swagger2模式
        gc.setSwagger2(true);

        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://221.221.221.8:3306/dataman_sec_db?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("dataman_sec");
        dsc.setPassword("Copote&20211110");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("generator");
        pc.setParent("com");
        pc.setController("controller");
        pc.setEntity("pojo");
        pc.setService("service");
        pc.setMapper("com.copote.data.manager.dao.mapper");
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 设置要映射的表名: pdx_\\w*，支持正则
        // 设置要映射的表名
        strategy.setInclude("t_dq_qc_wo");
        // 数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 设置表前缀不生成
        strategy.setTablePrefix("t_");
        // 数据库表字段映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // lombok 模型 @Accessors(chain = true) setter链式操作
        strategy.setEntityLombokModel(true);
        // restful api风格控制器
        strategy.setRestControllerStyle(true);
        // url中驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(strategy);

        // 6、执行
        mpg.execute();
    }
}
