package com.ninjaone.apps.rmm;

import com.ninjaone.apps.ApplicationTestCase;
import org.springframework.transaction.annotation.Transactional;

@Transactional("rmm-transaction_manager")
public abstract class RmmApplicationTestCase extends ApplicationTestCase  {


}
