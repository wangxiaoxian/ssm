set RELEASE_HOME=E:\deploy
mvn -Dmaven.test.skip=true  -Dmaven.compile.fork=true clean package assembly:assembly -U
echo "deploying..."
xcopy /y /i target\hdc-all\*.* %RELEASE_HOME%\ /s /e
