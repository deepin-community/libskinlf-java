set THEMEPACK=%1
IF "%THEMEPACK%"=="" SET THEMEPACK=..\lib\themepack.zip
java -classpath ..\lib\skinlf.jar;..\lib\examples.jar examples.demo %THEMEPACK% %2 %3 %4 %5 %6 %7 %8 %9
