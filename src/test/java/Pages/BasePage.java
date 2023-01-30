package Pages;


import org.openqa.selenium.WebDriver;


public abstract class BasePage {


        protected static WebDriver driver;

        public abstract boolean isPageOpened();

        public BasePage(WebDriver driver) {
            this.driver = driver;
        }

}
