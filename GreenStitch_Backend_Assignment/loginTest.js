const { Builder, By, until } = require('selenium-webdriver');
const assert = require('assert');

async function testLoginFunctionality() {
  let driver = await new Builder().forBrowser('chrome').build();
  try {
    await driver.get('http://example.com/login');
    await driver.findElement(By.name('username')).sendKeys('testUser');
    await driver.findElement(By.name('password')).sendKeys('testPassword');
    await driver.findElement(By.id('loginButton')).click();
    await driver.wait(until.titleIs('Dashboard'), 10000);
    let pageTitle = await driver.getTitle();
    assert.strictEqual(pageTitle, 'Dashboard');
  } finally {
    await driver.quit();
  }
}

testLoginFunctionality();