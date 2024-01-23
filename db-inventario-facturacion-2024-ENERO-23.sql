
/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home/bin/java -Dmaven.multiModuleProjectDirectory=/Users/franklin/all/repos/fullstack/backend -Djansi.passthrough=true -Dmaven.home=/Users/franklin/.m2/wrapper/dists/apache-maven-3.9.5-bin/2adeog8mj13csp1uusqnc1f2mo/apache-maven-3.9.5 -Dclassworlds.conf=/Users/franklin/.m2/wrapper/dists/apache-maven-3.9.5-bin/2adeog8mj13csp1uusqnc1f2mo/apache-maven-3.9.5/bin/m2.conf -Dmaven.ext.class.path=/Applications/IntelliJ IDEA CE.app/Contents/plugins/maven/lib/maven-event-listener.jar -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=50282:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/franklin/.m2/wrapper/dists/apache-maven-3.9.5-bin/2adeog8mj13csp1uusqnc1f2mo/apache-maven-3.9.5/boot/plexus-classworlds.license:/Users/franklin/.m2/wrapper/dists/apache-maven-3.9.5-bin/2adeog8mj13csp1uusqnc1f2mo/apache-maven-3.9.5/boot/plexus-classworlds-2.7.0.jar org.codehaus.classworlds.Launcher -Didea.version=2023.3 org.springframework.boot:spring-boot-maven-plugin:3.2.1:run
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------------< com.rodriguez:pruebas >------------------------
[INFO] Building pruebas 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] >>> spring-boot:3.2.1:run (default-cli) > test-compile @ pruebas >>>
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ pruebas ---
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] Copying 0 resource from src/main/resources to target/classes
[INFO] 
[INFO] --- compiler:3.11.0:compile (default-compile) @ pruebas ---
[INFO] Changes detected - recompiling the module! :source
[INFO] Compiling 71 source files with javac [debug release 17] to target/classes
[INFO] /Users/franklin/all/repos/fullstack/backend/src/main/java/com/rodriguez/pruebas/security/TokenJwt.java: /Users/franklin/all/repos/fullstack/backend/src/main/java/com/rodriguez/pruebas/security/TokenJwt.java uses or overrides a deprecated API.
[INFO] /Users/franklin/all/repos/fullstack/backend/src/main/java/com/rodriguez/pruebas/security/TokenJwt.java: Recompile with -Xlint:deprecation for details.
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ pruebas ---
[INFO] skip non existing resourceDirectory /Users/franklin/all/repos/fullstack/backend/src/test/resources
[INFO] 
[INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ pruebas ---
[INFO] Changes detected - recompiling the module! :dependency
[INFO] Compiling 1 source file with javac [debug release 17] to target/test-classes
[INFO] 
[INFO] <<< spring-boot:3.2.1:run (default-cli) < test-compile @ pruebas <<<
[INFO] 
[INFO] 
[INFO] --- spring-boot:3.2.1:run (default-cli) @ pruebas ---
[INFO] Attaching agents: []
17:21:51.611 [main] INFO com.rodriguez.pruebas.PruebasApplication -- An INFO Message
17:21:51.613 [main] WARN com.rodriguez.pruebas.PruebasApplication -- A WARN Message
17:21:51.613 [main] ERROR com.rodriguez.pruebas.PruebasApplication -- An ERROR Message

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.1)

