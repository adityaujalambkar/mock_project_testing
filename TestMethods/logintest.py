from selenium import webdriver
from selenium.webdriver.common.by import By

from driver import Configuration, XLUtils

path = "../driver/Login_Data.xlsx"

rows = XLUtils.getRowCount(path, "Sheet2")


def test_login():
    for r in range(1, rows + 1):
        options = webdriver.ChromeOptions();
        # options.add_argument('--headless')
        options.headless = False
        # options.add_argument('window-size=0x0')
        driver = webdriver.Chrome(chrome_options=options, executable_path="../driver/chromedriver.exe")
        driver.get(Configuration.login_url)
        element_email = driver.find_element(By.ID, "exampleInputEmail1")
        element_email.send_keys(XLUtils.readData(path, "Sheet2", r, 1))
        element_password = driver.find_element(By.ID, "exampleInputPassword1")
        element_password.send_keys(XLUtils.readData(path, "Sheet2", r, 2))
        element_login = driver.switch_to.active_element.find_element(By.XPATH, "//button[contains(text(),'Login')]")
        element_login.click()
        XLUtils.writeData(path, 'Sheet2', r, 3, driver.current_url)
        driver.quit()


test_login()
