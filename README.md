# J2EE

https://dzone.com/articles/how-use-glassfish-managed-jpa

How to use GlassFish Managed JPA EntityManager in Spring
  by Ryan Developer  ·  Aug. 11, 09 · Java Zone · Not set
Like (0)
  Comment (8)
Save   Tweet  17.34k Views
Join the DZone community and get the full member experience. JOIN FOR FREE
How do you break a Monolith into Microservices at Scale? This ebook shows strategies and techniques for building scalable and resilient microservices.
When you deploy your application into a Java EE 5 application server it detects the persistence.xml, creates an EntityManager for each persistence unit, and exposes them in JNDI. You can get Spring to load the EntityManagers of all your persistence units from JNDI. First you need to tell web.xml that you want to load the persistence unit references from JNDI. The JNDI name always starts with "persistence/" and ends with the persistence unit name. For example:

 <persistence-unit-ref>
   <persistence-unit-ref-name>persistence/MyPU1</persistence-unit-ref-name>
   <persistence-unit-name>MyPU1</persistence-unit-name>
 </persistence-unit-ref>

 <persistence-unit-ref>
   <persistence-unit-ref-name>persistence/MyPU2</persistence-unit-ref-name>
   <persistence-unit-name>MyPU2</persistence-unit-name>
 </persistence-unit-ref>
 Next, add the following configuration to your Spring XML config file:

 <bean class="org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor" >
   <property name="persistenceUnits">
     <map>
       <entry key="MyPU1" value="persistence/MyPU1"/>
       <entry key="MyPU2" value="persistence/MyPU2"/>
     </map>
   </property>
 </bean>

 <tx:jta-transaction-manager/>
 <tx:annotation-driven/>
Spring is now configured to use the JPA EntityManagers and JTA transactions from GlassFish. Use persistence.xml, @PersistenceUnit, and @PersistenceContext like normal. Use Spring's proprietary @Transactional annotation for transaction demarcation.  If you need to query both persistence units within the same transaction then you need to use XA data sources.