2024-01-23T17:21:51.813-06:00  INFO 2166 --- [           main] c.rodriguez.pruebas.PruebasApplication   : Starting PruebasApplication using Java 17.0.8 with PID 2166 (/Users/franklin/all/repos/fullstack/backend/target/classes started by usuario1 in /Users/franklin/all/repos/fullstack/backend)
2024-01-23T17:21:51.813-06:00  INFO 2166 --- [           main] c.rodriguez.pruebas.PruebasApplication   : No active profile set, falling back to 1 default profile: "default"
2024-01-23T17:21:52.090-06:00  INFO 2166 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2024-01-23T17:21:52.125-06:00  INFO 2166 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 30 ms. Found 14 JPA repository interfaces.
2024-01-23T17:21:52.346-06:00  INFO 2166 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8089 (http)
2024-01-23T17:21:52.353-06:00  INFO 2166 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-01-23T17:21:52.353-06:00  INFO 2166 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.17]
2024-01-23T17:21:52.383-06:00  INFO 2166 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-01-23T17:21:52.383-06:00  INFO 2166 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 546 ms
2024-01-23T17:21:52.453-06:00  INFO 2166 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2024-01-23T17:21:52.475-06:00  INFO 2166 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.4.1.Final
2024-01-23T17:21:52.487-06:00  INFO 2166 --- [           main] o.h.c.internal.RegionFactoryInitiator    : HHH000026: Second-level cache disabled
2024-01-23T17:21:52.579-06:00  INFO 2166 --- [           main] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
2024-01-23T17:21:52.590-06:00  INFO 2166 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2024-01-23T17:21:52.740-06:00  INFO 2166 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@4586a8aa
2024-01-23T17:21:52.741-06:00  INFO 2166 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2024-01-23T17:21:52.765-06:00  WARN 2166 --- [           main] org.hibernate.orm.deprecation            : HHH90000025: MySQLDialect does not need to be specified explicitly using 'hibernate.dialect' (remove the property setting and it will be selected by default)
2024-01-23T17:21:53.235-06:00  INFO 2166 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
Hibernate: alter table dbdev.cancion drop foreign key FKkoeqsbikkwgjhfa5mv9ybfq5a
2024-01-23T17:21:53.246-06:00  WARN 2166 --- [           main] o.h.t.s.i.ExceptionHandlerLoggedImpl     : GenerationTarget encountered exception accepting command : Error executing DDL "alter table dbdev.cancion drop foreign key FKkoeqsbikkwgjhfa5mv9ybfq5a" via JDBC [Table 'dbdev.cancion' doesn't exist]

org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "alter table dbdev.cancion drop foreign key FKkoeqsbikkwgjhfa5mv9ybfq5a" via JDBC [Table 'dbdev.cancion' doesn't exist]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:94) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlString(Helper.java:233) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlStrings(Helper.java:217) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.applyConstraintDropping(SchemaDropperImpl.java:470) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropConstraintsTablesSequences(SchemaDropperImpl.java:242) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropFromMetadata(SchemaDropperImpl.java:215) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.performDrop(SchemaDropperImpl.java:185) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:155) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:115) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:244) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.lambda$process$5(SchemaManagementToolCoordinator.java:145) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at java.base/java.util.HashMap.forEach(HashMap.java:1421) ~[na:na]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:142) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.boot.internal.SessionFactoryObserverForSchemaExport.sessionFactoryCreated(SessionFactoryObserverForSchemaExport.java:37) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.internal.SessionFactoryObserverChain.sessionFactoryCreated(SessionFactoryObserverChain.java:35) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:315) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:450) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1507) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:75) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:376) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:352) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1820) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1769) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:599) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1232) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:950) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:625) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:762) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:464) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:334) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1358) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1347) ~[spring-boot-3.2.1.jar:3.2.1]
	at com.rodriguez.pruebas.PruebasApplication.main(PruebasApplication.java:28) ~[classes/:na]
Caused by: java.sql.SQLSyntaxErrorException: Table 'dbdev.cancion' doesn't exist
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:121) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.StatementImpl.executeInternal(StatementImpl.java:767) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.StatementImpl.execute(StatementImpl.java:652) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94) ~[HikariCP-5.0.1.jar:na]
	at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java) ~[HikariCP-5.0.1.jar:na]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:80) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	... 40 common frames omitted

Hibernate: alter table dbdev.ccancion drop foreign key FKctopd9ibbcmft5p9j6207b6rb
2024-01-23T17:21:53.249-06:00  WARN 2166 --- [           main] o.h.t.s.i.ExceptionHandlerLoggedImpl     : GenerationTarget encountered exception accepting command : Error executing DDL "alter table dbdev.ccancion drop foreign key FKctopd9ibbcmft5p9j6207b6rb" via JDBC [Table 'dbdev.ccancion' doesn't exist]

org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "alter table dbdev.ccancion drop foreign key FKctopd9ibbcmft5p9j6207b6rb" via JDBC [Table 'dbdev.ccancion' doesn't exist]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:94) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlString(Helper.java:233) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlStrings(Helper.java:217) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.applyConstraintDropping(SchemaDropperImpl.java:470) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropConstraintsTablesSequences(SchemaDropperImpl.java:242) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropFromMetadata(SchemaDropperImpl.java:215) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.performDrop(SchemaDropperImpl.java:185) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:155) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:115) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:244) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.lambda$process$5(SchemaManagementToolCoordinator.java:145) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at java.base/java.util.HashMap.forEach(HashMap.java:1421) ~[na:na]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:142) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.boot.internal.SessionFactoryObserverForSchemaExport.sessionFactoryCreated(SessionFactoryObserverForSchemaExport.java:37) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.internal.SessionFactoryObserverChain.sessionFactoryCreated(SessionFactoryObserverChain.java:35) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:315) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:450) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1507) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:75) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:376) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:352) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1820) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1769) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:599) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1232) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:950) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:625) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:762) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:464) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:334) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1358) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1347) ~[spring-boot-3.2.1.jar:3.2.1]
	at com.rodriguez.pruebas.PruebasApplication.main(PruebasApplication.java:28) ~[classes/:na]
Caused by: java.sql.SQLSyntaxErrorException: Table 'dbdev.ccancion' doesn't exist
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:121) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.StatementImpl.executeInternal(StatementImpl.java:767) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.StatementImpl.execute(StatementImpl.java:652) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94) ~[HikariCP-5.0.1.jar:na]
	at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java) ~[HikariCP-5.0.1.jar:na]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:80) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	... 40 common frames omitted

