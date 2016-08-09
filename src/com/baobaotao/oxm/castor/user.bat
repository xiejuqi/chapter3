@echo off
REM Change the following line to set your JDK path
set JAVA_HOME=%JAVA_HOME%
set JAVA=%JAVA_HOME%\bin\Java
set JAVAC=%JAVA_HOME%\bin\Javac
@echo Create the classpath
set CP=.
for %%i in (lib\*.jar) do call cp.bat %%i
set CP=%CP%;%JDK_BIN%\lib\toos.jar
@echo.
@echo Using classpath:%CP%
@echo Castor Test Cases
@echo.
@echo Generating classes...
@rem Java 2 style collection types
@rem %JAVA% org.exolab.castor.builder.SourceGeneratorMain -i invoice.xsd -f -types j2 -binding-file bindingInvoice.xml
@rem Java 1.1 collection types
%JAVA% -cp %CP% org.exolab.castor.builder.SourceGeneratorMain -i user.xsd -types j2 -package com.baobaotao.oxm.castor
@echo.
@pause

REM 使用user.bat脚本命令生成Castor中的类时需要将user.bat和cp.bat以及user.xsd文件放在WEB-INF目录下，执行user.bat时将在WEB-INF目录下生成对应的Java类