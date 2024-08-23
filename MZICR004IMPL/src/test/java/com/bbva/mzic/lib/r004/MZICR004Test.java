package com.bbva.mzic.lib.r004;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.aop.framework.Advised;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/MZICR004-app.xml",
		"classpath:/META-INF/spring/MZICR004-app-test.xml",
		"classpath:/META-INF/spring/MZICR004-arc.xml",
		"classpath:/META-INF/spring/MZICR004-arc-test.xml" })
public class MZICR004Test {

	@Spy
	private Context context;

	@Resource(name = "mzicR004")
	private MZICR004 mzicR004;

	@Resource(name = "applicationConfigurationService")
	private ApplicationConfigurationService applicationConfigurationService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		context = new Context();
		ThreadContext.set(context);
		getObjectIntrospection();
	}
	
	private Object getObjectIntrospection() throws Exception{
		Object result = this.mzicR004;
		if(this.mzicR004 instanceof Advised){
			Advised advised = (Advised) this.mzicR004;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}
	
	@Test
	public void executeTest(){
		mzicR004.execute();
		Assert.assertEquals(0, context.getAdviceList().size());
	}
	
}