Hibernate: alter table dbdev.libro_escritor drop foreign key FKnd82f6r1exglb0bbpjwm0ond6
2024-01-23T17:21:53.250-06:00  WARN 2166 --- [           main] o.h.t.s.i.ExceptionHandlerLoggedImpl     : GenerationTarget encountered exception accepting command : Error executing DDL "alter table dbdev.libro_escritor drop foreign key FKnd82f6r1exglb0bbpjwm0ond6" via JDBC [Table 'dbdev.libro_escritor' doesn't exist]

org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "alter table dbdev.libro_escritor drop foreign key FKnd82f6r1exglb0bbpjwm0ond6" via JDBC [Table 'dbdev.libro_escritor' doesn't exist]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:94) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlString(Helper.java:233) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlStrings(Helper.java:217) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.applyConstraintDropping(SchemaDropperImpl.java:470) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropConstraintsTablesSequences(SchemaDropperImpl.java:242) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropFromMetadata(SchemaDropperImpl.java:215) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.performDrop(SchemaDropperImpl.java:185) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:155) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:115) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:244) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.lambda$process$5(SchemaManagementToolCoordinator.java:145) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at java.base/java.util.HashMap.forEach(HashMap.java:1421) ~[na:na]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:142) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.boot.internal.SessionFactoryObserverForSchemaExport.sessionFactoryCreated(SessionFactoryObserverForSchemaExport.java:37) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.internal.SessionFactoryObserverChain.sessionFactoryCreated(SessionFactoryObserverChain.java:35) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:315) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:450) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1507) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:75) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:376) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:352) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1820) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1769) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:599) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1232) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:950) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:625) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:762) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:464) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:334) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1358) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1347) ~[spring-boot-3.2.1.jar:3.2.1]
	at com.rodriguez.pruebas.PruebasApplication.main(PruebasApplication.java:28) ~[classes/:na]
Caused by: java.sql.SQLSyntaxErrorException: Table 'dbdev.libro_escritor' doesn't exist
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:121) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.StatementImpl.executeInternal(StatementImpl.java:767) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.StatementImpl.execute(StatementImpl.java:652) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94) ~[HikariCP-5.0.1.jar:na]
	at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java) ~[HikariCP-5.0.1.jar:na]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:80) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	... 40 common frames omitted

Hibernate: alter table dbdev.libro_escritor drop foreign key FKesq51snm36vikdx5caqqgwxcu
2024-01-23T17:21:53.251-06:00  WARN 2166 --- [           main] o.h.t.s.i.ExceptionHandlerLoggedImpl     : GenerationTarget encountered exception accepting command : Error executing DDL "alter table dbdev.libro_escritor drop foreign key FKesq51snm36vikdx5caqqgwxcu" via JDBC [Table 'dbdev.libro_escritor' doesn't exist]

org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "alter table dbdev.libro_escritor drop foreign key FKesq51snm36vikdx5caqqgwxcu" via JDBC [Table 'dbdev.libro_escritor' doesn't exist]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:94) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlString(Helper.java:233) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlStrings(Helper.java:217) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.applyConstraintDropping(SchemaDropperImpl.java:470) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropConstraintsTablesSequences(SchemaDropperImpl.java:242) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropFromMetadata(SchemaDropperImpl.java:215) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.performDrop(SchemaDropperImpl.java:185) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:155) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:115) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:244) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.lambda$process$5(SchemaManagementToolCoordinator.java:145) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at java.base/java.util.HashMap.forEach(HashMap.java:1421) ~[na:na]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:142) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.boot.internal.SessionFactoryObserverForSchemaExport.sessionFactoryCreated(SessionFactoryObserverForSchemaExport.java:37) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.internal.SessionFactoryObserverChain.sessionFactoryCreated(SessionFactoryObserverChain.java:35) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:315) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:450) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1507) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:75) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:376) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:352) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1820) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1769) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:599) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1232) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:950) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:625) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:762) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:464) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:334) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1358) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1347) ~[spring-boot-3.2.1.jar:3.2.1]
	at com.rodriguez.pruebas.PruebasApplication.main(PruebasApplication.java:28) ~[classes/:na]
Caused by: java.sql.SQLSyntaxErrorException: Table 'dbdev.libro_escritor' doesn't exist
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:121) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.StatementImpl.executeInternal(StatementImpl.java:767) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.StatementImpl.execute(StatementImpl.java:652) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94) ~[HikariCP-5.0.1.jar:na]
	at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java) ~[HikariCP-5.0.1.jar:na]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:80) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	... 40 common frames omitted

