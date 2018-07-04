package com.sp;



import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//@Configuration  //DB사용시 추가
//@EnableTransactionManagement
public class DbMybatisContext {
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Value("#{jdbcProperties['jdbc.driverClassName']}")
	private String driverClassName;
	@Value("#{jdbcProperties['jdbc.url']}")
	private String url;
	@Value("#{jdbcProperties['jdbc.username']}")
	private String username;
	@Value("#{jdbcProperties['jdbc.password']}")
	private String password;
	@Value("#{jdbcProperties['jdbc.autoCommit']}")
	private Boolean autoCommit;
	@Value("#{jdbcProperties['jdbc.connectionTimeoutMs']}")
	private Long connectionTimeoutMs;
	@Value("#{jdbcProperties['jdbc.idleTimeoutMs']}")
	private Long idleTimeoutMs;
	@Value("#{jdbcProperties['jdbc.maxLifetimeMs']}")
	private Long maxLifetimeMs;
	@Value("#{jdbcProperties['jdbc.minIdle']}")
	private Integer minIdle;
	@Value("#{jdbcProperties['jdbc.maxPoolSize']}")
	private Integer maxPoolSize;
	@Value("#{jdbcProperties['jdbc.connectionTestQuery']}")
	private String connectionTestQuery;

	private HikariDataSource dataSource() throws Exception {
//		this.logger.info("dataSource :: init"); 로그
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(this.driverClassName);
//		hikariConfig.setJdbcUrl(AES.decrypt(this.url)); 암호화
//		hikariConfig.setUsername(AES.decrypt(this.username));
//		hikariConfig.setPassword(AES.decrypt(this.password));
		hikariConfig.setAutoCommit(this.autoCommit);
		hikariConfig.setConnectionTimeout(this.connectionTimeoutMs);
		hikariConfig.setIdleTimeout(this.idleTimeoutMs);
		hikariConfig.setMaxLifetime(this.maxLifetimeMs);
		hikariConfig.setMinimumIdle(this.minIdle);
		hikariConfig.setMaximumPoolSize(this.maxPoolSize);
		hikariConfig.setConnectionTestQuery(this.connectionTestQuery);

		return new HikariDataSource(hikariConfig);
	}

	/**
	 * 마이바티스 {@link org.apache.ibatis.session.SqlSession} 빈을 등록한다.
	 *
	 * SqlSessionTemplate은 SqlSession을 구현하고 코드에서 SqlSession를 대체하는 역할을 한다. 쓰레드에 안전하게 작성되었기 때문에 여러 DAO나 매퍼에서 공유 할 수 있다.
	 *
	 */
	@Bean(name = "sqlSession", destroyMethod = "clearCache")
	@Autowired
	@Primary
	public SqlSessionTemplate sqlSessionTemplate(final ApplicationContext applicationContext) throws Exception {
		return new SqlSessionTemplate(this.sqlSessionFactory(applicationContext).getObject());
	}

	@Bean(name = "transactionManager")
	@Autowired
	@Primary
	public PlatformTransactionManager transactionManager(final ApplicationContext applicationContext) throws Exception {
		return new DataSourceTransactionManager(this.dataSource());
	}

	private SqlSessionFactoryBean sqlSessionFactory(final ApplicationContext applicationContext) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();

		sqlSessionFactory.setDataSource(this.dataSource());
		sqlSessionFactory.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
		sqlSessionFactory.setTypeAliasesPackage("com.skmns");
		sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath*:**/*Mapper.xml"));

		return sqlSessionFactory;
	}
}
