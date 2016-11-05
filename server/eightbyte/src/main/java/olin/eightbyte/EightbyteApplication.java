package olin.eightbyte;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.skife.jdbi.v2.DBI;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import olin.eightbyte.db.SoundByteDAO;
import olin.eightbyte.resources.SoundByteResource;

public class EightbyteApplication extends Application<EightbyteConfiguration> {

	public static void main(final String[] args) throws Exception {
		new EightbyteApplication().run(args);
	}

	 public Set<Class<?>> getClasses() {
	        final Set<Class<?>> resources = new HashSet<Class<?>>();

	        // Add your resources.
	        resources.add(SoundByteResource.class);

	        // Add additional features such as support for Multipart.
	        resources.add(MultiPartFeature.class);

	        return resources;
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
        configureCors(environment);
        getClasses();
		environment.jersey().register( MultiPartFeature.class);

		environment.jersey().register( SoundByteResource.class);

		final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
		final SoundByteDAO soundByteDAO = jdbi.onDemand(SoundByteDAO.class);
		
	}
	
	private void configureCors(Environment environment) {
        FilterRegistration.Dynamic filter = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,PUT,POST,DELETE,OPTIONS");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        filter.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
        filter.setInitParameter("allowedHeaders", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
        filter.setInitParameter("allowCredentials", "true");
    }

}