Hibernate: drop table if exists dbdev.aartista
Hibernate: drop table if exists dbdev.artista
Hibernate: drop table if exists dbdev.cancion
Hibernate: drop table if exists dbdev.ccancion
Hibernate: drop table if exists dbdev.curso
Hibernate: drop table if exists dbdev.escritor
Hibernate: drop table if exists dbdev.estudiante
Hibernate: drop table if exists dbdev.libro
Hibernate: drop table if exists dbdev.libro_escritor
Hibernate: drop table if exists dbdev.personaje
Hibernate: alter table inventario_facturacion.cliente_abona drop foreign key FK7px57p1vlvgqvsk7hy3ljgenc
2024-01-23T17:21:53.264-06:00  WARN 2166 --- [           main] o.h.t.s.i.ExceptionHandlerLoggedImpl     : GenerationTarget encountered exception accepting command : Error executing DDL "alter table inventario_facturacion.cliente_abona drop foreign key FK7px57p1vlvgqvsk7hy3ljgenc" via JDBC [Table 'inventario_facturacion.cliente_abona' doesn't exist]

org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "alter table inventario_facturacion.cliente_abona drop foreign key FK7px57p1vlvgqvsk7hy3ljgenc" via JDBC [Table 'inventario_facturacion.cliente_abona' doesn't exist]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:94) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlString(Helper.java:233) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlStrings(Helper.java:217) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.applyConstraintDropping(SchemaDropperImpl.java:470) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropConstraintsTablesSequences(SchemaDropperImpl.java:242) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropFromMetadata(SchemaDropperImpl.java:215) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.performDrop(SchemaDropperImpl.java:185) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:155) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:115) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:244) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.lambda$process$5(SchemaManagementToolCoordinator.java:145) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at java.base/java.util.HashMap.forEach(HashMap.java:1421) ~[na:na]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:142) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.boot.internal.SessionFactoryObserverForSchemaExport.sessionFactoryCreated(SessionFactoryObserverForSchemaExport.java:37) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.internal.SessionFactoryObserverChain.sessionFactoryCreated(SessionFactoryObserverChain.java:35) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:315) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:450) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1507) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:75) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:376) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:352) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1820) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1769) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:599) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1232) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:950) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:625) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:762) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:464) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:334) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1358) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1347) ~[spring-boot-3.2.1.jar:3.2.1]
	at com.rodriguez.pruebas.PruebasApplication.main(PruebasApplication.java:28) ~[classes/:na]
Caused by: java.sql.SQLSyntaxErrorException: Table 'inventario_facturacion.cliente_abona' doesn't exist
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:121) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.StatementImpl.executeInternal(StatementImpl.java:767) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.StatementImpl.execute(StatementImpl.java:652) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94) ~[HikariCP-5.0.1.jar:na]
	at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java) ~[HikariCP-5.0.1.jar:na]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:80) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	... 40 common frames omitted

