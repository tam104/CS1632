

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import org.junit.Test;

public class TestCases {

	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://www.library.pitt.edu/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	 @Test
	  public void testFindBook() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("text")).click();
	    driver.findElement(By.id("text")).clear();
	    driver.findElement(By.id("text")).sendKeys("Test");
	    driver.findElement(By.cssSelector("#form > input[type=\"submit\"]")).click();
	    assertEquals("Test - PITTCat+", driver.getTitle());
	    try {
	      assertEquals("Test", driver.findElement(By.id("searchBox_03O")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	  }
	  
	  @Test
	  public void testFindDatabase() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("quicktabs-tab-quicktab-3")).click();
	    driver.findElement(By.id("edit-combine")).clear();
	    driver.findElement(By.id("edit-combine")).sendKeys("computer science");
	    driver.findElement(By.id("edit-submit-databases-a-z")).click();
	    driver.findElement(By.linkText("Web of Science")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Connect to this database')])[22]")).click();
	    assertTrue(isElementPresent(By.cssSelector("html")));
	  }
	  
	  @Test
	  public void testFindEJournals() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("quicktabs-tab-quicktab-2")).click();
	    driver.findElement(By.id("SS_CFocusTag")).clear();
	    driver.findElement(By.id("SS_CFocusTag")).sendKeys("computer science");
	    driver.findElement(By.cssSelector("#SS_EJPSearchForm > p > input[type=\"Submit\"]")).click();

	    assertEquals("Title begins with \"computer science\"", driver.findElement(By.cssSelector("span.SS_ResultsTypeNote > span.SS_ResultsCount")).getText());
	  }
	  
	  @Test
	  public void testFindGuides() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("quicktabs-tab-quicktab-4")).click();
	    driver.findElement(By.id("s-lg-guide-search")).click();
	    driver.findElement(By.id("s-lg-guide-search")).clear();
	    driver.findElement(By.id("s-lg-guide-search")).sendKeys("ENGCMP 0200");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    driver.get("http://pitt.libguides.com/srch.php?q=ENGCMP+0200");
	    assertEquals("Search - LibGuides at University of Pittsburgh", driver.getTitle());
	    assertEquals("Showing 1 - 6 (of 6) for: engcmp 0200", driver.findElement(By.id("s-lg-srch-range")).getText());
	  }
	  
	  @Test
	  public void testFindSubjectSpecialists() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("quicktabs-tab-quicktab-5")).click();
	    driver.findElement(By.xpath("(//input[@id='edit-combine'])[2]")).click();
	    driver.findElement(By.xpath("(//input[@id='edit-combine'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@id='edit-combine'])[2]")).sendKeys("Engineering");
	    driver.findElement(By.id("edit-submit-subject-specialists")).click();
	    driver.findElement(By.id("edit-submit-subject-specialists")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [getTable | css=table.views-table.cols-5.1.0 | ]]
	  }
	  
	  @Test
	  public void testFindBookInvalid() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("text")).clear();
	    driver.findElement(By.id("text")).sendKeys("@@@@@");
	    driver.findElement(By.cssSelector("#form > input[type=\"submit\"]")).click();
	    assertEquals("@@@@@ - PITTCat+", driver.getTitle());
	    assertEquals("Your search for @@@@@ returned 0 results", driver.findElement(By.cssSelector("div.zero.ng-binding")).getText());
	  }
	  
	  @Test
	  public void testFindEJournalInvalid() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("quicktabs-tab-quicktab-2")).click();
	    driver.findElement(By.id("SS_CFocusTag")).click();
	    driver.findElement(By.id("SS_CFocusTag")).clear();
	    driver.findElement(By.id("SS_CFocusTag")).sendKeys("@@@");
	    driver.findElement(By.cssSelector("#SS_EJPSearchForm > p > input[type=\"Submit\"]")).click();
	   
	    assertEquals("0 records", driver.findElement(By.cssSelector("span.SS_ResultsCount")).getText());
	    assertEquals("Sorry, this search returned no results. We can help you find what you need, use the ask-a-librarian tab.", driver.findElement(By.cssSelector("div.SS_NoJournalFoundMsg")).getText());
	  }
	  
	  @Test
	  public void testFindGuideInvalid() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("quicktabs-tab-quicktab-4")).click();
	    driver.findElement(By.id("s-lg-guide-search")).clear();
	    driver.findElement(By.id("s-lg-guide-search")).sendKeys("@@@");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    driver.get("http://pitt.libguides.com/srch.php?q=%40%40%40");
	    assertEquals("No results found.", driver.findElement(By.cssSelector("p")).getText());
	  }
	  
	  @Test
	  public void testSearchStaffValid() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("About Us")).click();
	    driver.findElement(By.linkText("About Us")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Library Staff')])[2]")).click();
	    driver.findElement(By.id("edit-dir-search")).sendKeys("john");
	    driver.findElement(By.id("edit-submit-dir")).click();
	    driver.findElement(By.id("edit-submit-dir")).click();
	    assertTrue(isElementPresent(By.xpath("//div[@id='block-system-main']/div/div/div[3]/div")));
	  }
	  
	  @Test
	  public void testSearchStaffInvalid() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("About Us")).click();
	    driver.findElement(By.linkText("About Us")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Library Staff')])[2]")).click();
	    driver.findElement(By.id("edit-dir-search")).sendKeys("aaaaaa");
	    driver.findElement(By.id("edit-submit-dir")).click();
	    assertFalse(isElementPresent(By.xpath("//div[@id='block-system-main']/div/div/div[3]/div")));
	  }
	  
	  @Test
	  public void testSearchStudentJobs() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("About Us")).click();
	    driver.findElement(By.linkText("About Us")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Library Jobs')])[2]")).click();
	    driver.findElement(By.linkText("Current Student Job Listings")).click();
	    
	    assertTrue(isElementPresent(By.cssSelector("img[alt=\"Logo\"]")));
	  }
	  
	  @Test
	  public void testSearchBorrowingPolicies() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("About Us")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Policies')])[2]")).click();
	    driver.findElement(By.linkText("Borrowing")).click();
	    driver.findElement(By.linkText("Who Can Borrow?")).click();
	    assertEquals("Who can Borrow? | University Library System (ULS)",driver.getTitle());
	  }
	  
	  @Test
	  public void testCheckBusiness() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("Libraries & Collections")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Chemistry Library')])[2]")).click();
	    driver.findElement(By.linkText("Writing in Chemistry - Oakland Campus")).click();
	    driver.get("http://pitt.libguides.com/chemwriting");
	    assertEquals("Getting Started - Writing in Chemistry - Oakland Campus - LibGuides at University of Pittsburgh", driver.getTitle());
	  }
	  
	  @Test
	  public void testCheckChemistry() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("Libraries & Collections")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Chemistry Library')])[2]")).click();
	    driver.findElement(By.linkText("Writing in Chemistry - Oakland Campus")).click();
	    driver.get("http://pitt.libguides.com/chemwriting");
	    assertEquals("Getting Started - Writing in Chemistry - Oakland Campus - LibGuides at University of Pittsburgh", driver.getTitle());
	  }
	  
	  @Test
	  public void testCheckLangley() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("Libraries & Collections")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Chemistry Library')])[2]")).click();
	    driver.findElement(By.linkText("Writing in Chemistry - Oakland Campus")).click();
	    driver.get("http://pitt.libguides.com/chemwriting");
	    assertEquals("Getting Started - Writing in Chemistry - Oakland Campus - LibGuides at University of Pittsburgh", driver.getTitle());
	  }
	  
	  @Test
	  public void testCheckMusic() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("Libraries & Collections")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Chemistry Library')])[2]")).click();
	    driver.findElement(By.linkText("Writing in Chemistry - Oakland Campus")).click();
	    driver.get("http://pitt.libguides.com/chemwriting");
	    assertEquals("Getting Started - Writing in Chemistry - Oakland Campus - LibGuides at University of Pittsburgh", driver.getTitle());
	  }
	  
	  @Test
	  public void testORCIDInfo() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("Libraries & Collections")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Chemistry Library')])[2]")).click();
	    driver.findElement(By.linkText("Writing in Chemistry - Oakland Campus")).click();
	    driver.get("http://pitt.libguides.com/chemwriting");
	    assertEquals("Getting Started - Writing in Chemistry - Oakland Campus - LibGuides at University of Pittsburgh", driver.getTitle());
	  }
	  
	  @Test
	  public void testSupportDataManagement() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("Libraries & Collections")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Chemistry Library')])[2]")).click();
	    driver.findElement(By.linkText("Writing in Chemistry - Oakland Campus")).click();
	    driver.get("http://pitt.libguides.com/chemwriting");
	    assertEquals("Getting Started - Writing in Chemistry - Oakland Campus - LibGuides at University of Pittsburgh", driver.getTitle());
	  }
	  
	  @Test
	  public void testCheckLibraryResources() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("Libraries & Collections")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Library Resource Facility')])[2]")).click();
	    driver.findElement(By.cssSelector("h4 > a")).click();
	    assertEquals("Archives Service Center | University Library System (ULS)", driver.getTitle());
	  }
	  
	  @Test
	  public void testGetSpecificLibrarian() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("Services")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'For Faculty')])[2]")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Contact Your Librarian')])[3]")).click();
	    driver.findElement(By.xpath("//a[contains(text(),'Margarete  Bower')]")).click();
	    assertEquals("Margarete Bower - LibGuides at University of Pittsburgh", driver.getTitle());
	  }
	  
	  @Test
	  public void testReadAboutOpenAuthor() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("Services")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'For Faculty')])[2]")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Open Access Author Fund')])[2]")).click();
	    driver.findElement(By.linkText("Author Fees Fund Policy Guidelines")).click();
	    assertEquals("Open Access Author Fee Fund Policy | University Library System (ULS)", driver.getTitle());
	  }
	  
	  @Test
	  public void testPublishing() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.linkText("Services")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'For Faculty')])[2]")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Let Us Publish Your Journal or Digitize Your Content')])[2]")).click();
	    driver.findElement(By.linkText("why you should publish with us")).click();
	    assertEquals("Why Publish with Us? | University Library System (ULS)", driver.getTitle());
	  }
	

	  

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

}
