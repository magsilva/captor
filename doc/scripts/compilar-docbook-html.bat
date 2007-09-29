cls

rem ----------EDIT THIS VALUES TO RUN------------
rem ---------------------------------------------

SET INSTALL_DIR=C:\Dev\Captor
SET JAVA=C:\ArqProg\jdk1.5.0\bin\java.exe

rem ---------------------------------------------
rem ---------------------------------------------
rem ---------------------------------------------

SET CLASSPATH=%INSTALL_DIR%\dev\libdev\saxon6_5_3\saxon.jar;%INSTALL_DIR%\dev\libdev\fop-0.20.5\build\fop.jar
SET SRC="%INSTALL_DIR%\res\help\src\application.xml"
SET HTML_OUTPUT="%INSTALL_DIR%\doc\manual\index.html"
rem SET HTML_TEMPLATE="%INSTALL_DIR%\dev\libdev\docbook-xsl-1.69.1\html\docbook.xsl" 
SET HTML_TEMPLATE="%INSTALL_DIR%\dev\libdev\docbook-xsl-1.69.1\html\chunk.xsl" 

rem ---------------------------------------------

%JAVA% -classpath %CLASSPATH% com.icl.saxon.StyleSheet %SRC% %HTML_TEMPLATE% >  %HTML_OUTPUT%

rem ---------------------------------------------