Hibernate: alter table inventario_facturacion.cliente_abona drop foreign key FK87vei7j6jlrbu2jaosy9cncjh
2024-01-23T17:21:53.265-06:00  WARN 2166 --- [           main] o.h.t.s.i.ExceptionHandlerLoggedImpl     : GenerationTarget encountered exception accepting command : Error executing DDL "alter table inventario_facturacion.cliente_abona drop foreign key FK87vei7j6jlrbu2jaosy9cncjh" via JDBC [Table 'inventario_facturacion.cliente_abona' doesn't exist]

org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "alter table inventario_facturacion.cliente_abona drop foreign key FK87vei7j6jlrbu2jaosy9cncjh" via JDBC [Table 'inventario_facturacion.cliente_abona' doesn't exist]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:94) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlString(Helper.java:233) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlStrings(Helper.java:217) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.applyConstraintDropping(SchemaDropperImpl.java:470) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropConstraintsTablesSequences(SchemaDropperImpl.java:242) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropFromMetadata(SchemaDropperImpl.java:215) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.performDrop(SchemaDropperImpl.java:185) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:155) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:115) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:244) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.lambda$process$5(SchemaManagementToolCoordinator.java:145) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at java.base/java.util.HashMap.forEach(HashMap.java:1421) ~[na:na]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:142) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.boot.internal.SessionFactoryObserverForSchemaExport.sessionFactoryCreated(SessionFactoryObserverForSchemaExport.java:37) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.internal.SessionFactoryObserverChain.sessionFactoryCreated(SessionFactoryObserverChain.java:35) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:315) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:450) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1507) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:75) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:376) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:352) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1820) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1769) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:599) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1232) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:950) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:625) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:762) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:464) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:334) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1358) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1347) ~[spring-boot-3.2.1.jar:3.2.1]
	at com.rodriguez.pruebas.PruebasApplication.main(PruebasApplication.java:28) ~[classes/:na]
Caused by: java.sql.SQLSyntaxErrorException: Table 'inventario_facturacion.cliente_abona' doesn't exist
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:121) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.StatementImpl.executeInternal(StatementImpl.java:767) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.StatementImpl.execute(StatementImpl.java:652) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94) ~[HikariCP-5.0.1.jar:na]
	at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java) ~[HikariCP-5.0.1.jar:na]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:80) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	... 40 common frames omitted

Hibernate: alter table inventario_facturacion.factura drop foreign key FKarq3cr11iiegh05de5ty51bmt
2024-01-23T17:21:53.266-06:00  WARN 2166 --- [           main] o.h.t.s.i.ExceptionHandlerLoggedImpl     : GenerationTarget encountered exception accepting command : Error executing DDL "alter table inventario_facturacion.factura drop foreign key FKarq3cr11iiegh05de5ty51bmt" via JDBC [Table 'inventario_facturacion.factura' doesn't exist]

org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "alter table inventario_facturacion.factura drop foreign key FKarq3cr11iiegh05de5ty51bmt" via JDBC [Table 'inventario_facturacion.factura' doesn't exist]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:94) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlString(Helper.java:233) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlStrings(Helper.java:217) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.applyConstraintDropping(SchemaDropperImpl.java:470) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropConstraintsTablesSequences(SchemaDropperImpl.java:242) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropFromMetadata(SchemaDropperImpl.java:215) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.performDrop(SchemaDropperImpl.java:185) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:155) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:115) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:244) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.lambda$process$5(SchemaManagementToolCoordinator.java:145) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at java.base/java.util.HashMap.forEach(HashMap.java:1421) ~[na:na]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:142) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.boot.internal.SessionFactoryObserverForSchemaExport.sessionFactoryCreated(SessionFactoryObserverForSchemaExport.java:37) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.internal.SessionFactoryObserverChain.sessionFactoryCreated(SessionFactoryObserverChain.java:35) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:315) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:450) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1507) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:75) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:376) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:352) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1820) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1769) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:599) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1232) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:950) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:625) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:762) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:464) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:334) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1358) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1347) ~[spring-boot-3.2.1.jar:3.2.1]
	at com.rodriguez.pruebas.PruebasApplication.main(PruebasApplication.java:28) ~[classes/:na]
Caused by: java.sql.SQLSyntaxErrorException: Table 'inventario_facturacion.factura' doesn't exist
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:121) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.StatementImpl.executeInternal(StatementImpl.java:767) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.StatementImpl.execute(StatementImpl.java:652) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94) ~[HikariCP-5.0.1.jar:na]
	at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java) ~[HikariCP-5.0.1.jar:na]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:80) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	... 40 common frames omitted

