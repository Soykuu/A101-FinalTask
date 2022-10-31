import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;

@ExtendWith(logResults.class)

public class FinalCase<string> {
  WebDriver driver;
  @Before
   public void setup() {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.switchTo().window(driver.getWindowHandle());
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
   @After
       public void teardown() {
       driver.quit();
  }

       @Test
    public void test01() throws InterruptedException   //Kullanıcı girişi yapılmadan sepete ürün ekleme testi
       {

      driver.get("https://www.hepsiburada.com/");
      driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler")).click(); //çerezleri kabul et

      WebElement search= driver.findElement(By.cssSelector("input.desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b"));
      search.sendKeys("Stanley bordo termos");
      driver.findElement(By.cssSelector("div.SearchBoxOld-cHxjyU99nxdIaAbGyX7F")).click();

      driver.findElement(By.xpath("//a[@title='Stanley Klasik Trigger Action Seyahat Bardağı 0.47 LT']")).click();

      ArrayList <String> tabs = new ArrayList<String>(driver.getWindowHandles()); //yeni sekmede işlem yapmak için
      driver.switchTo().window(tabs.get(1));

           driver.findElement(By.xpath("//button[@class='button big with-icon']")).click(); //her seferinde satıcı değişiyor,ana sayfada açılan ürünü sepete ekliyoruz
           driver.findElement(By.xpath("//a[@class='checkoutui-Modal-2iZXl']")).click();
           driver.findElement(By.xpath("//button[@class='add-to-basket button small']")).click(); //her seferinde satıcı değişiyor,diğer satıcılardan aynı ürünü sepete ekliyoruz
           driver.findElement(By.xpath("//a[@class='checkoutui-Modal-2iZXl']")).click();
           driver.findElement(By.xpath("//span[@id='shoppingCart']")).click();

           WebElement ürünAdı = driver.findElement(By.xpath("//div[@class='product_name_3Lh3t']"));
           System.out.println(ürünAdı.getText());
           String actualÜrünAdı = ürünAdı.getText();
           String expectedÜrünAdı = "Stanley Klasik Trigger Action Seyahat Bardağı 0.47 LT";
           Assert.assertTrue(actualÜrünAdı.contains(expectedÜrünAdı));
           System.out.println(actualÜrünAdı.contains(expectedÜrünAdı));

       }

       @Test
    public void test02() throws InterruptedException    //Kullanıcı girişi yapılarak sepete ürün ekleme testi
       {

           driver.get("https://www.hepsiburada.com/");
           driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler")).click();

           WebElement girişMenü = driver.findElement(By.id("myAccount"));
           Actions act = new Actions(driver);
           act.moveToElement(girişMenü).perform();
           driver.findElement(By.xpath("//a[@id='login']")).click();

           driver.findElement(By.xpath("//button[@id='btnFacebook']")).click();   //Facebook ile giriş yap
           driver.findElement(By.xpath("//input[@id='email']")).sendKeys("oykudemirel3535@gmail.com");
           driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Oyku1212");
           driver.findElement(By.xpath("//button[@id='loginbutton']")).click();

           WebElement kullanıcıAdı = driver.findElement(By.xpath("//span[@class='sf-OldMyAccount-sS_G2sunmDtZl9Tld5PR']")); //kullanıcı girişi doğrulama
           System.out.println(kullanıcıAdı.getText());
           String actualKullanıcıAdı= kullanıcıAdı.getText();
           String expectedKullanıcıAdı= "Oyku Demirel";
           Assert.assertTrue(actualKullanıcıAdı.equals(expectedKullanıcıAdı));
           System.out.println(actualKullanıcıAdı.equals(expectedKullanıcıAdı));

           driver.findElement(By.cssSelector("input.desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b")).sendKeys("Stanley bordo termos");
           driver.findElement(By.cssSelector("div.SearchBoxOld-cHxjyU99nxdIaAbGyX7F")).click();

           driver.findElement(By.xpath("//a[@title='Stanley Klasik Trigger Action Seyahat Bardağı 0.47 LT']")).click();

           ArrayList <String> tabs = new ArrayList<String>(driver.getWindowHandles()); //yeni sekmede işlem yapmak için
           driver.switchTo().window(tabs.get(1));

           driver.findElement(By.xpath("//button[@class='button big with-icon']")).click(); //her seferinde satıcı değişiyor,ana sayfada açılan ürünü sepete ekliyoruz
           driver.findElement(By.xpath("//a[@class='checkoutui-Modal-2iZXl']")).click();
           driver.findElement(By.xpath("//button[@class='add-to-basket button small']")).click(); //her seferinde satıcı değişiyor,diğer satıcılardan aynı ürünü sepete ekliyoruz
           driver.findElement(By.xpath("//a[@class='checkoutui-Modal-2iZXl']")).click();
           driver.findElement(By.xpath("//span[@id='shoppingCart']")).click();

           WebElement ürünAdı = driver.findElement(By.xpath("//div[@class='product_name_3Lh3t']"));
           System.out.println(ürünAdı.getText());
           String actualÜrünAdı = ürünAdı.getText();
           String expectedÜrünAdı = "Stanley Klasik Trigger Action Seyahat Bardağı 0.47 LT";
           Assert.assertTrue(actualÜrünAdı.contains(expectedÜrünAdı));
           System.out.println(actualÜrünAdı.contains(expectedÜrünAdı));

       }
}



