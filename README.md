## automation-assesment-

Completed with selenium with POM design pattren +, Tested on Chrome only as maven project

## How to run it (installation)

Install: java jdk 1.8, chrome latest version
git clone
Build module WalletHub-app with Maven
Insert credentials (insert credentials for facebook login/pass in tests class)

## Add credentials (Usage)
public class FacebookAutomationTest {
    private static final String FB_LOGIN_URL = "https://www.facebook.com/";
    private static final String FB_EMAIL = "";
    private static final String FB_PASSWORD = "";
    private static final String STATUS_MESSAGE = "Hello World";
    
Insert credentials (insert credentials for wallethub login/pass in tests class)
public class WalletHubTest {
    private static final String WH_LOGIN_URL = "https://wallethub.com/join/light";
    static String subUrls = "https://wallethub.com/profile/13732055i";
    private static final String WH_EMAIL = "";
    private static final String WH_PASSWORD = "";

## How to run
Run Facebook/Wallethub tests with Run As (1 java application)

## Author
Harris Ahmed Butt