Hibernate: alter table inventario_facturacion.factura_detalle drop foreign key FK82g5tpb19dn0ed3dh8rjepfeo
2024-01-23T17:21:53.267-06:00  WARN 2166 --- [           main] o.h.t.s.i.ExceptionHandlerLoggedImpl     : GenerationTarget encountered exception accepting command : Error executing DDL "alter table inventario_facturacion.factura_detalle drop foreign key FK82g5tpb19dn0ed3dh8rjepfeo" via JDBC [Table 'inventario_facturacion.factura_detalle' doesn't exist]

org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "alter table inventario_facturacion.factura_detalle drop foreign key FK82g5tpb19dn0ed3dh8rjepfeo" via JDBC [Table 'inventario_facturacion.factura_detalle' doesn't exist]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:94) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlString(Helper.java:233) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlStrings(Helper.java:217) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.applyConstraintDropping(SchemaDropperImpl.java:470) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropConstraintsTablesSequences(SchemaDropperImpl.java:242) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropFromMetadata(SchemaDropperImpl.java:215) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.performDrop(SchemaDropperImpl.java:185) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:155) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:115) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:244) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.lambda$process$5(SchemaManagementToolCoordinator.java:145) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at java.base/java.util.HashMap.forEach(HashMap.java:1421) ~[na:na]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:142) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.boot.internal.SessionFactoryObserverForSchemaExport.sessionFactoryCreated(SessionFactoryObserverForSchemaExport.java:37) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.internal.SessionFactoryObserverChain.sessionFactoryCreated(SessionFactoryObserverChain.java:35) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:315) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:450) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1507) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:75) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:376) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:352) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1820) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1769) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:599) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1232) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:950) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:625) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:762) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:464) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:334) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1358) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1347) ~[spring-boot-3.2.1.jar:3.2.1]
	at com.rodriguez.pruebas.PruebasApplication.main(PruebasApplication.java:28) ~[classes/:na]
Caused by: java.sql.SQLSyntaxErrorException: Table 'inventario_facturacion.factura_detalle' doesn't exist
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:121) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.StatementImpl.executeInternal(StatementImpl.java:767) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.StatementImpl.execute(StatementImpl.java:652) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94) ~[HikariCP-5.0.1.jar:na]
	at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java) ~[HikariCP-5.0.1.jar:na]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:80) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	... 40 common frames omitted

Hibernate: alter table inventario_facturacion.factura_detalle drop foreign key FK49cxxxb69hbp79ot7q72d1amt
2024-01-23T17:21:53.268-06:00  WARN 2166 --- [           main] o.h.t.s.i.ExceptionHandlerLoggedImpl     : GenerationTarget encountered exception accepting command : Error executing DDL "alter table inventario_facturacion.factura_detalle drop foreign key FK49cxxxb69hbp79ot7q72d1amt" via JDBC [Table 'inventario_facturacion.factura_detalle' doesn't exist]

org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "alter table inventario_facturacion.factura_detalle drop foreign key FK49cxxxb69hbp79ot7q72d1amt" via JDBC [Table 'inventario_facturacion.factura_detalle' doesn't exist]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:94) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlString(Helper.java:233) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlStrings(Helper.java:217) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.applyConstraintDropping(SchemaDropperImpl.java:470) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropConstraintsTablesSequences(SchemaDropperImpl.java:242) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropFromMetadata(SchemaDropperImpl.java:215) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.performDrop(SchemaDropperImpl.java:185) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:155) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:115) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:244) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.lambda$process$5(SchemaManagementToolCoordinator.java:145) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at java.base/java.util.HashMap.forEach(HashMap.java:1421) ~[na:na]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:142) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.boot.internal.SessionFactoryObserverForSchemaExport.sessionFactoryCreated(SessionFactoryObserverForSchemaExport.java:37) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.internal.SessionFactoryObserverChain.sessionFactoryCreated(SessionFactoryObserverChain.java:35) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:315) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:450) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1507) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:75) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:376) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:352) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1820) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1769) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:599) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1232) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:950) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:625) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:762) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:464) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:334) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1358) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1347) ~[spring-boot-3.2.1.jar:3.2.1]
	at com.rodriguez.pruebas.PruebasApplication.main(PruebasApplication.java:28) ~[classes/:na]
Caused by: java.sql.SQLSyntaxErrorException: Table 'inventario_facturacion.factura_detalle' doesn't exist
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:121) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.StatementImpl.executeInternal(StatementImpl.java:767) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.StatementImpl.execute(StatementImpl.java:652) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94) ~[HikariCP-5.0.1.jar:na]
	at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java) ~[HikariCP-5.0.1.jar:na]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:80) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	... 40 common frames omitted

