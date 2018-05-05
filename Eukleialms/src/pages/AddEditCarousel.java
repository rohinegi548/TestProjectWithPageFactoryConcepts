/**
 * 
 */
package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonutil.PropertyUtil;
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
		
		@FindBy(xpath="//input[@type='file']")
		WebElement addFileInput;
		
		@FindBy(xpath="//button[@class='fp-upload-btn btn-primary btn']")
		WebElement uploadFileBtn;
		
		@FindBy(xpath="//*[starts-with(@id,'id_title')]")
		WebElement titleField;
		
		@FindBy(xpath="//*[starts-with(@id,'id_caption')]")
		WebElement captionDiv;
		
		@FindBy(xpath="//textarea[starts-with(@id,'id_caption')]")
		WebElement hiddenTexArea;
		
		@FindBy(xpath="//*[starts-with(@id,'id_buttontext')]")
		WebElement buttonText;
		
		@FindBy(xpath="//*[starts-with(@id,'id_link')]")
		WebElement linkText;
		
		@FindBy(xpath="//*[starts-with(@id,'id_remove')]")
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
			WaitUtil.waitForElementToBeClickable(driver, 30, addAttachment);
		}
		
		public void clickOnNewItemToggleGenratedAfterClkAddItem(){
			
			newItemAfterClkAddItem.click();
			//WaitUtil.waitForElement(driver, 30, addAttachment);
		}
		
		
		public void fillDataForAddItem() throws IOException, InterruptedException {
			
			addAttachment.click();
			addFileInput.click();
			WaitUtil.simpleWait(2);
			
			//autoit code
			Runtime.getRuntime().exec(PropertyUtil.getProperty("upload_file_path"));
			WaitUtil.simpleWait(2);
			uploadFileBtn.click();
			WaitUtil.simpleWait(2);
			
			titleField.sendKeys(PropertyUtil.getProperty("test_title"));
			WaitUtil.simpleWait(2);
			captionDiv.sendKeys(PropertyUtil.getProperty("test_caption"));
			WaitUtil.simpleWait(2);
			buttonText.sendKeys(PropertyUtil.getProperty("test_button_txt"));
			WaitUtil.simpleWait(2);
			linkText.sendKeys(PropertyUtil.getProperty("test_link"));
			WaitUtil.simpleWait(2);
			
			saveChangesBtn.click();
			
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
		
		public void setCarouselName(String carouselName) {
			
			carouselNameField.clear();
			carouselNameField.sendKeys(carouselName);
		}
		
		public void clickOnDeleteChkBox() {
			
			deleteChkBox.click();
		}
		
		public void clickOnSaveChanges() {
			
			saveChangesBtn.click();
		}
		
		public boolean isSaveChangesButtonExist() {
			
			return saveChangesBtn.isEnabled();
		}
		
		
		
}