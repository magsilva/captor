cls

rem ----------EDIT THIS VALUES TO RUN------------
rem ---------------------------------------------

SET INSTALL_DIR=C:\Dev\Captor
SET JAVA=C:\ArqPrg\jdk1.5.0\bin\java.exe

rem ---------------------------------------------
rem ---------------------------------------------
rem ---------------------------------------------

SET CLASSPATH=%INSTALL_DIR%\dev\libdev\saxon6_5_3\saxon.jar;%INSTALL_DIR%\dev\libdev\fop-0.20.5\build\fop.jar
SET SRC="%INSTALL_DIR%\res\help\src\application.xml"
SET PDF_OUTPUT_FO="%INSTALL_DIR%\doc\manual\Captor.fo"
SET PDF_OUTPUT="%INSTALL_DIR%\doc\manual\Captor.pdf"
SET PDF_TEMPLATE="%INSTALL_DIR%\dev\libdev\docbook-xsl-1.69.1\fo\docbook.xsl" 

SET FOP=%INSTALL_DIR%\dev\libdev\fop-0.20.5\fop.bat

rem ---------------------------------------------

%JAVA% com.icl.saxon.StyleSheet %SRC% %PDF_TEMPLATE% > %PDF_OUTPUT_FO%
%FOP% %PDF_OUTPUT_FO% %PDF_OUTPUT%
DEL %PDF_OUTPUT_FO%
rem ---------------------------------------------
