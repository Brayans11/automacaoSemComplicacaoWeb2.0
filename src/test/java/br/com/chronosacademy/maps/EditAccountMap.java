package br.com.chronosacademy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountMap {

    @FindBy(name = "first_nameAccountDetails")
    public WebElement InpFirstName;

    @FindBy(name = "last_nameAccountDetails")
    public WebElement InpLastName;

    @FindBy(id="save_btn")
    public WebElement btnSave;

    @FindBy(name = "countryListboxAccountDetails")
    public WebElement slcCountry;
}
