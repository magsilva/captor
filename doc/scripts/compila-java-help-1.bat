cls

rem ----------EDIT THIS VALUES TO RUN------------
rem ---------------------------------------------

rem NÃO PODE TER ESPAÇO NO PATH DA VARIÁVEL JAVAHELP_HOME!!!

SET INSTALL_DIR=C:\Dev\Captor
SET JAVA="C:\ArqPrg\jdk1.5.0\bin\java.exe"

rem ---------------------------------------------
rem ---------------------------------------------
rem ---------------------------------------------

SET CLASSPATH=%CLASSPATH%;%JAVAHELP_HOME%\\javahelp\\lib\\jhall.jar
SET PATH=%PATH%;%JAVAHELP_HOME%\\javahelp\\bin
SET JAVAHELP_HOME="%INSTALL_DIR%\dev\libdev\jh2.0"
SET DOCBOOK_XSL_JH_FILE="%INSTALL_DIR%\dev\libdev\docbook-xsl-1.69.1\javahelp\javahelp.xsl"
SET CLASSPATH=%CLASSPATH%;%INSTALL_DIR%\dev\libdev\saxon6_5_3\saxon.jar
SET JHDIR="%INSTALL_DIR%\res\help\output"
SET SRC="%INSTALL_DIR%\res\help\src\application.xml"
SET SCRIPTDIR="%INSTALL_DIR%\dev\scripts"
SET JHINDEXER=jhindexer.bat

rem ---------------------------------------------
rem FAZER A GERAÇÃO DO JAVA HELP

cd %JHDIR%
%JAVA% com.icl.saxon.StyleSheet %SRC% %DOCBOOK_XSL_JH_FILE%

cd %SCRIPTDIR%

rem ---------------------------------------------
