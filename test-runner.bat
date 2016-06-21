set projectLocation=C:\Users\Kairat_Doshekenov\IdeaProjects\email-test
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\src\main\resources\testng.xml
pause