Hibernate: alter table inventario_facturacion.inventario drop foreign key FK2jpmjsxwl42blfea24vda6fs6
2024-01-23T17:21:53.268-06:00  WARN 2166 --- [           main] o.h.t.s.i.ExceptionHandlerLoggedImpl     : GenerationTarget encountered exception accepting command : Error executing DDL "alter table inventario_facturacion.inventario drop foreign key FK2jpmjsxwl42blfea24vda6fs6" via JDBC [Table 'inventario_facturacion.inventario' doesn't exist]

org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "alter table inventario_facturacion.inventario drop foreign key FK2jpmjsxwl42blfea24vda6fs6" via JDBC [Table 'inventario_facturacion.inventario' doesn't exist]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:94) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlString(Helper.java:233) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlStrings(Helper.java:217) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.applyConstraintDropping(SchemaDropperImpl.java:470) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropConstraintsTablesSequences(SchemaDropperImpl.java:242) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropFromMetadata(SchemaDropperImpl.java:215) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.performDrop(SchemaDropperImpl.java:185) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:155) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:115) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:244) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.lambda$process$5(SchemaManagementToolCoordinator.java:145) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at java.base/java.util.HashMap.forEach(HashMap.java:1421) ~[na:na]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:142) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.boot.internal.SessionFactoryObserverForSchemaExport.sessionFactoryCreated(SessionFactoryObserverForSchemaExport.java:37) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.internal.SessionFactoryObserverChain.sessionFactoryCreated(SessionFactoryObserverChain.java:35) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:315) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:450) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1507) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:75) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:376) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:352) ~[spring-orm-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1820) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1769) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:599) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[spring-beans-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1232) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:950) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:625) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:762) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:464) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:334) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1358) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1347) ~[spring-boot-3.2.1.jar:3.2.1]
	at com.rodriguez.pruebas.PruebasApplication.main(PruebasApplication.java:28) ~[classes/:na]
Caused by: java.sql.SQLSyntaxErrorException: Table 'inventario_facturacion.inventario' doesn't exist
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:121) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.StatementImpl.executeInternal(StatementImpl.java:767) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.mysql.cj.jdbc.StatementImpl.execute(StatementImpl.java:652) ~[mysql-connector-j-8.2.0.jar:8.2.0]
	at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94) ~[HikariCP-5.0.1.jar:na]
	at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java) ~[HikariCP-5.0.1.jar:na]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:80) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
	... 40 common frames omitted

