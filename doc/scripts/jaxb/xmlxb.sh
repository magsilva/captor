# export CLASSPATH=$CLASSPATH:/opt/jaxb-ri-20070917/lib/jaxb-api.jar:/opt/jaxb-ri-20070917/lib/jaxb-impl.jar:/opt/jaxb-ri-20070917/lib/jaxb-xjc.jar
# export PATH=$PATH:/opt/jaxb-ri-20070917/bin
# xjc.sh -p captor.domainsystem domain.xsd -d tmp -classpath /home/magsilva/Projects-ICMC/Captor/bin
# xjc.sh -p captor.projectsystem.build.mapper rules.xsd -d tmp -classpath /home/magsilva/Projects-ICMC/Captor/bin

xjc.sh domain.xsd -d ../../../src/ -classpath /home/magsilva/Projects-ICMC/Captor/bin
xjc.sh rules.xsd -d ../../../src/ -classpath /home/magsilva/Projects-ICMC/Captor/bin
