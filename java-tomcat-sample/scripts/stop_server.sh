
#!/bin/bash
isExistApp=`pgrep java`
if [[ -n  $isExistApp ]]; then
   # service tomcat8 stop
   # /usr/bin/tomcatdown
   /opt/apache-tomcat-9.0.35/bin/shutdown.sh
fi