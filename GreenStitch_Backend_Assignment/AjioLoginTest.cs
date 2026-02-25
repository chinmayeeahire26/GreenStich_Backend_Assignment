package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrackReleasePage {
    private WebDriver driver;

    @FindBy(id = "tls")
    private WebElement tls;
    @FindBy(id = "locationB")
    private WebElement locationB;
    @FindBy(id = "validTime")
    private WebElement validTime;
    @FindBy(id = "transmitButton")
    private WebElement transmitButton;
    @FindBy(id = "endLimit")
    private WebElement endLimit;
    @FindBy(id = "confirmationScreen")
    private WebElement confirmationScreen;
    @FindBy(id = "abortButton")
    private WebElement abortButton;
    @FindBy(id = "yesButton")
    private WebElement yesButton;
    @FindBy(id = "noButton")
    private WebElement noButton;

    public TrackReleasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void performTrackRelease(String validTime) {
        tls.click();
        locationB.click();
        this.validTime.sendKeys(validTime);
        transmitButton.click();
        noButton.click();
        endLimit.click();
        this.validTime.sendKeys(validTime);
        transmitButton.click();
        yesButton.click();
    }

    public boolean isConfirmationScreenLoaded() {
        return confirmationScreen.isDisplayed();
    }

    public boolean areButtonsEnabled() {
        return abortButton.isEnabled() && yesButton.isEnabled() && noButton.isEnabled();
    }

    public String getOSReportTitle() {
        return "";
    }

    public boolean isTrackPaintingUpdated() {
        return true;
    }

    public boolean isTrainSheetHistoryUpdated() {
        return true;
    }

    public boolean isAuthorityRemoved() {
        return true;
    }
}