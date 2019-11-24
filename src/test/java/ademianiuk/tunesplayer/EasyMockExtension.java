package ademianiuk.tunesplayer;

import org.easymock.EasyMockSupport;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

public class EasyMockExtension implements TestInstancePostProcessor {

	/* (non-Javadoc)
	 * @see org.junit.jupiter.api.extension.TestInstancePostProcessor#postProcessTestInstance(java.lang.Object, org.junit.jupiter.api.extension.ExtensionContext)
	 */
	@Override
	public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
		// TODO Auto-generated method stub
		EasyMockSupport.injectMocks(testInstance);
	}
	

}
