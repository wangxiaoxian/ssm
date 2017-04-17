export CLASSPATH=$CLASSPATH:./config:./lib/*:./lib/thirdparty/*
>nohup.out
nohup java -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=18890  -Xmn128m -Xms1024m -Xmx1024m  com.aspire.jshdc.pay.dubbo.PayApplicationDubbo &
tail -f nohup.out
