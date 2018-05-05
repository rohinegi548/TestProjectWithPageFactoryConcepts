/**
 * 
 */
package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonutil.WaitUtil;

/**
 * @author rohitnegi
 *
 */
public class AddEditCarousel {

	WebDriver driver;
		
		@FindBy(id="id_carouselname")
		WebElement carouselNameField;
		
		@FindBy(id="id_error_carouselname")
		WebElement carouselNameFieldVldtnTxt;
		
		@FindBy(id="id_option_add_fields")
		WebElement addItemToggleBtn;
		
		//for specific to editing existing carousel
		@FindBy(xpath="//legend[@class='ftoggler']/a[text()='New item']")
		WebElement newItemAfterClkAddItem;
		
		@FindBy(xpath="//div[@class='fp-btn-add']/a")
		WebElement addAttachment;
		
		@FindBy(xpath="//*[starts-with(@id,'id_title_new')]")
		WebElement titleField;
		
		@FindBy(xpath="//*[starts-with(@id,'id_caption_new')]")
		WebElement captionDiv;
		
		@FindBy(xpath="//textarea[starts-with(@id,'id_caption_new')]")
		WebElement hiddenTexArea;
		
		@FindBy(xpath="//*[starts-with(@id,'id_buttontext_new')]")
		WebElement buttonText;
		
		@FindBy(xpath="//*[starts-with(@id,'id_link_new')]")
		WebElement linkText;
		
		@FindBy(xpath="//*[starts-with(@id,'id_remove_new')]")
		WebElement deleteChkBox;
		
		@FindBy(xpath="//input[contains(@value,'Save changes')]")
		WebElement saveChangesBtn;
		
		@FindBy(id="id_cancel")
		WebElement cancelButton;
		
		
		public AddEditCarousel(WebDriver driver){
			this.driver = driver;
			//testBase = new TestBase();
			PageFactory.initElements(driver, this);
		}
		
		
		public boolean isCarouselNameFieldMandatory() throws InterruptedException {
			
			carouselNameField.click();
			driver.findElement(By.id("instance-5-header")).click();
			WaitUtil.simpleWait(2);
			
			return carouselNameFieldVldtnTxt.isDisplayed();
		}
		
		
		public boolean isAddItemButtonExist() {
			
			return addItemToggleBtn.isEnabled();
		}
		
		public void clickOnAddItemButton(){
			
			addItemToggleBtn.click();
			//WaitUtil.waitForElement(driver, 30, addAttachment);
		}
		
		public void clickOnNewItemToggleGenratedAfterClkAddItem(){
			
			newItemAfterClkAddItem.click();
			//WaitUtil.waitForElement(driver, 30, addAttachment);
		}
		
		public boolean isElementsUnderAddItemDisplayedAndEnabled(){
			
			if(addAttachment.isEnabled() && titleField.isEnabled() 
					&& captionDiv.isEnabled() && buttonText.isEnabled()
					&& linkText.isEnabled() && deleteChkBox.isEnabled()){
				
				return true;
			}
			else{
				
				return false;
			}
		}
		
		
		public boolean isSaveChangesButtonExist() {
			
			return saveChangesBtn.isEnabled();
		}
		
		
		
}