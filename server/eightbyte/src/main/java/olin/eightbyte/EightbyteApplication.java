package olin.eightbyte;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class EightbyteApplication extends Application<EightbyteConfiguration> {

	public static void main(final String[] args) throws Exception {
		new EightbyteApplication().run(args);
	}

	@Override
	public String getName() {
		return "eightbyte";
	}

	@Override
	public void initialize(final Bootstrap<EightbyteConfiguration> bootstrap) {
		bootstrap.addBundle(new AssetsBundle("/assets/", "/raw/"));
	}

	@Override
	public void run(final EightbyteConfiguration configuration, final Environment environment) {
	}

}
