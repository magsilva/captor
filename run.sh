export CLASSPATH=$CLASSPATH:/opt/javahelp-2.0_05/javahelp/lib/jhall.jar:/opt/jaxb-ri-20070917/lib/jaxb-api.jar:/opt/jaxb-ri-20070917/lib/jaxb-impl.jar:/opt/jaxb-ri-20070917/lib/jsr173_1.0_api.jar:/opt/jaxb-ri-20070917/lib/activation.jar:/opt/jakarta-commons-io-1.3.2/commons-io-1.3.2.jar:/opt/ant-1.7.0/lib/ant.jar:/opt/ant-1.7.0/lib/ant-launcher.jar:/opt/xalan-2.7.0/xalan.jar:/opt/xalan-2.7.0/xml-apis.jar:/opt/jakarta-commons-cli-1.1/commons-cli-1.1.jar
pushd bin
java -Djava.endorsed.dirs=/opt/jaxb-ri-20070917/lib captor.Captor
popd