Hibernate: drop table if exists inventario_facturacion.cliente_abona
Hibernate: drop table if exists inventario_facturacion.factura
Hibernate: drop table if exists inventario_facturacion.factura_detalle
Hibernate: drop table if exists inventario_facturacion.imagen_producto
Hibernate: drop table if exists inventario_facturacion.ingresos_egresos
Hibernate: drop table if exists inventario_facturacion.inventario
Hibernate: drop table if exists inventario_facturacion.producto
Hibernate: drop table if exists inventario_facturacion.usuario
Hibernate: create table dbdev.aartista (id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table dbdev.artista (id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table dbdev.cancion (artista_id integer, id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table dbdev.ccancion (fk_aartista_id integer, id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table dbdev.curso (id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table dbdev.escritor (id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table dbdev.estudiante (id integer not null auto_increment, nombre varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table dbdev.libro (id integer not null auto_increment, titulo varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table dbdev.libro_escritor (escritor_id integer not null, libro_id integer not null) engine=InnoDB
Hibernate: create table dbdev.personaje (id integer not null auto_increment, puntos decimal(38,2), fecha_guardado datetime(6), nombre varchar(27), primary key (id)) engine=InnoDB
Hibernate: alter table dbdev.artista add constraint UK_7ptc116swarkeb8akjo5tdm2l unique (nombre)
Hibernate: alter table dbdev.personaje add constraint UK_3ux5ftu5rl5p8ijhl2bel9ujv unique (nombre)
Hibernate: create table inventario_facturacion.cliente_abona (abonos decimal(38,2), cargos decimal(38,2), factura_id integer, id integer not null auto_increment, saldo decimal(38,2), saldo_anterior decimal(38,2), usuario_id integer, fecha datetime(6), detalles varchar(512), primary key (id)) engine=InnoDB
Hibernate: create table inventario_facturacion.factura (costo_total decimal(38,2) not null, ganancia decimal(38,2) not null, id integer not null auto_increment, iva decimal(38,2) not null, subtotal_sin_iva decimal(38,2) not null, tipo_pago varchar(1), total decimal(38,2) not null, usuario_id integer, fecha_devolucion datetime(6), fecha_emision datetime(6), nombre_completo varchar(255) not null, primary key (id)) engine=InnoDB
Hibernate: create table inventario_facturacion.factura_detalle (cantidad_producto_vendido integer not null, costo_del_subtotal_por_producto decimal(38,2), costo_unidad decimal(38,2), factura_id integer, ganancia_del_subtotal_por_producto decimal(38,2), ganancia_unidad decimal(38,2), id integer not null auto_increment, iva_del_subtotal_por_producto decimal(38,2), precio_venta_por_producto decimal(38,2) not null, producto_id integer, subtotal_por_producto decimal(38,2), nombre_producto varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table inventario_facturacion.imagen_producto (id integer not null auto_increment, archivo LONGBLOB, imagen LONGBLOB, primary key (id)) engine=InnoDB
Hibernate: create table inventario_facturacion.ingresos_egresos (egresos decimal(38,2), id integer not null auto_increment, ingresos decimal(38,2), fecha datetime(6), detalle varchar(512), primary key (id)) engine=InnoDB
Hibernate: create table inventario_facturacion.inventario (entradas integer, existencia integer, id integer not null auto_increment, producto_id integer, saldo_anterior integer, salidas integer, fecha datetime(6), primary key (id)) engine=InnoDB
Hibernate: create table inventario_facturacion.producto (costo_unidad decimal(38,2) not null, existencias integer not null, ganancia decimal(38,2) not null, id integer not null auto_increment, precio_venta decimal(38,2) not null, fecha_adquisicion datetime(6), fecha_modificado datetime(6), nombre varchar(512) not null, primary key (id)) engine=InnoDB
Hibernate: create table inventario_facturacion.usuario (id integer not null auto_increment, pendiente_de_pago decimal(38,2), comentarios varchar(512), apellido varchar(255), apellido_dos varchar(255), nombre varchar(255) not null, nombre_completo varchar(255), nombre_dos varchar(255), primary key (id)) engine=InnoDB
Hibernate: alter table inventario_facturacion.producto add constraint UK_9su14n91mtgcg5ehl658v4afx unique (nombre)
Hibernate: alter table dbdev.cancion add constraint FKkoeqsbikkwgjhfa5mv9ybfq5a foreign key (artista_id) references dbdev.artista (id)
Hibernate: alter table dbdev.ccancion add constraint FKctopd9ibbcmft5p9j6207b6rb foreign key (fk_aartista_id) references dbdev.aartista (id)
Hibernate: alter table dbdev.libro_escritor add constraint FKnd82f6r1exglb0bbpjwm0ond6 foreign key (escritor_id) references dbdev.escritor (id)
Hibernate: alter table dbdev.libro_escritor add constraint FKesq51snm36vikdx5caqqgwxcu foreign key (libro_id) references dbdev.libro (id)
Hibernate: alter table inventario_facturacion.cliente_abona add constraint FK7px57p1vlvgqvsk7hy3ljgenc foreign key (usuario_id) references inventario_facturacion.usuario (id)
Hibernate: alter table inventario_facturacion.cliente_abona add constraint FK87vei7j6jlrbu2jaosy9cncjh foreign key (factura_id) references inventario_facturacion.factura (id)
Hibernate: alter table inventario_facturacion.factura add constraint FKarq3cr11iiegh05de5ty51bmt foreign key (usuario_id) references inventario_facturacion.usuario (id)
Hibernate: alter table inventario_facturacion.factura_detalle add constraint FK82g5tpb19dn0ed3dh8rjepfeo foreign key (factura_id) references inventario_facturacion.factura (id)
Hibernate: alter table inventario_facturacion.factura_detalle add constraint FK49cxxxb69hbp79ot7q72d1amt foreign key (producto_id) references inventario_facturacion.producto (id)
Hibernate: alter table inventario_facturacion.inventario add constraint FK2jpmjsxwl42blfea24vda6fs6 foreign key (producto_id) references inventario_facturacion.producto (id)
2024-01-23T17:21:53.416-06:00  INFO 2166 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2024-01-23T17:21:53.919-06:00  INFO 2166 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8089 (http) with context path ''
2024-01-23T17:21:53.924-06:00  INFO 2166 --- [           main] c.rodriguez.pruebas.PruebasApplication   : Started PruebasApplication in 2.257 seconds (process running for 2.402)


