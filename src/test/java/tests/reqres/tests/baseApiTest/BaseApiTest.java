package tests.reqres.tests.baseApiTest;

import tests.specification.AccountService;
import tests.specification.BookStoreService;

public abstract class BaseApiTest {

    protected static final AccountService accountService = new AccountService();
    protected static final BookStoreService bookStoreService = new BookStoreService();

}
