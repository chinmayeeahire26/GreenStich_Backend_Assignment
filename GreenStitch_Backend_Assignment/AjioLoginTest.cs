const { Builder, By, until } = require('selenium-webdriver');
const assert = require('assert');

async function loginTest() {
  let driver = await new Builder().forBrowser('chrome').build();
  try {
    await driver.get('http://example.com/login');
    await driver.findElement(By.id('username')).sendKeys('testUser');
    await driver.findElement(By.id('password')).sendKeys('testPass');
    await driver.findElement(By.id('loginButton')).click();
    await driver.wait(until.titleIs('Dashboard'), 10000);
    let title = await driver.getTitle();
    assert.strictEqual(title, 'Dashboard', 'Login failed or Dashboard title mismatch');
  } finally {
    await driver.quit();
  }
}

module.exports = { loginTest };