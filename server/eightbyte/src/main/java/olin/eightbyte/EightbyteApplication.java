package olin.eightbyte;

import org.skife.jdbi.v2.DBI;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
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
		
	}

	@Override
	public void run(final EightbyteConfiguration configuration, final Environment environment) {
		final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
	}

}
