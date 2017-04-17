set classpath=%classpath%;./config;./lib/*;./lib/thirdparty/*;
java -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=18890  -Xmn128m -Xms1024m -Xmx1024m com.aspire.jshdc.pay.dubbo.PayApplicationDubbo
