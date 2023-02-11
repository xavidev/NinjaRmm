package com.ninjaone.apps.rmmcustomers;

import com.ninjaone.apps.ApplicationTestCase;
import org.springframework.transaction.annotation.Transactional;

@Transactional("rmm-transaction_manager")
public abstract class CustomersApplicationTestCase extends ApplicationTestCase  {


}
