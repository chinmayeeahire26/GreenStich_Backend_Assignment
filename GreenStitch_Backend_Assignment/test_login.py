from playwright.sync_api import Page

class LoginPage:
    def __init__(self, page: Page):
        self.page = page
        self.username_input = page.locator('#username')
        self.password_input = page.locator('#password')
        self.login_button = page.locator('#loginBtn')

    def login(self, username: str, password: str):
        self.username_input.fill(username)
        self.password_input.fill(password)
        self.login_button.click()


import pytest
from playwright.sync_api import sync_playwright

class TestLogin:
    @pytest.fixture(scope='class')
    def setup(self):
        with sync_playwright() as p:
            browser = p.chromium.launch(headless=True)
            page = browser.new_page()
            login_page = LoginPage(page)
            yield login_page
            browser.close()

    def test_login_success(self, setup):
        login_page = setup
        login_page.page.goto('https://example.com/login')
        login_page.login('validUser', 'validPass')
        assert login_page.page.locator('text=Welcome').is_visible()

    def test_login_failure(self, setup):
        login_page = setup
        login_page.page.goto('https://example.com/login')
        login_page.login('invalidUser', 'invalidPass')
        assert login_page.page.locator('text=Invalid credentials').is_visible()

# Reporting can be handled by pytest's built-in reporting or plugins like pytest-html
