# Automation-assesment

Completed with selenium with POM design pattren, Tested on Chrome only as maven project as per requrment. 

## How to run it (installation)

1. Install Java JDK 1.8 and the latest version of Chrome browser.
2. Clone the repository using `git clone`.
3. Build the `WalletHub-app` module with Maven.
4. Insert your credentials for Facebook login in the tests class.

## Add credentials (Usage)

### Insert credentials (insert credentials for FacebookAutomationTest login/pass in tests class)  
public class FacebookAutomationTest {  
    private static final String FB_LOGIN_URL = "https://www.facebook.com/";  
    private static final String FB_EMAIL = "";  
    private static final String FB_PASSWORD = "";  
    private static final String STATUS_MESSAGE = "Hello World";  
    
### Insert credentials (insert credentials for WalletHubTest login/pass in tests class)  
public class WalletHubTest {  
    private static final String WH_LOGIN_URL = "https://wallethub.com/join/light";  
    static String subUrls = "https://wallethub.com/profile/13732055i";  
    private static final String WH_EMAIL = "";  
    private static final String WH_PASSWORD = "";  

## How to run
Run Facebook/Wallethub tests with Run As (1 java application)

## Author
Harris Ahmed Butt
