package com.spring.config.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 *
 *  @author jackycheng
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory1",
        transactionManagerRef = "transactionManager1",
        basePackages = {"com.spring.*.dao1"})
public class RepositoryConfig1 {

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    @Qualifier("druidDataSource1")
    private DataSource druidDataSource;

    @Bean(name = "entityManager1")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactory(builder).getObject().createEntityManager();
    }

    /**
     * 指定需要扫描的实体包实现与数据库关联
     * @param builder
     * @return
     */
    @Bean(name = "entityManagerFactory1")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(druidDataSource)
                .properties(getVendorProperties())
                .packages("com.spring.*.entity1")
                .persistenceUnit("persistenceUnitSpring")
                .build();
    }

    /**
     * 通过jpaProperties指定hibernate数据库方言以及在控制台打印sql语句
     * @return
     */
    private Map<String, Object> getVendorProperties() {
        Map<String, Object> map = jpaProperties.getHibernateProperties(new HibernateSettings());
        map.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        map.put("hibernate.show_sql", "true");
        return map;
    }

    /**
     * 创建事务管理
     * @param builder
     * @return
     */
    @Bean(name = "transactionManager1")
    PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactory(builder).getObject());
    }

}
