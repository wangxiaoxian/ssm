ps -ef | grep com.aspire.jshdc.pay.dubbo.PayApplicationDubbo | grep -v grep | awk '{print $2}' | xargs kill -9
