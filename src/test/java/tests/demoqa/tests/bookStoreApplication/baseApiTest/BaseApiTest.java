package tests.demoqa.tests.bookStoreApplication.baseApiTest;

import tests.specification.swagger.AccountService;
import tests.specification.swagger.BookStoreService;

public abstract class BaseApiTest {

    protected static final AccountService accountService = new AccountService();
    protected static final BookStoreService bookStoreService = new BookStoreService();

}
