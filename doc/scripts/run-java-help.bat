cls

rem ----------EDIT THIS VALUES TO RUN------------
rem ---------------------------------------------

rem NÃO PODE TER ESPAÇO NO PATH DA VARIÁVEL JAVAHELP_HOME!!!

SET INSTALL_DIR=C:\Dev\Captor
SET JAVA=C:\\ArqPrg\\jdk1.5.0\\bin\\java.exe

rem ---------------------------------------------
rem ---------------------------------------------
rem ---------------------------------------------

SET JAVAHELP_HOME="%INSTALL_DIR%\dev\libdev\jh2.0"
SET CLASSPATH=%CLASSPATH%;%JAVAHELP_HOME%\\javahelp\\lib\\jhall.jar
SET PATH=%PATH%;%JAVAHELP_HOME%\\javahelp\\bin

rem ---------------------------------------------

%JAVA% -jar "%JAVAHELP_HOME%\demos\bin\hsviewer.jar" -helpset "%INSTALL_DIR%\res\help\output\jhelpset.hs"