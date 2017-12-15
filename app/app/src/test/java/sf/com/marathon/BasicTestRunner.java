package sf.com.marathon;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.internal.bytecode.InstrumentationConfiguration;
import org.robolectric.manifest.AndroidManifest;

import java.util.ArrayList;
import java.util.List;

import sf.com.marathon.com.sf.marathon.shadows.ShadowHttpClient;
import sf.com.marathon.connectivity.HttpClient;

public class BasicTestRunner extends RobolectricGradleTestRunner {
    public BasicTestRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected AndroidManifest getAppManifest(Config config) {
        return super.getAppManifest(config);
    }

    @Override
    public InstrumentationConfiguration createClassLoaderConfig() {
        InstrumentationConfiguration.Builder builder = InstrumentationConfiguration.newBuilder();

        for (String className : instrumentClasses()) {
            builder.addInstrumentedClass(className);
        }

        return builder.build();
    }

    private List<String> instrumentClasses() {
        List<String> shadowedClassName = new ArrayList();

        shadowedClassName.add(HttpClient.class.getName());

        return shadowedClassName;
    }
}
