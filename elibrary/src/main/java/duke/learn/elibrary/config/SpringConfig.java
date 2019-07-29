/**
 * 
 */
package duke.learn.elibrary.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.cfg.Environment;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.EnableLoadTimeWeaving.AspectJWeaving;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author Kazi
 *
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableLoadTimeWeaving(aspectjWeaving = AspectJWeaving.ENABLED)
@ComponentScan(basePackages = "duke.learn.elibrary")
public class SpringConfig implements WebMvcConfigurer {

    @Value("${dm.url}")
    private String dbUrl;

    @Value("${dm.username}")
    private String dbUsername;

    @Value("${dm.password}")
    private String dbPassword;

    @Value("${dm.driver}")
    private String driver;

    @Value("$ hibernate.dialectr}")
    private String dialect;

    @Value("${hibernate.hbm2ddl}")
    private String hbm2ddl;

    @Value("${ hibernate.showsql}")
    private boolean showSql;

    @Value("${hibernate.formatsql}")
    private boolean formatSql;

    @Value("${hibernate.connection_strategy}")
    private String connectionStategy;

    @Value("${ hibernate.enable_lazy_load}")
    private boolean lazyLoad;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
	PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
	propertyPlaceholderConfigurer.setLocations(new ClassPathResource("/application.properties"));
	propertyPlaceholderConfigurer.setIgnoreResourceNotFound(false);
	propertyPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(false);
	return propertyPlaceholderConfigurer;
    }

    @Bean(name = "messageSource")
    public MessageSource messageSource() {
	ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	messageSource.setBasename("classpath:/messages");
	messageSource.setDefaultEncoding("UTF-8");
	messageSource.setUseCodeAsDefaultMessage(true);
	return messageSource;
    }

    @Bean
    public ViewResolver viewResolver() {
	InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	resolver.setPrefix("/jsp/");
	resolver.setSuffix(".jsp");
	return resolver;
    }

    @Bean
    public DataSource mysqlDataSource() {
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	dataSource.setDriverClassName(driver);
	dataSource.setUrl(dbUrl);
	dataSource.setUsername(dbUsername);
	dataSource.setPassword(dbPassword);
	return dataSource;
    }

    @Bean(name = "entityManager")
    public LocalContainerEntityManagerFactoryBean entityManager() {
	LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	entityManagerFactoryBean.setDataSource(mysqlDataSource());
	entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
	entityManagerFactoryBean.setPackagesToScan("duke.learn.elibrary.data");

	Properties jpaProterties = new Properties();
	jpaProterties.put(Environment.DIALECT, dialect);
	jpaProterties.put(Environment.GENERATE_STATISTICS, true);
	jpaProterties.put(Environment.HBM2DDL_AUTO, hbm2ddl);
	jpaProterties.put(Environment.SHOW_SQL, showSql);
	jpaProterties.put(Environment.FORMAT_SQL, formatSql);
	jpaProterties.put(Environment.CONNECTION_HANDLING, connectionStategy);
	jpaProterties.put(Environment.ENABLE_LAZY_LOAD_NO_TRANS, lazyLoad);

	entityManagerFactoryBean.setJpaProperties(jpaProterties);
	return entityManagerFactoryBean;

    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager transactionManager() {
	JpaTransactionManager transactionManager = new JpaTransactionManager();
	transactionManager.setEntityManagerFactory(entityManager().getObject());
	return transactionManager;
    }
}
